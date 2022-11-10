package gradingTools.javaThreads.primes.execution;

import java.beans.PropertyChangeEvent;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import grader.basics.concurrency.propertyChanges.AbstractConcurrentEventSupport;
import grader.basics.concurrency.propertyChanges.BasicConcurrentPropertyChangeSupport;
import grader.basics.concurrency.propertyChanges.ConcurrentEvent;
import grader.basics.concurrency.propertyChanges.ConcurrentEventUtility;
import grader.basics.concurrency.propertyChanges.ConcurrentPropertyChange;
import grader.basics.concurrency.propertyChanges.ConcurrentPropertyChangeSupport;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.NotRunnableException;
import grader.basics.execution.ResultingOutErr;
import grader.basics.execution.RunningProject;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.output.observer.BasicNegativeOutputSelector;
import grader.basics.output.observer.BasicPositiveOutputSelector;
import grader.basics.output.observer.BasicPrintStreamListener;
import grader.basics.output.observer.ObservablePrintStream;
import grader.basics.output.observer.ObservablePrintStreamFactory;
import grader.basics.output.observer.PropertyBasedStringChecker;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.javaThreads.hello.ConcurrentHelloSuite;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;
import gradingTools.shared.testcases.SubstringSequenceChecker;
import gradingTools.shared.testcases.concurrency.outputObserver.AbstractForkJoinOutputObserver;
import gradingTools.shared.testcases.greeting.AGreetingChecker;
import gradingTools.shared.testcases.greeting.GreetingMainProvided;
import gradingTools.shared.testcases.utils.ALinesMatcher;
import gradingTools.shared.testcases.utils.LinesMatchKind;
import gradingTools.shared.testcases.utils.LinesMatcher;
import gradingTools.utils.RunningProjectUtils;
import util.annotations.MaxValue;
import util.models.PropertyListenerRegisterer;
@MaxValue(2)
public abstract class AbstractPrimeExecution extends AbstractForkJoinOutputObserver {
	
	public static final int NUM_THREADS = 4;

	public static final Object[][] PRE_FORK_PROPERTIES = {
			{"Random Numbers", Array.class}			
	};
	public static final Object[][] ITERATION_PROPERTIES = {
			{"Index", Number.class},
			{"Number", Number.class},
			{"Is Prime", Boolean.class}
	};
	public static final Object[][] POST_ITERATION_PROPERTIES = {
			{"Num Primes", Number.class},
			
	};
	public static final Object[][] POST_JOIN_PROPERTIES = {
			{"Total Num Primes", Number.class},
			
	};

	@Override
	protected String mainClassIdentifier() {
		return ConcurrentPrimesSuite.ROOT_CLASS;

	}
	protected String[] args = {"1"};
	@Override
	protected String[] args() {
		args[0] = Integer.toString( totalIterations());
		return args;
	}
	@Override
	protected  int numExpectedForkedThreads() {
		return NUM_THREADS;
	}
	@Override
	protected Object[][] preForkPropertyNamesAndType() {
		return PRE_FORK_PROPERTIES;
	}

	@Override
	protected Object[][] iterationPropertyNamesAndType() {
		return ITERATION_PROPERTIES;
	}

	@Override
	protected Object[][] postIterationPropertyNamesAndType() {
		return POST_ITERATION_PROPERTIES;
	}
	@Override
	protected Object[][] postJoinPropertyNamesAndType() {
		return  POST_JOIN_PROPERTIES;
	}
	
	int numNumbersFoundByCurrentThread;
	int numExpectedFinalNumbers;	
	/**
	 * The above methods make properties output by each thread available to
	 * this testing code. Even though the property outputs are expected to be
	 * interleaved, the testing framework does not interleave the execution of 
	 * these methods, allowing the testing code to finish processing all properties
	 * output by a thread, before it processes those output by another thread after
	 * a thread switch. 
	 * 
	 * This method is called when a thread switch occurs.
	 * The first argument indicates the thread whose properties were previously
	 * made available, and the second one indicated those whose properties will now
	 * be made available.
	 * 
	 * It should be used to reset per thread state.
	 */
	protected void threadEventProcessingSwitched(Thread aPreviousThread, Thread aNewThread) {
		System.out.println ("Thread processing switched from " + aPreviousThread + " to " + aNewThread);
		numNumbersFoundByCurrentThread = 0;
	}
	// return null in the following message methods if there is no error, otherwise
    // return error message
	
	/**
	 * Invoked for each property output by the root thread before it forks new
	 * threads.
	 */
	@Override
	protected  String preForkEventsMessage(Thread aThread, Map<String, Object> aNameValuePairs) {
		System.out.println ("Thread:" + aThread.getId() + " prefork properties: " + aNameValuePairs);
		return null;
	}
	
	/**
	 * Invoked as each iteration of a thread is processed.
	 * The first argument indicates the thread that processed the iteration
	 * The second argument indicates the property names and values output on that
	 * iteration
	 * A failure message should be given if the values of the input and computed 
	 * properties are not consistent
	 * Once a failure message is given no other iteration or post iteration
	 * methods will be called, though the post join method woud be called
	 */
	@Override
	protected  String iterationEventsMessage(Thread aThread, Map<String, Object> aNameValuePairs) {
		System.out.println ("Thread:" + aThread.getId() + " iteration properties: " + aNameValuePairs);
		boolean isPrime = (boolean) aNameValuePairs.get("Is Prime");
		int aNumber = (Integer) aNameValuePairs.get("Number");
		if (isPrime) {
			numNumbersFoundByCurrentThread++;
		}
		boolean isActualPrime = isPrime(aNumber);
		if (isPrime != isActualPrime) {
			return "Is Prime output as " + isPrime + " for number " + aNumber + " but should be " + isActualPrime;
		}		
		return null;
	}
	@Override
	protected  String postIterationEventsMessage(Thread aThread, Map<String, Object> aNameValuePairs) {
		System.out.println ("Thread:" + aThread.getId() + " post iteration properties: " + aNameValuePairs);
		int aNumNumbersComputed = (int) aNameValuePairs.get("Num Primes");
		if (aNumNumbersComputed != numNumbersFoundByCurrentThread) {
			return "Thread " + aThread.getId() + " found " + numNumbersFoundByCurrentThread + " but computed " + aNumNumbersComputed;
		}
		numExpectedFinalNumbers += aNumNumbersComputed;
		return null;
	}
	@Override
	protected  String postJoinEventsMessage(Thread aThread, Map<String, Object> aNameValuePairs) {
		System.out.println ("Thread:" + aThread.getId() + " post join properties: " + aNameValuePairs);
		int aComputedFinalNumbers = (int) aNameValuePairs.get("Total Num Primes");
		if (aComputedFinalNumbers != numExpectedFinalNumbers) {
			return "Computed final numbers " + aComputedFinalNumbers + " != " + "expected final numbers " + numExpectedFinalNumbers;
		}
		return null;
	}
	
	public static boolean isPrime(int num) {
		if (num == 2)
			return true;

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if ((num % i) == 0) {
				return false;
			}
		}
		return true;
	}

	// inherited methods, that can be overridden
	@Override
	protected TestCaseResult checkOutput(ResultingOutErr anOutput) {
    	return super.checkOutput(anOutput);
    }
	protected  TestCaseResult checkEvents(ConcurrentPropertyChange[] anEvents) {
		return super.checkEvents(anEvents);
	}
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		return super.test(project, autoGrade);
	}

}

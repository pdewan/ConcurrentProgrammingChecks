package gradingTools.javaThreads.primes.execution;

import java.beans.PropertyChangeEvent;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
//	public static final String CONCURRENT_HELLO_CLASS_NAME = "Hello";
	
	public static final int NUM_THREADS = 4;
//	public static final int PER_ITERATION_EVENTS = 3;
//	public static final int POST_ITERATION_EVENTS = 1;
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
	public static final Object[][] POST_JOIN_PROPERTIES = POST_ITERATION_PROPERTIES;

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
		return  POST_ITERATION_PROPERTIES;
	}
//	@Override
//	protected int numPerIterationEvents() {
//		return PER_ITERATION_EVENTS;
//	}
//	protected  int numIterations() {
//		return AbstractPrimeExecution.NUM_THREADS;
//	}
//	@Override
//	protected Class mainClass() {
//		return findClassByName(mainClassIdentifier());
//	}
//	@Override
//	protected PropertyBasedStringChecker preForkChecker() {
//		return new APrimesPreForkPropertyChecker();
//	}

//	@Override
//	protected PropertyBasedStringChecker postForkChecker() {
////		return new AHelloPostForkChecker(numExpectedForkedThreads());
//		return new APrimesPostForkPropertyChecker(numExpectedItems());	
//
//	}

//	@Override
//	protected PropertyBasedStringChecker postJoinChecker() {
//		return new APrimesPostJoinPropertyChecker();
//
//	}

//	@Override
//	protected SubstringSequenceChecker rootThreadChecker() {
//		return new AHelloPerThreadChecker();
//	}
//	@Override
//	protected SubstringSequenceChecker forkedThreadChecker() {
//		return new AHelloPerThreadChecker();
//	}

//	@Override
//	protected double preForkOutputCredit() {
//		// TODO Auto-generated method stub
//		return 0.2;
//	}
//
//	@Override
//	protected double postForkOutputCredit() {
//		return 0.2;
//	}
//
//	@Override
//	protected double postJoinOutputCredit() {
//		return 0.1;
//	}
	@Override
	protected  String preForkEventsMessage(Thread aThread, Map<String, Object> aNameValuePairs) {
		return null;
	}
	@Override
	protected  String iterationEventsMessage(Thread aThread, Map<String, Object> aNameValuePairs) {
		return null;
	}
	@Override
	protected  String postIterationEventsMessage(Thread aThread, Map<String, Object> aNameValuePairs) {
		return null;
	}
	@Override
	protected  String postJoinEventsMessage(Thread aThread, Map<String, Object> aNameValuePairs) {
		return null;
	}

//	@Override
//	protected double forkedThreadPartialCredit() {
//		return 0.6;
//	}
//
//	@Override
//	protected double rootThreadPartialCredit() {
//		return 0;
//	}
	
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

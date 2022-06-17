package gradingTools.javaThreads.hello.execution;

import java.beans.PropertyChangeEvent;
import java.io.PrintStream;
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
public abstract class AbstractHelloExecution extends AbstractForkJoinOutputObserver {
//	public static final String CONCURRENT_HELLO_CLASS_NAME = "Hello";
	public static final Object[][] GREETING_DESCRIPTOR = {
			{"Greeting", String.class}
	};

	@Override
	protected String mainClassIdentifier() {
		return ConcurrentHelloSuite.ROOT_CLASS;

	}
	protected String[] args = {"1"};
	@Override
	protected String[] args() {
		args[0] = Integer.toString(numExpectedForkedThreads());
		return args;
	}
	
	protected Class mainClass() {
		return findClassByName(mainClassIdentifier());
	}
	@Override
	protected Object[][] preForkPropertyNamesAndType() {
		return null;
	}
	@Override
	protected Object[][] iterationPropertyNamesAndType() {
		return null;
	}
	@Override
	protected Object[][] postIterationPropertyNamesAndType() {
		return GREETING_DESCRIPTOR;
	}
	@Override
	protected Object[][] postJoinPropertyNamesAndType() {
		return GREETING_DESCRIPTOR;
	}
	@Override
	protected int totalIterations() {
		return 0;
	}
//	@Override
//	protected PropertyBasedStringChecker preForkChecker() {
//		return null;
//	}
//
//	@Override
//	protected PropertyBasedStringChecker postForkChecker() {
////		return new AHelloPostForkChecker(numExpectedForkedThreads());
//		return new AHelloPostForkPropertyChecker(numExpectedForkedThreads());	
//
//	}

//	@Override
//	protected PropertyBasedStringChecker postJoinChecker() {
////		return new AHelloRootPostJoinChecker();
//		return new AHelloPostJoinPropertyChecker();
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
//	protected double preForkPartialCredit() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	protected double postForkOutputCredit() {
		return 0.3;
	}

	@Override
	protected double postJoinOutputCredit() {
		return 0.1;
	}
	@Override
	protected double threadCountCredit () {
    	return 0.6;
    }
	@Override
	protected  String postIterationEventsMessage(Thread aThread, Map<String, Object> aNameValuePairs) {
		String aMessage = null;
		String aGreeting = (String) aNameValuePairs.get("Greeting");
		if (aGreeting == null) {
			return "Greeting property not found";
		}
		String aRegex = "Hello.*World.*";
		if (!aGreeting.matches(aRegex)) {
			return "Greeting property " + aGreeting + " does not match " + aRegex;
		}
		return null;
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

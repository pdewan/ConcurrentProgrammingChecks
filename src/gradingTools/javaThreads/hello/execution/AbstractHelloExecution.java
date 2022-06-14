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
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
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
	public static final String CONCURRENT_HELLO_CLASS_NAME = "Hello";

	@Override
	protected String mainClassIdentifier() {
		return CONCURRENT_HELLO_CLASS_NAME;

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
	protected SubstringSequenceChecker preForkChecker() {
		return null;
	}

	@Override
	protected SubstringSequenceChecker postForkChecker() {
		return new AHelloPostForkChecker(numExpectedForkedThreads());	}

	@Override
	protected SubstringSequenceChecker postJoinChecker() {
		return new AHelloRootPostJoinChecker();
	}

	@Override
	protected SubstringSequenceChecker rootThreadChecker() {
		return new AHelloRootPostJoinChecker();
	}
	@Override
	protected SubstringSequenceChecker forkedThreadChecker() {
		return new AHelloPerThreadChecker();
	}

	@Override
	protected double preForkPartialCredit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected double postForkPartialCredit() {
		return 0.3;
	}

	@Override
	protected double postJoinPartialCredit() {
		return 0.1;
	}

	@Override
	protected double forkedThreadPartialCredit() {
		return 0.6;
	}

	@Override
	protected double rootThreadPartialCredit() {
		return 0;
	}

}

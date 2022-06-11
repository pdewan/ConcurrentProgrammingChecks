package gradingTools.javaThreads.hello.execution;

import java.beans.PropertyChangeEvent;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.NotRunnableException;
import grader.basics.execution.ResultingOutErr;
import grader.basics.execution.RunningProject;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import grader.basics.trace.output.BasicNegativeOutputSelector;
import grader.basics.trace.output.BasicPositiveOutputSelector;
import grader.basics.trace.output.BasicPrintStreamListener;
import grader.basics.trace.output.ObservablePrintStream;
import grader.basics.trace.output.ObservablePrintStreamFactory;
import gradingTools.shared.testcases.SubstringSequenceChecker;
import gradingTools.shared.testcases.concurrency.propertyChanges.AbstractConcurrentEventSupport;
import gradingTools.shared.testcases.concurrency.propertyChanges.BasicConcurrentPropertyChangeSupport;
import gradingTools.shared.testcases.concurrency.propertyChanges.ConcurrentEvent;
import gradingTools.shared.testcases.concurrency.propertyChanges.ConcurrentEventUtility;
import gradingTools.shared.testcases.concurrency.propertyChanges.ConcurrentPropertyChange;
import gradingTools.shared.testcases.concurrency.propertyChanges.ConcurrentPropertyChangeSupport;
import gradingTools.shared.testcases.concurrency.propertyChanges.Selector;
import gradingTools.shared.testcases.greeting.AGreetingChecker;
import gradingTools.shared.testcases.greeting.GreetingMainProvided;
import gradingTools.shared.testcases.utils.ALinesMatcher;
import gradingTools.shared.testcases.utils.LinesMatchKind;
import gradingTools.shared.testcases.utils.LinesMatcher;
import gradingTools.utils.RunningProjectUtils;
import util.annotations.MaxValue;
import util.models.PropertyListenerRegisterer;
public abstract class AbstractOutputObserver extends PassFailJUnitTestCase {
	private ConcurrentPropertyChangeSupport concurrentPropertyChangeSupport;
	private ResultingOutErr resultingOutErr;
	public static final int CONCURRENT_PROGRAM_MAX_TIME = 1000;
	public AbstractOutputObserver() {
	}
	protected Selector positiveSelector() {
		return new BasicPositiveOutputSelector();
	}
	protected Selector negativeSelector() {
		return new BasicNegativeOutputSelector();
	}
	protected Selector<ConcurrentPropertyChangeSupport> waitSelector() {
		return null;
	}
	protected ResultingOutErr getResultingOutErr() {
		return resultingOutErr;
	}
	protected ConcurrentPropertyChangeSupport getConcurrentPropertyChangeSupport() {
		return concurrentPropertyChangeSupport;
	}
	protected  Class mainClass() throws ClassNotFoundException {
		return Class.forName("Main");
	}
	static String[] emptyArray = {};
	protected String[] args() {
		return emptyArray;
	}
	protected String[] inputs() {
		return emptyArray;
	}

	protected long timeOut() {
		return CONCURRENT_PROGRAM_MAX_TIME;
	}
	protected static PrintStream originalOut = System.out;
    protected ObservablePrintStream redirectOutput() {    	
    	ObservablePrintStream aRedirectedStream = ObservablePrintStreamFactory.getObservablePrintStream();
//		aRedirectedStream.addPropertyChangeListener(new BasicPrintStreamListener());
		aRedirectedStream.addPositiveSelector(positiveSelector());
		aRedirectedStream.addNegativeSelector(negativeSelector());
		System.setOut((PrintStream) aRedirectedStream);
		return aRedirectedStream;
    }
    protected void receivePropertyChanges(PropertyListenerRegisterer aRegisterer) {
    	concurrentPropertyChangeSupport = new BasicConcurrentPropertyChangeSupport();
    	aRegisterer.addPropertyChangeListener(concurrentPropertyChangeSupport);
		Selector<ConcurrentPropertyChangeSupport> aWaitSelector = waitSelector();
		if (aWaitSelector != null) {
	    	concurrentPropertyChangeSupport.addtWaitSelector(aWaitSelector);
		}    	
    }
    
    protected void restoreOutput() {
    	System.setOut(originalOut);
    }
    protected  TestCaseResult checkOutput() {
    	return pass();
    }
    protected  TestCaseResult checkEvents(ConcurrentPropertyChangeSupport aConcurrencySupport) {
    	return pass();
    }
    protected void waitForTermination() {
    	Selector<ConcurrentPropertyChangeSupport> aWaitSelector = waitSelector();
    	long aTimeOut = timeOut();
		if (aWaitSelector != null) {
	    	concurrentPropertyChangeSupport.selectorBasedWait(aTimeOut);
		} else {
			concurrentPropertyChangeSupport.timeOutBasedWait(aTimeOut);
		}
    }
	protected TestCaseResult runAndCheck(Class aMainClass, String[] anArgs, String[] anInputs) throws Throwable {		
		ObservablePrintStream aRedirectedStrean = redirectOutput();
		receivePropertyChanges(aRedirectedStrean);
		resultingOutErr = BasicProjectExecution.invokeMain(aMainClass, anArgs, anInputs);
		waitForTermination();
		restoreOutput();
		TestCaseResult aRetValOut = checkOutput();
		TestCaseResult aRetValEvents = checkEvents(concurrentPropertyChangeSupport);
		if (aRetValOut.isPass() && aRetValEvents.isPass()) {
			return pass();
		}
		if (aRetValOut.isFail() && aRetValEvents.isFail()) {
			return fail(aRetValOut.getNotes() + " " + aRetValEvents.getNotes());
		}
		if (!aRetValEvents.isPass()) {
			return partialPass(0.2, aRetValEvents.getNotes());
		}
		return partialPass(0.8, aRetValOut.getNotes());
//		return checkEvents(aNumThreads);

	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
			Class aMainClass = mainClass();
			TestCaseResult retVal = pass();;
			runAndCheck(aMainClass, args(), inputs());
			return retVal;			

		} catch (NotRunnableException e) {
			e.printStackTrace();
			throw new NotGradableException();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new NotGradableException();
		}
	}

}

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
import gradingTools.shared.testcases.greeting.AGreetingChecker;
import gradingTools.shared.testcases.greeting.GreetingMainProvided;
import gradingTools.shared.testcases.utils.ALinesMatcher;
import gradingTools.shared.testcases.utils.LinesMatchKind;
import gradingTools.shared.testcases.utils.LinesMatcher;
import gradingTools.utils.RunningProjectUtils;
import util.annotations.MaxValue;
import util.models.PropertyListenerRegisterer;
@MaxValue(2)
public abstract class AbstractHelloRunSingleArg extends PassFailJUnitTestCase {
//	public static final int TIME_OUT_SECS = 1; // secs
	protected SubstringSequenceChecker checker;	
	protected String[] args = {"5"};
	protected String[] inputs = {};
	protected ConcurrentPropertyChangeSupport concurrentPropertyChangeSupport;;


	public AbstractHelloRunSingleArg() {
	}
	abstract Selector positiveSelector() ;
	protected static PrintStream originalOut = System.out;
    protected ObservablePrintStream redirectOutput() {    	
    	ObservablePrintStream aRedirectedStream = ObservablePrintStreamFactory.getObservablePrintStream();
//		aRedirectedStream.addPropertyChangeListener(new BasicPrintStreamListener());
		aRedirectedStream.addPositiveSelector(new BasicPositiveOutputSelector());
		aRedirectedStream.addNegativeSelector(new BasicNegativeOutputSelector());
		System.setOut((PrintStream) aRedirectedStream);
		return aRedirectedStream;
    }
    protected void receivePropertyChanges(PropertyListenerRegisterer aRegisterer) {
    	concurrentPropertyChangeSupport = new BasicConcurrentPropertyChangeSupport();
    	aRegisterer.addPropertyChangeListener(concurrentPropertyChangeSupport);
    	concurrentPropertyChangeSupport.addtWaitSelector(new HelloMainWaitSelector());
    }
    
    protected void restoreOutput() {
    	System.setOut(originalOut);
    }
    public static final long TIME_OUT = 1000;
    protected TestCaseResult checkOutput(ResultingOutErr aResult) {
    	LinesMatcher aLinesMatcher = aResult.getLinesMatcher();
//		LinesMatcher aLineMatcher =  new ALinesMatcher(anOutputLines);

		boolean aRetval = checker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_UNORDERED, Pattern.DOTALL);

		if (!aRetval) {
			String anExpectedLines = Arrays.toString(checker.getSubstrings());

			return fail("Output did not match:" + anExpectedLines);

		}
		int aLastLineMatched = aLinesMatcher.getMaxMatchedLineNumber();
		checker = new AHelloMainOutputChecker();
		aLinesMatcher.setStartLineNumber(aLastLineMatched + 1);
		
		 aRetval = checker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_LINE, Pattern.DOTALL);
		if (!aRetval) {
			String anExpectedLines = Arrays.toString(checker.getSubstrings());

			return fail("Output, starting at line " + (aLastLineMatched + 1) + ""+ " did not match:" + anExpectedLines);

		}
		return pass();
    }
    protected TestCaseResult checkEvents(int aNumThreads) {
    	ConcurrentPropertyChange[] anEvents = concurrentPropertyChangeSupport.getConcurrentPropertyChanges();
    	Map<Thread, List<ConcurrentPropertyChange>> aMap = ConcurrentEventUtility.getConcurrentPropertyChangeListByThread(anEvents);
    	int aNumActualThreads = aMap.keySet().size();
    	if (aMap.keySet().size() != aNumThreads + 1) {
    		return fail ("Received  output from " +  aNumActualThreads + " threads rather than " + (aNumThreads + 1));
    	}
    	return pass();
    }
	protected TestCaseResult runAndCheck(Class aMainClass, int aNumThreads) throws Throwable {
		args[0] = Integer.toString(aNumThreads);
		checker = new AHelloThreadOutputChecker(aNumThreads);
		ObservablePrintStream aRedirectedStrean = redirectOutput();
		receivePropertyChanges(aRedirectedStrean);
		ResultingOutErr aResult = BasicProjectExecution.invokeMain(aMainClass, args, inputs);
		concurrentPropertyChangeSupport.selectorBasedWait(TIME_OUT);

		restoreOutput();
//		LinesMatcher aLinesMatcher = aResult.getLinesMatcher();
////		LinesMatcher aLineMatcher =  new ALinesMatcher(anOutputLines);
//
//		boolean aRetval = checker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_UNORDERED, Pattern.DOTALL);
//
//		if (!aRetval) {
//			String anExpectedLines = Arrays.toString(checker.getSubstrings());
//
//			return fail("Output did not match:" + anExpectedLines);
//
//		}
//		int aLastLineMatched = aLinesMatcher.getMaxMatchedLineNumber();
//		checker = new AHelloMainOutputChecker();
//		aLinesMatcher.setStartLineNumber(aLastLineMatched + 1);
//		
//		 aRetval = checker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_LINE, Pattern.DOTALL);
//		if (!aRetval) {
//			String anExpectedLines = Arrays.toString(checker.getSubstrings());
//
//			return fail("Output, starting at line " + (aLastLineMatched + 1) + ""+ " did not match:" + anExpectedLines);
//
//		}
//		return pass();
		TestCaseResult aRetValOut = checkOutput(aResult);
		TestCaseResult aRetValEvents = checkEvents(aNumThreads);
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
//			setEntryPoint(project, ConcurrentHelloClassProvided.class);
//			RunningProject aRunningProject = RunningProjectUtils.runProject(project, TIME_OUT_SECS, args, inputs);
//
//
//			if (aRunningProject == null) {
//				return fail ("Could not create project. See console messages.");
//			}
//
//			String anOutput = aRunningProject.await();
//			LinesMatcher aLinesMatcher = aRunningProject.getLinesMatcher();

			Class aMainClass = getTaggedClass(project, ConcurrentHelloClassProvided.class);
			TestCaseResult retVal = pass();;
			for (int aNumThreads = 1; aNumThreads < 10; aNumThreads++) {
				retVal = runAndCheck(aMainClass, aNumThreads);
				if (!retVal.isPass()) {
					return retVal;
				}
			}
			return retVal;
//			ResultingOutErr aResult = BasicProjectExecution.invokeMain(aMainClass, args, inputs);
//			LinesMatcher aLinesMatcher = aResult.getLinesMatcher();
////			LinesMatcher aLineMatcher =  new ALinesMatcher(anOutputLines);
//
//			boolean aRetval = checker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_LINE, Pattern.DOTALL);
//			String anExpectedLines = Arrays.toString(checker.getSubstrings());
//
//			if (!aRetval) {
//				return fail("Output  did not match:" + anExpectedLines);
//
//			}
//			return pass();
			

		} catch (NotRunnableException e) {
			e.printStackTrace();
			throw new NotGradableException();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new NotGradableException();
		}
	}

}

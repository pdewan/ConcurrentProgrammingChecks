package gradingTools.javaThreads.hello.execution;

import java.beans.PropertyChangeEvent;
import java.io.PrintStream;
import java.util.ArrayList;
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
public abstract class AbstractForkJoinOutputObserver extends AbstractOutputObserver {
//	public static final int TIME_OUT_SECS = 1; // secs
	

	private int forkLineNumber = 0;
	private int joinLineNumber = 0;
	private ConcurrentPropertyChange[] propertyChanges;
	private Map<Thread, ConcurrentPropertyChange[]> threadToPropertyChanges;
	private Map<Thread, String[]> threadToStrings;
	private Thread rootThread;
	private int numOutputtingThreads;

//	private LinesMatcher linesMatcher;
	
	public Thread getRootThread() {
		return rootThread;
	}

	public AbstractForkJoinOutputObserver() {
		rootThread = Thread.currentThread();
	}

	protected  SubstringSequenceChecker preForkChecker() {
		return null;
	}
	protected  SubstringSequenceChecker postForkChecker() {
		return null;
	}
	protected  SubstringSequenceChecker postJoinChecker() {
		return null;
	}
	protected SubstringSequenceChecker forkedThreadChecker() {
		return null;
	}
	protected SubstringSequenceChecker rootThreadChecker() {
		return null;
	}
	
	
	protected int getForkLineNumber() {
		return forkLineNumber;
	}
	
	protected int getJoinLineNumber() {
		return joinLineNumber;
	}
	
	
	public ConcurrentPropertyChange[] getPropertyChanges() {
		return propertyChanges;
	}
	public Map<Thread, ConcurrentPropertyChange[]> getThreadToPropertyChanges() {
		return threadToPropertyChanges;
	}
	
	
	public Map<Thread, String[]> getThreadToStrings() {
		return threadToStrings;
	}
	protected TestCaseResult preForkFailTestResult (String anExpectedLines) {
		return fail("Prefork output did not match:" + anExpectedLines);
	}
	
	
	public int getNumOutputtingThreads() {
		return numOutputtingThreads;
	}

	protected double preForkPartialCredit () {
		return 0.1;
	}
	protected double postForkPartialCredit () {
		return 0.8;
	}
	
	protected double postJoinPartialCredit () {
		return 0.1;
	}
	protected double forkedThreadPartialCredit () {
		return 0;
	}
	
	protected double rootThreadPartialCredit () {
		return 0;
	}


	
	protected TestCaseResult postForkFailTestResult (String anExpectedLines) {
		return partialPass(preForkPartialCredit(), "Post Fork output did not match:" + anExpectedLines);
	}
	protected TestCaseResult postJoinTestResult (String anExpectedLines) {
		return partialPass(postForkPartialCredit (), "Post Join output did not match:" + anExpectedLines);
	}
	
	protected LinesMatcher getLinesMatcher() {
		return getResultingOutErr().getLinesMatcher();
	}
	protected TestCaseResult checkPreForkOutput() {
    	LinesMatcher aLinesMatcher = getLinesMatcher();
    	boolean aPreForkRetVal = true;
    	SubstringSequenceChecker aPreForkChecker = preForkChecker();
    	if (aPreForkChecker != null) {
    		aPreForkRetVal = aPreForkChecker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_LINE, Pattern.DOTALL);
    	
    	if (!aPreForkRetVal) {
			String anExpectedLines = Arrays.toString(aPreForkChecker.getSubstrings());
			return fail("Pre fork output did not match:" + anExpectedLines);
		}
    	}
    	return partialPass(preForkPartialCredit(), "Pre fork output correct\n");
    }
	
	protected TestCaseResult checkPostForkOutput() {
    	LinesMatcher aLinesMatcher = getLinesMatcher();
    	forkLineNumber = aLinesMatcher.getMaxMatchedLineNumber();
    	aLinesMatcher.setStartLineNumber(forkLineNumber);    	
    	boolean aPostForkRetVal = true;
    	SubstringSequenceChecker aPostForkChecker = postForkChecker();
    	if (aPostForkChecker != null) {
    		aPostForkRetVal = aPostForkChecker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_UNORDERED, Pattern.DOTALL);
    	
    	if (!aPostForkRetVal) {
			String anExpectedLines = Arrays.toString(aPostForkChecker.getSubstrings());
			return fail("Pre fork output did not match:" + anExpectedLines);
		}
    	}    	
		return partialPass(postForkPartialCredit(), "Pre fork output correct\n");
    }
	protected TestCaseResult checkPostJoinOutput() {
    	LinesMatcher aLinesMatcher = getLinesMatcher();    	
    	joinLineNumber = aLinesMatcher.getMaxMatchedLineNumber();
    	aLinesMatcher.setStartLineNumber(joinLineNumber);  	

    	boolean aPostJoinRetVal = true;
    	SubstringSequenceChecker aPostJoinChecker = postJoinChecker();
    	if (aPostJoinChecker != null) {
    		aPostJoinRetVal = aPostJoinChecker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_LINE, Pattern.DOTALL);
    	
    	if (!aPostJoinRetVal) {
			String anExpectedLines = Arrays.toString(aPostJoinChecker.getSubstrings());

			return 	fail("Post join output did not match:" + anExpectedLines);
		} 
    	}
		return partialPass(postJoinPartialCredit(), "Post Join output correct\n");
    }
	
	protected TestCaseResult checkRootThreadOutput(String[] aRootThreadOutput) {
		SubstringSequenceChecker aRootThreadChecker = rootThreadChecker();
		if (aRootThreadChecker == null) {
			return pass();
		}
		if (aRootThreadOutput == null) {
			return fail("No root thread output");
		}
    	LinesMatcher aLinesMatcher = new ALinesMatcher(aRootThreadOutput);
    	boolean retVal = aRootThreadChecker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_LINE, Pattern.DOTALL);
    	
    	
    	if (!retVal) {
			String anExpectedLines = Arrays.toString(aRootThreadChecker.getSubstrings());

			return 	fail("Root thread output did not match:" + anExpectedLines);
		} 
    	
		return partialPass(rootThreadPartialCredit(), "Root thread output correct\n");
    }
	
	protected TestCaseResult checkForkedThreadOutput(Thread aThread, String[] aForkedThreadOutput) {
		SubstringSequenceChecker aForkedThreadChecker = forkedThreadChecker();
		if (aForkedThreadChecker == null) {
			return pass();
		}
		if (aForkedThreadChecker == null) {
			return fail("No root thread output");
		}
    	LinesMatcher aLinesMatcher = new ALinesMatcher(aForkedThreadOutput);
    	boolean retVal = aForkedThreadChecker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_LINE, Pattern.DOTALL);
    	
    	
    	if (!retVal) {
			String anExpectedLines = Arrays.toString(aForkedThreadChecker.getSubstrings());

			return 	fail("Forked thread " + aThread + " output did not match:" + anExpectedLines);
		} 
    	
		return partialPass(rootThreadPartialCredit(),  "Forked thread " + aThread + " output correct\n");
    }


    protected TestCaseResult checkOutput() {
    	TestCaseResult aPreForkResult = checkPreForkOutput();
    	TestCaseResult aPostForkResult = checkPostForkOutput();
    	TestCaseResult aPostJoinResult = checkPostJoinOutput();
    	double aTotalCredit = 
    			aPreForkResult.getPercentage() +
    			aPostForkResult.getPercentage() +
    			aPostJoinResult.getPercentage();
    	if (aTotalCredit == 1.0) {
    		return pass();
    	}
    	
    	String aTotalNotes = 
    			aPreForkResult.getNotes() +
    			aPostForkResult.getNotes() +
    			aPostJoinResult.getNotes();
    	return partialPass(
    			aTotalCredit,
    			aTotalNotes);
    	
    }
    protected TestCaseResult checkEvents() {
    	propertyChanges = getConcurrentPropertyChangeSupport().getConcurrentPropertyChanges();
    	threadToPropertyChanges = ConcurrentEventUtility.getConcurrentPropertyChangesByThread(propertyChanges);
    	threadToStrings = ConcurrentEventUtility.toNewValueStrings(threadToPropertyChanges);
    	numOutputtingThreads = threadToPropertyChanges.size();)
    	TestCaseResult aRootThreadResult;
    	List<TestCaseResult> aForkedThreadResults = new ArrayList();
    	for (Thread aThread:threadToStrings.keySet()) {
    		String[] aStrings = threadToStrings.get(aThread);
    		if (aThread == rootThread) {
    			aRootThreadResult = checkRootThreadOutput(aStrings);
    		} else {
    			aForkedThreadResults.add(checkForkedThreadOutput(aThread, aStrings));
    		}
    	}
    	
    	
    	
    	return pass();
    }
	
	
}

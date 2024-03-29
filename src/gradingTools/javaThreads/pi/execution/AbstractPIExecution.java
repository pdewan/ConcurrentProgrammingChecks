package gradingTools.javaThreads.pi.execution;
import java.util.Map;
import grader.basics.concurrency.propertyChanges.ConcurrentPropertyChange;
import grader.basics.execution.ResultingOutErr;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.javaThreads.pi.ConcurrentPISuite;
import gradingTools.shared.testcases.concurrency.outputObserver.AbstractForkJoinChecker;
import util.annotations.MaxValue;
@MaxValue(2)
public abstract class AbstractPIExecution extends AbstractForkJoinChecker {	
	static final int NUM_THREADS = 4;
	public static final String TOTAL_ITERATIONS = "Total Iterations";
	public static final String ITERATION_NUM = "Iteration Num";
	public static final String X = "X";
	public static final String Y = "Y";
	public static final String IN_CIRCLE = "In Circle";
	public static final String NUM_IN_CIRCLE = "Num In Circle";
	public static final String TOTAL_IN_CIRCLE = "Total In Circle";
	public static final String PI = "PI";
	
	static final Object[][] PRE_FORK_PROPERTIES = {
			{TOTAL_ITERATIONS, Integer.class}			
	};
	static final Object[][] ITERATION_PROPERTIES = {
			{ITERATION_NUM, Number.class},
			{X, Double.class},
			{Y, Double.class},
			{IN_CIRCLE, Boolean.class}
	};
	static final Object[][] POST_ITERATION_PROPERTIES = {
			{NUM_IN_CIRCLE, Integer.class},			
	};
	static final Object[][] POST_JOIN_PROPERTIES = {
			{TOTAL_IN_CIRCLE, Integer.class},
			{PI, Double.class}
	};
	@Override
	protected String mainClassIdentifier() {
		return ConcurrentPISuite.ROOT_CLASS;
	}
	@Override
	protected String[] args() {
		return new String[] {Integer.toString( totalIterations())};
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
	int totalIterations;
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
//		System.out.println ("Thread processing switched from " + aPreviousThread + " to " + aNewThread);
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
		totalIterations = (int) aNameValuePairs.get(TOTAL_ITERATIONS);
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
//		System.out.println ("Thread:" + aThread.getId() + " iteration properties: " + aNameValuePairs);
		double x = (double) aNameValuePairs.get(X);
		double y = (double) aNameValuePairs.get(Y);
		boolean inCircle = (boolean) aNameValuePairs.get(IN_CIRCLE);
		if (inCircle) {
			numNumbersFoundByCurrentThread++;
		}
		boolean isActualInCircle = Math.sqrt(x*x + y*y) < 1.0;
		if (inCircle != isActualInCircle) {
			return "In Circle output as " + inCircle + " for numbers (" + x + "," + y + ")" + " but should be " + isActualInCircle;
		}		
		return null;
	}
	@Override
	protected  String postIterationEventsMessage(Thread aThread, Map<String, Object> aNameValuePairs) {
//		if (isRootThread(aThread)) {
//			System.out.println("Unxpected root thread");
//			return null;
//		}
		int aNumNumbersComputed = (int) aNameValuePairs.get(NUM_IN_CIRCLE);
		if (aNumNumbersComputed != numNumbersFoundByCurrentThread) {
			return "Thread " + aThread.getId() + " found " + numNumbersFoundByCurrentThread + " but computed " + aNumNumbersComputed;
		}
		numExpectedFinalNumbers += aNumNumbersComputed;
		return null;
	}
	@Override
	protected  String postJoinEventsMessage(Thread aThread, Map<String, Object> aNameValuePairs) {
		int aComputedFinalNumbers = (int) aNameValuePairs.get(TOTAL_IN_CIRCLE);
		if (aComputedFinalNumbers != numExpectedFinalNumbers) {
			return "Computed final numbers " + aComputedFinalNumbers + " != " + "expected final numbers " + numExpectedFinalNumbers;
		}
		double anExpectedPI = (((double) aComputedFinalNumbers) / totalIterations)*4;
		double aComputedPI = (double) aNameValuePairs.get("PI");
		if (aComputedPI != anExpectedPI) {
			return "Computed PI " + aComputedPI + " != " + "expected PI " + anExpectedPI;
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

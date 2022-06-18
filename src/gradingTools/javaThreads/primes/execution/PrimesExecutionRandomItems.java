package gradingTools.javaThreads.primes.execution;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import util.annotations.MaxValue;
@MaxValue(30)
public class PrimesExecutionRandomItems extends AbstractPrimeExecution {
	public static int MAX_ITEMS = 25;
	int numItems;
	public PrimesExecutionRandomItems() {
	     numItems = (int) Math.ceil(Math.random()*MAX_ITEMS);
	     if (numItems <= 4) {
	    	 numItems = 7;
	     }
	}
	protected  int numExpectedItems() {
		return numItems;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		return super.test(project, autoGrade);
	}
	@Override
	protected Object[][] preForkPropertyNamesAndType() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected Object[][] iterationPropertyNamesAndType() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected Object[][] postIterationPropertyNamesAndType() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected Object[][] postJoinPropertyNamesAndType() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected int totalIterations() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	

	
}

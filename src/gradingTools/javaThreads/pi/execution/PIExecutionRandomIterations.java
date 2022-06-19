package gradingTools.javaThreads.pi.execution;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import util.annotations.MaxValue;
@MaxValue(30)
public class PIExecutionRandomIterations extends AbstractPIExecution {
	public static int MAX_ITEMS = 9;
	int numItems;
	public PIExecutionRandomIterations() {
	     numItems = (int) Math.ceil(Math.random()*MAX_ITEMS);
	     if (numItems <= 2) {
	    	 numItems = 3;
	     }
	}
	@Override
	protected int totalIterations() {
		return numItems;
	}
	
}

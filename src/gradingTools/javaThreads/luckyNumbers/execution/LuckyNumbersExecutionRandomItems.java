package gradingTools.javaThreads.luckyNumbers.execution;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import util.annotations.MaxValue;
@MaxValue(30)
public class LuckyNumbersExecutionRandomItems extends AbstractLuckyNumbersExecution {
	public static int MAX_ITEMS = 25;
	int numItems;
	public LuckyNumbersExecutionRandomItems() {
	     numItems = (int) Math.ceil(Math.random()*MAX_ITEMS);
	     if (numItems <= 4) {
	    	 numItems = 7;
	     }
	}	
	
	@Override
	protected int totalIterations() {
		// TODO Auto-generated method stub
		return numItems;
	}
	

	

	
}

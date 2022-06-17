package gradingTools.javaThreads.hello.execution;

import grader.basics.execution.ResultingOutErr;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import util.annotations.MaxValue;
@MaxValue(10)
public class HelloExecutionTwoChildren extends AbstractHelloExecution {
	
	protected  int numExpectedForkedThreads() {
		return 2;
	}
    
	

	

	
}

package gradingTools.javaThreads.hello.execution;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import util.annotations.MaxValue;
@MaxValue(2)
public class HelloExecutionRandomChildren extends AbstractHelloExecution {
	public static int MAX_THREADS = 10;
	int numThreads;
	public HelloExecutionRandomChildren() {
	     numThreads = (int) Math.ceil(Math.random()*MAX_THREADS);
	     if (numThreads <= 1) {
	    	 numThreads = 2;
	     }
	}
	protected  int numExpectedForkedThreads() {
		return numThreads;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		return super.test(project, autoGrade);
	}
	

	

	
}

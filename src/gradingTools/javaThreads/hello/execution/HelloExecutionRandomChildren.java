package gradingTools.javaThreads.hello.execution;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import util.annotations.MaxValue;
@MaxValue(30)
public class HelloExecutionRandomChildren extends AbstractHelloExecution {
	public static int MAX_THREADS = 10;
	int numThreads;
	public HelloExecutionRandomChildren() {
	     numThreads = (int) Math.ceil(Math.random()*MAX_THREADS);
	     if (numThreads <= 2) {
	    	 numThreads = 4;
	     }
	}
	protected  int numExpectedForkedThreads() {
		return numThreads;
	}
	
//	@Override
//	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
//			NotGradableException {
//		return super.test(project, autoGrade);
//	}
//	@Override
//	protected Object[][] preForkPropertyNamesAndType() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	protected Object[][] iterationPropertyNamesAndType() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	protected Object[][] postIterationPropertyNamesAndType() {
//		return null;
//	}
//	@Override
//	protected Object[][] postJoinPropertyNamesAndType() {
//		return null;
//	}
//	@Override
//	protected int totalIterations() {
//		return 0;
//	}
//	

	

	
}

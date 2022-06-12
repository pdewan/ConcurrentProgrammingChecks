package gradingTools.javaThreads.hello.execution;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import util.annotations.MaxValue;
@MaxValue(2)
public class HelloExecutionSingleChild extends AbstractHelloExecution {

	protected  int numExpectedForkedThreads() {
		return 1;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		return super.test(project, autoGrade);
	}
	

	

	
}

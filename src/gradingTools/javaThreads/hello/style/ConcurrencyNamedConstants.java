package gradingTools.javaThreads.hello.style;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.basics.sharedTestCase.checkstyle.MnemonicNameRatioTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.NamedConstantsRatioCheck;

public class ConcurrencyNamedConstants extends NamedConstantsRatioCheck {
	public TestCaseResult test(Project aProject, boolean autoGrade) throws NotAutomatableException, NotGradableException {
        return super.test(aProject, autoGrade);

        
    }

}

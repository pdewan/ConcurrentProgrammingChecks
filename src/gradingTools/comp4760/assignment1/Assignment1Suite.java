package gradingTools.comp4760.assignment1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp4760.assignment1.openmp.testcases.SequentialSumTestCase;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	SequentialSumTestCase.class,	
	
})
	

//@MaxValue(50)
public class Assignment1Suite {

	public static void main (String[] args) {
		try {
//		  Tracer.showInfo(true);
//			GraderBasicsTraceUtility.setBufferTracedMessages(false);
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
//			setStudentGradableProjectLocation("D:\\dewan_backup\\C\\OpenMPTraining");
			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.CPlusPlus_LANGUAGE);
			BasicJUnitUtils.interactiveTest(Assignment1Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicProjectIntrospection.setCheckAllSpecifiedTags(true);
		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);



	}
}

package gradingTools.comp530f22.assignment5;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.AValgrindMakeCommandGenerator;
import grader.basics.execution.BasicRunningProject;
import grader.basics.execution.ExecutableFinderSelector;
import grader.basics.junit.BasicJUnitUtils;


@RunWith(Suite.class)
@Suite.SuiteClasses({

	LRUTest.class,
	
	
})
public class LRUSuite {
	public static void main (String[] args) {
		try {
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//			BasicStaticConfigurationUtils.setModule("Comp524");
//			BasicStaticConfigurationUtils.setProblem("Assignment1");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(Assignment1Suite.class);
			BasicJUnitUtils.interactiveTest(LRUSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
//		sBasicProjectIntrospection.setCheckAllSpecifiedTags(true);
//		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setEchoOutput(false);
//		BasicRunningProject.setEchoOutput(false);

		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage("C");
//		ExecutableFinderSelector.setMainClassFinder(new AnExecutableFinder());
//		BasicLanguageDependencyManager.se
//		ExecutableFinderSelector.setMainClassFinder(new AValgrindMakeCommandGenerator());
		BasicLanguageDependencyManager.setMainClassFinder(new AValgrindMakeCommandGenerator());

//		setValgrindConfigurationDirectory(newVal);
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification()
//		.setValgrindConfiguration("BoundedBufferConfig");
		.setValgrindConfiguration("MutexLruConfig");
		String[] aCommand = new String[]{"./lru-mutex-wrapped", "-c", "2"};
		List<String> aCommandList = Arrays.asList(aCommand);
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification()
//		.setValgrindConfiguration("BoundedBufferConfig");
		.setGraderBasicCommand(aCommandList);


	}
}

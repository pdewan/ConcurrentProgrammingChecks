package gradingTools.comp530f24.assignment5;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.concurrency.propertyChanges.ConcurrentEventUtility;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.AValgrindMakeCommandGenerator;
import grader.basics.execution.BasicRunningProject;
import grader.basics.execution.ExecutableFinderSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.shared.testcases.MethodExecutionTest;
import util.trace.*;


@RunWith(Suite.class)
@Suite.SuiteClasses({
//	LRUSource.class,
	LRUOutput.class,
	BlockOnConditionVariables.class,
	ReleaseConditionWaiters.class,
	BroadcastVsSignal.class
	
	
})
public class Assignment5Suite {
	public static void main (String[] args) {
		try {
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//			BasicStaticConfigurationUtils.setModule("Comp524");
//			BasicStaticConfigurationUtils.setProblem("Assignment1");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(Assignment1Suite.class);
			System.out.println(" Starting interactive tests");

			BasicJUnitUtils.interactiveTest(Assignment5Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		ConcurrentEventUtility.setThreadsInDifferentProcess(true);
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setEchoOutput(false);
    	 BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setProcessOutputSleepTime(1);


		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage("C");

		BasicLanguageDependencyManager.setMainClassFinder(new AValgrindMakeCommandGenerator());

		BasicExecutionSpecificationSelector.getBasicExecutionSpecification()
		.setValgrindConfiguration("MutexLruConfig");
		String[] aCommand = new String[]{"./lru-mutex-wrapped", "-c", "2"};
		List<String> aCommandList = Arrays.asList(aCommand);
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification()
		.setGraderBasicCommand(aCommandList);
		Tracer.setKeywordPrintStatus(Assignment5Suite.class, true);



	}
}

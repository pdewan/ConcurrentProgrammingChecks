package gradingTools.javaThreads.luckyNumbers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.javaThreads.luckyNumbers.execution.LuckyNumbersExecutionChecks;
import gradingTools.javaThreads.luckyNumbers.source.LuckyNumbersSourceChecks;
import gradingTools.javaThreads.luckyNumbers.style.LuckyNumbersStyleChecks;
import gradingTools.shared.testcases.ConcurrencySuiteSkeleton;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	LuckyNumbersSourceChecks.class,
	LuckyNumbersExecutionChecks.class,
	LuckyNumbersStyleChecks.class
//	HelloExecutionChecks.class,
//	HelloSourceChecks.class,
//	HelloStyleChecks.class
	
//	GreetingCheckstyle.class
})
public class ConcurrentLuckyNumbersSuite extends ConcurrencySuiteSkeleton {
		public static final String ROOT_CLASS = "ConcurrentLuckyNumbers";
		public static final String WORKER_CLASS = "LuckyNumbersWorker";

		public static void main (String[] args) {
		try {

			processArgs(args);
			BasicJUnitUtils.interactiveTest(ConcurrentLuckyNumbersSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
		setCheckStyleConfiguration("unc_checks_concurrency.xml");
	}
	
}

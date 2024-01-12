package gradingTools.javaThreads.oddNumbers;

import java.util.Arrays;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.javaThreads.hello.execution.HelloExecutionChecks;
import gradingTools.javaThreads.hello.source.HelloSourceChecks;
import gradingTools.javaThreads.hello.style.HelloStyleChecks;
import gradingTools.javaThreads.luckyNumbers.execution.LuckyNumbersExecutionChecks;
import gradingTools.javaThreads.luckyNumbers.style.LuckyNumbersStyleChecks;
import gradingTools.javaThreads.oddNumbers.execution.OddNumbersExecutionChecks;
import gradingTools.javaThreads.oddNumbers.source.OddNumbersSourceChecks;
import gradingTools.javaThreads.oddNumbers.style.OddNumbersStyleChecks;
import gradingTools.javaThreads.primes.execution.PrimesExecutionChecks;
import gradingTools.javaThreads.primes.source.PrimesSourceChecks;
import gradingTools.shared.testcases.AssignmentSuiteSkeleton;
import gradingTools.shared.testcases.ConcurrencySuiteSkeleton;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	OddNumbersSourceChecks.class,
	OddNumbersExecutionChecks.class,
	OddNumbersStyleChecks.class
//	HelloExecutionChecks.class,
//	HelloSourceChecks.class,
//	HelloStyleChecks.class
	
//	GreetingCheckstyle.class
})
public class ConcurrentOddNumbersSuite extends ConcurrencySuiteSkeleton {
		public static final String ROOT_CLASS = "ConcurrentOddNumbers";
		public static final String DISPATCHER_CLASS = "OddNumbersDispatcher";

//		public static final String WORKER_CLASS = "OddNumbersWorke";
		public static final String WORKER_CLASS = "OddNumbersWorkerCode";

		public static void main (String[] args) {
		try {

			processArgs(args);
			BasicJUnitUtils.interactiveTest(ConcurrentOddNumbersSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
		setCheckStyleConfiguration("unc_checks_concurrency.xml");
	}
	
}

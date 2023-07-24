package gradingTools.javaThreads;

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
import gradingTools.javaThreads.pi.execution.PIExecutionChecks;
import gradingTools.javaThreads.pi.source.PISourceChecks;
import gradingTools.javaThreads.primes.execution.ExtendedPrimesExecutionFixedItems;
import gradingTools.javaThreads.primes.execution.ExtendedPrimesPerformanceChecker;
import gradingTools.javaThreads.primes.execution.PrimesExecutionChecks;
import gradingTools.javaThreads.primes.source.PrimesSourceChecks;
import gradingTools.javaThreads.source.JavaThreadsSourceChecks;
import gradingTools.javaThreads.style.JavaThreadsStyleChecks;
import gradingTools.shared.testcases.AssignmentSuiteSkeleton;
import gradingTools.shared.testcases.ConcurrencySuiteSkeleton;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	ExtendedPrimesExecutionFixedItems.class,
	ExtendedPrimesPerformanceChecker.class
	


})
public class ExtendedJavaThreadsSuite extends ConcurrencySuiteSkeleton {
//		public static final String ROOT_CLASS = "ConcurrentOddNumbers";
//		public static final String WORKER_CLASS = "OddNumbersWorker";

		public static void main (String[] args) {
		try {

			processArgs(args);
			BasicJUnitUtils.interactiveTest(ExtendedJavaThreadsSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
		setCheckStyleConfiguration("unc_checks_concurrency.xml");
	}
	
}

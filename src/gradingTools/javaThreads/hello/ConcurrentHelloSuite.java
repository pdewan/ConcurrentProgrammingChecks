package gradingTools.javaThreads.hello;

import java.util.Arrays;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.javaThreads.hello.execution.HelloExecutionChecks;
import gradingTools.javaThreads.hello.source.HelloSourceChecks;
import gradingTools.javaThreads.hello.style.ConcurrencyStyleChecks;
import gradingTools.javaThreads.primes.source.PrimesSourceChecks;
import gradingTools.shared.testcases.AssignmentSuiteSkeleton;
import gradingTools.shared.testcases.ConcurrencySuiteSkeleton;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	HelloExecutionChecks.class,
	HelloSourceChecks.class,
	ConcurrencyStyleChecks.class
	
//	GreetingCheckstyle.class
})
public class ConcurrentHelloSuite extends ConcurrencySuiteSkeleton {
		public static final String ROOT_CLASS = "Hello";
		public static final String WORKER_CLASS = "HelloWorker";

		public static void main (String[] args) {
		try {

			processArgs(args);
			BasicJUnitUtils.interactiveTest(ConcurrentHelloSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
		setCheckStyleConfiguration("unc_checks_concurrency_hello.xml");
	}
	
}

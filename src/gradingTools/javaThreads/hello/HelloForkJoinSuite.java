package gradingTools.javaThreads.hello;

import java.util.Arrays;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.javaThreads.hello.execution.HelloExecutionChecks;
import gradingTools.javaThreads.hello.execution.HelloForkJoinTest;
import gradingTools.javaThreads.hello.source.HelloSourceChecks;
import gradingTools.javaThreads.hello.style.HelloStyleChecks;
import gradingTools.javaThreads.primes.source.PrimesSourceChecks;
import gradingTools.shared.testcases.AssignmentSuiteSkeleton;
import gradingTools.shared.testcases.ConcurrencySuiteSkeleton;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	HelloForkJoinTest.class
	
//	GreetingCheckstyle.class
})
public class HelloForkJoinSuite extends ConcurrencySuiteSkeleton {
		

		public static void main (String[] args) {
		try {

			processArgs(args);
			BasicJUnitUtils.interactiveTest(HelloForkJoinSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
//		setCheckStyleConfiguration("unc_checks_concurrency.xml");
	}
	
}

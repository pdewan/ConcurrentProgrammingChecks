package gradingTools.javaThreads.pi;

import java.util.Arrays;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.javaThreads.hello.execution.HelloExecutionChecks;
import gradingTools.javaThreads.hello.source.HelloSourceChecks;
import gradingTools.javaThreads.hello.style.HelloStyleChecks;
import gradingTools.javaThreads.primes.execution.PrimesExecutionChecks;
import gradingTools.javaThreads.primes.source.PrimesSourceChecks;
import gradingTools.shared.testcases.AssignmentSuiteSkeleton;
import gradingTools.shared.testcases.ConcurrencySuiteSkeleton;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	PrimesSourceChecks.class,
	PrimesExecutionChecks.class,
	HelloStyleChecks.class
//	HelloExecutionChecks.class,
//	HelloSourceChecks.class,
//	HelloStyleChecks.class
	
//	GreetingCheckstyle.class
})
public class ConcurrentPISuite extends ConcurrencySuiteSkeleton {
		public static final String ROOT_CLASS = "ConcurrentMonteCarloPI";
		public static final String WORKER_CLASS = "PrimesWorker";

		public static void main (String[] args) {
		try {

			processArgs(args);
			BasicJUnitUtils.interactiveTest(ConcurrentPISuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
		setCheckStyleConfiguration("unc_checks_concurrency.xml");
	}
	
}

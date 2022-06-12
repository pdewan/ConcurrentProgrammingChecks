package gradingTools.javaThreads.hello;

import java.util.Arrays;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.javaThreads.hello.execution.HelloExecutionChecks;
import gradingTools.javaThreads.hello.source.HelloSourceChecks;
import gradingTools.javaThreads.hello.style.HelloStyleChecks;
import gradingTools.shared.testcases.AssignmentSuiteSkeleton;
import gradingTools.shared.testcases.ConcurrencySuiteSkeleton;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	HelloExecutionChecks.class,
	HelloSourceChecks.class,
	HelloStyleChecks.class
	
//	GreetingCheckstyle.class
})
public class ConcurrentHelloSuite extends ConcurrencySuiteSkeleton {
//	static String mainClass;
//	public static String getMainClass() {
//		return mainClass;
//	}
	
		public static void main (String[] args) {
		try {
//			if (args.length > 1) {
//				System.err.println("More than one main argument " + Arrays.toString(args) +  "\nProvide only the main class name as an argument");
//				System.exit(-1);
//			}
//			if (args.length == 1) {
//				mainClass = args[0];
//			}
			processArgs(args);
			BasicJUnitUtils.interactiveTest(ConcurrentHelloSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
		setCheckStyleConfiguration("unc_checks_concurrency.xml");
	}
	
}

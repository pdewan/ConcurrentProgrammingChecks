package gradingTools.javaThreads.hello;

import java.util.Arrays;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.shared.testcases.AssignmentSuiteSkeleton;
import gradingTools.shared.testcases.ConcurrencySuiteSkeleton;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	ConcurrentHelloClassProvided.class,
	ConcurrentHelloRun.class,
	ConcurrencySourceChecks.class
	
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

package gradingTools.javaThreads.hello;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	ConcurrentHelloClassProvided.class,
	ConcurrentHelloRun.class
	
//	GreetingCheckstyle.class
})
public class ConcurrentHelloSuite {
//	public static final String GREETING_MAIN_TAG = "GreetingMain";
		public static void main (String[] args) {
		try {
			
			BasicJUnitUtils.interactiveTest(ConcurrentHelloSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
//		setCheckStyleConfiguration("unc_checks_301_A0.xml");
	}
	
}

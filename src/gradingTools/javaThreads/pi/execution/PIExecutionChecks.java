package gradingTools.javaThreads.pi.execution;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import util.annotations.Explanation;
import util.annotations.MaxValue;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	PIExecutionFixedIterations.class,
//	PIExecutionRandomIterations.class
	

})
@Explanation("Checks execution constraints")
//@MaxValue(10)
public class PIExecutionChecks {

	
}

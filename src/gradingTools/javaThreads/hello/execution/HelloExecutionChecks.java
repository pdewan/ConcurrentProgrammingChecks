package gradingTools.javaThreads.hello.execution;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import util.annotations.Explanation;
import util.annotations.MaxValue;
@RunWith(Suite.class)
@Suite.SuiteClasses({
//	HelloClassProvided.class,
	HelloExecutionTwoChildren.class,
	HelloExecutionRandomChildren.class
//	HelloExectutionMultipleArgs.class,	

})
@Explanation("Checks execution constraints")
//@MaxValue(10)
public class HelloExecutionChecks {

	
}

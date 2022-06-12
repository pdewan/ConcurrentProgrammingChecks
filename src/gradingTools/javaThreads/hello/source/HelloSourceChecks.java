package gradingTools.javaThreads.hello.source;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.javaThreads.hello.execution.extra.HelloMainDefined;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@RunWith(Suite.class)
@Suite.SuiteClasses({
//	HelloMainDefined.class,
	HelloCallsParseInt.class,
	HelloInstantiatesThread.class,
	HelloInstantiatesHelloWorker.class,
	HelloCallsThreadStart.class,
	HelloCallsThreadJoin.class,
	HelloWorkerCallsPrintln.class,

})
@Explanation("Checks source code constraints")
@MaxValue(10)
public class HelloSourceChecks {

	
}

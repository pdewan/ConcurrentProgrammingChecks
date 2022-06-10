package gradingTools.javaThreads.hello.source;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import util.annotations.Explanation;
import util.annotations.MaxValue;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	HelloMainDefined.class,
	HelloCallsParseInt.class,
	HelloInstantiatesThread.class,
	HelloInstantiatesHelloWorker.class,
	HelloCallsThreadStart.class,
	HelloCallsThreadJoin.class,
	HelloWorkerCallsPrint.class,

})
@Explanation("Checks source code constraints")
@MaxValue(10)
public class ConcurrencySourceChecks {

	
}

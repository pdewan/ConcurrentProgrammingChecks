package gradingTools.javaThreads.primes.source;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.javaThreads.hello.execution.extra.HelloMainDefined;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@RunWith(Suite.class)
@Suite.SuiteClasses({
//	HelloMainDefined.class,
	PrimesCallsParseInt.class,
	PrimesInstantiatesThread.class,
	PrimesInstantiatesPrimesWorker.class,
	PrimeCallsThreadStart.class,
	PrimesCallsThreadJoin.class,
	PrimesWorkerISARunnable.class,
	PrimesWorkerCallsPrintln.class,

})
@Explanation("Checks source code constraints")
@MaxValue(10)
public class PrimesSourceChecks {

	
}

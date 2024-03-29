package gradingTools.javaThreads.primes.source;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsThreadJoin;
import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsThreadStart;
import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassInstantiatesThread;
import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassInstantiatesWorker;
import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.WorkerCallsPrintln;
import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.WorkerISARunnable;
import gradingTools.javaThreads.hello.execution.extra.HelloMainDefined;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@RunWith(Suite.class)
@Suite.SuiteClasses({
//	ConcurrentPrimeMainCallsPrintln.class,
//	ConcurrentPrimeMainCallsParseInt.class,
//	ConcurrentPrimeMainCallsPrintProperty.class,
	ConcurrentPrimeInstantiatesThread.class,
	ConcurrentPrimeCallsThreadStart.class,
	ConcurrentPrimeMainCallsThreadStart.class,
	ConcurrentPrimeCallsThreadJoin.class,
	ConcurrentPrimeMainCallsThreadJoin.class,
	ConcurrentPrimeInstantiatesWorker.class,
	PrimeWorkerISARunnable.class,
//	PrimeWorkerRunCallsPrintProperty.class

})
@Explanation("Checks source code constraints")
@MaxValue(2)
public class PrimesSourceChecks {

	
}

package gradingTools.javaThreads.oddNumbers.source;

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
//	HelloMainDefined.class,
	ConcurrentClassCallsParseInt.class,
	ConcurrentClassInstantiatesThread.class,
	ConcurrentClassInstantiatesWorker.class,
	ConcurrentClassCallsThreadStart.class,
	ConcurrentClassCallsThreadJoin.class,
	WorkerISARunnable.class,
	WorkerCallsPrintln.class,

})
@Explanation("Checks source code constraints")
@MaxValue(10)
public class OddNumbersSourceChecks {

	
}

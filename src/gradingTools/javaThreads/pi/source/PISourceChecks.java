package gradingTools.javaThreads.pi.source;

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
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@RunWith(Suite.class)
@Suite.SuiteClasses({
//	ConcurrentPIMainCallsPrintln.class,
//	ConcurrentPIMainCallsParseInt.class,
//	ConcurrentPIMainCallsPrintProperty.class,
	ConcurrentPIInstantiatesThread.class,
	ConcurrentPICallsThreadStart.class,
	ConcurrentPIMainCallsThreadStart.class,
	ConcurrentPICallsThreadJoin.class,
	ConcurrentPIMainCallsThreadJoin.class,
	ConcurrentPIInstantiatesWorker.class,
	PIWorkerISARunnable.class,
//	PIWorkerRunCallsPrintProperty.class

})
@Explanation("Checks source code constraints")
@MaxValue(2)
@IsExtra(true)
public class PISourceChecks {

	
}

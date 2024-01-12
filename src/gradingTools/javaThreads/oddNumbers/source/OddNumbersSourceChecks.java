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
//	ConcurrentClassCallsParseInt.class,
//	ConcurrentOddMainCallsPrintln.class,
//	ConcurrentOddMainCallsParseInt.class,
//	ConcurrentOddMainCallsPrintProperty.class,
	ConcurrentOddInstantiatesThread.class,
	ConcurrentOddCallsThreadStart.class,
	ConcurrentOddMainCallsThreadStart.class,
	ConcurrentOddCallsThreadJoin.class,
	ConcurrentOddMainCallsThreadJoin.class,
//	OddMainInstantiatesThread.class,
	ConcurrentOddInstantiatesWorker.class,
	OddWorkerISARunnable.class,
	AddOddNumberCallsSleep.class,
	FillOddNumbersSubsetCallsSleep.class,
	CreateAndStartThreadsCallsSleep.class,
	FillOddNumberCallsSerialVersion.class,
	FillOddNumberCallsConcurrentVersion.class,
	ThreadProblemSizeCallsFairVerson.class,
	ThreadProblemSizeCallsUnfairVerson.class,
	

	
//	OddWorkerRunCallsPrintProperty.class
	
//	ConcurrentClassInstantiatesThread.class,
//	ConcurrentClassInstantiatesWorker.class,
//	ConcurrentClassCallsThreadStart.class,
//	ConcurrentClassCallsThreadJoin.class,
//	WorkerISARunnable.class,
//	WorkerCallsPrintln.class,

})
@Explanation("Checks source code constraints")
@MaxValue(2)
public class OddNumbersSourceChecks {

	
}

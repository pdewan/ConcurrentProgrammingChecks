package gradingTools.javaThreads.primes.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleInterfaceDefinedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.WorkerISARunnable;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;
import util.annotations.MaxValue;
@MaxValue(2)
public class PrimesWorkerISARunnable extends WorkerISARunnable {
	
	public PrimesWorkerISARunnable() {
		super(ConcurrentPrimesSuite.WORKER_CLASS);
	}
	

}

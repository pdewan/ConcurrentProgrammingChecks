package gradingTools.javaThreads.primes.source;

import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassISARunnable;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class PrimeWorkerISARunnable extends ClassISARunnable {
	public PrimeWorkerISARunnable() {
		super(ConcurrentPrimesSuite.WORKER_CLASS);

	}
	
}

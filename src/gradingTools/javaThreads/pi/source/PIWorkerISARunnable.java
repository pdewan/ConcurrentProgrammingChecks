package gradingTools.javaThreads.pi.source;

import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassISARunnable;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;
import gradingTools.javaThreads.pi.ConcurrentPISuite;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class PIWorkerISARunnable extends ClassISARunnable {
	public PIWorkerISARunnable() {
		super(ConcurrentPISuite.WORKER_CLASS);

	}
	
}

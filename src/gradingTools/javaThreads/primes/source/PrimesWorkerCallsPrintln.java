package gradingTools.javaThreads.primes.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallesPrintln;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class PrimesWorkerCallsPrintln extends ClassCallesPrintln {

	public PrimesWorkerCallsPrintln() {
		super(ConcurrentPrimesSuite.WORKER_CLASS);
	}

}

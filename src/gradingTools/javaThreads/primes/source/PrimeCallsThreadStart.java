package gradingTools.javaThreads.primes.source;

import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassCallsThreadStart;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class PrimeCallsThreadStart extends RootClassCallsThreadStart {

	public PrimeCallsThreadStart() {
		super(ConcurrentPrimesSuite.ROOT_CLASS);
	}

}

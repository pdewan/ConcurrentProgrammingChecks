package gradingTools.javaThreads.primes.source;

import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassCallsThreadJoin;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class PrimesCallsThreadJoin extends RootClassCallsThreadJoin {

	public PrimesCallsThreadJoin() {
		super(ConcurrentPrimesSuite.ROOT_CLASS);
	}
	

}

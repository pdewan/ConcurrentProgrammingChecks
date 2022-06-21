package gradingTools.javaThreads.primes.source;

import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassCallsThreadStart;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class ConcurrentPrimeCallsThreadStart extends RootClassCallsThreadStart {
	public ConcurrentPrimeCallsThreadStart() {
		super(ConcurrentPrimesSuite.ROOT_CLASS);

	}
	
}

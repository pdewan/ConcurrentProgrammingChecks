package gradingTools.javaThreads.primes.source;

import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassInstantiatesThread;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class ConcurrentPrimeInstantiatesThread extends RootClassInstantiatesThread {
	public ConcurrentPrimeInstantiatesThread() {
		super(ConcurrentPrimesSuite.ROOT_CLASS);

	}
	
}

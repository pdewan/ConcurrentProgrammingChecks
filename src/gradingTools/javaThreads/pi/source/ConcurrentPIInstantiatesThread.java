package gradingTools.javaThreads.pi.source;

import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassInstantiatesThread;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;
import gradingTools.javaThreads.pi.ConcurrentPISuite;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class ConcurrentPIInstantiatesThread extends RootClassInstantiatesThread {
	public ConcurrentPIInstantiatesThread() {
		super(ConcurrentPISuite.ROOT_CLASS);

	}
	
}

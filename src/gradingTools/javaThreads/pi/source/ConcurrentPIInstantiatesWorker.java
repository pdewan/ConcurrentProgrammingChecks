package gradingTools.javaThreads.pi.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleClassInstantiatedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassInstantiatesThread;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;
import gradingTools.javaThreads.pi.ConcurrentPISuite;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class ConcurrentPIInstantiatesWorker extends CheckstyleClassInstantiatedTestCase {
	public ConcurrentPIInstantiatesWorker() {
		super(ConcurrentPISuite.ROOT_CLASS, ".*Worker");

	}
	
}

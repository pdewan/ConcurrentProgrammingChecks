package gradingTools.javaThreads.primes.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleClassInstantiatedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassInstantiatesThread;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class ConcurrentPrimeInstantiatesWorker extends CheckstyleClassInstantiatedTestCase {
	public ConcurrentPrimeInstantiatesWorker() {
		super(ConcurrentPrimesSuite.ROOT_CLASS, ".*Worker");

	}
	
}

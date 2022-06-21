package gradingTools.javaThreads.pi.source;

import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassCallsThreadJoin;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassCallsThreadStart;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;
import gradingTools.javaThreads.pi.ConcurrentPISuite;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class ConcurrentPIMainCallsThreadJoin extends RootClassCallsThreadJoin {
	public ConcurrentPIMainCallsThreadJoin() {
		super(ConcurrentPISuite.ROOT_CLASS, "main:String\\[\\]->void");

	}
	
}

package gradingTools.javaThreads.pi.source;

import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;
import gradingTools.javaThreads.pi.ConcurrentPISuite;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class ConcurrentPIMainCallsParseInt extends ClassCallsParseInt {
	public ConcurrentPIMainCallsParseInt() {
		super(ConcurrentPISuite.ROOT_CLASS, "main:String\\[\\]->void");

	}
	
}

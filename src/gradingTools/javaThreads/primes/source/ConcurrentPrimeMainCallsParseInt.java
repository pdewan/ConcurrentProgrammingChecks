package gradingTools.javaThreads.primes.source;

import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class ConcurrentPrimeMainCallsParseInt extends ClassCallsParseInt {
	public ConcurrentPrimeMainCallsParseInt() {
		super(ConcurrentPrimesSuite.ROOT_CLASS, "main:String\\[\\]->void");

	}
	
}

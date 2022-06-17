package gradingTools.javaThreads.primes.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodDefinedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class PrimesCallsParseInt extends ClassCallsParseInt {

	public PrimesCallsParseInt() {
		super(ConcurrentPrimesSuite.ROOT_CLASS);
	}

}

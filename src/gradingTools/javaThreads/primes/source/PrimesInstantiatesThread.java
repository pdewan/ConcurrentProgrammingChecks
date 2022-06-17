package gradingTools.javaThreads.primes.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleClassInstantiatedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodDefinedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassInstantiatesThread;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class PrimesInstantiatesThread extends RootClassInstantiatesThread {
	public PrimesInstantiatesThread() {
		super(ConcurrentPrimesSuite.ROOT_CLASS);
	}

}

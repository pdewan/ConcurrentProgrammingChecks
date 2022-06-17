package gradingTools.javaThreads.primes.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleClassInstantiatedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodDefinedTestCase;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class PrimesInstantiatesPrimesWorker extends CheckstyleClassInstantiatedTestCase {
	public PrimesInstantiatesPrimesWorker() {
		super(ConcurrentPrimesSuite.ROOT_CLASS, "default." +ConcurrentPrimesSuite.WORKER_CLASS);
	}

}

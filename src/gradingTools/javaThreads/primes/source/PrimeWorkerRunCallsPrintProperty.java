package gradingTools.javaThreads.primes.source;

import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsPrintProperty;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsPrintln;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class PrimeWorkerRunCallsPrintProperty extends ClassCallsPrintProperty {
	public PrimeWorkerRunCallsPrintProperty() {
		super(ConcurrentPrimesSuite.WORKER_CLASS, "run:->void");

	}
	
}

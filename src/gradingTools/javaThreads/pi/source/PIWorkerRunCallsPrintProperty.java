package gradingTools.javaThreads.pi.source;

import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsPrintProperty;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsPrintln;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;
import gradingTools.javaThreads.pi.ConcurrentPISuite;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;

public class PIWorkerRunCallsPrintProperty extends ClassCallsPrintProperty {
	public PIWorkerRunCallsPrintProperty() {
		super(ConcurrentPISuite.WORKER_CLASS, "run:->void");

	}
	
}

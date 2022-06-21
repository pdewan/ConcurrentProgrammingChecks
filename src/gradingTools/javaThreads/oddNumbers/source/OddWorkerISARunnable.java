package gradingTools.javaThreads.oddNumbers.source;

import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassISARunnable;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;

public class OddWorkerISARunnable extends ClassISARunnable {
	public OddWorkerISARunnable() {
		super(ConcurrentOddNumbersSuite.WORKER_CLASS);

	}
	
}

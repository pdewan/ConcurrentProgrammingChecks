package gradingTools.javaThreads.oddNumbers.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleClassInstantiatedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassInstantiatesThread;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;

public class ConcurrentOddInstantiatesWorker extends CheckstyleClassInstantiatedTestCase {
	public ConcurrentOddInstantiatesWorker() {
		super(ConcurrentOddNumbersSuite.ROOT_CLASS, ".*Worker");

	}
	
}

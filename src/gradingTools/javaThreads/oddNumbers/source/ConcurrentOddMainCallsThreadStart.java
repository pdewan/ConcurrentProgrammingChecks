package gradingTools.javaThreads.oddNumbers.source;

import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassCallsThreadStart;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;

public class ConcurrentOddMainCallsThreadStart extends RootClassCallsThreadStart {
	public ConcurrentOddMainCallsThreadStart() {
		super(ConcurrentOddNumbersSuite.ROOT_CLASS, "main:String\\[\\]->void");

	}
	
}

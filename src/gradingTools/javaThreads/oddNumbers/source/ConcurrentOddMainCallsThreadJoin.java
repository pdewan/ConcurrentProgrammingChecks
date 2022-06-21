package gradingTools.javaThreads.oddNumbers.source;

import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassCallsThreadJoin;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassCallsThreadStart;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;

public class ConcurrentOddMainCallsThreadJoin extends RootClassCallsThreadJoin {
	public ConcurrentOddMainCallsThreadJoin() {
		super(ConcurrentOddNumbersSuite.ROOT_CLASS, "main:String\\[\\]->void");

	}
	
}

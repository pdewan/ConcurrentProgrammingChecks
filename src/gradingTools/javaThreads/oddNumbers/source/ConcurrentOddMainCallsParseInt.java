package gradingTools.javaThreads.oddNumbers.source;

import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;

public class ConcurrentOddMainCallsParseInt extends ClassCallsParseInt {
	public ConcurrentOddMainCallsParseInt() {
		super(ConcurrentOddNumbersSuite.ROOT_CLASS, "main:String\\[\\]->void");

	}
	
}

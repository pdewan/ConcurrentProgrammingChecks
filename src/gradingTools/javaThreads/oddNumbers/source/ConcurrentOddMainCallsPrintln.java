package gradingTools.javaThreads.oddNumbers.source;

import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsPrintln;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;

public class ConcurrentOddMainCallsPrintln extends ClassCallsPrintln {
	public ConcurrentOddMainCallsPrintln() {
		super(ConcurrentOddNumbersSuite.ROOT_CLASS, "main:String\\[\\]->void");

	}
	
}

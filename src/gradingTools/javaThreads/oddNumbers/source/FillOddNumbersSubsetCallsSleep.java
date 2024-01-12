package gradingTools.javaThreads.oddNumbers.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsPrintProperty;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsPrintln;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsSleep;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;

public class FillOddNumbersSubsetCallsSleep extends ClassCallsSleep {
	 public FillOddNumbersSubsetCallsSleep() {			
		  super(ConcurrentOddNumbersSuite.ROOT_CLASS, "fillOddNumbersSubset:int\\[\\];int;int->void");	        
	  }	
}

package gradingTools.javaThreads.oddNumbers.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodNotCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.forkJoin.ConcurrentClassCallsParseInt;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsPrintProperty;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsPrintln;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsSleep;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.javaThreads.oddNumbers.ConcurrentOddNumbersSuite;

public class ThreadProblemSizeCallsUnfairVerson extends CheckstyleMethodNotCalledTestCase {
	 public ThreadProblemSizeCallsUnfairVerson() {			
		  super(ConcurrentOddNumbersSuite.DISPATCHER_CLASS,
				  "threadProblemSize:int;int->int",
				  "unfairThreadRemainderSize:int;int->int");	        
	  }	
}

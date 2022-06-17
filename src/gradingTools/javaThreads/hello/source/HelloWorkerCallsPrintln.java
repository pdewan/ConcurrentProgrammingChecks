package gradingTools.javaThreads.hello.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallesPrintln;
import gradingTools.javaThreads.hello.ConcurrentHelloSuite;

public class HelloWorkerCallsPrintln extends ClassCallesPrintln {

	public HelloWorkerCallsPrintln() {
		super(ConcurrentHelloSuite.WORKER_CLASS);
	}

}

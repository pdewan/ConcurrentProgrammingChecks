package gradingTools.javaThreads.hello.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallesPrintln;

public class HelloWorkerCallsPrintln extends ClassCallesPrintln {

	public HelloWorkerCallsPrintln() {
		super("HelloWorker");
	}

}

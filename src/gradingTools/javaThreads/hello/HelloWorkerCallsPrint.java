package gradingTools.javaThreads.hello;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;

public class HelloWorkerCallsPrint extends CheckstyleMethodCalledTestCase {

	public HelloWorkerCallsPrint() {
		super("HelloWorker", "java\\.io\\.PrintStream!println:\\*->\\.\\*");
		// TODO Auto-generated constructor stub
	}

}

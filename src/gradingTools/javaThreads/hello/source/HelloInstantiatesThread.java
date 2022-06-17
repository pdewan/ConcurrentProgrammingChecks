package gradingTools.javaThreads.hello.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleClassInstantiatedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodDefinedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassInstantiatesThread;
import gradingTools.javaThreads.hello.ConcurrentHelloSuite;

public class HelloInstantiatesThread extends RootClassInstantiatesThread {
	public HelloInstantiatesThread() {
		super(ConcurrentHelloSuite.ROOT_CLASS);
	}

}

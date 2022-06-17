package gradingTools.javaThreads.hello.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleClassInstantiatedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodDefinedTestCase;
import gradingTools.javaThreads.hello.ConcurrentHelloSuite;

public class HelloInstantiatesHelloWorker extends CheckstyleClassInstantiatedTestCase {
	public HelloInstantiatesHelloWorker() {
		super(ConcurrentHelloSuite.ROOT_CLASS, "default." +ConcurrentHelloSuite.WORKER_CLASS);
	}

}

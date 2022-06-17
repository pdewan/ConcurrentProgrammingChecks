package gradingTools.javaThreads.hello.source;

import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassCallsThreadStart;
import gradingTools.javaThreads.hello.ConcurrentHelloSuite;

public class HelloCallsThreadStart extends RootClassCallsThreadStart {

	public HelloCallsThreadStart() {
		super(ConcurrentHelloSuite.ROOT_CLASS);
	}

}

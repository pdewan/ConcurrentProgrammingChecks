package gradingTools.javaThreads.hello.source;

import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassCallsThreadJoin;
import gradingTools.javaThreads.hello.ConcurrentHelloSuite;

public class HelloCallsThreadJoin extends RootClassCallsThreadJoin {

	public HelloCallsThreadJoin() {
		super(ConcurrentHelloSuite.ROOT_CLASS);
	}
	

}

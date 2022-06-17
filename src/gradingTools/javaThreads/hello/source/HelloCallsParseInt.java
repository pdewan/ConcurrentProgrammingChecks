package gradingTools.javaThreads.hello.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodDefinedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;
import gradingTools.javaThreads.hello.ConcurrentHelloSuite;

public class HelloCallsParseInt extends ClassCallsParseInt {

	public HelloCallsParseInt() {
		super(ConcurrentHelloSuite.ROOT_CLASS);
	}

}

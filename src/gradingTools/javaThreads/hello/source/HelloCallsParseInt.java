package gradingTools.javaThreads.hello.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodDefinedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.ClassCallsParseInt;

public class HelloCallsParseInt extends ClassCallsParseInt {

	public HelloCallsParseInt() {
		super("Hello");
	}

}

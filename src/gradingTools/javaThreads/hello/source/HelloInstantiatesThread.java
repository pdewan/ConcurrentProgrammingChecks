package gradingTools.javaThreads.hello.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleClassInstantiatedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodDefinedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.RootClassInstantiatesThread;

public class HelloInstantiatesThread extends RootClassInstantiatesThread {
	public HelloInstantiatesThread() {
		super("Hello");
	}

}

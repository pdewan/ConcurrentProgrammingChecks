package gradingTools.javaThreads.hello;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleClassInstantiatedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodDefinedTestCase;

public class HelloInstantiatesHelloWorker extends CheckstyleClassInstantiatedTestCase {
	public HelloInstantiatesHelloWorker() {
		super("Hello", "default.HelloWorker");
		// TODO Auto-generated constructor stub
	}

}

package gradingTools.javaThreads.hello.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleInterfaceDefinedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.WorkerISARunnable;
import util.annotations.MaxValue;
@MaxValue(2)
public class HelloWorkerISARunnable extends WorkerISARunnable {
	
	public HelloWorkerISARunnable() {
		super("HelloWorker");
	}
	

}

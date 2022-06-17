package gradingTools.javaThreads.hello.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleInterfaceDefinedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.predefined.WorkerISARunnable;
import gradingTools.javaThreads.hello.ConcurrentHelloSuite;
import util.annotations.MaxValue;
@MaxValue(2)
public class HelloWorkerISARunnable extends WorkerISARunnable {
	
	public HelloWorkerISARunnable() {
		super(ConcurrentHelloSuite.WORKER_CLASS);
	}
	

}

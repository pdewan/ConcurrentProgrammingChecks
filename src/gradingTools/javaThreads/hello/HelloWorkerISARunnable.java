package gradingTools.javaThreads.hello;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleInterfaceDefinedTestCase;
import util.annotations.MaxValue;
@MaxValue(2)
public class HelloWorkerISARunnable extends CheckstyleInterfaceDefinedTestCase {
	protected final Class[] PRECEDING_TESTS = {
//			TaggedConsole.class,
			
	};
	@Override
	protected Class[] precedingTests() {
			return PRECEDING_TESTS;
	}
	
//	[INFO] D:\dewan_backup\Java\grail13\.\src\greeting\Cls.java:6: Expected signature main:String[]->void in type greeting.Cls:[@Comp301Tags.GREETING_MAIN]. Good! [ExpectedSignatures]
//	[WARN] D:\dewan_backup\Java\grail13\.\src\greeting\Cls.java:6: Missing signature main:String[]->void in type greeting.Cls:[@Comp301Tags.GREETING_MAIN]. [ExpectedSignatures]
	public HelloWorkerISARunnable() {
		super("HelloWorker", "java.lang.Runnable");
		// TODO Auto-generated constructor stub
	}
	

}

package gradingTools.javaThreads.hello.execution;

import gradingTools.shared.testcases.NameMatchClassTest;
import gradingTools.shared.testcases.NamedClassTest;
import gradingTools.shared.testcases.TaggedClassTest;
import gradingTools.shared.testcases.TaggedOrNamedClassTest;

public class HelloClassProvided extends TaggedOrNamedClassTest {
	public static final String CONCURRENT_HELLO_CLASS_NAME = "Hello";

	@Override
	protected String mainClassIdentifier() {
//		String retVal = ConcurrentHelloSuite.getMainClass();
//		if (retVal != null) {
//			return retVal;
//		}
		
		return CONCURRENT_HELLO_CLASS_NAME;
	}

}

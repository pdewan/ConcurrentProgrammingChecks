package gradingTools.javaThreads.hello;

import gradingTools.shared.testcases.NameMatchClassTest;
import gradingTools.shared.testcases.NamedClassTest;
import gradingTools.shared.testcases.TaggedClassTest;
import gradingTools.shared.testcases.TaggedOrNamedClassTest;

public class ConcurrentHelloClassProvided extends TaggedOrNamedClassTest {
	public static final String CONCURRENT_HELLO_CLASS_NAME = "Hello";

	@Override
	protected String tag() {
		return CONCURRENT_HELLO_CLASS_NAME;
	}

}

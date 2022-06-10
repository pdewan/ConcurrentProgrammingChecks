package gradingTools.javaThreads.hello.execution;

import gradingTools.shared.testcases.concurrency.propertyChanges.Selector;

public class HelloPositiveOutputSelector implements Selector{
	@Override
	public boolean selects(Object anObject) {
		return anObject.toString().contains("ello");
	}
}



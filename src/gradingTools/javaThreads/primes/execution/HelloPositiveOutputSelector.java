package gradingTools.javaThreads.primes.execution;

import grader.basics.concurrency.propertyChanges.Selector;

public class HelloPositiveOutputSelector implements Selector{
	@Override
	public boolean selects(Object anObject) {
		return anObject.toString().contains("ello");
	}
}



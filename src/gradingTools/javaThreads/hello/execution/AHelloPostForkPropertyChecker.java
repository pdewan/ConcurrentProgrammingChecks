package gradingTools.javaThreads.hello.execution;

import grader.basics.output.observer.APropertyBasedStringChecker;
import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class AHelloPostForkPropertyChecker extends APropertyBasedStringChecker {
	
	
protected   String[][] myProperties;
	
public AHelloPostForkPropertyChecker (int aNumThreads) {
	myProperties = new String[aNumThreads][];
	for (int i = 0; i < aNumThreads; i++) {
//		myPatterns[i] = ".*" + i + ".*ello.*" + ".*";
		myProperties[i] = new String[] {"Thread.*" + i, "Greeting", "Hello World"};

	}
	init ( myProperties);
		
	}
//	public AHelloOutputChecker() {
//		init( myPatterns);
//	}
			
}

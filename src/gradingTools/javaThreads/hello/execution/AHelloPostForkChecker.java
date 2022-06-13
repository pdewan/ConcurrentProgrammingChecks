package gradingTools.javaThreads.hello.execution;

import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class AHelloPostForkChecker extends ASubstringSequenceChecker {
	
	
protected   String[] myPatterns;
	
public AHelloPostForkChecker (int aNumThreads) {
	myPatterns = new String[aNumThreads];
	for (int i = 0; i < aNumThreads; i++) {
//		myPatterns[i] = ".*" + i + ".*ello.*" + ".*";
		myPatterns[i] = "Thread.*" + i + "->.*Greeting:.*Hello World.*";

	}
	init ( myPatterns);
		
	}
//	public AHelloOutputChecker() {
//		init( myPatterns);
//	}
			
}

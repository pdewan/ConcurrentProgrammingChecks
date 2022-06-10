package gradingTools.javaThreads.hello;

import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class AHelloThreadOutputChecker extends ASubstringSequenceChecker {
	
	
protected   String[] myPatterns;
	
public AHelloThreadOutputChecker (int aNumThreads) {
	myPatterns = new String[aNumThreads];
	for (int i = 0; i < aNumThreads; i++) {
		myPatterns[i] = ".*ello.*" + i + ".*";
	}
	init ( myPatterns);
		
	}
//	public AHelloOutputChecker() {
//		init( myPatterns);
//	}
			
}

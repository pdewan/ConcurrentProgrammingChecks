package gradingTools.javaThreads.hello;

import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class AHelloMainOutputChecker extends ASubstringSequenceChecker {
	
	
protected   String[] MY_PATTERNS = {".*ello.*" + "main" + ".*"};
	
public AHelloMainOutputChecker () {
	
	init ( MY_PATTERNS);
		
	}
//	public AHelloOutputChecker() {
//		init( myPatterns);
//	}
			
}

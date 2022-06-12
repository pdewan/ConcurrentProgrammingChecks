package gradingTools.javaThreads.hello.execution;

import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class AHelloRootPostJoinChecker extends ASubstringSequenceChecker {
	
	
protected   String[] MY_PATTERNS = {".*ello.*" + "main" + ".*"};
	
public AHelloRootPostJoinChecker () {
	
	init ( MY_PATTERNS);
		
	}
//	public AHelloOutputChecker() {
//		init( myPatterns);
//	}
			
}

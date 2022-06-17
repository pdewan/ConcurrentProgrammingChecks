package gradingTools.javaThreads.hello.execution.extra;

import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class AHelloRootPostJoinChecker extends ASubstringSequenceChecker {
	
	
protected   String[] MY_PATTERNS = {"Root Thread->.*Greeting.*Hello World.*"};
	
public AHelloRootPostJoinChecker () {
	
	init ( MY_PATTERNS);
		
	}
//	public AHelloOutputChecker() {
//		init( myPatterns);
//	}
			
}

package gradingTools.javaThreads.hello.execution;

import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class AHelloPerThreadChecker extends ASubstringSequenceChecker {
	
protected String[] MY_PATTERNS = {".*ello.*"};;
	
public AHelloPerThreadChecker () {
	
	init ( MY_PATTERNS);
		
	}
			
}

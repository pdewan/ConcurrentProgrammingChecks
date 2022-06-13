package gradingTools.javaThreads.hello.execution;

import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class AHelloPerThreadChecker extends ASubstringSequenceChecker {
	
protected String[] MY_PATTERNS = {"Thread.*->.*Greeting:.*Hello World.*"};;
	
public AHelloPerThreadChecker () {
	
	init ( MY_PATTERNS);
		
	}
			
}

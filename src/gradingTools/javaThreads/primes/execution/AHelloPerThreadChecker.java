package gradingTools.javaThreads.primes.execution;

import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class AHelloPerThreadChecker extends ASubstringSequenceChecker {
	
protected String[] MY_PATTERNS = {".*Hello World.*"};;
	
public AHelloPerThreadChecker () {
	
	init ( MY_PATTERNS);
		
	}
			
}

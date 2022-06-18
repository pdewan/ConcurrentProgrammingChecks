package gradingTools.javaThreads.primes.execution;

import grader.basics.output.observer.APropertyBasedStringChecker;
import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class APrimesPreForkPropertyChecker extends APropertyBasedStringChecker {
	
	
protected   String[][] MY_PROPERTIES = {
		{"Root Thread", "Random Numbers", "\\[.*\\d.*\\]"}
		};
	
public APrimesPreForkPropertyChecker () {
	
	init (MY_PROPERTIES);
		
	}
//	public AHelloOutputChecker() {
//		init( myPatterns);
//	}
			
}

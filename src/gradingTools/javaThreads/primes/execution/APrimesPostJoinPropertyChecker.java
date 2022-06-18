package gradingTools.javaThreads.primes.execution;

import grader.basics.output.observer.APropertyBasedStringChecker;
import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class APrimesPostJoinPropertyChecker extends APropertyBasedStringChecker {
	
	
protected   String[][] MY_PROPERTIES = {
		{"Root Thread", "Num Primes", ".*\\d.*"}
		};
	
public APrimesPostJoinPropertyChecker () {
	
	init (MY_PROPERTIES);
		
	}
//	public AHelloOutputChecker() {
//		init( myPatterns);
//	}
			
}

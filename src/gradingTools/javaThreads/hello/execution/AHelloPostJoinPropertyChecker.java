package gradingTools.javaThreads.hello.execution;

import grader.basics.output.observer.APropertyBasedStringChecker;
import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class AHelloPostJoinPropertyChecker extends APropertyBasedStringChecker {
	
	
protected   String[][] MY_PROPERTIES = {{"Root Thread", "Greeting", "Hello World"}};
	
public AHelloPostJoinPropertyChecker () {
	
	init (MY_PROPERTIES);
		
	}
//	public AHelloOutputChecker() {
//		init( myPatterns);
//	}
			
}

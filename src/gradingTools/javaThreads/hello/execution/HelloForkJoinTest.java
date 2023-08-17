package gradingTools.javaThreads.hello.execution;

import gradingTools.shared.testcases.concurrency.outputObserver.AbstractForkJoinChecker;
import util.annotations.MaxValue;
@MaxValue(10)
public class HelloForkJoinTest extends 
  AbstractForkJoinChecker {
	protected String mainClassIdentifier() {
		return "HelloForkJoin";
	}
	protected int numExpectedForkedThreads() {
		return 1;
	}
    protected double threadCountCredit () {
		return 0.8;
	}
}

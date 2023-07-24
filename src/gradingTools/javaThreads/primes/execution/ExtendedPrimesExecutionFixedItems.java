package gradingTools.javaThreads.primes.execution;

import grader.basics.junit.TestCaseResult;
import gradingTools.javaThreads.primes.ConcurrentPrimesSuite;
import util.annotations.MaxValue;
@MaxValue(10)
public class ExtendedPrimesExecutionFixedItems extends AbstractPrimeExecution {
	public static final String ROOT_CLASS = "ExtendedConcurrentPrimeNumbers";
	
	public ExtendedPrimesExecutionFixedItems() {
		args = new String[]{"5", "4"};
			
		
	}
	@Override
	protected String mainClassIdentifier() {
		return ROOT_CLASS;

	}

	@Override
	protected int totalIterations() {
		return  20;
	}
	
	@Override
	protected int numExpectedForkedThreads() {
		return 4;
	}
	
	protected String[] args() {
		args[0] = Integer.toString( totalIterations());
		args[1] = Integer.toString(numExpectedForkedThreads());
		return args;
	}
	@Override
	protected TestCaseResult performanceCredit(long aLowThreadsTime, long aHighThreadsTime, int aNumProcessors) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String[] lowThreadArgs() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String[] highThreadArgs() {
		// TODO Auto-generated method stub
		return null;
	}
	
    
	

	

	
}

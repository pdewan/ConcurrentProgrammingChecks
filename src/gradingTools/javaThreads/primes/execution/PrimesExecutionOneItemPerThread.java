package gradingTools.javaThreads.primes.execution;

import util.annotations.MaxValue;
@MaxValue(10)
public class PrimesExecutionOneItemPerThread extends AbstractPrimeExecution {
	
//	protected  int numExpectedItems() {
//		return AbstractPrimeExecution.NUM_THREADS;
//	}

//	@Override
//	protected Object[][] preForkPropertyNamesAndType() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected Object[][] iterationPropertyNamesAndType() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected Object[][] postIterationPropertyNamesAndType() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	protected Object[][] postJoinPropertyNamesAndType() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	protected int totalIterations() {
		return  AbstractPrimeExecution.NUM_THREADS;
	}
    
	

	

	
}

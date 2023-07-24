package gradingTools.javaThreads.primes.execution;

import grader.basics.junit.TestCaseResult;
import gradingTools.shared.testcases.concurrency.timing.AbstractConcurrencyPerformanceChecker;

public class ExtendedPrimesPerformanceChecker extends AbstractConcurrencyPerformanceChecker {
public static final String ROOT_CLASS = "ExtendedConcurrentPrimeNumbers";
protected static final int totalIterations = 24;
double expectedMinimumSpeedUp = 1.5;

@Override
protected String mainClassIdentifier() {
	// TODO Auto-generated method stub
	return ROOT_CLASS;
}
@Override
protected int maxThreads() {
	return 4;
}
@Override
protected String[] lowThreadArgs() {
	return new String[] {Integer.toString(totalIterations), 
			Integer.toString(minThreads())};
//	return new
}
protected String[] highThreadArgs() {
	return new String[] {Integer.toString(totalIterations),
			Integer.toString(maxThreads())};

}
public static double EXPECTED_MINIMUM_SPEEDUP = 1.5;
@Override
protected TestCaseResult performanceCredit(long aLowThreadsTime, long aHighThreadsTime, int aNumProcessors) {
	double anActualSpeedup = (double) aLowThreadsTime/ aHighThreadsTime;
	System.out.println("Actual Speedup:" + anActualSpeedup);
	System.out.println("Expected Minimum Speedup:" + EXPECTED_MINIMUM_SPEEDUP );
	if (anActualSpeedup < EXPECTED_MINIMUM_SPEEDUP) {
		return fail ("Speedup of " + anActualSpeedup + " less than minimum expected speedup of " + EXPECTED_MINIMUM_SPEEDUP);
	}
	return pass();
}
	


}

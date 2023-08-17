package gradingTools.javaThreads.primes.execution;

import grader.basics.junit.TestCaseResult;
import gradingTools.shared.testcases.concurrency.timing.AbstractConcurrencyPerformanceChecker;
import util.annotations.MaxValue;
@MaxValue(10)
public class PrimesPerformance extends AbstractConcurrencyPerformanceChecker {
final String TESTED_CLASS_NAME = "ExtendedConcurrentPrimeNumbers";
final String NUM_RANDOMS = "24";
static final double EXPECTED_MINIMUM_SPEEDUP = 1.5;
double expectedMinimumSpeedUp = 1.5;
final String MIN_THREADS = "1";
final String MAX_THREADS = "4";



@Override
protected String mainClassIdentifier() {
	return TESTED_CLASS_NAME ;
}

@Override
protected String[] lowThreadArgs() {
	return new String[] {
		NUM_RANDOMS, MIN_THREADS};
}
@Override
protected String[] highThreadArgs() {
	return new String[] {
		NUM_RANDOMS, MAX_THREADS};

}
@Override
protected double expectedMinimumSpeedup() {
	return EXPECTED_MINIMUM_SPEEDUP;
}

}

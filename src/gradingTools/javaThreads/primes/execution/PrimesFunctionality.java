package gradingTools.javaThreads.primes.execution;
import java.lang.reflect.Array;
import java.util.Map;
import gradingTools.shared.testcases.concurrency.outputObserver.AbstractForkJoinChecker;
import util.annotations.MaxValue;
@MaxValue(40)
public class PrimesFunctionality extends AbstractForkJoinChecker {
	final String TESTED_CLASS_NAME = "ExtendedConcurrentPrimeNumbers";
	// Do not need to vary number of threads in single test as performance is not being tested
	final int NUM_THREADS = 4;
	// This number can be small as performance is not being tested
	final int NUM_RANDOMS = 7;	
	
	// Names of properties, should be exported to tested program
	// so no naming mistake is made in it
	// Start static syntax description	
	// Properties are defined below for each fork-join phase
	public static final String RANDOM_NUMBERS = "Random Numbers";
	public static final String INDEX = "Index";
	public static final String NUMBER = "Number";
	public static final String IS_PRIME = "Is Prime";
	public static final String NUM_PRIMES = "Num Primes";
	// 1 Line N-Thread
	public static final String TOTAL_NUM_PRIMES = "Total Num Primes";
	
	// The constants above are used in the property parameter methods below
	final Object[][] PRE_FORK_PROPERTIES = {
			{RANDOM_NUMBERS, Array.class}			
	};
	final Object[][] ITERATION_PROPERTIES = {
			{INDEX, Number.class},
			{NUMBER, Number.class},
			{IS_PRIME, Boolean.class}
	};
	final Object[][] POST_ITERATION_PROPERTIES = {
			{NUM_PRIMES, Number.class},
			
	};
	final Object[][] POST_JOIN_PROPERTIES = {
			{TOTAL_NUM_PRIMES, Number.class},			
	};
	// end static syntax data

	@Override
	protected String mainClassIdentifier() {
		return TESTED_CLASS_NAME ;
	}
	
	@Override
	// need one iteration per random number	
	protected int totalIterations() {
		return NUM_RANDOMS; 
	}
	@Override
	protected  int numExpectedForkedThreads() {
		return NUM_THREADS;
	}

	@Override
	// This parameter is derived now from the above two parameters which are ints, hence the conversion
	protected String[] args() {
	  return new String[] {
		Integer.toString(totalIterations()),
		Integer.toString(numExpectedForkedThreads())};		
	}
	// Start parameter methods for static syntax
	// Each of the four static syntax methods can be omitted if there are no associated properties/logical variables
	@Override
	protected Object[][] preForkPropertyNamesAndType() {
		return PRE_FORK_PROPERTIES;
	}
	@Override
	protected Object[][] iterationPropertyNamesAndType() {
		return ITERATION_PROPERTIES;
	}
	@Override
	protected Object[][] postIterationPropertyNamesAndType() {
		return POST_ITERATION_PROPERTIES;
	}
	@Override
	protected Object[][] postJoinPropertyNamesAndType() {
		return POST_JOIN_PROPERTIES;
	}
	// End parameter methods for static syntax

	// Start semantics data
	Object[] randomNumbers;
	int numPrimesInRandomNumbers;
	int numPrimesFoundByCurrentThread;
	int sumPrimesFoundByAllThreads;	
	// End semantics data
	
	// Start semantics check methods
	// Each of these  methods is optional, and has a default no-op implementation
	// Each of them is associated with a fork-join phase. Its first argument
	// gives the thread that output a set of properties in that phase, and the Map argument
	// gives the names and vales of the properties output
	// Each of them should return null if there is no error, otherwise
    // it should return an error message printed by the infrastructure.
	
	/**
	 * This semantic method is invoked before the iteration and post iteration methods
	 * below. The first argument is  the root thread and the Map
	 * the properties output by it before forking.
	 */
	@Override
	protected  String preForkEventsMessage(Thread aThread, Map<String, Object> aNameValuePairs) {
//		System.out.println ("Thread:" + aThread.getId() + " prefork properties: " + aNameValuePairs);
		randomNumbers = (Object[]) aNameValuePairs.get(RANDOM_NUMBERS);
		return null;
	}
	
	/**
	 * This method is invoked as each iteration of a thread is processed.
	 * The first argument indicates the thread that processed the iteration
	 * The second argument indicates the property names and values output on that
	 * iteration
	 * A failure message should be given if the values of the input and computed 
	 * properties are not consistent
	 * Once a failure message is given no other iteration or post iteration
	 * methods will be called, though the post join method would be called
	 */
	@Override
	protected  String iterationEventsMessage(Thread aThread, Map<String, Object> aNameValuePairs) {
//		System.out.println ("Thread:" + aThread.getId() + " iteration properties: " + aNameValuePairs);
		int anIndex = (int) aNameValuePairs.get(INDEX);
		int aNumber = (int) aNameValuePairs.get(NUMBER);
		int anExpectedNumber = (int) randomNumbers[anIndex];
		if (aNumber != anExpectedNumber) {
			return "Number " + aNumber + " output at index " + anIndex + "!= expected number " + anExpectedNumber;
		}
		boolean isPrime = (boolean) aNameValuePairs.get(IS_PRIME);
		if (isPrime) {
			numPrimesFoundByCurrentThread++;
		}
		// check if the number is actually a prime
//		int aNumber = (Integer) aNameValuePairs.get("Number");
		boolean isActualPrime = isPrime(aNumber);
		if (isPrime != isActualPrime) {
			return "Is Prime output as " + isPrime + " for number " + aNumber + " but should be " + isActualPrime;
		}		
		return null;
	}
	/**
	 * This method is invoked after all iteration of a thread have been processed,
	 * and before the iteration properties of the next thread have been processed.
	 * Again, the Map consists of named and parsed values of post iteration properties
	 */
	@Override
	protected  String postIterationEventsMessage(Thread aThread, Map<String, Object> aNameValuePairs) {
//		System.out.println ("Thread:" + aThread.getId() + " post iteration properties: " + aNameValuePairs);
		int aNumNumbersComputed = (int) aNameValuePairs.get(NUM_PRIMES);
		if (aNumNumbersComputed != numPrimesFoundByCurrentThread) {
			return "Thread " + aThread.getId() + " found " + numPrimesFoundByCurrentThread + " but computed " + aNumNumbersComputed;
		}
		sumPrimesFoundByAllThreads += aNumNumbersComputed;
		return null;
	}
	/**
	 * This method is invoked after all iteration and post iteration methods for forked threads
	 * have been invoked. The first argument is  the root thread and the Map
	 * the properties output by it after joining.
	 */
	@Override
	protected  String postJoinEventsMessage(Thread aThread, Map<String, Object> aNameValuePairs) {
		int aComputedFinalNumbers = (int) aNameValuePairs.get(TOTAL_NUM_PRIMES);
		if (aComputedFinalNumbers != sumPrimesFoundByAllThreads) {
			return "Num primes with dispatching thread " + aComputedFinalNumbers + " != " + "sum of primes found by each thread " + sumPrimesFoundByAllThreads;
		}
		int aNumActualPrimes = 0;
		for (Object aRandom:randomNumbers) {
			if (isPrime((int) aRandom)) aNumActualPrimes++;
		}
		if (aComputedFinalNumbers != aNumActualPrimes) {
			return "Num computed primes " + aComputedFinalNumbers + " != " + "actual primes " + aNumActualPrimes;
		}
		return null;
	}
	// End semantic checking methods
	
	/**
	 * The following is a book keeping method for other semantic checking methods.
	 * The checking methods make properties output by each thread available to
	 * this testing code. Even though the property outputs are expected to be
	 * interleaved, the testing infrastructure does not interleave the execution of 
	 * these methods, allowing the testing code to finish processing all properties
	 * output by a thread, before it processes those output by another thread after
	 * a thread switch. 
	 * 
	 * This method is called when a thread switch occurs.
	 * The first argument indicates the thread whose properties were previously
	 * made available, and the second one indicated those whose properties will now
	 * be made available.
	 * 
	 * It should be used to reset per thread state.
	 */
	protected void threadEventProcessingSwitched(Thread aPreviousThread, Thread aNewThread) {
		System.out.println ("Thread processing switched from " + aPreviousThread + " to " + aNewThread);
		numPrimesFoundByCurrentThread = 0;
	}
	
	/**
	 * This is of course an auxilliary method to check the correctness of
	 * computations.
	 */
	public static boolean isPrime(int num) {
		if (num == 2)
			return true;

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if ((num % i) == 0) {
				return false;
			}
		}
		return true;
	}	
}

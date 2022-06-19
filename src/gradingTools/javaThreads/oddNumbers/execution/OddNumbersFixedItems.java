package gradingTools.javaThreads.oddNumbers.execution;

import util.annotations.MaxValue;
@MaxValue(10)
public class OddNumbersFixedItems extends AbstractOddNumbersExecution {
	@Override
	protected int totalIterations() {
		return  7;
	}
    
}

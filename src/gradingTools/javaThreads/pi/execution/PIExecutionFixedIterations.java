package gradingTools.javaThreads.pi.execution;

import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(10)
@IsExtra(true)
public class PIExecutionFixedIterations extends AbstractPIExecution {
	

	@Override
	protected int totalIterations() {
		return 9;
	}
    
	

	

	
}

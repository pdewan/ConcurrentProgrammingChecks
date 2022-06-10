package gradingTools.javaThreads.hello.style;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import util.annotations.Explanation;
import util.annotations.MaxValue;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	ConcurrencyNamedConstants.class,
	ConcurrencyMnemonicNames.class,	

})
@Explanation("Checks style constraints")
@MaxValue(10)
public class ConcurrencyStyleChecks {

	
}

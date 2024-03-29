package gradingTools.javaThreads.style;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.basics.sharedTestCase.checkstyle.MnemonicNameRatioTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.NamedConstantsRatioCheck;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	NamedConstantsRatioCheck.class,
	MnemonicNameRatioTestCase.class,	

})
@Explanation("Checks style constraints")
@MaxValue(2)
@IsExtra(true)
public class JavaThreadsStyleChecks {

	
}

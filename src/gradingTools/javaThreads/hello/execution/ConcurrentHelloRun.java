package gradingTools.javaThreads.hello.execution;

import java.util.Arrays;
import java.util.regex.Pattern;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.NotRunnableException;
import grader.basics.execution.ResultingOutErr;
import grader.basics.execution.RunningProject;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.shared.testcases.SubstringSequenceChecker;
import gradingTools.shared.testcases.greeting.AGreetingChecker;
import gradingTools.shared.testcases.greeting.GreetingMainProvided;
import gradingTools.shared.testcases.utils.ALinesMatcher;
import gradingTools.shared.testcases.utils.LinesMatchKind;
import gradingTools.shared.testcases.utils.LinesMatcher;
import gradingTools.utils.RunningProjectUtils;
import util.annotations.MaxValue;
@MaxValue(2)
public class ConcurrentHelloRun extends PassFailJUnitTestCase {
//	public static final int TIME_OUT_SECS = 1; // secs
	protected SubstringSequenceChecker checker;	
	protected String[] args = {"5"};
	protected String[] inputs = {};

	public ConcurrentHelloRun() {
	}
	

	protected TestCaseResult runAndCheck(Class aMainClass, int aNumThreads) throws Throwable {
		args[0] = Integer.toString(aNumThreads);
		checker = new AHelloThreadOutputChecker(aNumThreads);
		ResultingOutErr aResult = BasicProjectExecution.invokeMain(aMainClass, args, inputs);
		LinesMatcher aLinesMatcher = aResult.getLinesMatcher();
//		LinesMatcher aLineMatcher =  new ALinesMatcher(anOutputLines);

		boolean aRetval = checker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_UNORDERED, Pattern.DOTALL);

		if (!aRetval) {
			String anExpectedLines = Arrays.toString(checker.getSubstrings());

			return fail("Output did not match:" + anExpectedLines);

		}
		int aLastLineMatched = aLinesMatcher.getMaxMatchedLineNumber();
		checker = new AHelloMainOutputChecker();
		aLinesMatcher.setStartLineNumber(aLastLineMatched + 1);
		
		 aRetval = checker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_LINE, Pattern.DOTALL);
		if (!aRetval) {
			String anExpectedLines = Arrays.toString(checker.getSubstrings());

			return fail("Output, starting at line " + (aLastLineMatched + 1) + ""+ " did not match:" + anExpectedLines);

		}
		return pass();
	}

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
//			setEntryPoint(project, ConcurrentHelloClassProvided.class);
//			RunningProject aRunningProject = RunningProjectUtils.runProject(project, TIME_OUT_SECS, args, inputs);
//
//
//			if (aRunningProject == null) {
//				return fail ("Could not create project. See console messages.");
//			}
//
//			String anOutput = aRunningProject.await();
//			LinesMatcher aLinesMatcher = aRunningProject.getLinesMatcher();

			Class aMainClass = getTaggedClass(project, ConcurrentHelloClassProvided.class);
			TestCaseResult retVal = pass();;
			for (int aNumThreads = 1; aNumThreads < 10; aNumThreads++) {
				retVal = runAndCheck(aMainClass, aNumThreads);
				if (!retVal.isPass()) {
					return retVal;
				}
			}
			return retVal;
//			ResultingOutErr aResult = BasicProjectExecution.invokeMain(aMainClass, args, inputs);
//			LinesMatcher aLinesMatcher = aResult.getLinesMatcher();
////			LinesMatcher aLineMatcher =  new ALinesMatcher(anOutputLines);
//
//			boolean aRetval = checker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_LINE, Pattern.DOTALL);
//			String anExpectedLines = Arrays.toString(checker.getSubstrings());
//
//			if (!aRetval) {
//				return fail("Output  did not match:" + anExpectedLines);
//
//			}
//			return pass();
			

		} catch (NotRunnableException e) {
			e.printStackTrace();
			throw new NotGradableException();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new NotGradableException();
		}
	}

}

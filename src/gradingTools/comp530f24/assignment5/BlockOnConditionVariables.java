package gradingTools.comp530f24.assignment5;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import grader.basics.execution.AValgrindCommandGenerator;
import grader.basics.execution.RunningProject;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.utils.RunningProjectUtils;
import util.annotations.Explanation;
import util.annotations.MaxValue;
import util.misc.Common;
import util.trace.Tracer;
import valgrindpp.grader.ValgrindTrace;
@MaxValue(32)
@Explanation("This test checks if the traces include calls to pthread_cond_init and pthread_cond_wait with the same argument")
public class BlockOnConditionVariables extends PassFailJUnitTestCase {
	List<String> outputs ;
	List<ValgrindTrace> traces;
	@Override
	protected Class precedingTest() {
		return LRUOutput.class;
	}
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {

		System.out.println("Running Block on Conditional Variables");
		List<PassFailJUnitTestCase> aPrecedingTests = getPrecedingTestInstances();
		
		LRUOutput anLRUOutput = (LRUOutput) aPrecedingTests.get(0);
		outputs = anLRUOutput.getOutputs();
		traces = anLRUOutput.getValgrindTraces();
		

		String aBlockMessage = blockOnConditionVariables();
		if (aBlockMessage == null ) {
			return pass();
		}
		return fail (aBlockMessage);
		
		
	}
	static String emptyMessage = "";
	private String blockOnConditionVariables() {
		
		Set<String> seen = new HashSet<String>(), inits = new HashSet<String>();
		boolean called = false;
		
		for(ValgrindTrace trace: traces) {
			if(trace.fnname.equals("pthread_cond_init")) {
				seen.add(trace.arguments[0]);
				inits.add(trace.arguments[0]);
				called = true;
				Tracer.info(this, trace.toString());
				Tracer.info(this, "pthread_cont_init called with argument " + trace.arguments[0]);
			}
			
			if(trace.fnname.equals("pthread_cond_wait")) {
				if(!inits.contains(trace.arguments[0])) {
					Tracer.info(this, trace.toString());
					String aMessage = "pthead_cond_wait called without an earlier pthread_cond_init with the same argument";
					Tracer.info(this, aMessage);
					return aMessage;
				}
				return null;
			}
		}
		
		if (called && seen.size() > 0) {
			
			return "pthread_cond_init called but not pthread_cond_wait on the same argument";
		};
	
//		if  (seen.size() == 0 && called)  {
			return null;
//		}
		
	}

}

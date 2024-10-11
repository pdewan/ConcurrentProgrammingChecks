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
import util.annotations.MaxValue;
import util.misc.Common;
import util.trace.Tracer;
import valgrindpp.grader.ValgrindTrace;
@MaxValue(32)
public class BroadcastVsSignal extends PassFailJUnitTestCase {
	List<String> outputs ;
	List<ValgrindTrace> traces;
	@Override
	protected Class precedingTest() {
		return LRUOutput.class;
	}
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {

		
		List<PassFailJUnitTestCase> aPrecedingTests = getPrecedingTestInstances();
		
		LRUOutput anLRUOutput = (LRUOutput) aPrecedingTests.get(0);
		outputs = anLRUOutput.getOutputs();
		traces = anLRUOutput.getValgrindTraces();
		

		String aBroadcastVsSignal = broadcastVsSignal();
		if (aBroadcastVsSignal == null) {
			return pass();
		} else {
			return fail(aBroadcastVsSignal);
		}

//		if (!aBroadcastVsSignal) {
//			return fail("brodcast vs signal failed");
//		}
//		return pass();
		
		
	}

private String broadcastVsSignal() {
	
	Map<Long, Boolean> threadState = new HashMap<Long, Boolean>();
	
	for(ValgrindTrace trace: traces) {
		switch(trace.fnname) {
		case "clean": 
			Tracer.info(this,  trace.toString());
			Boolean calledSignal = threadState.get(trace.thread);
			
			if(calledSignal != null && calledSignal) {
				Tracer.info(this, trace.thread + " called signal");
				return "clean operation peformed after pthread_cond_signal";
//				return false;
			}
			break;
		case "reference": case "shutdown_threads":
//			Tracer.info(this,  trace.toString());
			threadState.put(trace.thread, false);
//			Tracer.info(this, trace.thread + " did not call signal");

			
			break;
		case "pthread_cond_signal":
			Tracer.info(this,  trace.toString());

			threadState.put(trace.thread, true);
			Tracer.info(this, trace.thread + " called signal");

			break;
		}
	}
	
	return null;
}
}

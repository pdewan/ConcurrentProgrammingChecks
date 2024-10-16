package gradingTools.comp530f22.assignment5;

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
import valgrindpp.grader.ValgrindTrace;
@MaxValue(32)
@Explanation("This test checks that that a pthread_cond_wait() and pthread_cond_broadcast()/pthread_cond_signal() occur in the trace with the same argument")
public class ReleaseConditionWaiters extends PassFailJUnitTestCase {
	List<String> outputs ;
	List<ValgrindTrace> traces;
	@Override
	protected Class precedingTest() {
		return LRUOutput.class;
	}
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
//		RunningProject noInputRunningProject = RunningProjectUtils.runProject(project, 40);
//		String mutexOut = noInputRunningProject.await();
//		File aTraceFile = AValgrindCommandGenerator.getTraceFile(project);
//		try {
////			StringBuilder aStringBuilder = Common.read
//			List<String> aMainLines = Files.readAllLines(aTraceFile.toPath(), Charset.defaultCharset());
//		
////		Map<String, List<String>> aLinesMap = noInputRunningProject.getProcessOutputLines();
////		List<String> aMainLines = aLinesMap.get("main");
//		traces = new ArrayList();
//		outputs = new ArrayList();
//		for (String aLine: aMainLines) {
//			try {
//				traces.add(new ValgrindTrace(aLine));
//			} catch (Exception e) {
//				outputs.add(aLine);
//				// TODO Auto-generated catch block
////				e.printStackTrace();
//			}
//		}
		
		List<PassFailJUnitTestCase> aPrecedingTests = getPrecedingTestInstances();
		
		LRUOutput anLRUOutput = (LRUOutput) aPrecedingTests.get(0);
		outputs = anLRUOutput.getOutputs();
		traces = anLRUOutput.getValgrindTraces();
		
//		String anOut = noInputRunningProject.getOutput();
//		
//		System.out.println("mutex_out\n " + anOut);
//		boolean aBlockOnConditionVariables = blockOnConditionVariables();
		boolean aReleaseConditionedWaiters = releaseConditionedWaiters();
//		boolean aBroadcastVsSignal = broadcastVsSignal();
//		if (!aBlockOnConditionVariables) {
//			return fail("block on condition variables failed");
//		}
		if (!aReleaseConditionedWaiters) {
			return fail("release failed");
		}
//		if (!aBroadcastVsSignal) {
//			return fail("brodcast vs signal failed");
//		}
		return pass();
		
		
	}
//	private boolean blockOnConditionVariables() {
//		
//		Set<String> seen = new HashSet<String>(), inits = new HashSet<String>();
//		boolean called = false;
//		
//		for(ValgrindTrace trace: traces) {
//			if(trace.fnname.equals("pthread_cond_init")) {
//				seen.add(trace.arguments[0]);
//				inits.add(trace.arguments[0]);
//				called = true;
//			}
//			
//			if(trace.fnname.equals("pthread_cond_wait")) {
//				if(!inits.contains(trace.arguments[0])) return false;
//				return true;
//			}
//		}
//		
//		return seen.size() == 0 && called;
//	}
private boolean releaseConditionedWaiters() {
		
		Set<String> waiters = new HashSet<String>(), seen = new HashSet<String>();
		for(ValgrindTrace trace: traces) {
			if(trace.fnname.equals("pthread_cond_wait")) {				
				if(!seen.contains(trace.arguments[0])) 
						waiters.add(trace.arguments[0]);
				seen.add(trace.arguments[0]);
			} 
			
			if(trace.fnname.equals("pthread_cond_broadcast") 
				|| trace.fnname.equals("pthread_cond_signal")){
				waiters.remove(trace.arguments[0]);
			}
		}
		
		return waiters.size() == 0;
	}
//private boolean broadcastVsSignal() {
//	
//	Map<Long, Boolean> threadState = new HashMap<Long, Boolean>();
//	
//	for(ValgrindTrace trace: traces) {
//		switch(trace.fnname) {
//		case "clean": 
//			Boolean calledSignal = threadState.get(trace.thread);
//			if(calledSignal != null && calledSignal) {
//				return false;
//			}
//			break;
//		case "reference": case "shutdown_threads":
//			threadState.put(trace.thread, false);
//			break;
//		case "pthread_cond_signal":
//			threadState.put(trace.thread, true);
//			break;
//		}
//	}
//	
//	return true;
//}
}

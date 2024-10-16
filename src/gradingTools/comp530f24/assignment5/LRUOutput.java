package gradingTools.comp530f24.assignment5;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import grader.basics.concurrency.propertyChanges.BasicConcurrentPropertyChangeSupport;
import grader.basics.concurrency.propertyChanges.ConcurrentEventUtility;
import grader.basics.concurrency.propertyChanges.ConcurrentPropertyChange;
import grader.basics.concurrency.propertyChanges.ConcurrentPropertyChangeSupport;
import grader.basics.concurrency.propertyChanges.BasicValgrindConcurrentPropertyChangeSupport;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.AValgrindCommandGenerator;
import grader.basics.execution.RunningProject;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.output.observer.ValgrindRepetitionBasedPropertyChangeSelector;
import grader.basics.output.observer.BasicPositiveOutputSelector;
import grader.basics.output.observer.BasicValgrindTraceToPropertyChange;
import grader.basics.output.observer.ObservablePrintStream;
import grader.basics.output.observer.ObservablePrintStreamFactory;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.utils.RunningProjectUtils;
import util.annotations.Explanation;
import util.annotations.MaxValue;
import util.misc.Common;
import valgrindpp.grader.ValgrindTrace;
@MaxValue(4)
@Explanation("The test checks if running the program produces output and traces.\n It converts the trace lines into an internal representation to be processed by other tests")
public class LRUOutput extends PassFailJUnitTestCase {
	List<String> outputs ;
	List<ValgrindTrace> traces;
	public List<String> getOutputs() {
		return outputs;
	}
	public List<ValgrindTrace> getValgrindTraces() {
		return traces;
	}
	ConcurrentPropertyChangeSupport concurrentPropertyChangeSupport = new BasicValgrindConcurrentPropertyChangeSupport();
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification()
				.setOutputValgrindTrace(true);
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification()
		.setMaxOutputLines(20000); // these will not be actually output
		ObservablePrintStream anObservablePrintStream = ObservablePrintStreamFactory.getObservablePrintStream();
		anObservablePrintStream.registerPropertyChangeConverter(new BasicValgrindTraceToPropertyChange());
		anObservablePrintStream.addPropertyChangeListener(concurrentPropertyChangeSupport);		
		anObservablePrintStream.addPositiveSelector(new BasicPositiveOutputSelector());
		anObservablePrintStream.setPropertyOutputSelector(new ValgrindRepetitionBasedPropertyChangeSelector());
		PrintStream anOriginalOut = System.out;
		System.setOut((PrintStream) anObservablePrintStream);

		RunningProject noInputRunningProject = RunningProjectUtils.runProject(project, 5);
		String mutexOut = noInputRunningProject.await();
		System.setOut(anOriginalOut);
		ConcurrentPropertyChange[] anOriginalEvents = concurrentPropertyChangeSupport.getConcurrentPropertyChanges();
		Map<String, List<ConcurrentPropertyChange>> aByPropertyView =  ConcurrentEventUtility.getConcurrentEventListByProperty(
				anOriginalEvents);
		Map<Object, List<ConcurrentPropertyChange>> aBySourceView =  ConcurrentEventUtility.getConcurrentEventListBySource(
				anOriginalEvents);
		Map<Thread, List<ConcurrentPropertyChange>> aByThreadView =  ConcurrentEventUtility.getConcurrentPropertyChangeListByThread(
				anOriginalEvents);
		File aTraceFile = AValgrindCommandGenerator.getTraceFile(project);
		try {
//			StringBuilder aStringBuilder = Common.read
			List<String> aMainLines = Files.readAllLines(aTraceFile.toPath(), Charset.defaultCharset());
		
//		Map<String, List<String>> aLinesMap = noInputRunningProject.getProcessOutputLines();
//		List<String> aMainLines = aLinesMap.get("main");
		traces = new ArrayList();
		outputs = new ArrayList();
		for (String aLine: aMainLines) {
		try {
			traces.add(new ValgrindTrace(aLine));
		} catch (Exception e) {
			outputs.add(aLine);

		}
	}
		if (outputs.size() == 0) {
			return fail ("No output produced. All other tests will fail.");
		}
		if (traces.size() == 0) {
			return fail ("No trace produced. All other tests will fail. Please contact instructor");
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return fail ("Internal error, could not read trace file:" + aTraceFile);
		}
		return pass();

		}
	}
//		for (String aLine: aMainLines) {
//			try {
//				traces.add(new ValgrindTrace(aLine));
//			} catch (Exception e) {
//				outputs.add(aLine);
//				// TODO Auto-generated catch block
////				e.printStackTrace();
//			}
//		}
//		
//		
//		
////		String anOut = noInputRunningProject.getOutput();
////		
////		System.out.println("mutex_out\n " + anOut);
//		boolean aBlockOnConditionVariables = blockOnConditionVariables();
//		boolean aReleaseConditionedWaiters = releaseConditionedWaiters();
//		boolean aBroadcastVsSignal = broadcastVsSignal();
//		if (!aBlockOnConditionVariables) {
//			return fail("block on condition variables failed");
//		}
//		if (!aReleaseConditionedWaiters) {
//			return fail("release failed");
//		}
//		if (!aBroadcastVsSignal) {
//			return fail("brodcast vs signal failed");
//		}
//		return pass();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			return fail ("Internal error, could not read trace file:" + aTraceFile);
//		}
		
//	}
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
//private boolean releaseConditionedWaiters() {
//		
//		Set<String> waiters = new HashSet<String>(), seen = new HashSet<String>();
//		for(ValgrindTrace trace: traces) {
//			if(trace.fnname.equals("pthread_cond_wait")) {				
//				if(!seen.contains(trace.arguments[0])) 
//						waiters.add(trace.arguments[0]);
//				seen.add(trace.arguments[0]);
//			} 
//			
//			if(trace.fnname.equals("pthread_cond_broadcast") 
//				|| trace.fnname.equals("pthread_cond_signal")){
//				waiters.remove(trace.arguments[0]);
//			}
//		}
//		
//		return waiters.size() == 0;
//	}
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
//}

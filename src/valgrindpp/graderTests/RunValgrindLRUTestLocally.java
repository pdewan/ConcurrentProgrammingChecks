package valgrindpp.graderTests;

import grader.basics.config.BasicExecutionSpecificationSelector;
import gradingTools.comp530f24.assignment5.Assignment5Suite;
import trace.grader.basics.GraderBasicsTraceUtility;

public class RunValgrindLRUTestLocally {
	public static void main (String[] args) {
		GraderBasicsTraceUtility.setTracerShowInfo(true);	
		GraderBasicsTraceUtility.setBufferTracedMessages(false);
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setCreateDockerContainer(false);

		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
//		setStudentGradableProjectLocation(
//		 "D:\\dewan_backup\\Java\\GraderBasics\\src\\valgrindpp\\examples\\mutex");
//		setStudentGradableProjectLocation("D:\\dewan_backup\\Java\\eclipse\\test-c");
//		setStudentGradableProjectLocation("D:\\dewan_backup\\C\\ValgrindExamples\\NoSrcMutex");
//		setStudentGradableProjectLocation("D:\\dewan_backup\\C\\ValgrindExamples\\TestSourceLogging");
//		setStudentGradableProjectLocation("D:\\dewan_backup\\C\\ValgrindExamples\\CorrectMutexLRU-src");
//		setStudentGradableProjectLocation("D:\\dewan_backup\\C\\ValgrindExamples\\ExtraErroneousMutexLRU");
		setStudentGradableProjectLocation(".");
//		setStudentGradableProjectLocation("D:\\dewan_backup\\C\\ValgrindExamples\\CorrectMutexLRU");
//		setStudentGradableProjectLocation("D:\\dewan_backup\\C\\ValgrindExamples\\MutexLRU\\CorrectMutexLRU");
//		GraderBasicsTraceUtility.setMaxTraces(600);
		Assignment5Suite.main(args);
//		AddMultiplySuite.main(args);
	}
}

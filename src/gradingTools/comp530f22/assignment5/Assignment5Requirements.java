package gradingTools.comp530f22.assignment5;

import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.javaThreads.JavaThreadsSuite;

public class Assignment5Requirements extends AJUnitProjectRequirements {
	public Assignment5Requirements() {
		
		GraderTraceUtility.setTurnOn(true);
		GraderTraceUtility.setTracing();
		addDueDate("11/15/2022 01:00:00", 1.05);
		addDueDate("11/23/2022 01:00:00", 1.0);
		addDueDate("12/01/2022 01:00:00", 0.9);
		addDueDate("12/08/2021 01:00:00", 0.8);
		addDueDate("12/10/2022 01:00:00", 0.5);
		
		addJUnitTestSuite(Assignment5Suite.class);
		
     	

	}
}

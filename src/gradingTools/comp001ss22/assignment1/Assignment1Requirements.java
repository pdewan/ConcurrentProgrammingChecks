package gradingTools.comp001ss22.assignment1;

import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.javaThreads.JavaThreadsSuite;

public class Assignment1Requirements extends AJUnitProjectRequirements {
	public Assignment1Requirements() {
		
		GraderTraceUtility.setTurnOn(true);
		GraderTraceUtility.setTracing();
		addDueDate("06/23/2022 01:00:00", 1.05);
		addDueDate("07/01/2022 01:00:00", 1.0);
		addDueDate("07/15/2022 01:00:00", 0.9);
		addDueDate("08/01/2021 01:00:00", 0.8);
		addDueDate("06/23/2022 01:00:00", 0.5);
		
		addJUnitTestSuite(JavaThreadsSuite.class);
		
     	

	}
}

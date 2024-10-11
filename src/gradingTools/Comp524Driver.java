package gradingTools;

import bus.uigen.ObjectEditor;
import grader.config.ExecutionSpecificationSelector;
import grader.trace.GraderTraceUtility;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.MessagePrefixKind;
import util.trace.TraceableWarning;
import util.trace.Tracer;
import util.trace.uigen.UnknownPropertyNotification;

public class Comp524Driver {
	public static void main (String[] args) {
//		ObjectEditor.setDenseMagnification(1.0);
//		ExecutionSpecificationSelector.getExecutionSpecification().setGraderModule("Comp524F20");
//		ExecutionSpecificationSelector.getExecutionSpecification().setGraderProblemDownloadPath("foo");
//		ExecutionSpecificationSelector.getExecutionSpecification().setUseProjectConfiguration(true); // duplicating what is in the ASuite
//		Tracer.showInfo(true);
//		TraceableWarning.doNotWarn(UnknownPropertyNotification.class);

//		Tracer.setMessagePrefixKind(MessagePrefixKind.FULL_CLASS_NAME);
//		GraderBasicsTraceUtility.setBufferTracedMessages(false);
		Driver.main(args);
		
		for(String s : args) {
			if (s.matches("-.*?[hH][eE][aA][dD][lL][eE][sS]{2}.*")) { // any variety of -.*headless.* with any capitalization
				System.out.println("Exiting driver");
				System.exit(0);
			}
		}
	}
}
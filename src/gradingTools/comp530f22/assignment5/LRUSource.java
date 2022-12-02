package gradingTools.comp530f22.assignment5;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.observers.ASourceAndTestLogWriter;
import grader.basics.observers.logSending.JSONObject;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import name.fraser.neil.plaintext.diff_match_patch;
import name.fraser.neil.plaintext.diff_match_patch.Diff;
import util.annotations.MaxValue;
import valgrindpp.grader.ValgrindTrace;
@MaxValue(4)
public class LRUSource extends PassFailJUnitTestCase {
	List<String> outputs ;
	List<ValgrindTrace> traces;
	public List<String> getOutputs() {
		return outputs;
	}
	public List<ValgrindTrace> getValgrindTraces() {
		return traces;
	}
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		String aVersion1 = ASourceAndTestLogWriter.getInstance().replayToSessioString(119);
		System.out.println("Version 1");
		System.out.println(aVersion1);
//		String aVersion2 = ASourceAndTestLogWriter.getInstance().replayToSessioString(110);
//		System.out.println("Version 2");
//		System.out.println(aVersion2);
//		String aVersion3 = ASourceAndTestLogWriter.getInstance().replayToSessioString(111);
//		System.out.println("Version 3");
//		System.out.println(aVersion3);
//		String aVersion4 = ASourceAndTestLogWriter.getInstance().replayToSessioString(90);
//		System.out.println("Version 4");
//		System.out.println(aVersion4);
//		String aVersion5 = ASourceAndTestLogWriter.getInstance().replayToSessioString(91);

//		Map<String, String> fileToText = project.getTextManager().getFileToText();
//		String aSource = project.getSource();
//		System.out.println(" Source\n:" + aSource);
//		project.getTextManager().initializeAllSourcesText();
		JSONObject jsonObject;
		
//		String aSecondSource = project.getSource();
//		if (!aSource.equals(aSecondSource)) {
//			System.out.println("Second source different");
//		} else {
//			System.out.println("Second source same");
//
//		}
//		
//		System.out.println(" Source again\n:" + aSecondSource);
//		aSecondSource = aSecondSource + " added text";
//		String aDiff = StringUtils.difference(aSource, aSecondSource);

//		StringsComparator aStringsComparator = new StringsComparator(aSource, aSecondSource);
//		EditScript aScript = aStringsComparator.getScript();
////		System.out.println(aScript);
//		aScript.visit(new CommandVisitor<Character>() {
//
//		    @Override
//		    public void visitKeepCommand(Character object) {
//		        System.out.println("k: " + object);
//		    }
//
//		    @Override
//		    public void visitInsertCommand(Character object) {
//		        System.out.println("i: " + object);
//		    }
//
//		    @Override
//		    public void visitDeleteCommand(Character object) {
//		        System.out.println("d: " + object);
//		    }
//		});
//		String aDiff = Diff_Match_Patch_Proxy.diffString(aSource, aSecondSource);
//		
//		 diff_match_patch aDiffer = new diff_match_patch();
//		LinkedList<Diff> aDiffs = aDiffer.diff_main(aSource, aSecondSource);
//		String aDeltas = aDiffer.diff_toDelta(aDiffs);
//		
//		LinkedList<Diff> aReadDiffs = aDiffer.diff_fromDelta(aSource, aDeltas);
//		String aRecreatedSource = aDiffer.diff_text1(aReadDiffs);
//		String aRecreatedSecondSource = aDiffer.diff_text2(aReadDiffs);
//		if (!aSource.equals(aRecreatedSource)) {
//			System.out.println(" Source != recreated Source");
//		}
//		if (!aSecondSource.equals(aRecreatedSecondSource)) {
//			System.out.println(" second Source != recreated second Source");
//		}
//		aDiffer.
		//		 List<Patch> aPatch = aDiffer.patch_fromText(aDiff);
//		int i = 5;
//		aDiffer.patch_apply(aPatch, aSource);
		 
//		 differ aDiffer = new diff_match_patch();
		
		

		return pass();
	}
}
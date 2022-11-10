package gradingTools;

import grader.basics.config.BasicExecutionSpecificationSelector;

public class TestOneStudentConcurrent {
	static final String FOLDER = "D:\\dewan_backup\\C\\ValgrindExamples\\Assignment5";

//	static final String STUDENT = "sdgeorge";
	static final String STUDENT = "acorrect";
	static final String COURSE = "Comp530F22";
	static final String ASSIGNMENT = "Assignment5";
	
	public static void main(String[] args) {
//		String[] myArgs = {
//				COURSE, ASSIGNMENT, FOLDER, STUDENT
//		};
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage("C");

		runHeadlessOneStudent(COURSE, ASSIGNMENT, FOLDER, STUDENT);
	}
//	public static void main(String[] args) {
//		runHeadlessOneStudent(args[0], args[1], args[2], args[3]);
//	}

	public static void runHeadlessOneStudent (String aCourse, 
			String anAssignment, 
			String aProjectFolder, 
			String aStudent ) {
		String[] myArgs = {
				 "--project-requirements",
				 "--project-name",
				 anAssignment,
				  "--grader-controller",
				  	"AHeadlessGradingManager",
				  	"--headless-path",
				  	aProjectFolder,
				  	"--headless-start",
				  	aStudent,
				  	"--headless-end",
				  	aStudent,
				  	"--course-name",
				  	aCourse,
				  	"--logger",
				  	"feedback-txt+feedback-json+local-txt+local-json",
				  	"--no-framework-gui",
				  	"--clean-slate",
				  	aStudent
		};
		

		Driver.main(myArgs);

		System.exit(0);
		}
//		Driver.main(myArgs);
//		java -cp .;D:\autograder\source\Comp524GraderAll.jar;D:\dewan_backup\Java\Gradescope-Autograder\GradescopeAssignmentSetup\target\classes;C:\Users\dewan\.m2\repository\org\json\json\20171018\json-20171018.jar gradingTools.Comp524Driver --project-requirements  --project-name  Assignment1 --grader-controller AHeadlessGradingManager --headless-path D:\autograder\source\Assignment1 --headless-start student --headless-end student --course-name Comp524F20 --logger feedback-txt+feedback-json+local-txt+local-json --no-framework-gui --clean-slate
}

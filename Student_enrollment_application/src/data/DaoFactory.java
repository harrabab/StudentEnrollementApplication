package data;

public class DaoFactory {
	
	public static CredentialDAO getTestDAO() {
		CredentialDAOText tDAO = new CredentialDAOText();
		return tDAO;
	}
	public static FacultyCredentialDao getTestDA() {
		
		FacultyCredentialDaoText fDAO = new  FacultyCredentialDaoText();
		return fDAO;
	}
	
	public static StudentDao getStudentDao() {
		
		StudentDbAccess fDAO = new StudentDbAccess();
		return fDAO;
	}
	public static ProgramDAO getProgramDao() {
		
		ProgramDbAccess fDAO = new ProgramDbAccess();
		return fDAO;
	}
	public static CourseDao getCourseDao() {
		
		CourseDbAccess fDAO = new CourseDbAccess();
		return fDAO;
	}
	
	
	public static MarksDao getMarksDao() {
		
		MarksDbAccess fDAO = new MarksDbAccess();
		return fDAO;
	}
	

}

package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Business.Marks;
import studentEnrollmentApplication.TestMain;

public class MarksDbAccess implements MarksDao {
	
	
	
	
	protected ResultSet rs=null;
	protected Statement stm=null;
	

	public int SubmitMarks(Marks marks) throws SQLException{
		
		String query = "Insert into marks values (?, ?, ?, ?,?)"; 
		PreparedStatement preparedStmt = TestMain.dbconn.prepareStatement(query);
	     preparedStmt.setInt(1, marks.getMarkId());
	     preparedStmt.setString(2, marks.getStudentId());
	     preparedStmt.setString(3, marks.getProgramId());
	     preparedStmt.setInt(4, marks.getCourseId());
	     preparedStmt.setInt(5, marks.getMarksobtained());
	     
	    int flag = preparedStmt.executeUpdate();
	     
		return flag;
	}
	
	public int updateMarks(Marks mm) throws Exception{
		int count=0;
			 String query = "update Marks set MARKS_OBTAINED=?  where student_id = ? and program_id = ? and course_id = ?";
		     PreparedStatement preparedStmt = TestMain.dbconn.prepareStatement(query);
		     preparedStmt.setInt(1, mm.getMarksobtained());
		     preparedStmt.setString(2, mm.getStudentId());
    	     preparedStmt.setString(3, mm.getProgramId());
    	     preparedStmt.setInt(4, mm.getCourseId());
		     count =  preparedStmt.executeUpdate();
		     return count;
			
		}
	public ResultSet findMarks(Marks mm)throws SQLException {
		ResultSet rs = null;
	
			
	    		 String query = "Select MARKS_OBTAINED From Marks where student_id = ? and program_id = ? and course_id = ? ";
	    		 PreparedStatement preparedStmt = TestMain.dbconn.prepareStatement(query);
	    	     preparedStmt.setString(1, mm.getStudentId());
	    	     preparedStmt.setString(2, mm.getProgramId());
	    	     preparedStmt.setInt(3, mm.getCourseId());
			   
			     rs = preparedStmt.executeQuery();
		

		return rs;
	}

}

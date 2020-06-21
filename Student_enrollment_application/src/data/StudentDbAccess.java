package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Business.Student;
import studentEnrollmentApplication.TestMain;

public class StudentDbAccess implements StudentDao {

	public int addStudent(Student student) throws SQLException {

		PreparedStatement preparedStmt = null;
		System.out.println("Inserting records into the table...");
        String query = " insert into STUDENT (STUDENT_ID, STUDENT_NAME, PHONE_NUMBER,ADDRESS,AGE,GENDER,PROGRAM_ID)"
				+ " values (?, ?, ?,?,?,?,?)";

		preparedStmt = TestMain.dbconn.prepareStatement(query);
        preparedStmt.setString(1, student.getStudentId());
		preparedStmt.setString(2, student.getStudentName());
		preparedStmt.setString(3, student.getPhoneNumber());
		preparedStmt.setString(4, student.getAddress());
		preparedStmt.setString(5, student.getAge());
		preparedStmt.setString(6, student.getGender());
		preparedStmt.setString(7, student.getProgramId());
		return preparedStmt.executeUpdate();

	}

	public int ModifyStudentDetail(Student ss) throws SQLException {

		PreparedStatement stmt = null;
        String sql = "UPDATE Student SET STUDENT_NAME = ?, PHONE_NUMBER= ?, ADDRESS = ?, AGE=?, GENDER=?, PROGRAM_ID=? WHERE STUDENT_ID = ?";
		stmt = TestMain.dbconn.prepareStatement(sql);
		stmt.setString(1, ss.getStudentName());
		stmt.setString(2, ss.getPhoneNumber());
		stmt.setString(3, ss.getAddress());
		stmt.setString(4, ss.getAge());
		stmt.setString(5, ss.getGender());
		stmt.setString(6, ss.getProgramId());
		stmt.setString(7, ss.getStudentId());
        return stmt.executeUpdate();

	}

	public ResultSet getStudentid() throws SQLException {
		ResultSet rs = null;
        String query = "Select STUDENT_ID From Student";
		Statement stm = TestMain.dbconn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = stm.executeQuery(query);
        return rs;

	}

	public ResultSet getStudentDetail(String StudentId) throws SQLException {
		ResultSet rs = null;
        String query = "Select * From Student where student_id ='" + StudentId + "'";
        Statement stm = TestMain.dbconn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = stm.executeQuery(query);
        return rs;
	}

	public ResultSet getProgramId() throws SQLException {
		ResultSet rs = null;
        String query = "Select PROGRAM_ID From Program";
        Statement stm = TestMain.dbconn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = stm.executeQuery(query);
        return rs;
	}
}

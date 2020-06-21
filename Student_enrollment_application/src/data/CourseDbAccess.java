package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.*;

import Business.Course;
import Business.Program;
import studentEnrollmentApplication.TestMain;

public class CourseDbAccess implements CourseDao {

	protected ResultSet rs = null;
	protected Statement stm = null;

	public ResultSet findCourse(String name) throws SQLException {
		ResultSet rs = null;
        String query = "Select * From COURSE where COURSE_NAME ='" + name + "'";
		Statement stm = TestMain.dbconn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = stm.executeQuery(query);
        return rs;
	}

	public ResultSet findCourseWithProgramId(String programid) throws SQLException  {
		ResultSet rs = null;
		try {

			String query = "Select * From COURSE where Program_ID ='" + programid + "'";
			Statement stm = TestMain.dbconn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stm.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int updateCourse(Course course)  throws SQLException  {
		int count = 0;

		try {
			String query = "update Course set COURSE_DESCRIPTION=?, COURSE_CREDIT=?, PROGRAM_ID=? where COURSE_NAME=?";
			PreparedStatement preparedStmt = TestMain.dbconn.prepareStatement(query);
			preparedStmt.setString(1, course.getCourseDescription());
			preparedStmt.setInt(2, course.getCourseCredit());
			preparedStmt.setString(3, course.getProgramId());
			preparedStmt.setString(4, course.getCourseName());
			count = preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;

	}

	public int deleteCourse(String name)  throws SQLException  {
		ResultSet rs = null;
		int flag = 0;
		try {

			String sql = "DELETE From COURSE where COURSE_NAME = ?";
			PreparedStatement pst = TestMain.dbconn.prepareStatement(sql);
			pst.setString(1, name);
			flag = pst.executeUpdate();

		} catch (SQLIntegrityConstraintViolationException e) {
			flag = 2;
			return flag;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

	public int addCourse(Course course)  throws SQLException  {

		String query = "Insert into course values (?, ?, ?, ?,?)";
		PreparedStatement preparedStmt;
		int flag = 0;
		try {
			preparedStmt = TestMain.dbconn.prepareStatement(query);
			preparedStmt.setInt(1, course.getCourseId());
			preparedStmt.setString(2, course.getCourseName());
			preparedStmt.setString(3, course.getCourseDescription());
			preparedStmt.setInt(4, course.getCourseCredit());
			preparedStmt.setString(5, course.getProgramId());

			flag = preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}
}
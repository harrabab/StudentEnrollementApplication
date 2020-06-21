package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import Business.Program;
import studentEnrollmentApplication.TestMain;

public class ProgramDbAccess implements ProgramDAO {

	public ResultSet findProgram(String id) throws SQLException {
		ResultSet rs = null;

		String query = "Select * From PROGRAM where PROGRAM_ID ='" + id + "'";

		Statement stm = TestMain.dbconn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = stm.executeQuery(query);

		return rs;
	}

	public int deleteProgram(String id) throws SQLException {

		int flag = 0;
		try {
			String sql = "DELETE From PROGRAM where PROGRAM_ID = ?";
			PreparedStatement pst = TestMain.dbconn.prepareStatement(sql);
			pst.setString(1, id);
			flag = pst.executeUpdate();
			return flag;
		}

		catch (SQLIntegrityConstraintViolationException e) {
			return flag = 2;
		}
	}

	public int updateProgram(Program program) throws SQLException {
		int count = 0;
		String query = "update PROGRAM set PROGRAM_NAME=?, Semester=?, YEAR=? where PROGRAM_ID=?";
		PreparedStatement preparedStmt = TestMain.dbconn.prepareStatement(query);
		preparedStmt.setString(1, program.getProgramName());
		preparedStmt.setInt(2, program.getSemesters());
		preparedStmt.setInt(3, program.getYears());
		preparedStmt.setString(4, program.getProgramId());
		count = preparedStmt.executeUpdate();

		return count;
	}

	public int addProgram(Program program) throws SQLException {

		int flag = 0;
			PreparedStatement preparedStmt = null;
			System.out.println("Inserting records into the table...");
			String query = " insert into Program (PROGRAM_ID, PROGRAM_NAME, SEMESTER, YEAR)" + " values (?, ?, ?, ?)";
			preparedStmt = TestMain.dbconn.prepareStatement(query);
			preparedStmt.setString(1, program.getProgramId());
			preparedStmt.setString(2, program.getProgramName());
			preparedStmt.setInt(3, program.getSemesters());
			preparedStmt.setInt(4, program.getYears());
			flag = preparedStmt.executeUpdate();

		return flag;
	}

}

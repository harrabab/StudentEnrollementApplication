package data;

import java.sql.ResultSet;
import java.sql.SQLException;

import Business.Program;

public interface ProgramMethods {
	
	public ResultSet findProgram(String id) throws SQLException ;
	public int deleteProgram(String id) throws SQLException ;
	public int updateProgram(Program program) throws SQLException ;
	public int addProgram(Program program) throws SQLException ;

}

package data;

import java.sql.ResultSet;
import java.sql.SQLException;

import Business.Marks;

public interface MarksMethods {

	
	public int SubmitMarks(Marks marks) throws SQLException;
	public int updateMarks(Marks mm) throws Exception;
	public ResultSet findMarks(Marks mm)throws SQLException;
}

package data;

import java.sql.ResultSet;
import java.sql.SQLException;

import Business.Student;

public interface StudentMethods {
	
	public int addStudent(Student student) throws SQLException ;
	public  int ModifyStudentDetail(Student ss) throws SQLException;
	public ResultSet getStudentid() throws SQLException ;
	public ResultSet getStudentDetail(String StudentId) throws SQLException;
	public ResultSet getProgramId() throws SQLException; 
}

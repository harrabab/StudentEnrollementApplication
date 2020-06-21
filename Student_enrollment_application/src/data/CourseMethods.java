package data;

import java.sql.ResultSet;
import java.sql.SQLException;

import Business.Course;

public interface CourseMethods {
	
	public  ResultSet findCourse(String name) throws SQLException;
	public ResultSet findCourseWithProgramId(String programid) throws SQLException;
	public int updateCourse(Course course) throws SQLException;
	public int deleteCourse(String name) throws SQLException;
	public int addCourse(Course course) throws SQLException;
	
	
	

}

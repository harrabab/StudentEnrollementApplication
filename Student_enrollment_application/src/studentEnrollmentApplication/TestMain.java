package studentEnrollmentApplication;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;

import data.DbConnection;

public class TestMain {
	
	public static JFrame frame;
	public static Connection dbconn=null;
	
	public static void main(String [] args) {
		
		 try {
				DbConnection db = new DbConnection();
				dbconn = db.connect();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
		 frame = new MainFrame();
		 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 frame.setVisible(true);
		
		
		 
	}

}

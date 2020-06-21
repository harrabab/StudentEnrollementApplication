package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	Connection dbconn=null;
	
	public DbConnection() throws SQLException,ClassNotFoundException{
		this.connect();
		}

		public Connection connect() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url ="jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK";
				String username = "N01349018";
				String password = "oracle";
				dbconn = DriverManager.getConnection(url,username,password);
			}catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return dbconn;
		}
		public void disconnect() throws SQLException{
			if (!dbconn.isClosed()) {	
				dbconn.close();
			}
		}
}

package operations;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class Database {
	private static Connection con;
	
	public static void Connect() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/testlogin?useSSL=false";
		con = (Connection) DriverManager.getConnection(url, "root", "");
		System.out.println("Successfully connected to database!");
	}
	
	public static ResultSet Query(String sql) throws SQLException {
		Statement stmt = (Statement) con.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		return result;
	}
	
	public static void readTable(ResultSet result) throws SQLException {
		while(result.next()) {
			for(int i=1;i<=4;i++) {
				System.out.print(result.getString(i)+" ");				
			}
			System.out.println();
		}
	}
	
	public static void closeConnection() throws SQLException {
		con.close();
	}
	
}

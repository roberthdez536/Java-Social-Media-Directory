package operations;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class Database {
	public static Connection con;
	
	// Establishes connection to SQL server
	public static void Connect() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/testlogin?useSSL=false";
		con = (Connection) DriverManager.getConnection(url, "root", "");
		System.out.println("Successfully connected to database!");
		
	}
	
	// Sends SQL query and returns output of query
	public static ResultSet mysqlQuery(String sql) throws SQLException {
		Statement stmt = (Statement) con.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		return result;
	}
	
	// Reads output of mysqlQuery, entire records
	public static void readTable(ResultSet result) throws SQLException {
		while(result.next()) {
			for(int i=1;i<=4;i++) {
				System.out.print(result.getString(i)+" ");				
			}
			System.out.println();
		}
	}
	
	// Closes connection to SQL server
	public static void closeConnection() throws SQLException {
		con.close();
		System.out.println("Successfully closed database connection!");
	}
	
}

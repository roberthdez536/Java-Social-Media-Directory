package operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

public class Add extends Manage {
	
	// Java doesn't support Bcrypt encryption so this method connects to a java.php file on the website to encrypt it
	// using the same encryption php used to store on the database
	public static void addUsertoTable(String uname, String pass, String email) throws SQLException, IOException {
		String urllink = "http://localhost/_c!/java.php?uname="+uname+"&pass="+pass+"&email="+email;
		URL url = new URL(urllink);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		StringBuffer sb = new StringBuffer();
		String line;
		
		while((line = in.readLine()) != null) {
			sb.append(line);
		}
		in.close();
		System.out.println(sb.toString());
	}
}

package operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Manage {
	@FXML private Label testlabelcb1;
	@FXML private TextField testtf1;
	@FXML private Button testbutton1;
	
	@FXML private Label testlabelcb2;
	@FXML private TextField testtf2;
	@FXML private Button testbutton2;
	
	public static final Pattern VALIDEMAIL = 
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public static boolean validate(String emailStr) {
		Matcher matcher = VALIDEMAIL.matcher(emailStr);
		return matcher.find();
	}
	
	// Java doesn't support Bcrypt encryption so this method connects to a java.php file on the website to encrypt it
	// using the same encryption php used to store on the database
	
	public static void addUsertoTable(String uname, String pass, String email) throws SQLException, IOException {
		if(Objects.equals(uname, "") || Objects.equals(pass, "") || Objects.equals(email, "")) {
			System.out.println("Some fields are empty!");
			return;
		}
		else if(validate(email) == false) {
			System.out.println("Invalid email!");
			return;
		}
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
	
	public static void removeUserFromTable(String id) throws SQLException {
		if(Objects.equals(id, "")) {
			System.out.println("Field is empty!");
			return;
		}
		ResultSet rs = Database.mysqlQuery("SELECT * FROM users WHERE id="+id);
		int rowCount = 0;
		while (rs.next()) {
			rowCount++;
		}
		if(rowCount > 1) {
			System.out.println("ERROR! User id was not removed!");
			return;
		}
		Database.mysqlUpdate("DELETE FROM users WHERE id="+id);
		System.out.println("Successfully removed user!");
	}
}

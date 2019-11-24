package operations;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {
	public SimpleIntegerProperty id = new SimpleIntegerProperty();
	public SimpleStringProperty uname = new SimpleStringProperty();
	public SimpleStringProperty pass = new SimpleStringProperty();
	public SimpleStringProperty email = new SimpleStringProperty();
	
	public Integer getId() {
		return id.get();
	}
	
	public Object getUname() {
		return uname.get();
	}
	
	public String getPass() {
		return pass.get();
	}
	
	public String getEmail() {
		return email.get();
	}
}

package application;

import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import operations.Database;
import operations.User;

public class GUIController {
	@FXML private TableView<User> UsersTable;
	@FXML private TableColumn<User, Integer> colId;
	@FXML private TableColumn<User, String> colUname;
	@FXML private TableColumn<User, String> colPass;
	@FXML private TableColumn<User, String> colEmail;
	@FXML private Button refreshButton;
	private ObservableList<User> data;
	
	
	@FXML
	public void initialize() {
		assert UsersTable != null : "fx:id=\"UsersTable\" was not "
				+ "injected: check your FXML file 'GUI.fxml'.";
		
		colId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
		colUname.setCellValueFactory(new PropertyValueFactory<User, String>("uname"));
		colPass.setCellValueFactory(new PropertyValueFactory<User, String>("pass"));
		colEmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
		
		buildUsersTable();
		
	}
	
	public void buildUsersTable() {
		data = FXCollections.observableArrayList();
		try{
			ResultSet rs = Database.mysqlQuery("SELECT * FROM users");
	        while(rs.next()){
	            User cm = new User();
	            cm.id.set(rs.getInt("id"));
	            cm.uname.set(rs.getString("uname"));
	            cm.pass.set(rs.getString("pass"));
	            cm.email.set(rs.getString("email"));
	            data.add(cm);
	        }
	        UsersTable.setItems(data);
	    }
	    catch(Exception e){
	          e.printStackTrace();
	          System.out.println("Error on Building Data");            
	    }
	}
	
	public void refreshTable(ActionEvent event) {
		buildUsersTable();
	}
	
	// Example button fx:id to set in Scene Builder
	@FXML private Button myButton;
	
	// Example button method for Scene Builder
	@FXML
	public void saySomething(ActionEvent event) {
		System.out.println("Hi");
	}
	
}

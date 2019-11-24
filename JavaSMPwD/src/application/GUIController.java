package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import operations.Add;
import operations.Database;
import operations.User;

public class GUIController {
	@FXML private TableView<User> UsersTable;
	@FXML private TableColumn<User, Integer> colId;
	@FXML private TableColumn<User, String> colUname;
	@FXML private TableColumn<User, String> colPass;
	@FXML private TableColumn<User, String> colEmail;
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
	
	@FXML private Button refreshButton;
	public void refreshTable(ActionEvent event) {
		buildUsersTable();
	}
	
	@FXML private TextField addtf1;
	@FXML private TextField addtf2;
	@FXML private TextField addtf3;
	@FXML private Button addsubmit;
	@FXML private TextField removetf1;
	@FXML private Button removesubmit;
	@FXML private TextField edittf1;
	@FXML private Button editsubmit;
	
	
	public void addSubmit(ActionEvent event) throws SQLException, IOException {
		Add.addUsertoTable(addtf1.getText(), addtf2.getText(), addtf3.getText());
	}
	
	// Example button fx:id to set in Scene Builder
	@FXML private Button myButton;
	
	// Example button method for Scene Builder
	@FXML
	public void saySomething(ActionEvent event) {
		System.out.println("Hi");
	}
	
}

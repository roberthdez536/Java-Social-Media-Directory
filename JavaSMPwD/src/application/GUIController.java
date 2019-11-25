package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import operations.Database;
import operations.Manage;
import operations.User;

public class GUIController {
	// Table declerations, could be simplified by adding listeners
	// but thats a whole other topic
	@FXML private TableView<User> UsersTable;
	@FXML private TableColumn<User, Integer> colId;
	@FXML private TableColumn<User, String> colUname;
	@FXML private TableColumn<User, String> colPass;
	@FXML private TableColumn<User, String> colEmail;
	@FXML private TableView<User> UsersTable2;
	@FXML private TableColumn<User, Integer> colId2;
	@FXML private TableColumn<User, String> colUname2;
	@FXML private TableColumn<User, String> colPass2;
	@FXML private TableColumn<User, String> colEmail2;
	@FXML private TableView<User> UsersTable3;
	@FXML private TableColumn<User, Integer> colId3;
	@FXML private TableColumn<User, String> colUname3;
	@FXML private TableColumn<User, String> colPass3;
	@FXML private TableColumn<User, String> colEmail3;
	@FXML private TableView<User> UsersTable4;
	@FXML private TableColumn<User, Integer> colId4;
	@FXML private TableColumn<User, String> colUname4;
	@FXML private TableColumn<User, String> colPass4;
	@FXML private TableColumn<User, String> colEmail4;
	private ObservableList<User> data;
	
	// javaFX reserved function that sets fields of TableView
	@FXML
	public void initialize() {
		assert UsersTable != null : "fx:id=\"UsersTable\" was not "
				+ "injected: check your FXML file 'GUI.fxml'.";
		
		// Woah whats this, it's so long and repetitive. This is used
		// to add the type of value the columns take for the tables
		colId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
		colUname.setCellValueFactory(new PropertyValueFactory<User, String>("uname"));
		colPass.setCellValueFactory(new PropertyValueFactory<User, String>("pass"));
		colEmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
		colId2.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
		colUname2.setCellValueFactory(new PropertyValueFactory<User, String>("uname"));
		colPass2.setCellValueFactory(new PropertyValueFactory<User, String>("pass"));
		colEmail2.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
		colId3.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
		colUname3.setCellValueFactory(new PropertyValueFactory<User, String>("uname"));
		colPass3.setCellValueFactory(new PropertyValueFactory<User, String>("pass"));
		colEmail3.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
		colId4.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
		colUname4.setCellValueFactory(new PropertyValueFactory<User, String>("uname"));
		colPass4.setCellValueFactory(new PropertyValueFactory<User, String>("pass"));
		colEmail4.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
		
		buildUsersTable();
		
	}
	
	// Grabs data from database table 'users' and displays each row on javaFX TableView
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
	        UsersTable2.setItems(data);
	        UsersTable.setItems(data);
	        UsersTable3.setItems(data);
	        UsersTable4.setItems(data);
	    }
	    catch(Exception e){
	          e.printStackTrace();
	          System.out.println("Error on Building Data");            
	    }
	}
	
	// Function to refresh table when button is clicked
	@FXML private Button refreshButton;
	@FXML private Button refreshButton2;
	@FXML private Button refreshButton3;
	@FXML private Button refreshButton4;
	public void refreshTable(ActionEvent event) {
		buildUsersTable();
	}
	
	// Edit user functions, for reasons it became long and repetetive to keep
	// users from change what was already set. Cleanup is optional
	@FXML private Label ei;
	@FXML private TextField edittf1;
	@FXML private Button editsubmit;
	public void turnOnEditOptions(ActionEvent event) throws SQLException {
		if(Database.checkIdExhist(edittf1.getText())) {
			
			eul.setVisible(true);
			epl.setVisible(true);
			eel.setVisible(true);
			edituname.setVisible(true);
			editpass.setVisible(true);
			editemail.setVisible(true);
			editsubmitchanges.setVisible(true);
			
			
			ei.setVisible(false);
			edittf1.setVisible(false);
			editsubmit.setVisible(false);
		}
		else {
			System.out.println("Error! ID does not exhist!");
		}
	}
	
	@FXML private Label eul;
	@FXML private Label epl;
	@FXML private Label eel;
	@FXML private TextField edituname;
	@FXML private TextField editpass;
	@FXML private TextField editemail;
	@FXML private Button editsubmitchanges;
	public void editUser(ActionEvent event) throws IOException {
		Manage.editUserFromTable(edittf1.getText(), edituname.getText(), editpass.getText(), editemail.getText());
		eul.setVisible(false);
		epl.setVisible(false);
		eel.setVisible(false);
		edituname.setVisible(false);
		editpass.setVisible(false);
		editemail.setVisible(false);
		editsubmitchanges.setVisible(false);
		
		ei.setVisible(true);
		edittf1.setVisible(true);
		editsubmit.setVisible(true);
		
		edituname.clear();
		editpass.clear();
		editemail.clear();
		edittf1.clear();
		
		buildUsersTable();
	}
	
	// Add user function
	@FXML private TextField addtf1;
	@FXML private TextField addtf2;
	@FXML private TextField addtf3;
	@FXML private Button addsubmit;
	public void addUser(ActionEvent event) throws SQLException, IOException {
		Manage.addUsertoTable(addtf1.getText(), addtf2.getText(), addtf3.getText());
		addtf1.clear();
		addtf2.clear();
		addtf3.clear();
		buildUsersTable();
	}
	
	// Remove user function
	@FXML private TextField removetf1;
	@FXML private Button removesubmit;
	public void removeUser(ActionEvent event) throws SQLException {
		Manage.removeUserFromTable(removetf1.getText());
		removetf1.clear();
		buildUsersTable();
	}
	
	// Toggle label test
	@FXML private Label testlabel;
	@FXML private Button visibilitytestbutton;
	public void toggleLabelTest(ActionEvent event) {
		if(testlabel.isVisible() == true) {
			testlabel.setVisible(false);
		}
		else {
			testlabel.setVisible(true);
		}
	}
	
	// ChoiceBox toggles show fields test
	
	// Example button fx:id to set in Scene Builder
	@FXML private Button myButton;
	
	// Example button method for Scene Builder
	@FXML
	public void saySomething(ActionEvent event) {
		System.out.println("Hi");
	}
	
}

package application;
	
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import operations.Database;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	public static void main(String[] args) throws SQLException {
		Database.Connect();
		launch(args);
		Database.closeConnection();
		
	}
	
	// Sets window and other necessary parts for the javaFX GUI
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
			Scene scene = new Scene(root,800,600);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

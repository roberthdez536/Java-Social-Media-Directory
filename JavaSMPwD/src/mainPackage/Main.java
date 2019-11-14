package mainPackage;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
 
public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	Parent root = FXMLLoader.load(getClass().getResource("/guiEditor.fxml"));
    	Scene scene = new Scene(root);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
}

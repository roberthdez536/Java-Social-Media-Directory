module javaSMP {
	
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.web;
	requires javafx.base;
	requires java.sql;
	requires mysql.connector.java;
	
	opens operations to javafx.base;
	
	opens application;
}
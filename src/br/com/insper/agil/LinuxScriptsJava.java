package br.com.insper.agil;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LinuxScriptsJava extends Application {
	
	private static String LOGO = "/br/com/insper/agil/resources/img/logo.png";
	public static String LAYOUT1 = "br/com/insper/agil/view/Layout1.fxml";

	private static AnchorPane root;
	private static Stage stage;


	public static void main(String[] args) {
		Application.launch(LinuxScriptsJava.class, args);
	}

	@Override
	public void start(Stage primaryStage) {
		
		LinuxScriptsJava.stage = primaryStage;

		try {
			LinuxScriptsJava.stage.getIcons().add(new Image(getClass().getResourceAsStream(LOGO)));
			} catch (NullPointerException e) {
			System.out.println("logo.png not found.");
			e.printStackTrace();
		}
		
		try {
			LinuxScriptsJava.root = FXMLLoader.load(getClass().getClassLoader().getResource(LAYOUT1));
			Scene scene = new Scene(root);
			
			LinuxScriptsJava.stage.setTitle("Linux Scripts");
			LinuxScriptsJava.stage.setScene(scene);
			LinuxScriptsJava.stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

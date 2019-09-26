package br.com.insper.agil;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LinuxScriptsJava extends Application {
	
	private static String LOGO = "/br/com/insper/agil/resources/img/logo.png";
	public static String LAYOUT1 = "/br/com/insper/agil/view/Layout1.fxml";


	public static void main(String[] args) {
		Application.launch(LinuxScriptsJava.class, args);
	}

	@Override
	public void start(Stage stage) {

		try {
			stage.getIcons().add(new Image(getClass().getResourceAsStream(LOGO)));
			} catch (NullPointerException e) {
			System.out.println("logo.png not found.");
			e.printStackTrace();
		}
		
		try {
			Scene scene = new Scene(FXMLLoader.load(
			        getClass().getResource("view/Layout1.fxml")));

			stage.setTitle("Linux Scripts");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

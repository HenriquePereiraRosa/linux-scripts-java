package br.com.insper.agil;

import java.io.IOException;

import br.com.insper.agil.util.FileHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LinuxScriptsJava extends Application {
	
	private static String LOGO = "/br/com/insper/agil/resources/img/logo.png";
	public static String LAYOUT1 = "view/Layout1.fxml";
	public static String NET_FILE = "/etc/NetworkManager/system-connections";
	//public static String NET_FILE = "/etc/NetworkManager/system-connections/Insper_Alunos";

	public static void main(String[] args) {
		Application.launch(LinuxScriptsJava.class, args);
	}

	@Override
	public void start(Stage stage) {

		FileHandler fh = new FileHandler();

		try {
			stage.getIcons().add(new Image(getClass().getResourceAsStream(LOGO)));
			} catch (NullPointerException e) {
			System.out.println("logo.png not found.");
			e.printStackTrace();
		}
		
		try {
			Scene scene = new Scene(FXMLLoader.load(
			        getClass().getResource(LAYOUT1)));

			stage.setTitle("Linux Scripts");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {

			System.out.println("Could't load fxml file");
			e.printStackTrace();
		}

//		try {
//			if (fh.removeFile(NET_FILE))
//				System.out.println("File Removed");
//			else System.out.println("File not Removed");
//
//		} catch (Exception e) {
//			System.out.println("Error removing file... ");
//		}
	}

}

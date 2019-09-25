package br.com.insper.agil.controller;

import br.com.insper.agil.event.Trigger;
import br.com.insper.agil.event.TriggerHandler;
import br.com.insper.agil.resources.strings.StringResources;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;


public class Layout1Controller {

	private Trigger trigger;
	private TriggerHandler tgrHandler;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="btnOK"
	private Button btnOK; // Value injected by FXMLLoader

	@FXML // fx:id="imgInsper"
	private ImageView imgInsper; // Value injected by FXMLLoader


	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert btnOK != null : "fx:id=\"btnOK\" was not injected: check your FXML file 'Layout1.fxml'.";
		assert imgInsper != null : "fx:id=\"imgInsper\" was not injected: check your FXML file 'Layout1.fxml'.";

		trigger = new Trigger();
		tgrHandler = new TriggerHandler();

	}

	@FXML
	void goToInsper(ActionEvent event) {
		trigger.addListener(tgrHandler);
		trigger.triggerEvent(StringResources.INSPER);
	}

	@FXML
	void close(ActionEvent event) {
		System.out.println("Closing...");
		System.exit(0);
	}

}

package paquete.rhc.controller;

import javafx.fxml.FXML;
import paquete.rhc.MainApp;

public class RootLayoutController {

	private MainApp mainApp;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void handleExit() {
		System.exit(0);
	}
}
package paquete.rhc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import paquete.rhc.MainApp;
import paquete.rhc.model.Persona;

public class PersonaCreateController {

	private Stage dialogStage;

	@FXML
	private TextField tfNombre;
	@FXML
	private TextField tfDni;
	@FXML
	private TextField tfPrecio;
	@FXML
	private Button btnGuardar;

	private MainApp mainApp;

	@FXML
	private void initialize() {
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	private void crearPersona() {
		if (camposValidos()) {
			String nombre = tfNombre.getText();
			String dni = tfDni.getText();
			int precio = Integer.parseInt(tfPrecio.getText());
			Persona persona = new Persona(nombre, dni, precio);
			mainApp.getPersonaData().add(persona);
			salir();
		}
	}

	private boolean camposValidos() {

		int errores = 0;
		if (tfNombre.getText().toString().trim() == null || tfNombre.getText().toString().trim().isBlank()) {
			errores++;
		}
		if (tfDni.getText().toString().trim() == null || tfDni.getText().toString().trim().isBlank()) {
			errores++;
		}
		if (tfPrecio.getText().toString().trim() == null || tfPrecio.getText().toString().trim().isBlank()
				|| Integer.parseInt(tfPrecio.getText().toString().trim()) <= 0) {
			errores++;
		}

		if (errores == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Campos invalidos");
			alert.setHeaderText("Introduce datos correctos");
			alert.showAndWait();
			return false;
		}
	}

	@FXML
	private void salir() {
		dialogStage.close();
	}
}
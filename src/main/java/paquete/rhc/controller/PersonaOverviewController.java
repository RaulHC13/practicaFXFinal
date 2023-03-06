package paquete.rhc.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import paquete.rhc.MainApp;
import paquete.rhc.model.Persona;

public class PersonaOverviewController {

	@FXML
	private TableView<Persona> personTable;
	@FXML
	private TableColumn<Persona, String> firstNameColumn;
	@FXML
	private TableColumn<Persona, String> dniColumn;
	@FXML
	private Label nombreLabel;
	@FXML
	private Label dniLabel;
	@FXML
	private Label precioLabel;
	@FXML
	private Label edadLabel;
	@FXML
	private CheckBox disponibleCB;
	
	private MainApp mainApp;
	
	public PersonaOverviewController() {
		
	}

	@FXML
	private void initialize() {
		firstNameColumn.setCellValueFactory(
				cellData -> cellData.getValue().getNombreProperty());
		dniColumn.setCellValueFactory( 
				cellData -> cellData.getValue().getDniProperty());
		
		showPersonData(null);
		
		personTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showPersonData(newValue));
	}
	
	private void showPersonData(Persona persona) {
		if(persona != null) {
			nombreLabel.setText(persona.getNombre());
			dniLabel.setText(persona.getDni());
			precioLabel.setText(String.valueOf(persona.getPrecio()));
			edadLabel.setText(String.valueOf(persona.getEdad()));
			
			disponibleCB.setSelected(persona.getDisponible() == 0);
		} else {
			nombreLabel.setText("");
			dniLabel.setText("");
			precioLabel.setText("");
			edadLabel.setText("");
			disponibleCB.setSelected(false);
		}
	}
	
	@FXML
	private void handleCreate() throws IOException {
		mainApp.showPersonCreate();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		personTable.setItems(mainApp.getPersonaData());
	}
}
package paquete.rhc;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import paquete.rhc.controller.PersonaOverviewController;
import paquete.rhc.controller.RootLayoutController;
import paquete.rhc.model.Persona;

public class MainApp extends Application {

	private Stage mainStage;
	private BorderPane rootLayout;
	
	private ObservableList<Persona> dataInicial = FXCollections.observableArrayList();
	
    @Override
    public void start(Stage stage) throws IOException {
    		this.mainStage = stage;
    		this.mainStage.setTitle("Practica");
    		
    		initRootLayout();
    		initPersonOverview();
    }
    
    public MainApp() {
    	dataInicial.add(new Persona("Uno", "Apellido", 1));
    	dataInicial.add(new Persona("Dos", "Apellid", 2));
    	dataInicial.add(new Persona("Tres", "Apelli", 3));
    	dataInicial.add(new Persona("Cuatro", "Apell", 4));
    	dataInicial.add(new Persona("Cinco", "Apel", 5));
    	dataInicial.add(new Persona("Seis", "Ape", 6));
    }
    
    public ObservableList<Persona> getPersonaData() {
    	return dataInicial;
    }
    
    public static void main(String[] args) {
        launch();
    }
    
    private void initRootLayout() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
    	rootLayout = (BorderPane) loader.load();
    	
    	Scene scene = new Scene(rootLayout);
    	mainStage.setScene(scene);
    	
    	RootLayoutController controller = loader.getController();
    	controller.setMainApp(this);
    	
    	mainStage.show();
    }
    
    public void initPersonOverview() throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainApp.class.getResource("view/PersonaOverview.fxml"));
    	AnchorPane root = (AnchorPane) loader.load();
    	
    	rootLayout.setCenter(root);
    	
    	PersonaOverviewController controller = loader.getController();
    	controller.setMainApp(this);
    }
    
    public void showPersonCreate() {
    	try {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(MainApp.class.getResource("view/PersonaCreate.fxml"));
    	AnchorPane rootPane = (AnchorPane) loader.load();
    	
    	Stage createStage = new Stage();
    	createStage.setTitle("Crear persona");
    	createStage.initModality(Modality.WINDOW_MODAL);
    	createStage.initOwner(mainStage);
    	
    	Scene scene = new Scene(rootPane);
    	createStage.setScene(scene);
    	
    	createStage.showAndWait();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
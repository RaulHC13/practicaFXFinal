module paquete.rhc.practicaExamenFinal {
    requires javafx.controls;
    requires javafx.fxml;

    opens paquete.rhc to javafx.fxml;
    opens paquete.rhc.controller;
    opens paquete.rhc.model;
    
    exports paquete.rhc;
}
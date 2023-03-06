package paquete.rhc.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {
	
	private final StringProperty nombre;
	private final StringProperty dni;
	private final IntegerProperty precio;
	private final IntegerProperty edad;
	private final IntegerProperty disponible;
	
	public Persona() {
		this(null,null,0);
	}
	
	public Persona(String nombre, String dni, int precio) {
		this.nombre = new SimpleStringProperty(nombre);
		this.dni = new SimpleStringProperty(dni);
		this.precio = new SimpleIntegerProperty(precio);
		
		this.edad = new SimpleIntegerProperty((int) Math.round(Math.random()*100));
		this.disponible = new SimpleIntegerProperty((int) Math.round(Math.random()));
	}

	public String getNombre() {
		return nombre.get();
	}
	
	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}
	
	public StringProperty getNombreProperty() {
		return nombre;
	}

	public String getDni() {
		return dni.get();
	}
	
	public void setDni(String dni) {
		this.dni.set(dni);
	}
	
	public StringProperty getDniProperty() {
		return dni;
	}

	public int getPrecio() {
		return precio.get();
	}
	
	public void setPrecio(int precio) {
		this.precio.set(precio);
	}
	
	public IntegerProperty getPrecioProperty() {
		return precio;
	}
	
	public int getEdad() {
		return edad.get();
	}
	
	public int getDisponible() {
		return disponible.get();
	}
}
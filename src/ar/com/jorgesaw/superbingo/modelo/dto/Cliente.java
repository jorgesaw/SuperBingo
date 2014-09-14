package ar.com.jorgesaw.superbingo.modelo.dto;

public class Cliente extends Persona {
	
	public Cliente() {}
	
	public Cliente(Long dni, String apellido, String nombre) {
		super(dni, apellido, nombre);
	}
}

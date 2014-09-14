package ar.com.jorgesaw.superbingo.modelo.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Empleado {
	
	public transient static final Long NULO = -1L;
	private Long dni;
	private String apellido;
	private String nombre;
//	private String direccion;
//	private String ciudad;
//	private String provincia;
	private Direccion direccion;
	private String celular;
	private String telefono;
	private java.util.Date fechaIng;

	private Set<Carton> colCartones = new HashSet<Carton>();

	public Empleado() { }
	
	public Empleado(Long dni, String apellido, String nombre) {
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
	}

	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public Set<Carton> getColCartones() {
		return colCartones;
	}

	public void setColCartones(Set<Carton> colCartones) {
		this.colCartones = colCartones;
	}
	public void addCarton(Carton carton) {
		colCartones.add(carton);
	}
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public java.util.Date getFechaIng() {
		return fechaIng;
	}

	public void setFechaIng(java.util.Date fechaIng) {
		this.fechaIng = fechaIng;
	}
	
	public String toString() {
		return dni + " - " + nombre + " " + apellido;
	}
}

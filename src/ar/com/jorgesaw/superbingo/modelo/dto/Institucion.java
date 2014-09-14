package ar.com.jorgesaw.superbingo.modelo.dto;

public class Institucion {
	
	private Long idInstit;
	private String tipo;
	private String descripcion;
	private String alias;
	private String telefono;
	private String celular;

	private Direccion direccion;

	public Institucion() {}
	
	public Institucion(String tipo, String descripcion, String alias) {
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.alias = alias;
	}
	
	public Institucion(Long idInstit, String tipo, 
			String descripcion, String alias) {
		this.idInstit = idInstit;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.alias = alias;
	}
	public Long getIdInstit() {
		return idInstit;
	}
	public void setIdInstit(Long idInstit) {
		this.idInstit = idInstit;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String toString() {
		return alias;
	}
}

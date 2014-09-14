package ar.com.jorgesaw.superbingo.modelo.dto;

public class TipoLoteria {
	
	Integer idTipo;
	String nombre;
	String alias;
	
	public TipoLoteria() { }
	
	public TipoLoteria(String nombre, String alias) {
		this.nombre = nombre;
		this.alias = alias;
	}

	public TipoLoteria(Integer idTipo, String nombre, String alias) {
		this.idTipo = idTipo;
		this.nombre = nombre;
		this.alias = alias;
	}
	
	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String toString() {
		return alias;
	}
}

package ar.com.jorgesaw.dto;

public class TipoUsuario {

	private Integer tipoUsuario;
	private String descTipoUsuario;
	
	public TipoUsuario() { }
	
	public TipoUsuario(String descTipoUsuario) { 
		this.descTipoUsuario = descTipoUsuario;
	}

	/**
	 * @return the tipoUsuario
	 */
	protected Integer getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario the tipoUsuario to set
	 */
	protected void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * @return the descTipoUsuario
	 */
	protected String getDescTipoUsuario() {
		return descTipoUsuario;
	}

	/**
	 * @param descTipoUsuario the descTipoUsuario to set
	 */
	protected void setDescTipoUsuario(String descTipoUsuario) {
		this.descTipoUsuario = descTipoUsuario;
	}
	
	public String toString() {
		return descTipoUsuario;
	}
}

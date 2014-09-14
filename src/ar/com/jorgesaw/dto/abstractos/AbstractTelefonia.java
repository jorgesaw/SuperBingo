package ar.com.jorgesaw.dto.abstractos;

import ar.com.jorgesaw.dto.Ciudad;

public class AbstractTelefonia {

	private Long idTelefonia;
	private Ciudad ciudad;
	private String numero;
	
	public AbstractTelefonia() { }
	
	public AbstractTelefonia(Ciudad ciudad, String numero) {
		super();
		this.ciudad = ciudad;
		this.numero = numero;
	}
	/**
	 * @return the idTelefonia
	 */
	protected Long getIdTelefonia() {
		return idTelefonia;
	}
	/**
	 * @param idTelefonia the idTelefonia to set
	 */
	protected void setIdTelefonia(Long idTelefonia) {
		this.idTelefonia = idTelefonia;
	}
	/**
	 * @return the ciudad
	 */
	protected Ciudad getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad the ciudad to set
	 */
	protected void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * @return the numero
	 */
	protected String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	protected void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append(ciudad.getDDN());
		cadena.append(" - ");
		cadena.append(numero);
	
		return  cadena.toString();
	}
	
}

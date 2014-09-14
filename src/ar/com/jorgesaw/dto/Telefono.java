package ar.com.jorgesaw.dto;

import ar.com.jorgesaw.dto.abstractos.AbstractTelefonia;

public class Telefono extends AbstractTelefonia {

	private boolean fax;
	
	public Telefono() { }

	
	public Telefono(Ciudad ciudad, String numero, boolean fax) {
		super(ciudad, numero);
		this.fax = fax;
	}


	/**
	 * @return the fax
	 */
	protected boolean isFax() {
		return fax;
	}

	/**
	 * @param fax the fax to set
	 */
	protected void setFax(boolean fax) {
		this.fax = fax;
	}
	
	
}

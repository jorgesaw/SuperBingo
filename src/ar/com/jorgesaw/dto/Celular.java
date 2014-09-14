package ar.com.jorgesaw.dto;

import ar.com.jorgesaw.dto.abstractos.AbstractTelefonia;

public class Celular extends AbstractTelefonia {

	public Celular() { }
	
	public Celular(Ciudad ciudad, String numero) {
		super(ciudad, numero);
	}
	
}

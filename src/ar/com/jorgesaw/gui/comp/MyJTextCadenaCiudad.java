package ar.com.jorgesaw.gui.comp;

import ar.com.jorgesaw.dto.Ciudad;
import ar.com.jorgesaw.gui.vista.interfaces.CompBasicoCiudad;

public class MyJTextCadenaCiudad extends MyJTextCadena implements CompBasicoCiudad {

	private static final long serialVersionUID = 7642626965041596724L;
	Ciudad ciudad = null;
	
	public MyJTextCadenaCiudad(String nomComp) {
		super(nomComp);
		super.setEditable(false);
	}
	
	public MyJTextCadenaCiudad(String nomComp, int minLong, int maxLong,
			boolean obligatorio) {
		super(nomComp, minLong, maxLong, obligatorio);
	}	

	@Override
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public Ciudad getCiudad() {
		return this.ciudad;
	}

	@Override
	public void resetValue() {
		this.ciudad = null;
		super.resetValue();
	}
	
	@Override
	public Object getValue() {
		return this.ciudad;
	}

}
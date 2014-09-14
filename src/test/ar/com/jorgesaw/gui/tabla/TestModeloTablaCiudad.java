package test.ar.com.jorgesaw.gui.tabla;

import ar.com.jorgesaw.dto.Ciudad;
import ar.com.jorgesaw.gui.tabla.ModeloTabla;

public class TestModeloTablaCiudad extends ModeloTabla<Ciudad> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6559512884462969352L;

	public TestModeloTablaCiudad(String[] nombreColumnas, Object[] longValores) {
		super(nombreColumnas, longValores);
	}

	@Override
	public Object getValueAt(int fila, int col) {
		Object valor = null;
		switch(col) {
			case 0 :
				valor = fila + 1;
				break;
			case 1 :
				valor = super.getData().get(fila).getNomCiudad();
				break;
			case 2 :
				valor = super.getData().get(fila).getCodPostal();
				break;
			case 3 :
				valor = super.getData().get(fila).getDDN();
				break;
		}
		return valor;
	}
	
	@Override
	public void setValueAt(Object valor, int fila, int col) {
		switch(col) {
		case 1 :
			super.getData().get(fila).setNomCiudad(valor.toString());
			break;
		case 2 :
			super.getData().get(fila).setCodPostal(valor.toString());
			break;
		case 3 :
			super.getData().get(fila).setDDN(valor.toString());
			break;
	}
		super.setValueAt(valor, fila, col);
	}

	@Override
	public void setValueAtPojo(Ciudad pojo, int fila) {
		setValueAt(pojo.getNomCiudad(), fila, 1);
		setValueAt(pojo.getCodPostal(), fila, 2);
		setValueAt(pojo.getDDN(), fila, 3);
	}
	
}

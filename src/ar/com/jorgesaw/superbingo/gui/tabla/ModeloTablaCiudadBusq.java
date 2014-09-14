package ar.com.jorgesaw.superbingo.gui.tabla;

import ar.com.jorgesaw.dto.Ciudad;
import ar.com.jorgesaw.gui.tabla.ModeloTabla;

public class ModeloTablaCiudadBusq extends ModeloTabla<Ciudad> {

	private static final long serialVersionUID = 7770797841961700635L;
	
	public ModeloTablaCiudadBusq(String[] nombreColumnas, Object[] longValores) {
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
		}
		return valor;
	}
	
	@Override
	public void setValueAt(Object valor, int fila, int col) {
		switch(col) {
		case 1 :
			super.getData().get(fila).setNomCiudad(valor.toString());
			break;
		}
		super.setValueAt(valor, fila, col);
	}
	
	@Override
	public void setValueAtPojo(Ciudad pojo, int fila) {
		setValueAt(pojo.getNomCiudad(), fila, 1);
	}
}

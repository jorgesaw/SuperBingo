package ar.com.jorgesaw.superbingo.gui.tabla;

import ar.com.jorgesaw.gui.tabla.ModeloTabla;
import ar.com.jorgesaw.superbingo.modelo.dto.TipoLoteria;

public class ModeloTablaTipoLot extends ModeloTabla<TipoLoteria> {

	private static final long serialVersionUID = 5199189126187017043L;

	public ModeloTablaTipoLot(String[] nombreColumnas, Object[] longValores) {
		super(nombreColumnas, longValores);
	}

	@Override
	public Object getValueAt(int fila, int col) {
		Object valor = null;

		switch (col) {
		case 0:
			valor = fila + 1;
			break;
		case 1:
			valor = super.getData().get(fila).getNombre();
			break;
		case 2:
			valor = super.getData().get(fila).getAlias();
			break;
		}
		return valor;
	}

	@Override
	public void setValueAt(Object valor, int fila, int col) {
		switch (col) {
		case 1:
			super.getData().get(fila).setNombre(valor.toString());
			break;
		case 2:
			super.getData().get(fila).setAlias(valor.toString());
			break;
		}
		super.setValueAt(valor, fila, col);
	}
	
	@Override
	public void setValueAtPojo(TipoLoteria pojo, int fila) {
		setValueAt(pojo.getNombre(), fila, 1);
		setValueAt(pojo.getAlias(), fila, 2);
	}

}
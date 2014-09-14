package ar.com.jorgesaw.superbingo.gui.tabla;

import ar.com.jorgesaw.gui.tabla.ModeloTabla;
import ar.com.jorgesaw.superbingo.modelo.dto.Bingo;

public class ModeloTablaBingoBusq extends ModeloTabla<Bingo> {

	private static final long serialVersionUID = 3350764002248701171L;
	
	public ModeloTablaBingoBusq(String[] nombreColumnas, Object[] longValores) {
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
				valor = super.getData().get(fila).getTitulo();
				break;
		}
		return valor;
	}
	
	@Override
	public void setValueAt(Object valor, int fila, int col) {
		switch(col) {
		case 1 :
			super.getData().get(fila).setTitulo(valor.toString());
			break;
		}
		super.setValueAt(valor, fila, col);
	}
	
}

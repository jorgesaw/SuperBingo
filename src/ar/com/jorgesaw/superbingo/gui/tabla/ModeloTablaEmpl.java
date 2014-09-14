package ar.com.jorgesaw.superbingo.gui.tabla;

import ar.com.jorgesaw.gui.tabla.ModeloTabla;
import ar.com.jorgesaw.superbingo.modelo.dto.Empleado;

public class ModeloTablaEmpl extends ModeloTabla<Empleado> {

	private static final long serialVersionUID = 8101561657448621444L;

	public ModeloTablaEmpl(String[] nombreColumnas, Object[] longValores) {
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
			valor = super.getData().get(fila).getApellido();
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
			super.getData().get(fila).setApellido(valor.toString());
			break;
		}
		super.setValueAt(valor, fila, col);
	}
	
	@Override
	public void setValueAtPojo(Empleado pojo, int fila) {
		setValueAt(pojo.getNombre(), fila, 1);
		setValueAt(pojo.getApellido(), fila, 2);
	}
}
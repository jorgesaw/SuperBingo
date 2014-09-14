package ar.com.jorgesaw.superbingo.gui.tabla;

import ar.com.jorgesaw.dto.Ciudad;
import ar.com.jorgesaw.dto.Provincia;
import ar.com.jorgesaw.gui.tabla.ModeloTabla;
import ar.com.jorgesaw.superbingo.modelo.dto.Institucion;

public class ModeloTablaInstit extends ModeloTabla<Institucion> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1400577707223586950L;

	public ModeloTablaInstit(String[] nombreColumnas, Object[] longValores) {
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
			valor = super.getData().get(fila).getTipo();
			break;
		case 2:
			valor = super.getData().get(fila).getDescripcion();
			break;
		case 3:
			valor = super.getData().get(fila).getAlias();
			break;
		case 4:
			valor = super.getData().get(fila).getCelular();
			break;
		case 5:
			valor = super.getData().get(fila).getTelefono();
			break;
		case 6:
			valor = super.getData().get(fila).getDireccion().toString();
			break;
		case 7:
			valor = super.getData().get(fila).getDireccion().getPiso();
			break;
		case 8:
			valor = super.getData().get(fila).getDireccion().getDepto();
			break;
		case 9:
			valor = super.getData().get(fila).getDireccion().getCiudad();
			break;
		case 10:
			valor = super.getData().get(fila).getDireccion().getCiudad().getProv();
			break;
		}
		return valor;
	}

	@Override
	public void setValueAt(Object valor, int fila, int col) {
		switch (col) {
		case 1:
			super.getData().get(fila).setTipo(valor.toString());
			break;
		case 2:
			super.getData().get(fila).setDescripcion(valor.toString());
			break;
		case 3:
			super.getData().get(fila).setAlias(valor.toString());
			break;
		case 4:
			super.getData().get(fila).setCelular(valor.toString());
			break;
		case 5:
			super.getData().get(fila).setTelefono(valor.toString());
			break;
		case 6:
			String[] datosDireccion = valor.toString().split(" ");
			super.getData().get(fila).getDireccion().setCalle(datosDireccion[0]);
			super.getData().get(fila).getDireccion().setAltura(datosDireccion[1]);
			break;
		case 7:
			super.getData().get(fila).getDireccion().setPiso(valor.toString());
			break;
		case 8:
			super.getData().get(fila).getDireccion().setDepto(valor.toString());
			break;
		case 9:
			super.getData().get(fila).getDireccion().setCiudad((Ciudad) valor);
			break;
		case 10:
			super.getData().get(fila).getDireccion().getCiudad().setProv((Provincia) valor);
			break;
		}
		super.setValueAt(valor, fila, col);
	}
	
	@Override
	public void setValueAtPojo(Institucion pojo, int fila) {
		setValueAt(pojo.getTipo(), fila, 1);
		setValueAt(pojo.getDescripcion(), fila, 2);
		setValueAt(pojo.getAlias(), fila, 3);
		setValueAt(pojo.getCelular(), fila, 4);
		setValueAt(pojo.getTelefono(), fila, 5);
		setValueAt(pojo.getDireccion().toString(), fila, 6);
		setValueAt(pojo.getDireccion().getPiso(), fila, 7);
		setValueAt(pojo.getDireccion().getDepto(), fila, 8);
		setValueAt(pojo.getDireccion().getCiudad(), fila, 9);
		setValueAt(pojo.getDireccion().getCiudad().getProv(), fila, 10);
	}
}

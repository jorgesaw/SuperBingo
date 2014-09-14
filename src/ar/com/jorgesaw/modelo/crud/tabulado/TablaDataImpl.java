package ar.com.jorgesaw.modelo.crud.tabulado;

import java.util.List;

import ar.com.jorgesaw.gui.tabla.ModeloTabla;
import ar.com.jorgesaw.gui.tabla.interfaces.ControlTabla;
import ar.com.jorgesaw.modelo.crud.tabulado.interfaces.TablaData;

public class TablaDataImpl<T> implements TablaData<T> {

	@SuppressWarnings("rawtypes")
	private ControlTabla controlTabla;
	
	@Override
	public void setControlTabla(ControlTabla<?> controlTabla) {
		this.controlTabla = controlTabla;
	}

	@Override
	public ControlTabla<?> getControlTabla() {
		return controlTabla;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void mostrarDatos(T pojo) {
		controlTabla.agregarFila(pojo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void mostrarDatos(List<T> listaPojos) {
		controlTabla.eliminarTotalFilas();
		controlTabla.agregarFilas(listaPojos);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void mostrarDatos(int pos, T pojo) {
		controlTabla.agregarFila(pos, pojo);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T getPojoFilaTabla(int fila) {
		return ((ModeloTabla<T>) controlTabla.getModelo()).getData().get(fila);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void mostrarDatosActualiz(T pojo, int fila) {
		controlTabla.actualizarFila(pojo, fila);
	}
	
	@Override
	public void elimDatoMostrado(int pos) {
		controlTabla.eliminarFila(pos);
	}
	
	@Override
	public void elimDatoMostrado() {
		controlTabla.eliminarFila(controlTabla.getTabla().getSelectedRow());
	}

	@Override
	public void limpiarDatosTabla() {
		controlTabla.eliminarTotalFilas();
	}
}
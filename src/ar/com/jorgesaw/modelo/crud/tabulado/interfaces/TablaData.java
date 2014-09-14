package ar.com.jorgesaw.modelo.crud.tabulado.interfaces;

import java.util.List;

import ar.com.jorgesaw.gui.tabla.ControlTablaImpl;
import ar.com.jorgesaw.gui.tabla.interfaces.ControlTabla;

public interface TablaData<T> {
	
	void setControlTabla(ControlTabla<?> ct);
	
	void mostrarDatos(T dato);

	void mostrarDatos(List<T> listaPojos);

	void mostrarDatos(int pos, T pojo);
	
	T getPojoFilaTabla(int fila);

	void mostrarDatosActualiz(T pojo, int fila);

	void elimDatoMostrado(int pos);

	void elimDatoMostrado();

	ControlTabla<?> getControlTabla();

	void limpiarDatosTabla();
	
}

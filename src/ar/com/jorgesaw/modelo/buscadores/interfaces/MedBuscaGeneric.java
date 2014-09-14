package ar.com.jorgesaw.modelo.buscadores.interfaces;

import java.util.HashMap;

import ar.com.jorgesaw.modelo.crud.tabulado.interfaces.TablaData;

public interface MedBuscaGeneric<T> {

	T getDatoSeleccionado();
	
	void limpiarModeloTabla();
	
	int buscarDatos(HashMap<String, Object> mapDatos, String categoria);	
	
	boolean seleccionarDato();

	TablaData<T> getTablaData();

	BuscaEspecifico<?> getBuscaEspecifico();
	
}

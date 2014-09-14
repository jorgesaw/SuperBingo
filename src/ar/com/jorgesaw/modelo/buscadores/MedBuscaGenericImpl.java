package ar.com.jorgesaw.modelo.buscadores;

import java.util.HashMap;
import java.util.List;

import ar.com.jorgesaw.modelo.buscadores.interfaces.BuscaEspecifico;
import ar.com.jorgesaw.modelo.buscadores.interfaces.MedBuscaGeneric;
import ar.com.jorgesaw.modelo.crud.tabulado.interfaces.TablaData;

public class MedBuscaGenericImpl<T> implements MedBuscaGeneric<T> {

	@SuppressWarnings("rawtypes")
	TablaData tablaData;
	@SuppressWarnings("rawtypes")
	BuscaEspecifico buscaEspecif;
	
	T datoSeleccionado;
	
	public MedBuscaGenericImpl() { }
	
	public MedBuscaGenericImpl(BuscaEspecifico<?> buscaEspecifico, TablaData<?> tablaData) { 
		this.buscaEspecif = buscaEspecifico;
		this.tablaData = tablaData;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TablaData<T> getTablaData() {
		return tablaData;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public BuscaEspecifico<T> getBuscaEspecifico() {
		return buscaEspecif;
	}
	
	@Override
	public T getDatoSeleccionado() {
		return this.datoSeleccionado;
	}

	@Override
	public void limpiarModeloTabla() {
		tablaData.limpiarDatosTabla();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int buscarDatos(HashMap<String, Object> mapDatos,
			String categoria) {
		List<T> listaDatos = buscaEspecif.buscarDatos(mapDatos, categoria);
		int encontrados = listaDatos.size();
		
		if (encontrados > 0) {
			tablaData.mostrarDatos(listaDatos);
		}
		return encontrados;
	}
	
	/**
	 * Método que busca el dato seleccionado por el usuario en la tabla.
	 * Convierte la fila seleccionada de la vista a la fila del modelo
	 * que corresponde con el objeto seleccionado.
	 * Se aplica cuando aplicamos un filtro de filas a la tabla, lo que permite
	 * que no se la fila seleccionada de la tabla igual a la del modelo.
	 * 
	 * @return boolean indicando si selecciono un dato de la tabla.
	 */
	@SuppressWarnings("unchecked")
	public boolean seleccionarDato() {
		int filaVista = tablaData.getControlTabla().getTabla().getSelectedRow();
		
		if (filaVista >= 0) {
			int filaModelo = tablaData.getControlTabla().getTabla().convertRowIndexToModel(filaVista);
			this.datoSeleccionado = (T) tablaData.getPojoFilaTabla(filaModelo);
		}
		
		return filaVista >= 0;
	}

}
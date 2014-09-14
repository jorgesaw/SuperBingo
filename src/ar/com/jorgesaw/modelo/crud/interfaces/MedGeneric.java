package ar.com.jorgesaw.modelo.crud.interfaces;

import java.io.Serializable;
import java.util.HashMap;

import ar.com.jorgesaw.modelo.crud.tabulado.interfaces.TablaData;

public interface MedGeneric {

	boolean guardarDatos(HashMap<String, Object> mapDatos);

	void mostrarDatos();

	void setMedEspecif(MedEspecif<?> medEspecif);

	void setTablaData(TablaData<?> tablaData);

	int listarDatos();

	HashMap<String, Object> traerDato(int fila);
	HashMap<String, Object> traerDato();

	boolean actualizarDatos(HashMap<String, Object> mapDatos);

	void mostrarDatosActualiz();

	boolean eliminarDatos(HashMap<String, Object> mapDatos);
	boolean eliminarDatos();
	
	void elimDatoMostrado();

	void setDatoBuscado(Object dato);

	Object getDatoBuscado();
	
	MedEspecif getMedEspecif();

	TablaData getTablaData();

	void getDatoById(Serializable idBingo, boolean lazy);

	int getFilaSelTabla();

}

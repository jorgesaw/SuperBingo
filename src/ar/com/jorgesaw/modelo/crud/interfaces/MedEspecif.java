package ar.com.jorgesaw.modelo.crud.interfaces;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public interface MedEspecif<T> {
	
	void guardarPojo(HashMap<String, Object> mapDatos);
	
	T getPojo();

	List<T>getListaPojos();

	void listarPojos();

	HashMap<String, Object> getPojo2Data(int pos);
	HashMap<String, Object> getPojo2Data();

	void actualizarPojo(HashMap<String, Object> mapDatos);

	void elimPojo(HashMap<String, Object> mapDatos);

	void getPojoById(Serializable idPojo);

	void limpiarListaPojos();

	void setPojo(Object pojo);

	boolean elimPojo();

	boolean actualizarPojo();

	void getPojoById(Serializable idPojo, boolean lazy);

	void setPojoGen(PojoGen<T> utilPojo);

}

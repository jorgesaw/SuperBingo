package ar.com.jorgesaw.modelo.crud.interfaces;

import java.io.Serializable;
import java.util.HashMap;

public interface PojoGen<T> {
	
	T makePojo(HashMap<String, Object> mapDatos);
	
	Class<T> getClasePojo();

	HashMap<String, Object> getPojo2Data(T pojo);

	T getPojoConID(HashMap<String, Object> mapDatos);

	Serializable getIdPojo(T pojo);

	void actualizarPojo(HashMap<String, Object> mapDatos, T pojo);
	
}

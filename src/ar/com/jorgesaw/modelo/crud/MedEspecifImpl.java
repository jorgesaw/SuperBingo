package ar.com.jorgesaw.modelo.crud;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ar.com.jorgesaw.dao.GenericDAOImpl;
import ar.com.jorgesaw.dao.interfaces.GenericDAO;
import ar.com.jorgesaw.modelo.crud.interfaces.MedEspecif;
import ar.com.jorgesaw.modelo.crud.interfaces.PojoGen;

public class MedEspecifImpl<T> implements  MedEspecif<T> {
	
	T pojo;
	PojoGen<T> utilPojo;
	List<T> listaPojos = new ArrayList<T>();
	
	protected GenericDAO<T, Serializable> genericDAO = 
			new GenericDAOImpl<>();

	int pos; // Guarda la fila que se quiera actualizar de listaPojos.
	
	public MedEspecifImpl() { }
	
	@Override
	public void setPojoGen (PojoGen<T> utilPojo) {
		this.utilPojo = utilPojo;
	}
	
	@Override
	public T getPojo() {
		return (T) pojo;
	}
	
	@Override
	public List<T> getListaPojos() {
		return (List<T>) listaPojos;
	}
	
	@Override
	public void guardarPojo(HashMap<String, Object> mapDatos) {
		pojo = (T) utilPojo.makePojo(mapDatos);
		if( !(genericDAO.insert(pojo) > 0) ) { // Si no se guardó.
			pojo = null;
		} else {
			addPojo2Lista();
		}
	}

	@Override
	public void actualizarPojo(HashMap<String, Object> mapDatos) {
//		pojo = (T) utilPojo.getPojoConID(mapDatos);
		
		utilPojo.actualizarPojo(mapDatos, pojo);
		
		if ( !(genericDAO.update(pojo) > 0) ) {
			pojo = null;
		} else {
			actPojo2Lista();
		}

	}
	
	@Override
	public boolean actualizarPojo() {
		return (genericDAO.update(pojo) > 0 );
	}
	
	@Override
	public void elimPojo(HashMap<String, Object> mapDatos) {
		pojo = (T) utilPojo.getPojoConID(mapDatos);
		getPojoById(utilPojo.getIdPojo(pojo));
		
		elimPojo();
		/*getPojoById(utilPojo.getIdPojo(pojo));
		
		if (genericDAO.eliminar(pojo) > 0) {
			pojo = null;
			elimPojo2Lista();
		}*/ 
	}
	
	@Override
	public boolean elimPojo() {
//		getPojoById(utilPojo.getIdPojo(pojo));
		
		// Ojo, que si el objeto pojo pertenece a otra sesión sin cerrar lo busco primero porque si no cierro 
//		la sesión no funciona. Ya que para eliminar un objeto tiene que estar desprendido de la sesión a 
//		la que pertenece.
// 		Eso ocurre cuando lo traigo de otra sesión de otra clase genericDAO, al buscar el 
//		último bingo, como tengo otro genericQueryDAO en ModeloListar.
		boolean retorno = genericDAO.delete(pojo) > 0;
		
		if (retorno) {
			pojo = null;
			elimPojo2Lista();
		}
		
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void getPojoById(Serializable idPojo) {
		pojo = genericDAO.getById((Class<T>) pojo.getClass(),
				idPojo);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void getPojoById(Serializable idPojo, boolean lazy) {
		pojo = genericDAO.getById((Class<T>) pojo.getClass(),
				idPojo);
	}
	
	@Override
	public HashMap<String, Object> getPojo2Data(int pos) {
		this.pos = pos;
		
		pojo = listaPojos.get(pos);
		return utilPojo.getPojo2Data(pojo);
	}
	
	@Override
	public HashMap<String, Object> getPojo2Data() {
		return utilPojo.getPojo2Data(pojo);
	}
	
	@Override
	public void listarPojos() {
		listaPojos = genericDAO.getAll((Class<T>) utilPojo.getClasePojo());
	}
	
	private void addPojo2Lista() {
//		listaPojos.clear();
		listaPojos.add(pojo);
	}
	
	private void actPojo2Lista() {
		listaPojos.remove(pos);
		listaPojos.add(pos, pojo);
	}

	private void elimPojo2Lista() {
		listaPojos.remove(pos);
	}
	@Override
	public void limpiarListaPojos() {
		listaPojos.clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setPojo(Object pojo) {
		this.pojo = (T) pojo;	
//		addPojo2Lista();
	}

}

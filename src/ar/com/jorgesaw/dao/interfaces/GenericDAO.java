package ar.com.jorgesaw.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface GenericDAO<T, PK extends Serializable> {
	
	int insert (T object);
	int update (T object);
	int delete (T object);
	
	T getById(Class<T> typeClass, PK id);
	
	List<T> getAll(Class<T> typeClass);
	
	List<T> getPaginated(Class<T> typeClass, int startPosition, 
			int maxResult);
	List<T> getPaginated(Class<T> typeClass, int startPosition, 
			int maxResult, String order, int dir);
	int insertMasivo(List<T> object);
	int updateMasivo(List<T> object);
	int deleteMasivo(List<T> object);
	
	public Session getSesion();
}

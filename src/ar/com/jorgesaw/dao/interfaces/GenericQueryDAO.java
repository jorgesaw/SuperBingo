package ar.com.jorgesaw.dao.interfaces;

import java.util.List;

import org.hibernate.Session;

public interface GenericQueryDAO<T> {
	
	T getDataQueryUniq(String query);
	
	List<T> getDataQueryList(String query);
	
	public Session getSesion();
}

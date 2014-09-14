package ar.com.jorgesaw.superbingo.modelo.dao;

import ar.com.jorgesaw.dao.GenericDAOImpl;
import ar.com.jorgesaw.dto.Provincia;
import ar.com.jorgesaw.superbingo.modelo.dao.interfaces.ProvinciaDAO;

public class ProvinciaDAOImpl extends GenericDAOImpl<Provincia, Integer> 
		implements ProvinciaDAO {

	public ProvinciaDAOImpl() { super(); }
	
	public ProvinciaDAOImpl(boolean cerrarSesion) { super(cerrarSesion); }

}
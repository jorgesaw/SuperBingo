package ar.com.jorgesaw.superbingo.modelo.dao;

import ar.com.jorgesaw.dao.GenericDAOImpl;
import ar.com.jorgesaw.dto.Ciudad;
import ar.com.jorgesaw.superbingo.modelo.dao.interfaces.CiudadDAO;

public class CiudadDAOImpl extends GenericDAOImpl<Ciudad, Integer> 
	implements CiudadDAO {

	public CiudadDAOImpl() { super(); }
	
	public CiudadDAOImpl(boolean cerrarSesion) { super(cerrarSesion); }
	
}
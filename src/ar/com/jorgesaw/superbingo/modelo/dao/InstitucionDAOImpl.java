package ar.com.jorgesaw.superbingo.modelo.dao;

import ar.com.jorgesaw.dao.GenericDAOImpl;
import ar.com.jorgesaw.superbingo.modelo.dao.interfaces.InstitucionDAO;
import ar.com.jorgesaw.superbingo.modelo.dto.Institucion;

public class InstitucionDAOImpl extends GenericDAOImpl<Institucion, Long>
	implements InstitucionDAO {

	public InstitucionDAOImpl() { super(); }
	
	public InstitucionDAOImpl(boolean cerrarSesion) { super(cerrarSesion); }

}

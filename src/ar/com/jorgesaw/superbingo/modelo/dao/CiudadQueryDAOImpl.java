package ar.com.jorgesaw.superbingo.modelo.dao;

import java.util.List;

import ar.com.jorgesaw.dao.GenericQueryDAOImpl;
import ar.com.jorgesaw.dto.Ciudad;
import ar.com.jorgesaw.superbingo.modelo.dao.interfaces.CiudadQueryDAO;

public class CiudadQueryDAOImpl extends GenericQueryDAOImpl<Ciudad> implements CiudadQueryDAO {

	public CiudadQueryDAOImpl() { super(); }
	
	public CiudadQueryDAOImpl(boolean cerrarSesion) { super(cerrarSesion); }

	@Override
	public List<Ciudad> getCiudadByDDN(String DDN) {
		String query = "from Ciudad c " +
				"where c.DDN = " + DDN;
		return super.getDataQueryList(query);
	}
	
}

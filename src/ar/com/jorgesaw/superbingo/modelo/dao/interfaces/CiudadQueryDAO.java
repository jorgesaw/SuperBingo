package ar.com.jorgesaw.superbingo.modelo.dao.interfaces;

import java.util.List;

import ar.com.jorgesaw.dto.Ciudad;

public interface CiudadQueryDAO {

	public List<Ciudad> getCiudadByDDN(String DDN);
	
}

package ar.com.jorgesaw.superbingo.modelo.dao;

import ar.com.jorgesaw.dao.GenericDAOImpl;
import ar.com.jorgesaw.superbingo.modelo.dao.interfaces.HoraLoteriaDAO;
import ar.com.jorgesaw.superbingo.modelo.dto.HoraLoteria;

public class HoraLoteriaDAOImpl extends GenericDAOImpl<HoraLoteria, Integer> 
	implements HoraLoteriaDAO {

	public HoraLoteriaDAOImpl() { super(); }
	
	public HoraLoteriaDAOImpl(boolean cerrarSesion) { super(cerrarSesion); }
}

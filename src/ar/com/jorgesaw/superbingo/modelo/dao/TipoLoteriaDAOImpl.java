package ar.com.jorgesaw.superbingo.modelo.dao;

import ar.com.jorgesaw.dao.GenericDAOImpl;
import ar.com.jorgesaw.superbingo.modelo.dao.interfaces.TipoLoteriaDAO;
import ar.com.jorgesaw.superbingo.modelo.dto.TipoLoteria;

public class TipoLoteriaDAOImpl extends GenericDAOImpl<TipoLoteria, Integer>
	implements TipoLoteriaDAO {

	public TipoLoteriaDAOImpl() { super(); }
	
	public TipoLoteriaDAOImpl(boolean cerrarSesion) { super(cerrarSesion); }
	
}

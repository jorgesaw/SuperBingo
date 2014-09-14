package ar.com.jorgesaw.superbingo.modelo.dao;

import ar.com.jorgesaw.dao.GenericDAOImpl;
import ar.com.jorgesaw.dao.GenericQueryDAOImpl;
import ar.com.jorgesaw.dao.interfaces.GenericQueryDAO;
import ar.com.jorgesaw.superbingo.modelo.dao.interfaces.LoteriaDAO;
import ar.com.jorgesaw.superbingo.modelo.dto.HoraLoteria;
import ar.com.jorgesaw.superbingo.modelo.dto.Loteria;
import ar.com.jorgesaw.superbingo.modelo.dto.TipoLoteria;

/**
 * Clase que implementa un DAO para obtener datos de las lotería de la DB.
 * @author jorgesaw
 * @version 1.0
 */
public class LoteriaDAOImpl extends GenericDAOImpl<Loteria, Integer> 
		implements LoteriaDAO {

	public LoteriaDAOImpl() { }
	
	/**
	 * Método que devuelve una lotería según el tipo y la hora de la misma.
	 * @param tipoLoteria El tipo de la lotería.
	 * @param horaLoteria El horario de la lotería.
	 * @return Devuelve una Loteria.
	 */
	@Override
	public Loteria getLoteria(TipoLoteria tipoLot, HoraLoteria horaLot) {
		GenericQueryDAO<Loteria> loteriaDAO = new GenericQueryDAOImpl<>();
		String query = "from Loteria lot " +
				"where lot.nombre.idTipo = " + tipoLot.getIdTipo() + " " +
				"and lot.horario.idHora = " + horaLot.getIdHora();
		return loteriaDAO.getDataQueryUniq(query);
	}

}
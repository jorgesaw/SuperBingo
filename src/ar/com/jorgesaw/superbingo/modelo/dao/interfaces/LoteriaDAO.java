package ar.com.jorgesaw.superbingo.modelo.dao.interfaces;

import ar.com.jorgesaw.dao.interfaces.GenericDAO;
import ar.com.jorgesaw.superbingo.modelo.dto.HoraLoteria;
import ar.com.jorgesaw.superbingo.modelo.dto.Loteria;
import ar.com.jorgesaw.superbingo.modelo.dto.TipoLoteria;

public interface LoteriaDAO extends GenericDAO<Loteria, Integer> {

	Loteria getLoteria(TipoLoteria tipoLot, HoraLoteria horaLot);

}
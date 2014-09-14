package ar.com.jorgesaw.superbingo.modelo.dao.interfaces;

import ar.com.jorgesaw.dao.interfaces.GenericDAO;
import ar.com.jorgesaw.superbingo.modelo.dto.Bingo;

public interface BingoDAO extends GenericDAO<Bingo, Long> {

	Long getCantCartones(Long idBingo);
}

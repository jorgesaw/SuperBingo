package ar.com.jorgesaw.superbingo.modelo.servicios;

import ar.com.jorgesaw.superbingo.modelo.dao.BingoDAOImpl;
import ar.com.jorgesaw.superbingo.modelo.dao.interfaces.BingoDAO;
import ar.com.jorgesaw.superbingo.modelo.dto.Bingo;
import ar.com.jorgesaw.superbingo.modelo.dto.Serie;

public class ServCartonesBingo {

	public static int getCantCartones(Bingo bingo) {
		int i = 0;
		for (Serie s : bingo.getSeries()) {
			i += s.getCartones().size();
		}
		return i;
	}
	
	public static int getCantCartones(Long idBingo) {
		Integer cantSeries = 0;
		try {
			BingoDAO bingoDAO = new BingoDAOImpl();
			cantSeries =  Integer.valueOf(bingoDAO.getCantCartones(idBingo).toString());
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			cantSeries = -1;
		} 
		return cantSeries;
	}

}
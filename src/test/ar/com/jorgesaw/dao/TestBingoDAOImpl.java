package test.ar.com.jorgesaw.dao;

import static org.junit.Assert.*;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.junit.Test;

import ar.com.jorgesaw.superbingo.modelo.dao.BingoDAOImpl;
import ar.com.jorgesaw.superbingo.modelo.dao.interfaces.BingoDAO;
import ar.com.jorgesaw.superbingo.modelo.dto.Bingo;

public class TestBingoDAOImpl {
	
	@Test
	public void testBingofalloColeciones() {
		BingoDAO bingoDAO = new BingoDAOImpl();
		Bingo bin = bingoDAO.getById(Bingo.class, new Long(5));
		
		try {
			Hibernate.initialize(bin.getSeries());
			System.out.println("Cantidad de series: " + bin.getSeries().size());
		} catch(HibernateException ex) {
			System.out.println("Error al cargar la colección.");
			fail("Error al cargar la colección: " + ex);
		}
	}

	@Test
	public void testCargaCorrectaColecciones() {
		BingoDAO bingoDAO = new BingoDAOImpl(false);
		Bingo bin = bingoDAO.getById(Bingo.class, new Long(5));

		Hibernate.initialize(bin.getSeries());
		System.out.println("Cantidad de series: " + bin.getSeries().size());
		
		bingoDAO.getSesion().close();
	}
	
	@Test
	public void testGetCantCartones() {
		BingoDAO bingoDAO = new BingoDAOImpl();
		assertTrue(bingoDAO.getCantCartones(new Long(1)) > 0);
	}
}
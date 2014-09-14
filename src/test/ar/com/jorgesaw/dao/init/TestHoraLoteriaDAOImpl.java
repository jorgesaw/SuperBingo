package test.ar.com.jorgesaw.dao.init;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.jorgesaw.superbingo.modelo.dao.HoraLoteriaDAOImpl;
import ar.com.jorgesaw.superbingo.modelo.dao.interfaces.HoraLoteriaDAO;
import ar.com.jorgesaw.superbingo.modelo.dto.HoraLoteria;

public class TestHoraLoteriaDAOImpl {

	@Resource
	HoraLoteriaDAO horaLotDAO;
	
	@Before
	public void creaHoraLoteriaDAO() {
			horaLotDAO = new HoraLoteriaDAOImpl();
	}
	
	@After
	public void destruyeHoraLoteriaDAO() {
		horaLotDAO = null;
	}
	
	@Test
	public void testInsert() {
		HoraLoteria hLot = new HoraLoteria();
		hLot.setHorario("Matutina");
		assertEquals(1, horaLotDAO.insert(hLot)); 
		
	}

	@Test
	public void testUpdate() {
		HoraLoteria hLot = new HoraLoteria(5, "jorgesaw");
		assertEquals(1, horaLotDAO.update(hLot));
	}

	@Test
	public void testDelete() {
		HoraLoteria hLot = new HoraLoteria(3, "Vespertina");
		assertEquals(1, horaLotDAO.update(hLot));
	}

	@Test
	public void testGetById() {
		assertEquals(new Integer(7), horaLotDAO.getById(HoraLoteria.class, 7).getIdHora());
	}

	@Test
	public void testGetAll() {
		List<HoraLoteria> horasLoterias = horaLotDAO.getAll(HoraLoteria.class);
		assertTrue(horasLoterias.size() > 0);
	}

	@Test
	public void crudHoraLoteria() {
		HoraLoteria hLot = new HoraLoteria();hLot.setHorario("Matutinaaa");
		assertEquals(1, horaLotDAO.insert(hLot));
		
		HoraLoteria hlotRecuperada = horaLotDAO.getById(HoraLoteria.class, 8);
		hlotRecuperada.setHorario("Matutina");
		
		horaLotDAO.update(hlotRecuperada);
		
		hlotRecuperada = horaLotDAO.getById(HoraLoteria.class, hlotRecuperada.getIdHora());
		assertEquals("Matutina", hlotRecuperada.getHorario());
		
		horaLotDAO.delete(hlotRecuperada);
	}
}

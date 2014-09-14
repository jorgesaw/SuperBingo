package test.ar.com.jorgesaw.modelo.buscadores;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.jorgesaw.modelo.buscadores.BuscaEspecificoImplBingo;
import ar.com.jorgesaw.superbingo.modelo.dto.Bingo;

public class TestBuscaEspecificoImplBingo {

	@Resource
	BuscaEspecificoImplBingo buscaBingo;
	
	@Before
	public void creaBuscaDAO() {
		buscaBingo = new BuscaEspecificoImplBingo();
	}
	
	@After
	public void destruyeBuscaDAO() {
		buscaBingo = null;
	}
	
	@Test
	public void testbuscarDatos() {
		List<Bingo> listaBingos = buscaBingo.buscarDatos(null, null);
		
		assertTrue(listaBingos.get(0).getIdBingo() > 0);
	}

}
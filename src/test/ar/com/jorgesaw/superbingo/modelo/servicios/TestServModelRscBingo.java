package test.ar.com.jorgesaw.superbingo.modelo.servicios;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.annotation.Resource;
import javax.swing.DefaultComboBoxModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.jorgesaw.superbingo.modelo.servicios.ServModelRscBingo;

public class TestServModelRscBingo {

	@Test
	public void testGetLoterias() {
		DefaultComboBoxModel<Object> modeloCombo= ServModelRscBingo.getTipoLoterias();
		assertEquals("Seleccionar", modeloCombo.getElementAt(0));
		assertTrue(Integer.valueOf(modeloCombo.getSize()) > 1); // Al menos hay un tipo de loteria en DB.
	}

	@Test
	public void testGetHorasLoterias() {
		assertEquals(new Integer(3), Integer.valueOf(ServModelRscBingo.getHorasLoterias().getSize()));
	}

	@Test
	public void testGetInstituciones() {
		DefaultComboBoxModel<Object> modeloCombo= ServModelRscBingo.getInstituciones();
		assertEquals("Seleccionar", modeloCombo.getElementAt(0));
		assertTrue(Integer.valueOf(modeloCombo.getSize()) > 1); // Al menos hay una institución en DB.
	}

}

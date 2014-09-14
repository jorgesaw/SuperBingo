package test.ar.com.jorgesaw.gui;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ar.com.jorgesaw.gui.VentanaMain;

public class TestVentanaPrincipal {

	@Test
	public void creaVentanaPrincipal() {
		VentanaMain ventana = new VentanaMain("Ventana de prueba");
		ventana.init();
		
		assertNotNull(ventana);
	}

}

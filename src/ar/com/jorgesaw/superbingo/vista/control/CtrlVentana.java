package ar.com.jorgesaw.superbingo.vista.control;

import java.awt.event.WindowEvent;

import org.apache.log4j.Logger;

import ar.com.jorgesaw.gui.control.abstractos.AbstractCtrlVentana;
import ar.com.jorgesaw.gui.vista.interfaces.VentanaCerrable;

public class CtrlVentana extends AbstractCtrlVentana {
	
	protected static final Logger log = Logger.getLogger(CtrlVentana.class.getName());
	
	protected static VentanaCerrable ventana;
	
	public CtrlVentana() { }
	
	public CtrlVentana(VentanaCerrable ventana) { CtrlVentana.ventana = ventana; }
	
	public static VentanaCerrable getVentanaCerrable() {
		return ventana;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosed(e);
		this.cerrarVentana();
	}
	
	protected void cerrarVentana() {
		log.debug("Cerrando ventana...");
		CtrlVentana.ventana.cerrarVentana();
		log.info("Cerrando aplicación...");
		System.exit(0);
	}
	
}
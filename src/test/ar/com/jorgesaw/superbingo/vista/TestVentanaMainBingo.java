package test.ar.com.jorgesaw.superbingo.vista;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ar.com.jorgesaw.superbingo.modelo.ModeloMainImpl;
import ar.com.jorgesaw.superbingo.modelo.interfaces.ModeloMain;
import ar.com.jorgesaw.superbingo.vista.VentanaMainBingoImpl;
import ar.com.jorgesaw.superbingo.vista.control.CtrlMainBingoImpl;

/**
 * Clase que testea la ventana del bingo.
 * @author jorgesaw
 */
public class TestVentanaMainBingo {

	protected static final Logger log = Logger.getLogger(TestVentanaMainBingo.class.getName());
	
	public static void main(String[] args) {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\log.properties");
		log.info("Iniciando test desde...");
		log.info("..." + System.getProperty("user.dir"));
		VentanaMainBingoImpl ventana = new VentanaMainBingoImpl("Súper bingo");
		ModeloMain modelo = new ModeloMainImpl();
		CtrlMainBingoImpl control = new CtrlMainBingoImpl(ventana, modelo); 
		
		ventana.setControlador(control);
		ventana.init();
	}
}
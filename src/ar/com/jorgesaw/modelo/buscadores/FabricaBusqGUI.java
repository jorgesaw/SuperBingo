package ar.com.jorgesaw.modelo.buscadores;

import org.apache.log4j.Logger;

import ar.com.jorgesaw.modelo.buscadores.interfaces.BusqGUI;

public class FabricaBusqGUI {
	
	protected static final Logger log = Logger.getLogger(FabricaBusqGUI.class.getName());
			
	public static BusqGUI<?> creaBusqGUI(int tipo) {
		BusqGUI<?> ventana = null;
		
		switch(tipo) {	
			case BusqGUI.CIUDAD_BUSQ :
				ventana = new BusqCiuGUI();
				break;
			case BusqGUI.INSTIT_BUSQ :
//				ventana = new BusqInstitGUI();
				break;
			case BusqGUI.BINGO_BUSQ : 
				ventana = new BusqBingoGUI();
				break;
			case BusqGUI.EMPLEADO_BUSQ : 
//				ventana = new BusqEmplGUI();
				break;
			default :
				log.error("No existe Interfaz gráfica de búsqueda " +
						"para ese tipo: " + tipo);
				
		}
		
		return ventana;	
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(creaBusqGUI(23).getDatoBuscado());
		} catch(NullPointerException ex) {
			log.error("No existe ventana. " + ex.getMessage());
		}
		
	}
}

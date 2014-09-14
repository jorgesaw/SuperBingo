package ar.com.jorgesaw.modelo.buscadores.interfaces;

import ar.com.jorgesaw.modelo.buscadores.control.interfaces.ControlBusquedaGen;

public interface PanelBusqBingoGUI extends PanelBusqGUI {

	public static final String TEXT_BINGOS = "Texto bingos";
	
	void setControlador(ControlBusquedaGen c);
	
}

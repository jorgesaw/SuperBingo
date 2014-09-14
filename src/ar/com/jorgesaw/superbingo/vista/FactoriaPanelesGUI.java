package ar.com.jorgesaw.superbingo.vista;

import org.apache.log4j.Logger;

import ar.com.jorgesaw.superbingo.vista.factoria.PanelBingoNuevo;
import ar.com.jorgesaw.superbingo.vista.factoria.PanelEmplNuevo;
import ar.com.jorgesaw.superbingo.vista.factoria.PanelInstitNuevo;
import ar.com.jorgesaw.superbingo.vista.factoria.PanelLoteriaNuevo;
import ar.com.jorgesaw.superbingo.vista.factoria.interfaces.PanelGUI;

public class FactoriaPanelesGUI {

	protected static final Logger log = Logger.getLogger(FactoriaPanelesGUI.class.getName());
	
	public static PanelGUI<?> creaPanelGUI(int tipo) {
		PanelGUI<?> panel = null;
		
		switch(tipo) {
		case PanelGUI.BINGO_NUEVO :
			panel = new PanelBingoNuevo();
			break;
		case PanelGUI.LOTERIA_NUEVO :
			panel = new PanelLoteriaNuevo();
			break;
		case PanelGUI.EMPLEADO :
			panel = new PanelEmplNuevo();
			break;
		case PanelGUI.INSTITUCION :
			panel = new PanelInstitNuevo();
			break;
		}
		
		return panel;
	}

}

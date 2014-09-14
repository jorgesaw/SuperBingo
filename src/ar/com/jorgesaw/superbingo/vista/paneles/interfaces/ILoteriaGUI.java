package ar.com.jorgesaw.superbingo.vista.paneles.interfaces;

import ar.com.jorgesaw.gui.control.CtrlGenCRUDBase;
import ar.com.jorgesaw.gui.vista.interfaces.MuestraDatos;
import ar.com.jorgesaw.gui.vista.interfaces.VistaCRUD;

public interface ILoteriaGUI extends VistaCRUD, MuestraDatos {
	
	static final String TEXT_NOM_LOT = "Nom Lot.";
	static final String TEXT_ALIAS_LOT = "Alias Lot.";
	
	static final int MAX_LONG_NOM = 40;
	static final int MAX_LONG_ALIAS = 18;
	
	void setControlador(CtrlGenCRUDBase c); 
	
}
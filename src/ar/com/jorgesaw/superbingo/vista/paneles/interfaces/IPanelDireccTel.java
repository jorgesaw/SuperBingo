package ar.com.jorgesaw.superbingo.vista.paneles.interfaces;

import javax.swing.DefaultComboBoxModel;

import ar.com.jorgesaw.gui.vista.interfaces.MuestraDatos;
import ar.com.jorgesaw.gui.vista.interfaces.VistaCRUD;

public interface IPanelDireccTel extends VistaCRUD, MuestraDatos {
	
	static final String TEXT_DIR = "Direccion";
	static final String TEXT_PROV = "Provincia";
	static final String TEXT_CIU = "Ciudad";
	static final String TEXT_CEL = "Cel.";
	static final String TEXT_TEL = "Tel.";
	static final String TEXT_FECHA_ING = "Fecha ingreso";
	static final String TEXT_ALTURA = "Altura";
	static final String TEXT_PISO = "Piso";
	static final String TEXT_DEPTO = "Depto";
	static final String COMBO_PROV = "Combo provincia";
	static final String BTN_CIUDAD = "Boton ciudad";
	
	static final int MAX_LONG_CEL = 18;
	static final int MAX_LONG_TEL = 18;
	static final int MAX_LONG_DIRECCION = 60;
	static final int MAX_LONG_ALTURA = 5;
	static final int MAX_LONG_PISO = 3;
	static final int MAX_LONG_DEPTO = 4;
	
	void addProvincias(DefaultComboBoxModel<Object> comboProvModelo);
	
}

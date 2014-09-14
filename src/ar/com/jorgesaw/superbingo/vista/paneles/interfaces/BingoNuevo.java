package ar.com.jorgesaw.superbingo.vista.paneles.interfaces;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import ar.com.jorgesaw.gui.control.CtrlGenCRUDBase;
import ar.com.jorgesaw.gui.vista.interfaces.MuestraDatos;
import ar.com.jorgesaw.gui.vista.interfaces.VistaCRUD;

public interface BingoNuevo extends VistaCRUD, MuestraDatos {
	
	public static final String TEXT_NOM = "Text título";
	static final String LABEL_TIT = "Label titulo";
	static final String TEXT_OBSERV = "Text observaciones";
	static final String LABEL_OBSERV = "Label observaciones";
	static final String TEXT_FECHA_CREA = "Fecha crea";
	static final String TEXT_FECHA_VENCE = "Fecha vence";
	static final String VENDIDO = "Vendido";
	static final String TEXT_SPINNER = "Spinner";
	static final String TEXT_NUM_RIFA = "Num rifa";
	static final String COD_BARRAS = "Código barras";
	static final String PERIO_JUG = "Período jug.";
	static final String PREM_JUG = "Premio jug.";
	static final String DIAS_JUG = "Días jug";
	
	static final String TEXT_VENDE = "Vendedor";
	static final String TEXT_COBRA = "Cobrador";
	static final String CANT_CART = "Cant. cartones";
	
	static final int CARTONES_POR_SERIE = 6;
	static final int MAX_LONG_NOM = 50;
	static final int MAX_LONG_OBSERV = 255;
	static final int MAX_LONG_RIFA = 5;
	static final int MAX_LONG_PREMIO = 30;
	
	static final String TEXT_ID = "ID";
	static final String LOTERIA = "Loteria";
	static final String HORA_LOTERIA = "Hora Lot.";
	static final String INSTITUCION = "Institucion";
	static final String PREMIO = "Premio";

	void addTipoLoterias(DefaultComboBoxModel<Object> modelTipoLot);
	void addHorasLot(DefaultComboBoxModel<Object> modelHorasLot);
	void addPerioJug(DefaultComboBoxModel<Object> modelPerioJug);
	void addPremJug(DefaultListModel<Object> modelListPremJug);
	void addDiasJug(DefaultListModel<Object> modelListDiasJug);
	
	void setControlador(CtrlGenCRUDBase c); 
}

package ar.com.jorgesaw.superbingo.vista.paneles.interfaces;

import ar.com.jorgesaw.gui.control.CtrlGenCRUDBase;

public interface IPanelEmpleados extends IPanelDireccTel {

	static final String TEXT_DNI = "DNI";
	static final String TEXT_APE = "Ape";
	static final String TEXT_NOM = "Nom";
	static final String TEXT_OBSERV = "Observaciones";
	static final String FECHA_ALTA = "Fecha alta";
	static final String TEXT_DDN_CEL = "DDN cel.";
	static final String TEXT_DDN_TEL = "DDN tel.";
	static final String VENDEDOR = "Vendedor";
	static final String COBRADOR = "Cobrador";
	static final String CATEGORIA = "Categoria";
	
	static final int MAX_LONG_DNI = 8;
	static final int MAX_LONG_NOMBRE = 30;
	static final int MAX_LONG_APE = 30;
	static final int MAX_LONG_OBSERV = 255;
	static final int MAX_LONG_DDN = 10;
	
	void setControlador(CtrlGenCRUDBase c);
	
}

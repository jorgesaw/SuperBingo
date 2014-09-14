package ar.com.jorgesaw.modelo.buscadores.interfaces;

import ar.com.jorgesaw.gui.vista.interfaces.GenericVista;

public interface PanelBusqGUI extends GenericVista {
	
	public static final String ACEPTAR = "Aceptar";
	public static final String BUSCAR = "Buscar";
	public static final String TEXT_DATOS = "Text datos";
	
	boolean isValidarDatos(String nomComp);

	boolean isFiltrable();
	void setFiltrable(boolean filtrable);
	
	void setNameBoton(String nomBoton);
	public void setTitleLabel(String titleLabel);
	String getNameBoton();

}
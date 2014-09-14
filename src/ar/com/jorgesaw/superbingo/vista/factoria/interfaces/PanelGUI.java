package ar.com.jorgesaw.superbingo.vista.factoria.interfaces;

public interface PanelGUI<T> {

	public static final int BINGO_NUEVO   = 1;
	public static final int LOTERIA_NUEVO = 2;
	public static final int EMPLEADO      = 3;
	public static final int INSTITUCION   = 4;
	public static final int CIUDAD        = 5; 
	
	T getContenedor();
}

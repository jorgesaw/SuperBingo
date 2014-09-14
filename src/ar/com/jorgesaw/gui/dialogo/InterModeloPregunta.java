package ar.com.jorgesaw.gui.dialogo;

public interface InterModeloPregunta {
	
	static final int SIN_RESPUESTA = -1;
	static final int RES_CANCELAR = 0;
	static final int RES_ACEPTAR = 1;
	static final int RES_SI = 2;
	static final int RES_NO = 3;
	
	void enviarEventoSeleccionado(int evento);
}

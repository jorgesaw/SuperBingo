package ar.com.jorgesaw.gui.dialogo;


public interface InterfazVistaPregunta {
	static final String MENSAJE = "msg";
	static final String CANCELAR = "cancelar";
	static final String SI = "Si";
	static final String NO = "No";
	
	void cerrarVentana();
	void init();
	void setControlador(ControlDialogoPregunta c);	
	
	int getRespuesta();
	void setRespuesta(int r);
}

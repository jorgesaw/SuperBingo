package ar.com.jorgesaw.gui.vista.interfaces;

public interface VentanaBasica {

	void init();
	void mostrarVentana(boolean b);
	void cambiarIconoMouse(int waitCursor);
	void setIconoAPP(String recurso);
	void mostrarVentanaInterna(VentanaInternaBasica ventanaInterna);
	
}

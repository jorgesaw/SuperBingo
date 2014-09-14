package ar.com.jorgesaw.gui.vista.interfaces;

import java.awt.Component;

public interface VentanaInternaBasica {

	void init();
	void mostrarVentana(boolean b);
	void cambiarIconoMouse(int waitCursor);
	void addPanel(Component panel);
	void setTitulo(String titulo);
}

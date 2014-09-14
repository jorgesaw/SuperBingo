package ar.com.jorgesaw.gui.vista.interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.util.HashMap;

public interface GenericVista extends VentanaCerrable {
	
	void mostrarVentana(boolean b);
	HashMap<String, Object> getMapDatos();
	void mostrarMensaje(HashMap<String, Object> mapMensajes, Container ventana);
	void setMapDatos(HashMap<String, Object> mapDatos);
	void setFoco(Component c);
	void cambiarColorFuente(Component comp, Color c);
	void cambiarIconoMouse(int cursor);
	boolean isValidarDatos();
}

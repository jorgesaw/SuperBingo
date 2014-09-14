package ar.com.jorgesaw.modelo.buscadores.control.interfaces;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.HashMap;

public interface ControlBusquedaGen extends ActionListener, KeyListener, MouseListener {

	void listarDatos(HashMap<String, Object> mapDatos, String nomComp);
	
}

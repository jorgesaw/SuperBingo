package ar.com.jorgesaw.gui.control;

import java.util.HashMap;

import javax.swing.JOptionPane;

import ar.com.jorgesaw.util.mensajes.interfaces.GenericMsg;

public class GenericMensajes {
	
	public static final String [] listaMensajes = {
		
		"Datos guardados con éxito.", // 0 - guardado.
		"Datos actualizados con éxito.", // 1 - actualizado.
		"Dato eliminado con éxito.",  // 2 - eliminado.
		"No existen elementos para mostrar.", // 3 - no_elementos.
		"Por favor seleccione un elemento de la tabla",  // 4 - sel_elemntos_tabla.
		"¿Desea eliminar el elemento seleccionado?",  // 5
		"No existen elementos para mostrar." // 6
	};

	public static final int ERROR = -1;
	public static final int GUARDADO = 0;
	public static final int ACTUALIZADO = 1;
	public static final int ELIMINADO = 2;
	public static final int NO_ELEMENTOS = 3;
	public static final int SEL_ELEMENT_TABLA = 4;
	public static final int ELIMINAR = 5;
	public static final int NO_ELEM_TABLA = 6;
	
	public static HashMap<String, Object> getMapMensaje(int tipo) {
		HashMap<String, Object> mapMensaje = new HashMap<String, Object>();
		
		switch (tipo) {
			case GUARDADO :
				mapMensaje.put(GenericMsg.TIT, "Info");
				mapMensaje.put(GenericMsg.MSG, listaMensajes[GUARDADO]);
				mapMensaje.put(GenericMsg.ICONO, JOptionPane.INFORMATION_MESSAGE);
				break;
			case ACTUALIZADO :
				mapMensaje.put(GenericMsg.TIT, "Info");
				mapMensaje.put(GenericMsg.MSG, listaMensajes[ACTUALIZADO]);
				mapMensaje.put(GenericMsg.ICONO, JOptionPane.INFORMATION_MESSAGE);
				break;
			case ELIMINADO :
				mapMensaje.put(GenericMsg.TIT, "Info");
				mapMensaje.put(GenericMsg.MSG, listaMensajes[ELIMINADO]);
				mapMensaje.put(GenericMsg.ICONO, JOptionPane.INFORMATION_MESSAGE);
				break;
			case NO_ELEMENTOS :
				mapMensaje.put(GenericMsg.TIT, "Info");
				mapMensaje.put(GenericMsg.MSG, listaMensajes[NO_ELEMENTOS]);
				mapMensaje.put(GenericMsg.ICONO, JOptionPane.INFORMATION_MESSAGE);
				break;
			case SEL_ELEMENT_TABLA :
				mapMensaje.put(GenericMsg.TIT, "Info");
				mapMensaje.put(GenericMsg.MSG, listaMensajes[SEL_ELEMENT_TABLA]);
				mapMensaje.put(GenericMsg.ICONO, JOptionPane.WARNING_MESSAGE);
				break;
			case ELIMINAR :
				mapMensaje.put(GenericMsg.TIT, "Warning");
				mapMensaje.put(GenericMsg.MSG, listaMensajes[ELIMINAR]);
				mapMensaje.put(GenericMsg.ICONO, JOptionPane.WARNING_MESSAGE);
				break;
			case NO_ELEM_TABLA : 
				mapMensaje.put(GenericMsg.TIT, "Info");
				mapMensaje.put(GenericMsg.MSG, listaMensajes[NO_ELEM_TABLA]);
				mapMensaje.put(GenericMsg.ICONO, JOptionPane.INFORMATION_MESSAGE);
				break;
		}
		
		return mapMensaje;
	}
}

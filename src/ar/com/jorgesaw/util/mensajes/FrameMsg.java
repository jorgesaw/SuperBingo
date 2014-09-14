package ar.com.jorgesaw.util.mensajes;

import java.awt.Component;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class FrameMsg {

	private Component padre;

	public FrameMsg(Component padre) {
		this.padre = padre;
	}

	public FrameMsg(String titulo, Component padre) {
		this.padre = padre;
	}

	public void configurarPane(JOptionPane pane) {

	}

	public boolean confirmarMensaje(String titulo, String mensaje) {
		String j1 = "Aceptar";
		Object[] opciones = { j1 };
		int n = JOptionPane.showOptionDialog(padre, mensaje, titulo,
				JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null,
				opciones, j1);
		if (n == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}

	public void mostrarMensaje(String titulo, String msg, int tipoMensaje) {
		JOptionPane.showMessageDialog(padre, msg, titulo, tipoMensaje);
	}

	public boolean confirmarMensaje(String titulo, String mensaje,
			int tipoMensaje) {
		String j1 = "Aceptar";
		Object[] opciones = { j1 };
		int n = JOptionPane.showOptionDialog(padre, mensaje, titulo,
				JOptionPane.YES_OPTION, tipoMensaje, null, opciones, j1);
//		Si apretamos Enter toma el valor por defecto, hat que presionar back space.
		if (n == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}

	public boolean elegirOpcion(String titulo, String mensaje) {
		String j1 = "   Si   ";
		String j2 = "   No   ";
		Object[] opciones = { j1, j2 };
		int n = JOptionPane.showOptionDialog(padre, mensaje, titulo,
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
				opciones, j2);
		System.out.println("Muestra número mensaje" + n + " "
				+ JOptionPane.YES_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}

}
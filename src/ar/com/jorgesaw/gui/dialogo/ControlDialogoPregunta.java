package ar.com.jorgesaw.gui.dialogo;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;

public class ControlDialogoPregunta implements ActionListener, KeyListener {

	private int respuesta = InterModeloPregunta.SIN_RESPUESTA;
	
	InterfazVistaPregunta vista;
	InterModeloPregunta modelo;

	public ControlDialogoPregunta(InterfazVistaPregunta vista,
			InterModeloPregunta modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public ControlDialogoPregunta(InterfazVistaPregunta vista) {
		this.vista = vista;
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(InterfazVistaPregunta.SI)) {
//			modelo.enviarEventoSeleccionado(InterModeloPregunta.RES_ACEPTAR);
			selSi();
		} else if (comando.equals(InterfazVistaPregunta.NO)) {
//			modelo.enviarEventoSeleccionado(InterModeloPregunta.RES_CANCELAR);
			selNo();
		} else if (comando.equals(InterfazVistaPregunta.CANCELAR)) {
//			modelo.enviarEventoSeleccionado(InterModeloPregunta.RES_CANCELAR);
			selCancelar();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyChar() == (char) KeyEvent.VK_ENTER) {
			if (e.getComponent().getName()
					.equals(InterfazVistaPregunta.SI)) {
//				modelo.enviarEventoSeleccionado(InterModeloPregunta.RES_ACEPTAR);
				selSi();
			} else if (e.getComponent().getName()
					.equals(InterfazVistaPregunta.NO)) {
//				modelo.enviarEventoSeleccionado(InterModeloPregunta.RES_CANCELAR);
				selNo();
			} else if (e.getComponent().getName()
					.equals(InterfazVistaPregunta.CANCELAR)) {
//				modelo.enviarEventoSeleccionado(InterModeloPregunta.RES_CANCELAR);
				selCancelar();
			}
		} else if (e.getKeyChar() == (char) KeyEvent.VK_ESCAPE) {
//			modelo.enviarEventoSeleccionado(InterModeloPregunta.RES_CANCELAR);
			selCancelar();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public int getRespuesta() {
		return respuesta;
	}
	
	private void selSi() {
		respuesta = InterModeloPregunta.RES_SI;
		vista.cerrarVentana();
	}
	
	private void selNo() {
		respuesta = InterModeloPregunta.RES_NO;
		vista.cerrarVentana();
	}
	
	private void selCancelar() {
		respuesta = InterModeloPregunta.RES_CANCELAR;
		vista.cerrarVentana();
	}
}

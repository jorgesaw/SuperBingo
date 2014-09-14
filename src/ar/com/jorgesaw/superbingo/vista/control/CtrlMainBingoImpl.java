package ar.com.jorgesaw.superbingo.vista.control;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import ar.com.jorgesaw.gui.vista.interfaces.VentanaBasica;
import ar.com.jorgesaw.gui.vista.interfaces.VentanaCerrable;
import ar.com.jorgesaw.gui.vista.interfaces.VentanaInternaBasica;
import ar.com.jorgesaw.superbingo.modelo.interfaces.ModeloMain;
import ar.com.jorgesaw.superbingo.vista.control.interfaces.CtrlMainBingo;
import ar.com.jorgesaw.superbingo.vista.interfaces.VentanaMainBingo;
import ar.com.jorgesaw.util.mensajes.MsgOpciones;

public class CtrlMainBingoImpl extends CtrlVentana 
		implements CtrlMainBingo, ActionListener, KeyListener {

	ModeloMain modelo;
	
	public CtrlMainBingoImpl(VentanaCerrable ventana, ModeloMain modelo) {
		super(ventana);
		this.modelo = modelo;
	}

	@Override
	public void keyPressed(KeyEvent e) { 
		char caracter = e.getKeyChar();
		String nomComp = e.getComponent().getName();

		if ((char) KeyEvent.VK_ENTER == caracter)
			selectEvento(nomComp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		selectEvento(comando);
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		if (MsgOpciones.elegirSiNoCancelar( 
				(Component) getVentanaCerrable(), 
				"Cerrar aplicación", "Desea cerrar la aplicación?", JOptionPane.INFORMATION_MESSAGE) 
					== JOptionPane.YES_OPTION) 
			super.windowClosing(e);
	}
	
	@Override
	public void keyReleased(KeyEvent e) { }

	@Override
	public void keyTyped(KeyEvent e) { }
	
	/**
	 * 
	 * @param nomComp Nombre del componente que generó el evento.
	 */
	private void selectEvento(String nomComp) {
		if (VentanaMainBingo.SALIR.equals(nomComp)) {
			salirAPP();
		} else if (VentanaMainBingo.OPCIONES.equals(nomComp)
				|| VentanaMainBingo.IMPRIMIR.equals(nomComp)
				|| VentanaMainBingo.NUEVO_BINGO.equals(nomComp)
				|| VentanaMainBingo.LISTAR_BINGO.equals(nomComp)
				|| VentanaMainBingo.CONSIG.equals(nomComp)
				|| VentanaMainBingo.CARTONES_GENERAR.equals(nomComp) 
				|| VentanaMainBingo.EMPLEADOS.equals(nomComp)
				|| VentanaMainBingo.INSTITUCIONES.equals(nomComp)  
				|| VentanaMainBingo.LOTERIAS.equals(nomComp) 
				|| VentanaMainBingo.CIUDADES.equals(nomComp) 
				|| VentanaMainBingo.ADD_VENTAS.equals(nomComp)  
				|| VentanaMainBingo.CONTROL_VENTAS.equals(nomComp) 
				|| VentanaMainBingo.BUSCA_GANADORES.equals(nomComp)
				|| VentanaMainBingo.CARTONES_CARGAR_DATOS.equals(nomComp)
				|| VentanaMainBingo.CARTONES_BUSCAR_DATOS.equals(nomComp) ){
			
			( (VentanaBasica) CtrlVentana.ventana).cambiarIconoMouse(Cursor.WAIT_CURSOR);
			( (VentanaBasica) CtrlVentana.ventana).mostrarVentanaInterna((VentanaInternaBasica) modelo.abrirVentana(nomComp));
			( (VentanaBasica) CtrlVentana.ventana).cambiarIconoMouse(Cursor.DEFAULT_CURSOR);
		}
	}
	
	private void salirAPP() {
		if (MsgOpciones.elegirSiNoCancelar( 
				(Component) getVentanaCerrable(), 
				"Cerrar aplicación", "Desea cerrar la aplicación?", JOptionPane.INFORMATION_MESSAGE) 
					== JOptionPane.YES_OPTION) 
			super.cerrarVentana();
	}
}

package ar.com.jorgesaw.gui.vista.abstractos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JPanel;

import ar.com.jorgesaw.gui.vista.interfaces.CambioComponente;
import ar.com.jorgesaw.gui.vista.interfaces.CompBasico;
import ar.com.jorgesaw.gui.vista.interfaces.GenericVista;
import ar.com.jorgesaw.util.mensajes.FrameMsg;
import ar.com.jorgesaw.util.mensajes.interfaces.GenericMsg;

public abstract class AbstractGenericVistaImpl extends JPanel implements
		GenericVista, CambioComponente {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4391325087627785171L;
	private HashMap<String, Object> mapDatos = new HashMap<String, Object>();
	private boolean validarDatos = false;
	private int cantDatosValidados;
	private int totalDatosValidar;

	public AbstractGenericVistaImpl() {
		super();
	}

	@Override
	public void mostrarVentana(boolean b) {
		setVisible(b);
	}

	@Override
	public HashMap<String, Object> getMapDatos() {
		return mapDatos;
	}

	@Override
	public void cambiarIconoMouse(int cursor) {
		setCursor(new Cursor(cursor));
	}

	@Override
	public void mostrarMensaje(HashMap<String, Object> mapMensaje,
			Container ventana) {
		FrameMsg msg = new FrameMsg((JComponent) ventana);
		msg.confirmarMensaje((String) mapMensaje.get(GenericMsg.TIT),
				(String) mapMensaje.get(GenericMsg.MSG),
				(int) mapMensaje.get(GenericMsg.ICONO));
	}

	@Override
	public void setMapDatos(HashMap<String, Object> mapDatos) {
		this.mapDatos = mapDatos;
	}

	@Override
	public void setFoco(Component c) {
		c.requestFocus();
	}

	@Override
	public void cambiarColorFuente(Component comp, Color c) {
		comp.setForeground(c);
	}

	@Override
	public void avisarCambioComp(CompBasico comp) {
		if (comp.isValidado()) {
			System.out.println("VALOR: " + comp.getValue());
			if (mapDatos.get(comp.getNomComp()) == null) {
//				System.out.println("VALOR DENTRO: " + comp.getValue());
//				mapDatos.put(comp.getNomComp(), comp.getValue());
				if (comp.isObligatorio()) {
					++cantDatosValidados;
				}
			}
			mapDatos.put(comp.getNomComp(), comp.getValue());
		} else {
			if (mapDatos.get(comp.getNomComp()) != null) {
				mapDatos.put(comp.getNomComp(), null);
				if (comp.isObligatorio())
					--cantDatosValidados;
			}
		}
		if (cantDatosValidados == totalDatosValidar)
			validarDatos = true;
		else
			validarDatos = false;
	}

	/**
	 * @return the datosValidados
	 */
	@Override
	public boolean isValidarDatos() {
		return validarDatos;
	}

	/**
	 * @param datosValidados
	 *            the datosValidados to set
	 */
	protected void setValidarDatos(boolean validarDatos) {
		this.validarDatos = validarDatos;
	}

	/**
	 * @return the cantDatosValidados
	 */
	protected int getCantDatosValidados() {
		return cantDatosValidados;
	}

	/**
	 * @param cantDatosValidados
	 *            the cantDatosValidados to set
	 */
	protected void setCantDatosValidados(int cantDatosValidados) {
		this.cantDatosValidados = cantDatosValidados;
	}

	/**
	 * @return the totalDatosValidar
	 */
	protected int getTotalDatosValidar() {
		return totalDatosValidar;
	}

	/**
	 * @param totalDatosValidar
	 *            the totalDatosValidar to set
	 */
	protected void setTotalDatosValidar(int totalDatosValidar) {
		this.totalDatosValidar = totalDatosValidar;
	}

}
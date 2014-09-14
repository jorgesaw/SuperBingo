package ar.com.jorgesaw.gui.comp;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.JTextComponent;

import ar.com.jorgesaw.gui.vista.interfaces.CambioComponente;
import ar.com.jorgesaw.gui.vista.interfaces.CompBasico;
import ar.com.jorgesaw.superbingo.vista.SuperBingoTheme;
import ar.com.jorgesaw.util.fecha.ManejadorFechas;

import com.toedter.calendar.JDateChooser;

public class MyJDateChooser extends JDateChooser implements KeyListener, 
		FocusListener, CompBasico {

	private static final long serialVersionUID = -7973314028061948761L;
	private boolean obligatorio;
	private Component msgAsociado;
	private boolean validado = false;
	private static final String NOM_EDITOR = "Nombre editor";
	private static final String NOM_DATE_CHOOSER = "Nombre date chooser";
	
	List<CambioComponente> suscriptores = new ArrayList<CambioComponente>();
	
	public MyJDateChooser(String nomComp) {
		super();
		setName(nomComp);
		initComponente();
	}
	
	public MyJDateChooser(String nomComp, boolean obligatorio) {
		super();
		setName(nomComp);
		this.obligatorio = obligatorio;
		initComponente();
	}
	
	private void initComponente() {
		addFocusListener(this);
		addKeyListener(this);
		((Component) super.getDateEditor()).setName(NOM_EDITOR);
		((Component) this).setName(NOM_DATE_CHOOSER);
		((Component) super.getDateEditor()).addFocusListener(this);
		((Component) super.getDateEditor()).addKeyListener(this);
		this.addPropertyChangeListener(this);
	}
	
	@Override
	public boolean isObligatorio() {
		return obligatorio;
	}

	@Override
	public void setObligatorio(boolean b) {
		this.obligatorio = b;
	}

	@Override
	public boolean isValidado() {
		return validado;
	}

	/**
	 * Primero formateo la fecha antes de obtenerla porque he comproibado
	 * que al comparar dos fechas iguales del tipo '13-06-2013' resulta que la 
	 * son diferentes. Ocurre que el componente DateChooser toma como fecha el valor entero
	 * y luego lo formatea dando una fecha similar en días, meses y años pero diferente hora.
	 * 
	 * @return la hora seleccionada por el ususario, si no selecciono devuelve null.
	 */
	@Override
	public Object getValue() {
		return ManejadorFechas.string2Date(
				ManejadorFechas.date2String(
						super.getDateEditor().getDate()));
	}

	@Override
	public void addSuscriptor(CambioComponente comp) {
		suscriptores.add(comp);
	}
	
	@Override
	public String getNomComp() {
		return this.getName();
	}

	@Override
	public void resetValue() {
		super.getDateEditor().setDate(null);
		
		try {
			msgAsociado.setBackground(SuperBingoTheme.VALIDADO);
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void avisarSuscriptores() {
		for (CambioComponente suscriptor : suscriptores)
			suscriptor.avisarCambioComp(this);
	}

	private void validar() {
		validado = super.getDateEditor().getDate() != null
				&& ((Date) this.getValue()).compareTo(super.getMinSelectableDate()) >= 0 
				&& ((Date) this.getValue()).compareTo(super.getMaxSelectableDate()) <= 0;
		
		if (!validado)
			msgAsociado.setForeground(SuperBingoTheme.NO_VALIDADO);
		else
			msgAsociado.setForeground(SuperBingoTheme.VALIDADO);

		avisarSuscriptores();
	}
	
	/**
	 * @return the msgAsociado
	 */
	public Component getMsgAsociado() {
		return msgAsociado;
	}

	/**
	 * @param msgAsociado
	 *            the msgAsociado to set
	 */
	public void setMsgAsociado(Component msgAsociado) {
		this.msgAsociado = msgAsociado;
	}

	/**
	 * @param validado
	 *            the validado to set
	 */
	public void setValidado(boolean validado) {
		this.validado = validado;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void keyPressed(KeyEvent e) {
		char caracter = e.getKeyChar();
		String nomComp = e.getComponent().getName();
		
		if ((char) KeyEvent.VK_ENTER == caracter)
			if (NOM_EDITOR.equals(nomComp)) {
				if (this.getNextFocusableComponent() != null) {
					validar();
					this.getNextFocusableComponent().requestFocus();
				}
			} else { // sino es el componente con nombre: NOM_DATE_CHOOSER
				if (this.getNextFocusableComponent() != null) {
					validar();
					this.getNextFocusableComponent().requestFocus();
				}
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		((JTextComponent) super.getDateEditor()).selectAll();
	}

	@Override
	public void focusLost(FocusEvent e) {
		validar();
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		try {
			super.propertyChange(e);
		} catch (StackOverflowError ex) {
			
		}
		
		if (e.getPropertyName().equals("date")) {
			if (msgAsociado != null && suscriptores.size() > 0) {
				validar();
			}
		}
	}
}
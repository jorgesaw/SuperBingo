package ar.com.jorgesaw.gui.comp;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import ar.com.jorgesaw.gui.vista.interfaces.CambioComponente;
import ar.com.jorgesaw.gui.vista.interfaces.CompBasico;
import ar.com.jorgesaw.superbingo.vista.SuperBingoTheme;
import ar.com.jorgesaw.util.texto.Validacion;

public class MyJTextCadena extends JTextField implements KeyListener,
		DocumentListener, FocusListener, CompBasico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5283903625842958073L;
	private boolean obligatorio;
	private Component msgAsociado;
	private boolean validado = false;
	private int minLong = 1;
	private int maxLong = 10000;

	List<CambioComponente> suscriptores = new ArrayList<CambioComponente>();

	public MyJTextCadena(String nomComp) {
		super();
		setName(nomComp);
		initComponente();
	}

	public MyJTextCadena(String nomComp, int minLong, int maxLong,
			boolean obligatorio) {
		super();
		setName(nomComp);
		this.minLong = minLong;
		this.maxLong = maxLong;
		this.obligatorio = obligatorio;
		initComponente();
	}

	private void initComponente() {
		addFocusListener(this);
		addKeyListener(this);
		getDocument().addDocumentListener(this);
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

	@Override
	public Object getValue() {
		System.out.println("Texto: " + this.getText().toString());
		return super.getText();
	}

	@Override
	public void addSuscriptor(CambioComponente comp) {
		suscriptores.add(comp);
	}

	@Override
	public String getNomComp() {
		return super.getName();
	}

	@Override
	public void resetValue() {
		super.setText("");
		if (msgAsociado != null)
			msgAsociado.setBackground(SuperBingoTheme.VALIDADO);
	}

	@Override
	public void avisarSuscriptores() {
		for (CambioComponente suscriptor : suscriptores)
			suscriptor.avisarCambioComp(this);
	}

	private void validar() {
		validado = Validacion.longCadena(super.getText(), minLong, maxLong);
		
		if (super.getText().length() == 0 && this.obligatorio == false)
			validado = true;
		
		if (!validado) {
			if (msgAsociado != null)
				msgAsociado.setForeground(SuperBingoTheme.NO_VALIDADO);
		} else {
			if (msgAsociado != null)
				msgAsociado.setForeground(SuperBingoTheme.VALIDADO);
		}
		
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
	 * @return the minLong
	 */
	protected int getMinLong() {
		return minLong;
	}

	/**
	 * @param minLong
	 *            the minLong to set
	 */
	public void setMinLong(int minLong) {
		this.minLong = minLong;
	}

	/**
	 * @return the maxLong
	 */
	public int getMaxLong() {
		return maxLong;
	}

	/**
	 * @param maxLong
	 *            the maxLong to set
	 */
	public void setMaxLong(int maxLong) {
		this.maxLong = maxLong;
	}

	/**
	 * @param validado
	 *            the validado to set
	 */
	public void setValidado(boolean validado) {
		this.validado = validado;
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		validar();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		validar();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		validar();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void keyPressed(KeyEvent e) {
		char caracter = e.getKeyChar();

		if ((char) KeyEvent.VK_ENTER == caracter)
			if (getNextFocusableComponent() != null) {
				validar();
				getNextFocusableComponent().requestFocus();
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (getText().length() > maxLong - 1) {
			e.consume();
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		selectAll();
	}

	@Override
	public void focusLost(FocusEvent e) {
		validar();
	}

}

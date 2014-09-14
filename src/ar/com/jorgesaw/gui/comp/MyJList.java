package ar.com.jorgesaw.gui.comp;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import ar.com.jorgesaw.gui.vista.interfaces.CambioComponente;
import ar.com.jorgesaw.gui.vista.interfaces.CompBasico;
import ar.com.jorgesaw.superbingo.vista.SuperBingoTheme;

public class MyJList<E> extends JList<E> implements CompBasico, 
			KeyListener, FocusListener {

	private static final long serialVersionUID = 4264669030651547330L;
	private boolean obligatorio;
	private Component msgAsociado;
	private boolean validado = false;
	private int[] indexSel = { 0 };
	List<CambioComponente> suscriptores = new ArrayList<CambioComponente>();
	
	public MyJList(String nomComp, DefaultListModel<E> modelo) {
		super(modelo);
		setName(nomComp);
		initComponente();
	}
	
	public MyJList(String nomComp, boolean obligatorio) {
		super();
		setName(nomComp);
		this.obligatorio = obligatorio;
		initComponente();
	}
	
	private void initComponente() {
		addKeyListener(this);
		addFocusListener(this);
	}
	
	/**
	 * @return the obligatorio
	 */
	public boolean isObligatorio() {
		return obligatorio;
	}
	/**
	 * @param obligatorio the obligatorio to set
	 */
	public void setObligatorio(boolean obligatorio) {
		this.obligatorio = obligatorio;
	}
	/**
	 * @return the msgAsociado
	 */
	public Component getMsgAsociado() {
		return msgAsociado;
	}
	/**
	 * @param msgAsociado the msgAsociado to set
	 */
	public void setMsgAsociado(Component msgAsociado) {
		this.msgAsociado = msgAsociado;
	}
	/**
	 * @return the validado
	 */
	public boolean isValidado() {
		return validado;
	}
	/**
	 * @param validado the validado to set
	 */
	public void setValidado(boolean validado) {
		this.validado = validado;
	}
	
	public int[] getIndexSel() {
		return this.indexSel;
	}
	
	public void setIndexSel(int[] indexSel) {
		this.indexSel = indexSel;
	}
	
	private void validar() {
		validado = getSelectedIndices().length >= 0;
		if (msgAsociado != null) {
			if (!validado)
				msgAsociado.setForeground(SuperBingoTheme.NO_VALIDADO);
			else
				msgAsociado.setForeground(SuperBingoTheme.VALIDADO);
		}

		avisarSuscriptores();
	}
	
	@Override
	public void focusGained(FocusEvent e) { 
		this.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
	}

	@Override
	public void focusLost(FocusEvent e) {
		this.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
	public void keyReleased(KeyEvent e) { }

	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public Object getValue() {
		return getSelectedValuesList();
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
		setSelectedIndices(indexSel);
	}

	@Override
	public void avisarSuscriptores() {
		for (CambioComponente suscriptor : suscriptores)
			suscriptor.avisarCambioComp(this);
	}

}
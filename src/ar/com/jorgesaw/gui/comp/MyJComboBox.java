package ar.com.jorgesaw.gui.comp;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import ar.com.jorgesaw.gui.vista.interfaces.CambioComponente;
import ar.com.jorgesaw.gui.vista.interfaces.CompBasico;
import ar.com.jorgesaw.superbingo.vista.SuperBingoTheme;

public class MyJComboBox<E> extends JComboBox<E> implements ItemListener, CompBasico, 
	KeyListener, FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3813712810211459874L;
	private boolean obligatorio;
	private Component msgAsociado;
	private boolean validado = false;
	private int indexSel = 0;
	
	List<CambioComponente> suscriptores = new ArrayList<CambioComponente>();
	
	public MyJComboBox(String nomComp, DefaultComboBoxModel<E> modelo) {
		super(modelo);
		setName(nomComp);
		setActionCommand(nomComp);
		initComponente();
	}
	
	public MyJComboBox(String nomComp, boolean obligatorio) {
		super();
		setName(nomComp);
		setActionCommand(nomComp);
		this.obligatorio = obligatorio;
		initComponente();
	}
	
	private void initComponente() {
		addActionListener(this);
		addKeyListener(this);
		addItemListener(this);
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
	
	public int getIndexSel() {
		return this.indexSel;
	}
	
	public void setIndexSel(int indexSel) {
		this.indexSel = indexSel;
	}
	
	private void validar() {
		/**
		 * Código que controla si el primer elemento del combo
		 * es un elemento para invitar a "seleccionar" una opción.
		 * Si es así el elemento no queda validado.
		 */
		if (getModel().getElementAt(0) instanceof String 
				&& getModel().getElementAt(0)
					.toString().equals(CompBasico.SELECCIONAR))
			validado = getSelectedIndex() > 0;
		else 
			validado = getSelectedIndex() >= 0;
		if (msgAsociado != null) {
			if (!validado)
				msgAsociado.setForeground(SuperBingoTheme.NO_VALIDADO);
			else
				msgAsociado.setForeground(SuperBingoTheme.VALIDADO);
		}

		avisarSuscriptores();
	}
	
	@Override
	public void avisarSuscriptores() {
		for (CambioComponente suscriptor : suscriptores)
			suscriptor.avisarCambioComp(this);
	}
	
	@Override
	public Object getValue() {
		return getSelectedItem();
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
		setSelectedIndex(indexSel);
		if (msgAsociado != null)
			msgAsociado.setForeground(SuperBingoTheme.VALIDADO);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		validar();
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
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
		
	}
	@Override
	public void focusGained(FocusEvent e) {
		
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		validar();
	}

}
package ar.com.jorgesaw.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

import ar.com.jorgesaw.gui.vista.interfaces.VentanaCerrable;
import ar.com.jorgesaw.gui.vista.interfaces.VentanaInternaBasica;

public class DialogoGUI extends javax.swing.JDialog implements VentanaInternaBasica, VentanaCerrable {

	private static final long serialVersionUID = -6292656573956087178L;
	private static DialogoGUI instancia;
	private JPanel panelGUI;
	
	private DialogoGUI() {
		super();
		initComponentes();
	}
	
	private DialogoGUI(javax.swing.JFrame padre, String titulo) {
		super(padre, true);
		super.setTitle(titulo);
		initComponentes();
	}
	
	private DialogoGUI(javax.swing.JFrame padre, boolean modal) {
		super(padre, modal);
		initComponentes();
	}
	
	public static DialogoGUI getDialogo() {
		if (instancia == null) {
			instancia = new DialogoGUI();
		}
		return instancia;
	}
	
	public static DialogoGUI getDialogo(javax.swing.JFrame padre, String titulo) {
		if (instancia == null) {
			instancia = new DialogoGUI(padre, titulo);
		}
		return instancia;
	}
	
	public static DialogoGUI getDialogo(javax.swing.JFrame padre, boolean modal) {
		if (instancia == null) {
			instancia = new DialogoGUI(padre, modal);
		}
		return instancia;
	}
	
	private void initComponentes() {
		int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                  screenSize.width  - inset*2,
                  screenSize.height - inset*2);
        
        panelGUI = new JPanel();
        getContentPane().add(panelGUI);
	}
	
	@Override
	public void cerrarVentana() {
		dispose();
	}

	@Override
	public void init() {
		pack();
		setLocation(50, 0);
		setVisible(true);
	}

	@Override
	public void mostrarVentana(boolean b) {
		setVisible(b);	
	}

	@Override
	public void cambiarIconoMouse(int cursor) {
		setCursor(new Cursor(cursor));
	}

	@Override
	public void addPanel(Component panel) {
		panelGUI.removeAll();
		panelGUI.add((JPanel) panel, BorderLayout.CENTER);
		((JPanel) panel).updateUI();
	}

	@Override
	public void setTitulo(String titulo) {
		this.setTitle(titulo);
	}
	
}
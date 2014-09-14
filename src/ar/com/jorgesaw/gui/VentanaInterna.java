package ar.com.jorgesaw.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import ar.com.jorgesaw.gui.vista.interfaces.VentanaCerrable;
import ar.com.jorgesaw.gui.vista.interfaces.VentanaInternaBasica;

public class VentanaInterna extends JInternalFrame 
		implements VentanaInternaBasica, VentanaCerrable {

	private static final long serialVersionUID = 1501822874673649149L;
	private static VentanaInterna instancia;
	private JPanel panelGUI;
	
	private VentanaInterna() {
		super(null, 
				false, // resizable 
				false, //cerrable
				false, // maximizable
				false); // iconificable
		
		int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                  screenSize.width  - inset*2,
                  screenSize.height - inset*2);
        
		initComponentes();
	}
	
	public static Container getVentana() {
		if (instancia == null) {
			instancia = new VentanaInterna();
		}
		return instancia;
	}
	
	private void initComponentes() {
		panelGUI = new JPanel();
		panelGUI.setLayout(new BorderLayout());
		
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
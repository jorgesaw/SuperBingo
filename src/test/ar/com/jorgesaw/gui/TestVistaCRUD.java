package test.ar.com.jorgesaw.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class TestVistaCRUD extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8888781963449153970L;
	
	public TestVistaCRUD(String titulo) {
		super(titulo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Importante para gestionar el evento al cerrar la ventana
		
        initComponentes();
	}
	
	private void initComponentes() {
		panelGUI = new TestPanelVistaCRUD();
		
		getContentPane().add(panelGUI, BorderLayout.CENTER);
	}
	
	public void init() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	javax.swing.JPanel panelGUI;
	
	public static void main(String[] args) {
		new TestVistaCRUD("Ventana con botones").init();
	}
}

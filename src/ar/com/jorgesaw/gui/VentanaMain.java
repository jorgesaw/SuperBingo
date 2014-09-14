package ar.com.jorgesaw.gui;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import ar.com.jorgesaw.gui.vista.interfaces.VentanaBasica;
import ar.com.jorgesaw.gui.vista.interfaces.VentanaCerrable;
import ar.com.jorgesaw.gui.vista.interfaces.VentanaInternaBasica;


public class VentanaMain extends javax.swing.JFrame implements VentanaBasica, VentanaCerrable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7727765581202541463L;
	private javax.swing.JPanel panelGUI;
	private javax.swing.JMenuBar menuPrincipal;
	private javax.swing.JDesktopPane desktop;
	
	public VentanaMain(String titulo) {
		super(titulo);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // JFrame.EXIT_ON_CLOSE la cierra
		setResizable(false);
		
		int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                  screenSize.width  - inset*2,
                  screenSize.height - inset*2);
        
        initComponentes();
	}
	
	/**
	 * @return the panelGUI
	 */
	protected javax.swing.JPanel getPanelGUI() {
		return panelGUI;
	}

	/**
	 * @param panelGUI the panelGUI to set
	 */
	protected void setPanelGUI(javax.swing.JPanel panelGUI) {
		this.panelGUI = panelGUI;
	}

	/**
	 * @return the menuPrincipal
	 */
	protected javax.swing.JMenuBar getMenuPrincipal() {
		return menuPrincipal;
	}

	/**
	 * @param menuPrincipal the menuPrincipal to set
	 */
	protected void setMenuPrincipal(javax.swing.JMenuBar menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	/**
	 * @return the desktop
	 */
	protected javax.swing.JDesktopPane getDesktop() {
		return desktop;
	}

	/**
	 * @param desktop the desktop to set
	 */
	protected void setDesktop(javax.swing.JDesktopPane desktop) {
		this.desktop = desktop;
	}

	private void initComponentes() {
		int inset = 50;
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                  screenSize.width  - inset*2,
                  screenSize.height - inset*2);
        
        panelGUI = new javax.swing.JPanel();
		menuPrincipal = new javax.swing.JMenuBar();
		desktop = new javax.swing.JDesktopPane();
		
		setJMenuBar(menuPrincipal);
		getContentPane().add(desktop);
		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
	}
	
	@Override
	public void init() {
		pack();
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}
	
	
	public void mostrarVentanaInterna(VentanaInternaBasica ventanaInterna) {
		desktop.removeAll();
		desktop.add((Container) ventanaInterna);
		ventanaInterna.init();
	}
	

	@Override
	public void cerrarVentana() {
		dispose();
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
	public void setIconoAPP(String recurso) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource(recurso)));
	}
}
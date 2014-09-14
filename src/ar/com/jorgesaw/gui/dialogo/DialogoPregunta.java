package ar.com.jorgesaw.gui.dialogo;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.JButton;

import ar.com.jorgesaw.util.gui.MuestraComponentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;

public class DialogoPregunta extends JDialog implements InterfazVistaPregunta {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4352758115929278039L;
	private HashMap<String, Component> mapaComponentes;
	private int respuesta;
	
//	private JLabel lbMsg;
	private JTextArea lbMsg;
	private JButton btnSI;
	private JButton btnNO;
	private JButton btnCancelar;
	
	
	public DialogoPregunta(JFrame padre, String titulo, String msg) {
		
		super(padre, true);
		setTitle(titulo);
		
		initComponentes();
		setMensaje(msg);
	}
	private void initComponentes() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(30, 30));
		
		Font fuente = new Font("Arial", Font.PLAIN, 14);
//		lbMsg = new JLabel();
		lbMsg = new JTextArea();
		lbMsg.setFont(new Font("Arial", Font.PLAIN, 16));
//		lbMsg.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMsg.setBackground(new Color(214, 217, 223));
		lbMsg.setBorder(BorderFactory.createCompoundBorder(
				lbMsg.getBorder(), 
		        BorderFactory.createEmptyBorder(20, 3, 3, 3)));
		lbMsg.setName(MENSAJE);
		lbMsg.setEditable(false);
		
		
		JPanel panelAux = new JPanel(); panelAux.add(lbMsg, BorderLayout.CENTER);
		panelPrincipal.add(panelAux, BorderLayout.NORTH); 
		
		btnSI = new JButton("   Sí   ");
		btnSI.setFont(fuente);
		btnSI.setBorder(BorderFactory.createCompoundBorder(
				btnSI.getBorder(), 
		        BorderFactory.createEmptyBorder(3, 3, 3, 3)));
		btnSI.setName(InterfazVistaPregunta.SI);
		btnSI.setActionCommand(SI);
		
		btnNO = new JButton("   No   ");
		btnNO.setFont(fuente);
		btnNO.setBorder(BorderFactory.createCompoundBorder(
				btnNO.getBorder(), 
		        BorderFactory.createEmptyBorder(3, 3, 3, 3)));
		btnNO.setName(NO);
		btnNO.setActionCommand(NO);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(fuente);
		btnCancelar.setBorder(BorderFactory.createCompoundBorder(
				btnCancelar.getBorder(), 
		        BorderFactory.createEmptyBorder(0, 0, 0, 0)));
		btnCancelar.setName(CANCELAR);
		btnCancelar.setActionCommand(CANCELAR);
		
		JPanel panelAux2 = new JPanel();
		panelAux2.add(btnSI, BorderLayout.EAST);
		panelAux2.add(btnNO, BorderLayout.CENTER);
		panelAux2.add(btnCancelar, BorderLayout.WEST);
		panelPrincipal.add(panelAux2, BorderLayout.SOUTH); 
		
		getContentPane().add(panelPrincipal);
		setPreferredSize(new Dimension(510, 175));
		MuestraComponentes.getAllCompsRecursicoConNombre(this, mapaComponentes);
	}
	
	public void cerrarVentana() {
		dispose();
	}
	public void init() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void setControlador(ControlDialogoPregunta c) {
		btnCancelar.addKeyListener(c); btnCancelar.addActionListener(c);
		btnSI.addKeyListener(c); btnSI.addActionListener(c);
		btnNO.addKeyListener(c); btnNO.addActionListener(c);
	}

	public int getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(int respuesta) {
		this.respuesta = respuesta;
	}
	public void setMensaje(String m) {
		lbMsg.setText(m);
	}
	
}

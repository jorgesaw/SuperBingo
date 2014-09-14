package test.ar.com.jorgesaw.modelo.buscadores;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.annotation.Resource;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ar.com.jorgesaw.modelo.buscadores.FabricaBusqGUI;
import ar.com.jorgesaw.modelo.buscadores.interfaces.BusqGUI;
import ar.com.jorgesaw.superbingo.modelo.dto.Bingo;

public class TestFabricaBusqGUI extends javax.swing.JFrame {

	private static final long serialVersionUID = -5052587721924683820L;
	@Resource
	FabricaBusqGUI factoria;
	
	public TestFabricaBusqGUI(String titulo) {
		super(titulo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(640, 480));
        initComponentes();
	}
	
	private void initComponentes() {
		panelGUI = new JPanel();
		
		getContentPane().add(panelGUI, BorderLayout.CENTER);
	}
	
	public void init() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	javax.swing.JPanel panelGUI;
	
	public void creaFabricaBusqGUI() {
		factoria = new FabricaBusqGUI();
	}
	
	public void destruyeFabricaBusqGUI() {
		factoria = null;
	}
	
	public void testCreaBusqGUI() {
		Bingo b = (Bingo) FabricaBusqGUI.creaBusqGUI(BusqGUI.BINGO_BUSQ).getDatoBuscado();
		System.out.println(b.getTitulo());
	}

	public static void main(String[] args) {
		TestFabricaBusqGUI testFabrica = new TestFabricaBusqGUI("Ventana de búsquedas");
		testFabrica.init();
		
		testFabrica.creaFabricaBusqGUI();
		testFabrica.testCreaBusqGUI();
		testFabrica.destruyeFabricaBusqGUI();
	}
}

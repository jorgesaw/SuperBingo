package test.ar.com.jorgesaw.gui.tabla;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import ar.com.jorgesaw.dto.Ciudad;
import ar.com.jorgesaw.gui.tabla.ControlTablaImpl;
import ar.com.jorgesaw.gui.tabla.MyJScrollPane;
import ar.com.jorgesaw.gui.tabla.TablaImpl;

public class TestTablaModelo extends javax.swing.JPanel {

	private static final long serialVersionUID = -3670202686271011671L;
	
	public TestTablaModelo() {
		super();
		initComponentes();
	}
	
	private void initComponentes() {
//		TablaImpl sTabla = new TablaImpl();
		MyJScrollPane sTabla = new MyJScrollPane();
		
		sTabla.setBackground(Color.gray);
//		tabla = sTabla.getTabla();
		tabla = new TablaImpl();
		
		initModeloTabla();
		
		sTabla.addtabla(tabla);
		this.add(sTabla);
		
	}
	
	private void initModeloTabla() {
		List<Ciudad> ciudades = new ArrayList<Ciudad>();

		for (int i = 0; i < 10;i++) {
			ciudades.add( new Ciudad( "Ciudad " + i , 
					String.valueOf(Math.round(Math.random() * 1000)), 
					String.valueOf(Math.round(Math.random() * 100)) ) );
		}  
		String[] nombreColumnas = {"", "Ciudad", "C. P.", "DDN"};
		Object[] longValores = {new Integer(9), "Nombre ciudad                  ", 
				"99999", "9999"};
		TestModeloTablaCiudad modelTabla = new TestModeloTablaCiudad(nombreColumnas, longValores);
		
		ctrlTabla = new ControlTablaImpl<Ciudad>(tabla, modelTabla);
		
		ctrlTabla.initTamanioColumnas();
		ctrlTabla.getTabla().setRowHeight(
				ctrlTabla.getTabla().getRowHeight() + 8);
		ctrlTabla.agregarFilas(ciudades);
		
		ctrlTabla.modificarCelda("Villa Constitución", 1, 1);
		ctrlTabla.eliminarFila(3);
		ctrlTabla.agregarFila(0, new Ciudad("Avellaneda", "4556", "347"));
		ctrlTabla.agregarFilas(ciudades);
	}
	
	private static void crearMostrarVentana() {
        javax.swing.JFrame frame = new javax.swing.JFrame("Test Tabla Modelo");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        TestTablaModelo panelTabla = new TestTablaModelo();
        panelTabla.setOpaque(true); 
        frame.setContentPane(panelTabla);

        frame.pack();
        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	crearMostrarVentana();
            }
        });
	}
	
	private javax.swing.JTable tabla;
	private ControlTablaImpl<Ciudad> ctrlTabla;
}

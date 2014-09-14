package ar.com.jorgesaw.gui.tabla;

import javax.swing.JTable;
import javax.swing.border.Border;

public class MyJScrollPane extends javax.swing.JScrollPane {

	private static final long serialVersionUID = -3720319931422079226L;
	String tituloTabla = "";

	public MyJScrollPane() {
		super();
	}

	public MyJScrollPane(String tituloTabla) {
		super();
		this.tituloTabla = tituloTabla;
		initComponentes();
	}

	private void initComponentes() {
		Border borde = javax.swing.BorderFactory.createTitledBorder(null,
				tituloTabla,
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("SansSerif", 0, 14));

		super.setBorder(borde);
		super.isWheelScrollingEnabled();
	}
	
	public void addtabla(JTable tabla) {
		add(tabla);
		setViewportView(tabla);
        
//        tabla.setFillsViewportHeight(true);
        
		isWheelScrollingEnabled();
		setViewportView(tabla);
		setColumnHeaderView (tabla.getTableHeader());
	}
}

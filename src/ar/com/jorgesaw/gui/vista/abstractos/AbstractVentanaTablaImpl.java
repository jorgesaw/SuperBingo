package ar.com.jorgesaw.gui.vista.abstractos;

import java.awt.BorderLayout;

import javax.swing.JTable;

import ar.com.jorgesaw.gui.tabla.MyJScrollPane;
import ar.com.jorgesaw.gui.vista.interfaces.VentanaTabla;
import ar.com.jorgesaw.gui.vista.interfaces.VistaCRUD;

public abstract class AbstractVentanaTablaImpl extends AbstractGenericVistaImpl implements VentanaTabla {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4833659695984701817L;
	protected JTable tabla;
	protected MyJScrollPane scrollTabla;
	protected javax.swing.JPanel panelContTabla;
	
	public AbstractVentanaTablaImpl() {
		super();
		panelContTabla  = new javax.swing.JPanel();
        scrollTabla 	= new MyJScrollPane();
	}
	
	@Override
	public int getFilaTablaSel() {
		return tabla.getSelectedRow();
	}

	@Override
	public void setTabla(JTable tabla) {
		this.tabla = tabla;
		tabla.setName(VistaCRUD.TABLA_DATOS);
		
		scrollTabla.addtabla(tabla);
		addTablaAPanel();
	}

	@Override
	public JTable getTabla() {
		return tabla;
	}
	
	private void addTablaAPanel() {
		panelContTabla.removeAll();
		panelContTabla.setLayout(new BorderLayout());
		panelContTabla.add(scrollTabla, BorderLayout.CENTER);
		scrollTabla.updateUI();
	}

}
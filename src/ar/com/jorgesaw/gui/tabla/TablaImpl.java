package ar.com.jorgesaw.gui.tabla;

import javax.swing.border.Border;
import javax.swing.table.TableModel;

import ar.com.jorgesaw.gui.vista.interfaces.VistaCRUD;


/**
 *
 * @author jorgesaw
 * 
 */
public class TablaImpl extends javax.swing.JTable { //extends javax.swing.JScrollPane {

	private static final long serialVersionUID = -2270672975408539007L;
//    private javax.swing.JTable tabla;
    String tituloTabla = "";
    
    public TablaImpl() {
    	super();
        initComponentes();
    }
    
    public TablaImpl(String tituloTabla) {
    	super();
    	this.tituloTabla = tituloTabla;
        initComponentes();
    }
    
    public javax.swing.JTable getTabla() {
    	return null;//tabla;
    }

    public void setModeloTabla(TableModel modelo) throws NullPointerException {
//    	tabla.setModel(modelo);
    }
    public void setBorder(Border borde) {
    	super.setBorder(borde);
    }
    private void initComponentes() {
//        tabla = new javax.swing.JTable();
        super.setShowHorizontalLines(true);	
        super.setShowVerticalLines(true);
        super.setName(VistaCRUD.TABLA_DATOS);
        
		/*Border borde = javax.swing.BorderFactory.createTitledBorder(
        		null, tituloTabla, 
        		javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
        		javax.swing.border.TitledBorder.DEFAULT_POSITION, 
        		new java.awt.Font("SansSerif", 0, 14));

        setBorder(borde);*/
        
//        setViewportView(tabla);
        
        super.setFillsViewportHeight(true);
//        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
//		isWheelScrollingEnabled();
//		setViewportView(tabla);
//		setColumnHeaderView (tabla.getTableHeader());
        
    }
   
}


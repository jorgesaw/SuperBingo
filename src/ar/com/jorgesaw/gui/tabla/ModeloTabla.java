package ar.com.jorgesaw.gui.tabla;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class ModeloTabla<T> extends AbstractTableModel {
	
	private static final long serialVersionUID = -7115209556058416434L;
	
	public static final int ELEMENTO_AL_PRINCIPIO = 0;
	public static final int ELEMENTO_AL_FINAL = 1;

	private LinkedList<T> data = new LinkedList<T>();
	public String[] nombreColumnas;
	public Object[] longValores;

	private int tipoIngreso = ELEMENTO_AL_FINAL;
	
	private ArrayList<TableModelListener> listeners = new ArrayList<TableModelListener>();

	public ModeloTabla(String[] nombreColumnas, Object[] longValores) {
		this.nombreColumnas = nombreColumnas;
		this.longValores = longValores;
	}

	public LinkedList<T> getData() {
		return data;
	}
	
	@Override
	public int getColumnCount() {
		return nombreColumnas.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Class<?> getColumnClass(int c) {
		return longValores[c].getClass(); //getValueAt(0, c).getClass();
	}

	@Override
	public Object getValueAt(int fila, int col) {
		return null;

	}

	public String getColumnName(int i) {
		return nombreColumnas[i].toString();
	}

	/**
	 * El modelo por defecto no es editable.
	 */
	public boolean isCellEditable(int fila, int col) {
		return false;
	}

	public int getTipoIngreso() {
		return tipoIngreso;
	}

	public void setTipoIngreso(int tipoIngreso) {
		this.tipoIngreso = tipoIngreso;
	}

	public void agregarFila(int index, T lineaTabla) {
		int primFila;
		int ultFila;
		data.add(index, lineaTabla);
		primFila = index;
		ultFila = index;

		TableModelEvent e = new TableModelEvent(this, primFila, ultFila,
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);

		avisaSuscriptores(e);
	}

	public void agregarFila(T lineaTabla) {
		int primFila;
		int ultFila;
		if (tipoIngreso == ELEMENTO_AL_PRINCIPIO) {
			data.addFirst(lineaTabla);
			primFila = 0;
			ultFila = 0;
		} else { // ELEMENTO_AL_FINAL
			data.addLast(lineaTabla);
			primFila = getRowCount() - 1;
			ultFila = getRowCount() - 1;
		}

		TableModelEvent e = new TableModelEvent(this, primFila, ultFila,
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		
		avisaSuscriptores(e);
	}

	public void eliminarFila(int fila) {
		data.remove(fila);
		
		TableModelEvent e = new TableModelEvent(this, fila, fila,
				TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);

		avisaSuscriptores(e);
	}

	public void setValueAt(Object valor, int fila, int col) {
		TableModelEvent e = new TableModelEvent(this, fila, fila, col, 
				 TableModelEvent.UPDATE);
		avisaSuscriptores(e);
//		fireTableCellUpdated(fila, col);
	}
	
	public void setValueAtPojo(T pojo, int fila) {
		
	}
	
	public void addTableModelListener(TableModelListener l) {
		listeners.add(l);
	}

	public void removeTableModelListener(TableModelListener l) {
		listeners.remove(l);
	}

	protected void avisaSuscriptores(TableModelEvent e) {
		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).tableChanged(e);
		}
	}

}
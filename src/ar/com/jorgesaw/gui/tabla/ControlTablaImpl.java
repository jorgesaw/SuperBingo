package ar.com.jorgesaw.gui.tabla;

import java.awt.Component;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import ar.com.jorgesaw.gui.tabla.interfaces.ControlTabla;

public class ControlTablaImpl<T> implements ControlTabla<T>{

	ModeloTabla<T> modelo;
	JTable vistaTabla;

	public ControlTablaImpl(JTable vistaTabla, ModeloTabla<T> modelo) {
		this.vistaTabla = vistaTabla;
		this.modelo = modelo;
		this.vistaTabla.setModel(modelo);
	}

	public TableModel getModelo() {
		return modelo;
	}
	
	public JTable getTabla() {
		return vistaTabla;
	}
	
	public void agregarFila(int index, T filaTabla) {
		modelo.agregarFila(index, filaTabla);
	}

	public void agregarFila(T filaTabla) {
		modelo.agregarFila(filaTabla);
	}
	
	public void agregarFilas(int index, List<T> filas) {
		int cantFilas = filas.size();
		if (cantFilas > 0) {
			for (int i = 0; i < cantFilas; i++) {
				agregarFila(index, filas.get(i));
			}
		}
	}
	
	public void agregarFilas(List<T> filas) {
		int cantFilas = filas.size();
		if (cantFilas > 0) {
			for (int i = 0; i < cantFilas; i++) {
				agregarFila(filas.get(i));
			}
		}
	}
	
	public void eliminarFila(int fila) {
		if (modelo.getRowCount() > 0 && fila < modelo.getRowCount()) {
			modelo.eliminarFila(fila);
		}
	}

	public void eliminarTotalFilas() {
		int totFilas = modelo.getRowCount();
		if (totFilas > 0) {
			for (int i = 0; i < totFilas; i++) {
				modelo.eliminarFila(0);
			}
		}
	}

	public void eliminarFilas(int[] filas) {
		int filasCorridas = 0;
		if (modelo.getRowCount() >= filas.length) {
			for (int fila : filas) {
				modelo.eliminarFila(fila - filasCorridas);
				filasCorridas++;
			}
		}
	}

	public void modificarCelda(Object valor, int fila, int col) {
		modelo.setValueAt(valor, fila, col);
	}

	public void actualizarFila(T pojo, int fila) {
		modelo.setValueAtPojo(pojo, fila);
	}
	
	public void initTamanioColumnas() {
		TableColumn columna = null;
		Component comp = null;
		int headerWidth = 0;
		int cellWidth = 0;
		Object longValores[] = modelo.longValores;

		TableCellRenderer headerRenderer = vistaTabla.getTableHeader()
				.getDefaultRenderer();

		for (int i = 0; i < modelo.getColumnCount(); i++) {
			columna = vistaTabla.getColumnModel().getColumn(i);
			 columna.setHeaderValue(modelo.getColumnName(i));
			 columna.sizeWidthToFit();

			comp = headerRenderer.getTableCellRendererComponent(null,
					columna.getHeaderValue(), false, false, 0, 0);
			headerWidth = comp.getPreferredSize().width;

			comp = vistaTabla.getDefaultRenderer(modelo.getColumnClass(i)).
					getTableCellRendererComponent(vistaTabla, longValores[i], false,
							false, 0, i);
			cellWidth = comp.getPreferredSize().width;
			columna.setPreferredWidth(Math.max(headerWidth, cellWidth));
		}
	}
	
}
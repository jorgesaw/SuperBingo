package ar.com.jorgesaw.gui.tabla.interfaces;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public interface ControlTabla<T> {

	public TableModel getModelo();
	JTable getTabla();
	public void agregarFila(int index, T filaTabla);
	public void agregarFila(T filaTabla);
	public void agregarFilas(int index, List<T> filas);
	public void agregarFilas(List<T> filas);
	public void eliminarFila(int fila);
	public void eliminarTotalFilas();
	public void eliminarFilas(int[] filas);
	public void modificarCelda(Object valor, int fila, int col);
	public void actualizarFila(T pojo, int fila);
	void initTamanioColumnas();
	
}

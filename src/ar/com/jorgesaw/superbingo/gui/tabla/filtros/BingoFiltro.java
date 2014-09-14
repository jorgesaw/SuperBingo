package ar.com.jorgesaw.superbingo.gui.tabla.filtros;

import javax.swing.RowFilter;

import ar.com.jorgesaw.superbingo.gui.tabla.ModeloTablaBingoBusq;
import ar.com.jorgesaw.superbingo.modelo.dto.Bingo;


@SuppressWarnings("hiding")
public class BingoFiltro extends RowFilter<Object, Object> {

	@Override
	public boolean include(
			javax.swing.RowFilter.Entry entry) {
		ModeloTablaBingoBusq bingoModelo = (ModeloTablaBingoBusq) entry.getModel();
		Bingo b = (Bingo) bingoModelo.getData().get((Integer)entry.getIdentifier());
		
		System.out.println(b.getTitulo());
		
		return false;
	}
	
}

package ar.com.jorgesaw.superbingo.modelo.servicios;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import ar.com.jorgesaw.dao.GenericQueryDAOImpl;
import ar.com.jorgesaw.dao.interfaces.GenericQueryDAO;
import ar.com.jorgesaw.dto.Provincia;
import ar.com.jorgesaw.gui.vista.interfaces.CompBasico;

public class ServCiudadProv {

	public static DefaultComboBoxModel<Object> getProvincias() {
		DefaultComboBoxModel<Object> retorno = new DefaultComboBoxModel<Object>();
		GenericQueryDAO<Provincia> QueryProv = new GenericQueryDAOImpl<Provincia>();
		
		String ordenado = "p.nomProvincia";
		String direccion = "ASC";
		
		final StringBuilder sql = new StringBuilder("select p from ")
			.append(Provincia.class.getSimpleName()).append(" p order by ")
			.append(ordenado).append(" ").append(direccion);
		List<Provincia> provincias = QueryProv.getDataQueryList(sql.toString());
		
		retorno.addElement(CompBasico.SELECCIONAR);
		
		if (provincias != null && provincias.size() > 0) {
			for (Provincia prov : provincias) {
				retorno.addElement(prov);
			}
		}
		
		return retorno;
	}

}
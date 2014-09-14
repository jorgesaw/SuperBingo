package ar.com.jorgesaw.modelo.buscadores;

import java.util.HashMap;
import java.util.List;

import ar.com.jorgesaw.dao.GenericQueryDAOImpl;
import ar.com.jorgesaw.dao.interfaces.GenericQueryDAO;
import ar.com.jorgesaw.dto.Ciudad;
import ar.com.jorgesaw.dto.Provincia;
import ar.com.jorgesaw.modelo.buscadores.interfaces.BuscaEspecifico;
import ar.com.jorgesaw.modelo.buscadores.interfaces.PanelBusqGUI;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.IPanelDireccTel;

public class BuscaEspecificoImplCiudad implements BuscaEspecifico<Ciudad> {

	GenericQueryDAO<Ciudad> DAOCiudad = new GenericQueryDAOImpl<Ciudad>();
	@Override
	public List<Ciudad> buscarDatos(HashMap<String, Object> mapDatos,
			String categoria) {
		Provincia prov = (Provincia) mapDatos.get(IPanelDireccTel.TEXT_PROV);
		String ciudad = mapDatos.get(PanelBusqGUI.TEXT_DATOS).toString();
		
		StringBuilder sql = new StringBuilder("from Ciudad ciu where ciu.prov.idProvincia = ");
		sql.append(prov.getIdProvincia());
		if (ciudad.length() > 0) {
			sql.append(" and ciu.nomCiudad like ");
			sql.append("'"); sql.append(ciudad);
			sql.append("%"); sql.append("'");
		}
		
		return DAOCiudad.getDataQueryList(sql.toString());
	}

}

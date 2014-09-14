package ar.com.jorgesaw.modelo.buscadores;

import java.util.HashMap;
import java.util.List;

import ar.com.jorgesaw.dao.GenericQueryDAOImpl;
import ar.com.jorgesaw.dao.interfaces.GenericQueryDAO;
import ar.com.jorgesaw.modelo.buscadores.interfaces.BuscaEspecifico;
import ar.com.jorgesaw.superbingo.modelo.dto.Bingo;

public class BuscaEspecificoImplBingo implements BuscaEspecifico<Bingo> {

	GenericQueryDAO<Bingo> bingoDAO = new GenericQueryDAOImpl<Bingo>(false);

	@Override
	public List<Bingo> buscarDatos(HashMap<String, Object> mapDatos,
			String categoria) {
		String ordenado = "c.idBingo";
		String direccion = "DESC";
		
		final StringBuilder sql = new StringBuilder("select c from ")
			.append(Bingo.class.getSimpleName()).append(" c order by ")
			.append(ordenado).append(" ").append(direccion);
		return bingoDAO.getDataQueryList(sql.toString());
	}

}
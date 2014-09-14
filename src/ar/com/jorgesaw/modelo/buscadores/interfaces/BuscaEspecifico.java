package ar.com.jorgesaw.modelo.buscadores.interfaces;

import java.util.HashMap;
import java.util.List;

public interface BuscaEspecifico<T> {

	List<T> buscarDatos(HashMap<String, Object> mapDatos, String categoria);

}

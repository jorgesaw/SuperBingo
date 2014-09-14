package ar.com.jorgesaw.superbingo.modelo.crud;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import ar.com.jorgesaw.gui.vista.interfaces.VistaCRUD;
import ar.com.jorgesaw.modelo.crud.interfaces.PojoGen;
import ar.com.jorgesaw.superbingo.modelo.dao.LoteriaDAOImpl;
import ar.com.jorgesaw.superbingo.modelo.dto.Bingo;
import ar.com.jorgesaw.superbingo.modelo.dto.HoraLoteria;
import ar.com.jorgesaw.superbingo.modelo.dto.LoteriaDetalle;
import ar.com.jorgesaw.superbingo.modelo.dto.TipoLoteria;
import ar.com.jorgesaw.superbingo.modelo.dto.enumerados.DiasSemana;
import ar.com.jorgesaw.superbingo.modelo.dto.enumerados.PeriodoJugadas;
import ar.com.jorgesaw.superbingo.modelo.servicios.ServCartonesBingo;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.BingoNuevo;
import ar.com.jorgesaw.util.texto.NumTexto;

/**
 * Clase que implementa una serie de métodos para acceder a los datos de un bingo.
 * @author jorgesaw
 * @version 1.0
 */
public class PojoGenImplBingo implements PojoGen<Bingo> {

	private static int intervalo_prem_jug = 5;
	private static String separador_dias_jug = "-";
	private static int diferencia = 2;

	/**
	 * Clase que crea un bingo a pertir de los datos de un HashMap.
	 * @return Devuelve un bingo.
	 */
	@Override
	public Bingo makePojo(HashMap<String, Object> mapDatos) {
		Bingo bingo = new Bingo();
		cargarDatosPojo(mapDatos, bingo);

		return bingo;
	}

	/**
	 * 
	 * @return Devuelve la clase bingo.
	 */
	@Override
	public Class<Bingo> getClasePojo() {
		return Bingo.class;
	}

	/**
	 * @return Devuelve un Map con los datos de un bingo
	 * @param pojo Un bingo.
	 */
	@Override
	public HashMap<String, Object> getPojo2Data(Bingo pojo) {
		HashMap<String, Object> retorno = new HashMap<String, Object>();
		Bingo bingo = (Bingo) pojo;

		retorno.put(VistaCRUD.ID_POJO, bingo.getIdBingo());
		retorno.put(BingoNuevo.TEXT_NOM, bingo.getTitulo());
		retorno.put(BingoNuevo.TEXT_OBSERV, bingo.getObservaciones());
		retorno.put(BingoNuevo.TEXT_FECHA_VENCE, bingo.getFechaVence());
		retorno.put(BingoNuevo.TEXT_FECHA_CREA, bingo.getFechaCrea());
		retorno.put(BingoNuevo.CANT_CART,
				ServCartonesBingo.getCantCartones(bingo.getIdBingo()));
		retorno.put(BingoNuevo.VENDIDO, bingo.isVendido());
		retorno.put(BingoNuevo.LOTERIA, bingo.getLoteria().getNombre());
		retorno.put(BingoNuevo.HORA_LOTERIA, bingo.getLoteria()
				.getHorario());
		retorno.put(BingoNuevo.PREMIO, bingo.getPremio());
		retorno.put(BingoNuevo.PERIO_JUG, bingo.getLotDetalle()
				.getPeriodoJug());
		retorno.put(BingoNuevo.PREM_JUG, (bingo.getLotDetalle()
				.getNumJugadas() / intervalo_prem_jug) - 1);

		String[] numDias = bingo.getLotDetalle().getDiasJugada()
				.split(separador_dias_jug);

		retorno.put(BingoNuevo.DIAS_JUG,
				NumTexto.arrayText2ArrayInt(numDias, diferencia));

		return retorno;
	}

	@Override
	public Bingo getPojoConID(HashMap<String, Object> mapDatos) {
		Bingo bin = (Bingo) makePojo(mapDatos);
		bin.setIdBingo((Long) mapDatos.get(VistaCRUD.ID_POJO));

		return bin;
	}

	@Override
	public Serializable getIdPojo(Bingo pojo) {
		Bingo bin = pojo;
		return bin.getIdBingo();
	}

	private int getPremJugadas(String cadena) {
		String[] listaCadena = cadena.split(" ");
		int premJug = Integer.valueOf(listaCadena[listaCadena.length - 1]);

		return premJug;
	}

	@Override
	public void actualizarPojo(HashMap<String, Object> mapDatos, Bingo pojo) {
		cargarDatosPojo(mapDatos, pojo);
	}

	@SuppressWarnings("unchecked")
	private void cargarDatosPojo(HashMap<String, Object> mapDatos, Bingo pojo) {
		pojo.setTitulo((String) mapDatos.get(BingoNuevo.TEXT_NOM));
		pojo.setObservaciones((String) mapDatos
				.get(BingoNuevo.TEXT_OBSERV));
		pojo.setFechaCrea((Date) mapDatos
				.get(BingoNuevo.TEXT_FECHA_CREA));
		pojo.setFechaVence((Date) mapDatos
				.get(BingoNuevo.TEXT_FECHA_VENCE));
//		pojo.setVendido((boolean) mapDatos.get(BingoNuevo.VENDIDO));
		pojo.setVendido(true);

		pojo.setLoteria(new LoteriaDAOImpl().getLoteria(
				((TipoLoteria) mapDatos.get(BingoNuevo.LOTERIA)),
				(HoraLoteria) mapDatos.get(BingoNuevo.HORA_LOTERIA)));

		pojo.setPremio((String) mapDatos.get(BingoNuevo.PREMIO));

		pojo.setLotDetalle(new LoteriaDetalle(((PeriodoJugadas) mapDatos
				.get(BingoNuevo.PERIO_JUG)).getPeriodo(),
			getPremJugadas((String) ((List<String>) mapDatos.get(BingoNuevo.PREM_JUG)).get(0) ), 
			LoteriaDetalle.diasArray2String((List<DiasSemana>) mapDatos
				.get(BingoNuevo.DIAS_JUG))));
	}

}
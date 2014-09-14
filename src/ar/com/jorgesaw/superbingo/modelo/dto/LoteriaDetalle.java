package ar.com.jorgesaw.superbingo.modelo.dto;

import java.util.List;

import ar.com.jorgesaw.superbingo.modelo.dto.enumerados.DiasSemana;


public class LoteriaDetalle {
	
	private static String separador = "-";
	
	private Long idLotDetalle;
	private int periodoJug;
	private int numJugadas;
	private String  diasJugada;
	
	public LoteriaDetalle() { }
	
	public LoteriaDetalle(int periodoJug, int numJugadas, String diasJugada) {
		this.periodoJug = periodoJug;
		this.numJugadas = numJugadas;
		this.diasJugada = diasJugada;
	}

	public Long getIdLotDetalle() {
		return idLotDetalle;
	}

	public void setIdLotDetalle(Long idLotDetalle) {
		this.idLotDetalle = idLotDetalle;
	}

	public int getPeriodoJug() {
		return periodoJug;
	}

	public void setPeriodoJug(int periodoJug) {
		this.periodoJug = periodoJug;
	}

	public int getNumJugadas() {
		return numJugadas;
	}

	public void setNumJugadas(int numJugadas) {
		this.numJugadas = numJugadas;
	}

	public String getDiasJugada() {
		return diasJugada;
	}

	public void setDiasJugada(String diasJugada) {
		this.diasJugada = diasJugada;
	}

	public static String diasArray2String(List<DiasSemana> lista) {
		String cadenaDias = "";
		
		for (int i = 0; i < lista.size();i++) {
			cadenaDias += String.valueOf(lista.get(i).getDiaSemana()) + "-";
		}
		
		return cadenaDias;
	}
	
	public static int[] diasString2Array(String cadenaDias) {
		String[] numDias = cadenaDias.split(separador);
		int[] numDiasEnteros = new int[numDias.length];
		
		for (int i = 0; i < numDias.length;i++) {
			numDiasEnteros[i] = Integer.parseInt(numDias[i]);
		}
		
		return numDiasEnteros;
	}
}

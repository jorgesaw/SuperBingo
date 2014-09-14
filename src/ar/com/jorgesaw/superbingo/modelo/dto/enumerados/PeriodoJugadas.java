package ar.com.jorgesaw.superbingo.modelo.dto.enumerados;

public enum PeriodoJugadas {
	
	DIARIO(0), SEMANAL(1), MENSUAL(2);
	
	private int periodo;
	
	private PeriodoJugadas(int periodo) {
		this.periodo = periodo;
	}
	
	public int getPeriodo() {
		return periodo;
	}
	
}

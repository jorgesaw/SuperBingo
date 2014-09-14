package ar.com.jorgesaw.superbingo.modelo.dto.enumerados;

public enum DiasSemana {
	
	DOMINGO(1), LUNES(2), MARTES(3), MIERCOLES(4), JUEVES(5), VIERNES(6), SABADO(7), ;
	
	private int diaSemana;
	
	private DiasSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}
	
	public int getDiaSemana() {
		return diaSemana;
	}
	
}

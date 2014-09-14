package ar.com.jorgesaw.superbingo.modelo.dto.enumerados;

public enum HoraLoteria {

	MATUTINA("Matutina"), VESPERTINA("Vespertina"), NOCTURNA("Nocturna");
	
	String nombreHorario;
	
	private HoraLoteria(String nombreHorario) {
		this.nombreHorario = nombreHorario;
	}

	public String toString() {
		return nombreHorario;
	}
}

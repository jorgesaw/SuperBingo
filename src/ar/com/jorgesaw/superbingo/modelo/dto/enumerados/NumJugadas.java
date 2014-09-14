package ar.com.jorgesaw.superbingo.modelo.dto.enumerados;

public enum NumJugadas {

	CINCO(5), DIEZ(10), QUINCE(15), VEINTE(20);
	
	private int premios;
	
	private NumJugadas(int premios) {
		this.premios = premios;
	}
	
	public int getPremios() {
		return premios;
	}

}

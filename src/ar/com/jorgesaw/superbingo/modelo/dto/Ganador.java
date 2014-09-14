package ar.com.jorgesaw.superbingo.modelo.dto;

public class Ganador {

	private Long idGanador;
	private Carton cartonGanador;
	private java.util.Date fechaInicioGanador;
	
	public Ganador() { }
	
	public Long getIdGanador() {
		return idGanador;
	}
	public void setIdGanador(Long idGanador) {
		this.idGanador = idGanador;
	}
	public Carton getCartonGanador() {
		return cartonGanador;
	}
	public void setCartonGanador(Carton cartonGanador) {
		this.cartonGanador = cartonGanador;
	}
	public java.util.Date getFechaInicioGanador() {
		return fechaInicioGanador;
	}
	public void setFechaInicioGanador(java.util.Date fechaInicioGanador) {
		this.fechaInicioGanador = fechaInicioGanador;
	}
	
	
}

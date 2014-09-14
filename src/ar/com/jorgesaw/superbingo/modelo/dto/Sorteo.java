package ar.com.jorgesaw.superbingo.modelo.dto;

public class Sorteo {

	private Long idSorteo;
	private Loteria loteria;
	private java.util.Date fechaSorteo;
	private String numeros;
	
	public Sorteo() { }
	
	public Sorteo(Loteria loteria, java.util.Date fechaSorteo, String numeros) {
		this.loteria = loteria;
		this.fechaSorteo = fechaSorteo;
		this.numeros = numeros;
	}
	
	public Long getIdSorteo() {
		return idSorteo;
	}
	public void setIdSorteo(Long idSorteo) {
		this.idSorteo = idSorteo;
	}
	public Loteria getLoteria() {
		return loteria;
	}
	public void setLoteria(Loteria loteria) {
		this.loteria = loteria;
	}
	public java.util.Date getFechaSorteo() {
		return fechaSorteo;
	}
	public void setFechaSorteo(java.util.Date fechaSorteo) {
		this.fechaSorteo = fechaSorteo;
	}
	public String getNumeros() {
		return numeros;
	}
	public void setNumeros(String numeros) {
		this.numeros = numeros;
	}
	
	

}

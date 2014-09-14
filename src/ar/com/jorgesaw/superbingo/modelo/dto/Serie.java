package ar.com.jorgesaw.superbingo.modelo.dto;

import java.util.SortedSet;
import java.util.TreeSet;

public class Serie implements Comparable {
	
	public static final int MAX_CANT_CARTONES = 6;
	private int cantCart = 1;
	private Long idSerie;
	private int numSerie;
	private Institucion institucion;
	private java.util.Date fechaVence;
	private java.util.Date fechaInicio;

	private int generacion;

	private boolean generado;
	private Bingo bingo;
	
	private SortedSet<Carton> cartones = new TreeSet<Carton>();;
	
	public Serie() {}
	
	public Serie(int numSerie) {
		this.numSerie = numSerie;
	}
	public Long getIdSerie() {
		return idSerie;
	}
	public void setIdSerie(Long id) {
		this.idSerie = id;
	}
	public int getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}
	public SortedSet<Carton> getCartones() {
		return cartones;
	}
	public void setCartones(SortedSet<Carton> cartones) {
			this.cartones = cartones;
	}
	
	public void addCarton(Carton carton) {
			cartones.add(carton);
	}
	
	public Institucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}
	
	public java.util.Date getFechaVence() {
		return fechaVence;
	}

	public void setFechaVence(java.util.Date fechaVence) {
		this.fechaVence = fechaVence;
	}
	
	public int getGeneracion() {
		return generacion;
	}

	public void setGeneracion(int generacion) {
		this.generacion = generacion;
	}

	public boolean isGenerado() {
		return generado;
	}

	public void setGenerado(boolean generado) {
		this.generado = generado;
	}
	
	public java.util.Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(java.util.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}*/
	
	public String toString() {
		return String.valueOf(numSerie);
	}

	@Override
	public int compareTo(Object o) {
		Serie otraSerie = (Serie) o;
		// Lo hago porque Integer implementa Comparable.
		return Integer.valueOf(numSerie).compareTo(otraSerie.getNumSerie());
	}

	public Bingo getBingo() {
		return bingo;
	}

	public void setBingo(Bingo bingo) {
		this.bingo = bingo;
	}
}

package ar.com.jorgesaw.superbingo.modelo.dto;

import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

public class Bingo {

	public static final int MAX_CANT_BINGOS = 9999;
	private Long idBingo;
	private String titulo;
	private String observaciones;
	private Date fechaCrea;
	private Date fechaVence;
	private boolean vendido;

	private SortedSet<Serie> series = new TreeSet<Serie>();
	
	private Loteria loteria;
	
	private String premio;
	private LoteriaDetalle lotDetalle;

	public Bingo() {
	}

	public Bingo(String titulo, String observaciones, Date fechaCrea,
			Date fechaVence) {
		this.titulo = titulo;
		this.observaciones = observaciones;
		this.fechaCrea = fechaCrea;
		this.fechaVence = fechaVence;

	}
	
	public Bingo(String titulo, String observaciones, Date fechaCrea,
			Date fechaVence, boolean vendido) {
		this.titulo = titulo;
		this.observaciones = observaciones;
		this.fechaCrea = fechaCrea;
		this.fechaVence = fechaVence;
		this.vendido = vendido;
	}
	
	public Bingo (Long id) {
		this.idBingo = id;
	}

	public Long getIdBingo() {
		return idBingo;
	}

	public void setIdBingo(Long id) {
		this.idBingo = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFechaCrea() {
		return fechaCrea;
	}

	public void setFechaCrea(Date fechaCrea) {
		this.fechaCrea = fechaCrea;
	}

	public Date getFechaVence() {
		return fechaVence;
	}

	public void setFechaVence(Date fechaVence) {
		this.fechaVence = fechaVence;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public SortedSet<Serie> getSeries() {
		return series;
	}

	public void setSeries(SortedSet<Serie> series) {
		this.series = series;
	}

	public void addSerie(Serie serie) {
		series.add(serie);
	}
	
	public Loteria getLoteria() {
		return loteria;
	}

	public void setLoteria(Loteria loteria) {
		this.loteria = loteria;
	}
	public String getPremio() {
		return premio;
	}

	public void setPremio(String premio) {
		this.premio = premio;
	}
	public LoteriaDetalle getLotDetalle() {
		return lotDetalle;
	}

	public void setLotDetalle(LoteriaDetalle lotDetalle) {
		this.lotDetalle = lotDetalle;
	}
	
	public String toString() {
		return idBingo + " - " + titulo;
	}

}

package ar.com.jorgesaw.superbingo.modelo.dto;

public class Campagna {
	
	private Long idCampagna;
	private Long idBingo;
	private Long idInstit;
	
	private int serieInicial;
	private int serieFinal;
	private boolean generado;
	
	public Campagna() { }

	public Campagna(Long idCampagna, Long idBingo, Long idInstit) {
		this.idCampagna = idCampagna;
		this.idBingo = idBingo;
		this.idInstit = idInstit;
	}
	
	public Long getIdCampagna() {
		return idCampagna;
	}
	public void setIdCampagna(Long idCampagna) {
		this.idCampagna = idCampagna;
	}
	public Long getIdBingo() {
		return idBingo;
	}
	public void setIdBingo(Long idBingo) {
		this.idBingo = idBingo;
	}
	public Long getIdInstit() {
		return idInstit;
	}
	public void setIdInstit(Long idInstit) {
		this.idInstit = idInstit;
	}
	public int getSerieInicial() {
		return serieInicial;
	}
	public void setSerieInicial(int serieInicial) {
		this.serieInicial = serieInicial;
	}
	public int getSerieFinal() {
		return serieFinal;
	}
	public void setSerieFinal(int serieFinal) {
		this.serieFinal = serieFinal;
	}
	public boolean isGenerado() {
		return generado;
	}
	public void setGenerado(boolean generado) {
		this.generado = generado;
	}
}

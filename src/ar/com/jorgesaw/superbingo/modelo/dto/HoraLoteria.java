package ar.com.jorgesaw.superbingo.modelo.dto;

public class HoraLoteria {
	
	Integer idHora;
	String horario;
	
	public HoraLoteria() { }

	public HoraLoteria(Integer idHora, String horario) {
		this.idHora = idHora;
		this.horario = horario;
	}
	
	public Integer getIdHora() {
		return idHora;
	}

	public void setIdHora(Integer idHora) {
		this.idHora = idHora;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String toString() {
		return horario;
	}
}

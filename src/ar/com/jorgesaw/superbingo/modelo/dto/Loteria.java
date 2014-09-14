package ar.com.jorgesaw.superbingo.modelo.dto;

public class Loteria {
	
	Integer idLoteria;
	TipoLoteria nombre;
	HoraLoteria horario;

	public Loteria() { }
	
	public Loteria(TipoLoteria nombre, HoraLoteria horario) {
		this.nombre = nombre;
		this.horario = horario;
	}
	public Loteria(Integer idLoteria, TipoLoteria nombre) {
		this.idLoteria = idLoteria;
		this.nombre = nombre;
	}
	
	public Integer getIdLoteria() {
		return idLoteria;
	}

	public void setIdLoteria(Integer idLoteria) {
		this.idLoteria = idLoteria;
	}

	public TipoLoteria getNombre() {
		return nombre;
	}

	public void setNombre(TipoLoteria nombre) {
		this.nombre = nombre;
	}

	public HoraLoteria getHorario() {
		return horario;
	}

	public void setHorario(HoraLoteria horario) {
		this.horario = horario;
	}
	
	public String toString() {
		return nombre.getAlias() + " " + horario.getHorario();
	}
}

package ar.com.jorgesaw.dto;

public class Ciudad {
	
	Integer idCiudad;
	String nomCiudad;
	String codPostal;
	String DDN;
	
	Provincia prov;
	
	public Ciudad() { }
	
	public Ciudad(Integer idCiudad, String nomCiudad) {
		this.idCiudad = idCiudad;
		this.nomCiudad = nomCiudad;
	}
	
	public Ciudad(String nomCiudad, String codPostal, String DDN) {
		this.nomCiudad = nomCiudad;
		this.codPostal = codPostal;
		this.DDN = DDN;
	}
	public Integer getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNomCiudad() {
		return nomCiudad;
	}

	public void setNomCiudad(String nomCiudad) {
		this.nomCiudad = nomCiudad;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getDDN() {
		return DDN;
	}

	public void setDDN(String dDN) {
		DDN = dDN;
	}

	public Provincia getProv() {
		return prov;
	}

	public void setProv(Provincia prov) {
		this.prov = prov;
	}

	@Override
	public String toString() {
		return nomCiudad;
	}
	
}

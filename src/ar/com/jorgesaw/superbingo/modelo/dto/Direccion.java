package ar.com.jorgesaw.superbingo.modelo.dto;

import ar.com.jorgesaw.dto.Ciudad;

public class Direccion {

//	Long idDireccion;
	String calle;
	String altura;
	String piso;
	String depto;
	
	Ciudad ciudad;
//	Provincia prov; 
	
	
	public Direccion() { }
	
	public Direccion(String calle, String altura, String piso, String depto,
			Ciudad ciudad) {
		super();
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.depto = depto;
		this.ciudad = ciudad;
//		this.prov = prov;
	}

	public Direccion(String calle, String altura, Ciudad ciudad) {
		super();
		this.calle = calle;
		this.altura = altura;
		this.ciudad = ciudad;
//		this.prov = prov;
	}

	/*public Long getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}*/
	
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	/*public Provincia getProv() {
		return prov;
	}

	public void setProv(Provincia prov) {
		this.prov = prov;
	}*/
	
	public String toString() {
		return calle + " " + altura;
	}
	
}

package ar.com.jorgesaw.dto;

import java.util.HashSet;
import java.util.Set;

public class Provincia {
	
	Integer idProvincia;
	String nomProvincia;
	Set<Ciudad> colCiudades = new HashSet<Ciudad>();
	
	public Provincia() { }
	
	public Provincia(String nomProvincia) {
		this.nomProvincia = nomProvincia;
	}
	public Provincia(Integer idProvincia ,String nomProvincia) {
		this.idProvincia = idProvincia;
		this.nomProvincia = nomProvincia;
	}
	
	public Integer getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNomProvincia() {
		return nomProvincia;
	}

	public void setNomProvincia(String nomProvincia) {
		this.nomProvincia = nomProvincia;
	}
	public Set<Ciudad> getColCiudades() {
		return colCiudades;
	}

	public void setColCiudades(Set<Ciudad> colCiudades) {
		this.colCiudades = colCiudades;
	}
	public void addCiudad(Ciudad ciudad) {
		colCiudades.add(ciudad);
	}
	
	public String toString() {
		return nomProvincia;
	}
}

package ar.com.jorgesaw.superbingo.modelo.dto;

import java.util.Date;

public class Carton implements Comparable {

	private Long idCarton;
	private String numeros;
//	private Empleado consig = null;
//	transient private Cliente cli = null;
	
	private Empleado vendedor;
	private Empleado cobrador;
	private Long codigoBarras;
	private int numeroRifa;
	private boolean consignado = false;
	private boolean vendido = false;
//	private java.util.Date fechaVence;
	private Serie serie = null;
	private int numCarton;

	public Serie getSerie() {
		return serie;
	}


	public void setSerie(Serie serie) {
		this.serie = serie;
	}


	public Carton() {
	
	}
	
	
	/*public Carton(String numeros, Date fechaVence) {
		super();
		this.numeros = numeros;
		this.fechaVence = fechaVence;
	}*/
	
	public Carton(String numeros) {
		super();
		this.numeros = numeros;
	}

	public Carton(Long idCarton, String numeros) {
		super();
		this.idCarton = idCarton;
		this.numeros = numeros;
	}
	
	public Long getIdCarton() {
		return idCarton;
	}

	public void setIdCarton(Long id) {
		this.idCarton = id;
	}

	public String getNumeros() {
		return numeros;
	}

	public void setNumeros(String numeros) {
		this.numeros = numeros;
	}

	/*public Empleado getConsig() {
		return consig;
	}

	public void setConsig(Empleado consig) {
		this.consig = consig;
	}*/
	public Long getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(Long codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public int getNumeroRifa() {
		return numeroRifa;
	}

	public void setNumeroRifa(int numeroRifa) {
		this.numeroRifa = numeroRifa;
	}

	public boolean isConsignado() {
		return consignado;
	}

	public void setConsignado(boolean consignado) {
		this.consignado = consignado;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
	
	/*public Date getFechaVence() {
		return fechaVence;
	}

	public void setFechaVence(Date fechaVence) {
		this.fechaVence = fechaVence;
	}*/
	
	public int getNumCarton() {
		return numCarton;
	}


	public void setNumCarton(int numCarton) {
		this.numCarton = numCarton;
	}

//	Lo saqué porque en la clase ServicioBingoNumeros con estos dos
//	métodos implementados no me dejaba poner más que un elemento
//	ya que por la forma de guardarlos tomaba como que era un eleme3nyto repetido
//	y no me dejaba ingresarlo.
/*  @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoBarras == null) ? 0 : codigoBarras.hashCode());
		result = prime * result + (consignado ? 1231 : 1237);
		result = prime * result + ((idCarton == null) ? 0 : idCarton.hashCode());
		result = prime * result + numeroRifa;
		result = prime * result + (vendido ? 1231 : 1237);
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
		Carton other = (Carton) obj;
		if (codigoBarras == null) {
			if (other.codigoBarras != null)
				return false;
		} else if (!codigoBarras.equals(other.codigoBarras))
			return false;
		if (consignado != other.consignado)
			return false;
		if (idCarton == null) {
			if (other.idCarton != null)
				return false;
		} else if (!idCarton.equals(other.idCarton))
			return false;
		if (numeroRifa != other.numeroRifa)
			return false;
		if (vendido != other.vendido)
			return false;
		return true;
	} */
	
	public int compareTo(Object o) {
		Carton otroCarton = (Carton) o;
		return Integer.valueOf(numCarton).compareTo(otroCarton.getNumCarton());
	}
	
	public String toString() {
		return numeros;
	}


	public Empleado getVendedor() {
		return vendedor;
	}


	public void setVendedor(Empleado vendedor) {
		this.vendedor = vendedor;
	}


	public Empleado getCobrador() {
		return cobrador;
	}


	public void setCobrador(Empleado cobrador) {
		this.cobrador = cobrador;
	}
}

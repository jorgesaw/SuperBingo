package ar.com.jorgesaw.modelo.buscadores;

import ar.com.jorgesaw.modelo.buscadores.interfaces.BusqGUI;

public abstract class BusqClassGUI<T> implements BusqGUI<T>  {

	private T datoBuscado;
	
	@Override
	public T getDatoBuscado() {
		return datoBuscado;
	}
	
	protected void setDatoBuscado(T datoBuscado) {
		this.datoBuscado = datoBuscado;
	}

}

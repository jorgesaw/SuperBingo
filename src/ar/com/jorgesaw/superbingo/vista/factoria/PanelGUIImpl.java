package ar.com.jorgesaw.superbingo.vista.factoria;

import ar.com.jorgesaw.superbingo.vista.factoria.interfaces.PanelGUI;

public abstract class PanelGUIImpl<T> implements PanelGUI<T> {
	
	T contenedor;

	@Override
	public T getContenedor() {
		return contenedor;
	}
	
	protected void setContenedor(T contenedor) {
		this.contenedor = contenedor;
	}

}
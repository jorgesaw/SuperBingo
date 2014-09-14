package ar.com.jorgesaw.modelo.buscadores.interfaces;

public interface BusqGUI<T> {
	
	static final int BINGO_BUSQ = 1;
	static final int INSTIT_BUSQ = 2;
	static final int EMPLEADO_BUSQ = 3;
	static final int CIUDAD_BUSQ = 4;
	
	T getDatoBuscado();
}

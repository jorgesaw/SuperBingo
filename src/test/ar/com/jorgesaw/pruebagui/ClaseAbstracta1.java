package test.ar.com.jorgesaw.pruebagui;

public abstract class ClaseAbstracta1 implements InterClaseAbstracta1 {

	public ClaseAbstracta1() { }
	
	@Override
	public String getNombreClase() {
		return ClaseAbstracta1.class.getCanonicalName();
	}

	
}

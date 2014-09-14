package test.ar.com.jorgesaw.pruebagui;

public class ClaseImpl extends ClaseAbstracta1 {

	public ClaseImpl() {
		super();
	}
	
	@Override
	public String getNombreClase() {
		System.out.println("-------");
		return super.getNombreClase();
	}
	public static void main(String[] args) {
		ClaseImpl instancia = new ClaseImpl();
		System.out.println("Mi clase abstracta padre es: " + instancia.getNombreClase());
	}
}

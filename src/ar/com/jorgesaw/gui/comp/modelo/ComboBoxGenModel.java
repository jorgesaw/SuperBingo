package ar.com.jorgesaw.gui.comp.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

public class ComboBoxGenModel<E> extends DefaultComboBoxModel<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3893880331622519128L;

//	private List<E> elementos = new ArrayList<E>();
//	private E[] elementos;
	
	public ComboBoxGenModel() { }
	
	public ComboBoxGenModel(E[] elementos) { 
		super(elementos);
	}

	/*@Override
	public void removeAllElements() {
		elementos.clear();
	}
	
	@Override
	public void removeElementAt(int index) {
		
	}*/
	
	public static void main(String[] args) {
		List<String> nombress = new ArrayList<String>(0);
		nombress.add("Luisana"); nombress.add("Lorena"); nombress.add("Florencia");
		String[] nombres = (String[]) nombress.toArray(new String[nombress.size()]);
		
		ComboBoxGenModel<String> instancia = new ComboBoxGenModel<String>((String[])nombres);
		System.out.println("Tamaño modelo: " + instancia.getSize());
		System.out.println("Primer nombre: " + instancia.getElementAt(0));
//		instancia.removeAllElements();
//		System.out.println("Tamaño modelo: " + instancia.getSize());
		instancia.removeElementAt(0);
		System.out.println("Primer nombre: " + instancia.getElementAt(0));
	}
}

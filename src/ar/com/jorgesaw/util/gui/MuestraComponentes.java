package ar.com.jorgesaw.util.gui;

import java.awt.Component;
import java.awt.Container;
import java.util.HashMap;

public class MuestraComponentes {
	
	static boolean DEBUG = false;
	
	public static void getAllCompsRecursivo(Container c, 
			HashMap<String, Component> mapaComponentes) {
		
	}
	
	public static void getAllCompsRecursicoConNombre(Container c, 
			HashMap<String, Component> mapaComponentes) {
		
		if (c == null) { return; }
		if (mapaComponentes == null) {
			mapaComponentes = new HashMap<String, Component>();
		}
		
		for (int i = 0;i < c.getComponents().length;i++) {
			if (c.getComponents()[i] instanceof Container) {
				if (c.getComponents()[i].getName() != null) {
					mapaComponentes.put(c.getComponents()[i].getName(), c.getComponents()[i]);
					if (DEBUG) {
						System.out.println("NOMBRE: " + c.getComponents()[i].getName());
					}
				}
				getAllCompsRecursicoConNombre((Container)c.getComponents()[i],
						mapaComponentes);
			} else {
				System.out.println("No es un objeto de la clase Container.");
			}
		}
	}
	
	public static Component getComponentByName(String nombre, 
			HashMap<String, Component> mapaComponentes) {
		if (mapaComponentes.containsKey(nombre)) {
			return (Component) mapaComponentes.get(nombre);
		}
		return null;
	}
}

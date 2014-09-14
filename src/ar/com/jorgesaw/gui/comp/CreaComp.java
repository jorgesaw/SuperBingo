package ar.com.jorgesaw.gui.comp;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CreaComp {

	public static Font fuente = new java.awt.Font("Tahoma", 0, 12);
	
	public static MyJTextCadena creaTextCadena(String nomComp, int minLong, int maxLong, boolean obligatorio) {
		MyJTextCadena txt = new MyJTextCadena(nomComp, minLong, maxLong, obligatorio);
		txt.setBorder(BorderFactory.createCompoundBorder(
				txt.getBorder(),
				BorderFactory.createEmptyBorder(3, 3, 3, 3)));
		txt.setHorizontalAlignment(SwingConstants.LEFT);
		txt.setFont(fuente);
		return txt;
	}
	
	public static MyJTextNum creaTextNum(String nomComp, int minLong, int maxLong, boolean obligatorio) {
		MyJTextNum txt = new MyJTextNum(nomComp, minLong, maxLong, obligatorio);
		txt.setBorder(BorderFactory.createCompoundBorder(
				txt.getBorder(),
				BorderFactory.createEmptyBorder(3, 3, 3, 3)));
		txt.setHorizontalAlignment(SwingConstants.RIGHT);
		txt.setFont(fuente);
		return txt;
	}
	
	public static JButton creaBoton(String texto, String nomComp, int tecla, String icono) {
		JButton boton = new JButton(texto);
		boton.setName(nomComp);
		boton.setActionCommand(nomComp);
		boton.setMnemonic(tecla);
		boton.setBorder(BorderFactory.createCompoundBorder(
				boton.getBorder(),
				BorderFactory.createEmptyBorder(3, 3, 3, 3)));
		if (icono != null) {
			boton.setIcon(new ImageIcon(CreaComp.class.getResource(
					icono)));
			boton.setIconTextGap(2);
		}
		return boton;
	}
	
	public static JLabel creaLabel(String texto, Font fuente) {
		JLabel label = new JLabel(texto);
		label.setFont(fuente);
		
		return label;
	}
	
	public static <E> MyJComboBox<E> creaCombo(String nomComp, boolean obligatorio) {
		MyJComboBox<E> combo = new MyJComboBox<E>(nomComp, obligatorio);
		combo.setFont(fuente);
		return combo;
	}
	
	public static <E> MyJList<E> creaLista(String nomComp, boolean obligatorio) {
		MyJList<E> lista = new MyJList<E>(nomComp, obligatorio);
		lista.setFont(fuente);
		lista.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		return lista;
	}
}
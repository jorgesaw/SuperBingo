package ar.com.jorgesaw.gui.comp;

import java.awt.event.KeyEvent;

public class MyJTextNum extends MyJTextCadena {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5059032001813866163L;

	public MyJTextNum(String nomComp) {
		super(nomComp);
	}
	
	public MyJTextNum(String nomComp, int minLong, int maxLong, boolean obligatorio) {
		super(nomComp, minLong, maxLong, obligatorio);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		char caracter = e.getKeyChar();
		
		if (!Character.isDigit(caracter) 
				|| getText().length() > getMaxLong() - 1) {
			e.consume();
		}
	}

}
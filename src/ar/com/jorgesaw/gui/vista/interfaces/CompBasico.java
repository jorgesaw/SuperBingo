package ar.com.jorgesaw.gui.vista.interfaces;

public interface CompBasico {

	public static final int NO_VALIDAR = 0;
	public static final int NO_VALIDAR_SI_VACIO = 1;
	public static final String SELECCIONAR = "Seleccionar";
	
	boolean isObligatorio();
	void setObligatorio(boolean b);
	boolean isValidado();
	Object getValue();
	void addSuscriptor(CambioComponente comp);
	String getNomComp();
	void resetValue();
	void avisarSuscriptores();
}

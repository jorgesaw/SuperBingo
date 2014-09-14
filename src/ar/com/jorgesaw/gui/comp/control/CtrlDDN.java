package ar.com.jorgesaw.gui.comp.control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import ar.com.jorgesaw.dto.Ciudad;
import ar.com.jorgesaw.gui.comp.MyJTextCadenaCiudad;
import ar.com.jorgesaw.superbingo.modelo.dao.CiudadQueryDAOImpl;
import ar.com.jorgesaw.superbingo.modelo.dao.interfaces.CiudadQueryDAO;
import ar.com.jorgesaw.superbingo.vista.SuperBingoTheme;

public class CtrlDDN implements KeyListener, FocusListener {
	
	HashMap<String, MyJTextCadenaCiudad> mapText;
	CiudadQueryDAO DAOCiudad = new CiudadQueryDAOImpl();
	
	public CtrlDDN() { }
	
	public CtrlDDN(HashMap<String, MyJTextCadenaCiudad> mapText) {
		this.mapText = mapText;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
				
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		String nomComp = e.getComponent().getName();
		String DDN = mapText.get(nomComp).getCiudad().getDDN();
		
		Ciudad c = DAOCiudad.getCiudadByDDN(DDN).get(0); // Busco el primer resultado.
		
		if (c == null) {
			mapText.get(nomComp).getMsgAsociado().setForeground(SuperBingoTheme.NO_VALIDADO);
		} else {
			mapText.get(nomComp).getMsgAsociado().setForeground(SuperBingoTheme.VALIDADO);
		}
		mapText.get(nomComp).setCiudad(c);
		mapText.get(nomComp).setValidado(c != null);
		mapText.get(nomComp).avisarSuscriptores();
	}

}

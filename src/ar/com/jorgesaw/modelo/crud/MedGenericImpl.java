package ar.com.jorgesaw.modelo.crud;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import ar.com.jorgesaw.modelo.crud.interfaces.MedEspecif;
import ar.com.jorgesaw.modelo.crud.interfaces.MedGeneric;
import ar.com.jorgesaw.modelo.crud.tabulado.interfaces.TablaData;

public class MedGenericImpl implements MedGeneric {

	@SuppressWarnings("rawtypes")
	MedEspecif medEspecif;
	@SuppressWarnings("rawtypes")
	TablaData tablaData;
	
	@Override
	public void setMedEspecif(MedEspecif<?> medEspecif) {
		this.medEspecif = medEspecif;
	}
	
	@Override
	public void setTablaData(TablaData<?> tablaData) {
		this.tablaData = tablaData;
	}

	@Override
	public MedEspecif<?> getMedEspecif() {
		return medEspecif;
	}
	
	@Override
	public TablaData<?> getTablaData() {
		return tablaData;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean guardarDatos(HashMap<String, Object> mapDatos) {
		medEspecif.guardarPojo(mapDatos);
		
		return medEspecif.getPojo() != null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void mostrarDatos() {
		tablaData.mostrarDatos(medEspecif.getPojo());
	}

	@SuppressWarnings("unchecked")
	@Override
	public int listarDatos() {
		int retorno = -1;
		medEspecif.listarPojos();
		List<?> listaPojos = medEspecif.getListaPojos();
		
		if (listaPojos.size() > 0) {
			retorno = medEspecif.getListaPojos().size();
			tablaData.mostrarDatos(listaPojos);
		}
		
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> traerDato(int fila) {
		return medEspecif.getPojo2Data(fila);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> traerDato() {
		medEspecif.setPojo(tablaData.getPojoFilaTabla(tablaData.getControlTabla().getTabla().getSelectedRow()));
		return medEspecif.getPojo2Data();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean actualizarDatos(HashMap<String, Object> mapDatos) {
		medEspecif.actualizarPojo(mapDatos);
		
		return medEspecif.getPojo() != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void mostrarDatosActualiz() {
		tablaData.mostrarDatosActualiz(medEspecif.getPojo(), tablaData.getControlTabla().getTabla().getSelectedRow());
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean eliminarDatos(HashMap<String, Object> mapDatos) {
		medEspecif.elimPojo(mapDatos);
		
		return medEspecif.getPojo() == null;
	}


	@Override
	public boolean eliminarDatos() {
		medEspecif.setPojo(tablaData.getPojoFilaTabla(tablaData.getControlTabla().getTabla().getSelectedRow()));
		return medEspecif.elimPojo();
	}
	
	@Override
	public void elimDatoMostrado() {
		tablaData.elimDatoMostrado();
	}

	@Override
	public void setDatoBuscado(Object dato) {
		medEspecif.setPojo(dato);
	}
	
	@Override 
	public Object getDatoBuscado() {
		return medEspecif.getPojo();
	}

	@Override
	public void getDatoById(Serializable idBingo, boolean lazy) {
		medEspecif.getPojoById(idBingo, lazy);
	}

	@Override
	public int getFilaSelTabla() {
		return tablaData.getControlTabla().getTabla().getSelectedRow();
	}

}

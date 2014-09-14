package ar.com.jorgesaw.superbingo.modelo.crud;

import java.io.Serializable;
import java.util.HashMap;

import ar.com.jorgesaw.dto.Ciudad;
import ar.com.jorgesaw.dto.Provincia;
import ar.com.jorgesaw.gui.vista.interfaces.VistaCRUD;
import ar.com.jorgesaw.modelo.crud.interfaces.PojoGen;
import ar.com.jorgesaw.superbingo.modelo.dto.Direccion;
import ar.com.jorgesaw.superbingo.modelo.dto.Institucion;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.IPanelDireccTel;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.IPanelEmpleados;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.IPanelInstitucion;

public class PojoGenImplInstit implements PojoGen<Institucion> {
	
	@Override
	public Institucion makePojo(HashMap<String, Object> mapDatos) {
		Institucion instit = null;
				
		return instit;
	}

	@Override
	public Class<Institucion> getClasePojo() {
		return Institucion.class;
	}

	@Override
	public HashMap<String, Object> getPojo2Data(Institucion pojo) {
		HashMap<String, Object> retorno = new HashMap<String, Object>();
		
		try {
			retorno.put(VistaCRUD.ID_POJO, pojo.getIdInstit());
			retorno.put(IPanelInstitucion.TEXT_TIPO, pojo.getTipo());
			retorno.put(IPanelInstitucion.TEXT_DESCRIPCION, pojo.getDescripcion());
			retorno.put(IPanelInstitucion.TEXT_ALIAS, pojo.getAlias());
			retorno.put(IPanelDireccTel.TEXT_DIR, pojo.getDireccion()
					.getCalle());
			retorno.put(IPanelDireccTel.TEXT_ALTURA, pojo.getDireccion()
					.getAltura());
			retorno.put(IPanelDireccTel.TEXT_PROV, pojo.getDireccion()
					.getCiudad().getProv());
			retorno.put(IPanelDireccTel.TEXT_CIU, pojo.getDireccion()
					.getCiudad());
			retorno.put(IPanelEmpleados.TEXT_CEL, pojo.getCelular());
			retorno.put(IPanelEmpleados.TEXT_TEL, pojo.getTelefono());
//			retorno.put(IPanelEmpleados.TEXT_FECHA_ING, pojo.getFechaIng());
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			retorno = null;
		}
		
		return retorno;
	}

	@Override
	public Institucion getPojoConID(HashMap<String, Object> mapDatos) {
		Institucion instit = makePojo(mapDatos);
		instit.setIdInstit( (Long) mapDatos.get(VistaCRUD.ID_POJO) );
		
		return instit;
	}

	@Override
	public Serializable getIdPojo(Institucion  pojo) {
		return pojo.getIdInstit();
	}

	@Override
	public void actualizarPojo(HashMap<String, Object> mapDatos, Institucion  pojo) {
		cargarDatosPojo(mapDatos, pojo);
	}

	private void cargarDatosPojo(HashMap<String, Object> mapDatos, Institucion pojo) {
		pojo.setTipo(	(String) mapDatos.get(IPanelInstitucion.TEXT_TIPO));
		pojo.setDescripcion(	(String) mapDatos.get(IPanelInstitucion.TEXT_DESCRIPCION));
		pojo.setAlias((String) mapDatos.get(IPanelInstitucion.TEXT_ALIAS));
		pojo.setCelular((String) mapDatos.get(IPanelDireccTel.TEXT_CEL));
		pojo.setTelefono((String) mapDatos.get(IPanelDireccTel.TEXT_TEL));

		Direccion dir = new Direccion(
				(String) mapDatos.get(IPanelDireccTel.TEXT_DIR), 
				(String) mapDatos.get(IPanelDireccTel.TEXT_ALTURA),
				(Ciudad) mapDatos.get(IPanelDireccTel.TEXT_CIU));
		dir.getCiudad().setProv((Provincia) mapDatos.get(IPanelDireccTel.TEXT_PROV));
		
		if(mapDatos.get(IPanelDireccTel.TEXT_PISO) != null 
				&& mapDatos.get(IPanelDireccTel.TEXT_DEPTO) != null ) {
			dir.setPiso((String) mapDatos.get(IPanelDireccTel.TEXT_PISO));
			dir.setDepto((String) mapDatos.get(IPanelDireccTel.TEXT_DEPTO));
		}

		pojo.setDireccion(dir);
	}
}

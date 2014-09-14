package ar.com.jorgesaw.superbingo.modelo.crud;

import java.io.Serializable;
import java.util.HashMap;

import ar.com.jorgesaw.dto.Ciudad;
import ar.com.jorgesaw.dto.Provincia;
import ar.com.jorgesaw.gui.vista.interfaces.VistaCRUD;
import ar.com.jorgesaw.modelo.crud.interfaces.PojoGen;
import ar.com.jorgesaw.superbingo.modelo.dto.Cobrador;
import ar.com.jorgesaw.superbingo.modelo.dto.Direccion;
import ar.com.jorgesaw.superbingo.modelo.dto.Empleado;
import ar.com.jorgesaw.superbingo.modelo.dto.Vendedor;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.IPanelDireccTel;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.IPanelEmpleados;


public class PojoGenImplEmpl implements PojoGen<Empleado> {

	@Override
	public Empleado makePojo(HashMap<String, Object> mapDatos) {
		Empleado empl = null;
		if (IPanelEmpleados.VENDEDOR.equals(
				(String) mapDatos.get(IPanelEmpleados.CATEGORIA))) {
			empl = new Vendedor();
		} else if (IPanelEmpleados.COBRADOR.equals(
				(String) mapDatos.get(IPanelEmpleados.CATEGORIA))) {
			empl = new Cobrador();
		}  
				
		return empl;
	}

	@Override
	public Class<Empleado> getClasePojo() {
		return Empleado.class;
	}

	@Override
	public HashMap<String, Object> getPojo2Data(Empleado pojo) {
		HashMap<String, Object> retorno = new HashMap<String, Object>();
		
		try {
			retorno.put(IPanelEmpleados.TEXT_DNI, pojo.getDni());
			retorno.put(IPanelEmpleados.TEXT_APE, pojo.getApellido());
			retorno.put(IPanelEmpleados.TEXT_NOM, pojo.getNombre());
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
			retorno.put(IPanelEmpleados.TEXT_FECHA_ING, pojo.getFechaIng());
			if (pojo instanceof Vendedor) {
				retorno.put(IPanelEmpleados.CATEGORIA, 
						IPanelEmpleados.VENDEDOR);
			} else if (pojo instanceof Cobrador) {
				retorno.put(IPanelEmpleados.CATEGORIA, 
						IPanelEmpleados.COBRADOR);
			}
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			retorno = null;
		}
		
		return retorno;
	}

	@Override
	public Empleado getPojoConID(HashMap<String, Object> mapDatos) {
		Empleado empl = makePojo(mapDatos);
		empl.setDni( (Long) mapDatos.get(VistaCRUD.ID_POJO) );
		
		return empl;
	}

	@Override
	public Serializable getIdPojo(Empleado pojo) {
		return pojo.getDni();
	}

	@Override
	public void actualizarPojo(HashMap<String, Object> mapDatos, Empleado pojo) {
		cargarDatosPojo(mapDatos, pojo);
	}

	private void cargarDatosPojo(HashMap<String, Object> mapDatos, Empleado pojo) {
		pojo.setDni(	(Long) mapDatos.get(IPanelEmpleados.TEXT_DNI));
		pojo.setApellido((String) mapDatos.get(IPanelEmpleados.TEXT_APE));
		pojo.setNombre((String) mapDatos.get(IPanelEmpleados.TEXT_NOM));
		pojo.setCelular((String) mapDatos.get(IPanelDireccTel.TEXT_CEL));
		pojo.setTelefono((String) mapDatos.get(IPanelDireccTel.TEXT_TEL));
		pojo.setFechaIng((java.util.Date) mapDatos
				.get(IPanelEmpleados.TEXT_FECHA_ING));

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
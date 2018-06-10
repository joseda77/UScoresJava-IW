/**
 * 
 */
package co.edu.udea.iw.BL.Impl;

import static org.junit.Assert.fail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.Dao.EquipoDao;
import co.edu.udea.iw.Dao.Implement.TorneoDaoImpl;
import co.edu.udea.iw.BL.EquipoBL;
import co.edu.udea.iw.dto.Equipo;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora de la implementacion de la interfaz EquipoBL
 */
@Transactional
public class EquipoBLImpl  implements EquipoBL {
	@Autowired
	EquipoDao equipoDao;
	@Autowired
	TorneoDaoImpl torneoDao;
	
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.BL.EquipoBL#obtenerEquipo()
	 */
	@Override
	public List<Equipo> obtenerEquipo() throws MyException {
		
		return equipoDao.ObternerEquipos();
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.BL.EquipoBL#obtener(java.lang.String)
	 */
	@Override
	public Equipo obtener(String codigo) throws MyException {
		if(codigo.equals("")) {
			throw new MyException("Ingrese el codigo");
		}
		
		return equipoDao.obtener(codigo);
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.BL.EquipoBL#crearEquipo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Equipo crearEquipo(String codigo, String nombre, String fase, String puntaje, Torneo torneo)
			throws MyException {
		Equipo equipo = null;
		try {
			if (codigo.equals("")) {
				throw new MyException("Rellene el campo codigo");
			} else if(nombre.equals("")){
				throw new MyException("Rellene el campo nombre ");
			}else if(fase.equals("")){
				throw new MyException("Rellene el campo deporte");
			}else if(puntaje.equals("")){
				throw new MyException("Rellene el campo tipo de torneo");
			}else if(torneo.equals(null)) {
				throw new MyException("Usuario invalido!");
			}else if(torneoDao.ObtenerTorneo(torneo.getCodigo())== null) {
				
				throw new MyException("Usuario no valido");
			}	
			
			equipo = new Equipo();
			equipo.setCodigo(codigo);
			equipo.setFase(fase);
			equipo.setNombre(nombre);
			equipo.setPuntaje(puntaje);
			equipo.setTorneo(torneo);
			
			equipoDao.CrearEquipo(equipo);
		} catch (MyException e) {
			fail(e.getCause().getMessage());
		}
		return equipo;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.BL.EquipoBL#actualizar(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Equipo actualizar(String codigo, String nombre, String puntaje, String fase) throws MyException {
		Equipo equipo = null;
		try {
		if(codigo.equals("") && nombre.equals("") && puntaje.equals("") && fase.equals("")) {
			throw new MyException("No se ha hecho ninguna actualizacion");
		}		
		equipo = this.obtener(codigo);
		
		if(equipo !=null) {
			if(!nombre.equals("")) {
				equipo.setNombre(nombre);
			}
			if(!puntaje.equals("")) {
				equipo.setPuntaje(puntaje);
			}
			if(!fase.equals("")) {
				equipo.setFase(fase);
			}
			
		equipoDao.ModificarEquipo(equipo);
		}else {
			throw new MyException("Codigo no validos");
		}
		}catch (MyException e) {
			fail(e.getCause().getMessage());
		}
		
		return equipo;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.BL.EquipoBL#eliminar(java.lang.String)
	 */
	@Override
	public void eliminar(String codigo) throws MyException {
		Equipo equipo = null;
		try {
			if (codigo.equals("")) {
				throw new MyException("Rellene el campo codigo");			
			}	
			equipo = new Equipo();		
			equipo.setCodigo(codigo);
			equipoDao.EliminarEquipo(equipo);
		} catch (MyException e) {
			fail(e.getCause().getMessage());
		}

	}

}

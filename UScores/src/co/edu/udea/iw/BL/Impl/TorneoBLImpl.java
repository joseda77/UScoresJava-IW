package co.edu.udea.iw.BL.Impl;

import static org.junit.Assert.fail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.BL.TorneoBL;
import co.edu.udea.iw.BL.UsuarioBL;
import co.edu.udea.iw.Dao.TorneoDao;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora de la implementacion de la interfaz TorneoBL
 */
@Transactional
public class TorneoBLImpl implements TorneoBL {
	
	@Autowired
	TorneoDao torneoDao;
	@Autowired
	UsuarioBL usuarioBL;
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.BL.TorneoBL#obtenerTorneos()
	 */
	@Override
	public List<Torneo> obtenerTorneos() throws MyException {
		return torneoDao.ObtenerTorneos();
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.BL.TorneoBL#obtener(java.lang.String)
	 */
	@Override
	public Torneo obtener(String codigo) throws MyException {
		if (codigo.equals("")) {
			throw new MyException("Codigo incorrecto");
		} else if(torneoDao.ObtenerTorneo(codigo)==null) {
			throw new MyException("Torneo no encontrado");
		}

		System.out.println("Entra en torneo BLTorneo:"+torneoDao.ObtenerTorneo(codigo).getNombre());
		return torneoDao.ObtenerTorneo(codigo);
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.BL.TorneoBL#crearTorneo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, co.edu.udea.iw.dto.Usuario)
	 */
	@Override
	public Torneo crearTorneo(String codigo, String nombre, String deporte, String tipoTorneo, Usuario usuario)
			throws MyException {
		Torneo torneo = null;
		System.out.println("Toreno BL");
		try {
			if (codigo.equals("")) {
				throw new MyException("Rellene el campo codigo");
			}
			if(nombre.equals("")){
				throw new MyException("Rellene el campo nombre ");
			}
			if(deporte.equals("")){
				throw new MyException("Rellene el campo deporte");
			}
			if(tipoTorneo.equals("")){
				throw new MyException("Rellene el campo tipo de torneo");
			}
			if(usuario.equals(null)) {
				throw new MyException("Usuario invalido!");
			}
			if(!usuarioBL.autenticar(usuario.getNombreUsuario(),usuario.getContrasena()).equals("Usuario Correcto")) {
				throw new MyException("Usuario no valido");
			}		
			torneo = new Torneo();
			torneo.setCodigo(codigo);
			torneo.setNombre(nombre);
			torneo.setDeporte(deporte);
			torneo.setTipoTorneo(tipoTorneo);
			torneo.setUsuario(usuario);
			
			torneoDao.CrearTorneo(torneo);
		} catch (MyException e) {
			fail(e.getCause().getMessage());
		}
		return torneo;
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.BL.TorneoBL#actualizar(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Torneo actualizar(String codigo,String nombre, String deporte, String tipoTorneo) throws MyException {
		Torneo torneo = null;
		try {
			if (nombre.equals("") && deporte.equals("") && tipoTorneo.equals("")) {
				throw new MyException("NO SE HAN ACTUALIZADO NING�N DATO");
			} 
			torneo = torneoDao.ObtenerTorneo(codigo);
			
			if(!this.obtener(codigo).equals(null)) {
				if(!nombre.equals("")) {
					torneo.setNombre(nombre);
				}
				if(!deporte.equals("")) {
					torneo.setDeporte(deporte);
				}
				if(!tipoTorneo.equals("")) {
					torneo.setTipoTorneo(tipoTorneo);
				}
			}else {
				throw new MyException("Codigo no validos");
			}
			torneoDao.ModificarTorneo(torneo);
		} catch (MyException e) {
			fail(e.getCause().getMessage());
		}
		return torneo;
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.BL.TorneoBL#eliminar(java.lang.String, co.edu.udea.iw.dto.Usuario)
	 */
	@Override
	public void eliminar(String codigo, Usuario usuario) throws MyException {
		Torneo torneo = null;		
		try {
			System.out.println("entra aqui"+ usuarioBL.autenticar(usuario.getNombreUsuario(), usuario.getContrasena()));
			if (codigo.equals("")) {
				throw new MyException("Rellene el campo codigo");			
			}else if(!usuarioBL.autenticar(usuario.getNombreUsuario(),usuario.getContrasena()).equals("Usuario Correcto")) {
				throw new MyException("Usuario no valido");
			}		
			torneo = torneoDao.ObtenerTorneo(codigo);
			
			torneoDao.EliminarTorneo(torneo);
		} catch (MyException e) {
			fail(e.getCause().getMessage());
		}
		
	}
	
	
}

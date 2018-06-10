package co.edu.udea.iw.BL.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.BL.UsuarioBL;
import co.edu.udea.iw.Dao.UsuarioDao;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;
import co.edu.udea.iw.util.validations.Validaciones;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora de la implementacion de la interfaz UsuarioBL
 */
@Transactional
public class UsuarioBLImpl implements UsuarioBL {

	@Autowired
	UsuarioDao usuariodao;
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.BL.UsuarioBL#autenticar(java.lang.String, java.lang.String)
	 */
	@Override
	public String autenticar(String nombreUsuario, String contrasena) throws MyException {
		
		
		if (Validaciones.isTextoVacio(nombreUsuario)) {
			throw new MyException("Ingrese un Usuario");
		}
		Usuario usuario = usuariodao.ObtenerUsuario(nombreUsuario);
		System.out.println("Entra en el bl "+usuario);
		if (Validaciones.isTextoVacio(contrasena)) {
			throw new MyException("Ingrese una contrase�a");
		}
		if (!usuario.getContrasena().equals(contrasena)) {
			return("Usuario o password invalidos");
		}
		return "Usuario Correcto";
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.BL.UsuarioBL#crearUsuario(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String crearUsuario(String nombreUsuario, String contrasena, String email) throws MyException {
		Usuario usuario = null;
		try {
			if (Validaciones.isTextoVacio(nombreUsuario)) {
				throw new MyException("Usuario vacio");
			}
			if (Validaciones.isTextoVacio(contrasena)) {
				throw new MyException("Contrase�a vacia");
			}
			if (Validaciones.isTextoVacio(email)) {
				throw new MyException("Correo Vacio");
			}
			if (Validaciones.isEmail(email)) {
				throw new MyException("Ingrese un correo correcto");
			}
			usuario = new Usuario();
			usuario.setNombreUsuario(nombreUsuario);
			usuario.setContrasena(contrasena);
			usuario.setEmail(email);
			usuariodao.CrearUsuario(usuario);
		} catch (MyException e) {
			e.getStackTrace();
		}

		return "Creado correctamente";
	}

}

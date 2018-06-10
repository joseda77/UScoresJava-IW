package co.edu.udea.iw.BL;

import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora de la interfaz de la logica del negocio de Usuario
 */
public interface UsuarioBL {
	/**
	 * 
	 * @param nombreUsuario
	 * @param contrasena
	 * @return valida y autencica un usuario y su contraseña
	 * @throws MyException
	 */
	public String autenticar(String nombreUsuario, String contrasena) throws MyException;
	/**
	 * crea un usuario validando sus datos
	 * @param nombreUsuario
	 * @param contrasena
	 * @param email
	 * @return 
	 * @throws MyException
	 */
	public String crearUsuario(String nombreUsuario,String contrasena, String email) throws MyException;
	
}

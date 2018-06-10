package co.edu.udea.iw.Dao;

import java.util.List;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 *Declaración de métodos al acceso de los datos del usuario en la base datos
 */
public interface UsuarioDao {

	/**
	 * 
	 * @return retorna la lista de usuarios
	 * @throws MyException
	 */
	public List<Usuario> ObtenerUsuarios() throws MyException;
	/**
	 * 
	 * @param nombreUsuario
	 * @return obtiene un usuario en especifico
	 * @throws MyException
	 */
	public Usuario ObtenerUsuario(String nombreUsuario) throws MyException;
	/**
	 * 
	 * @param usuario
	 * @return inserta un usuario nuevo
	 * @throws MyException
	 */
	public Usuario CrearUsuario(Usuario usuario) throws MyException;
	/**
	 * 
	 * @param usuario
	 * @return un usuario que se modificó previamente
	 * @throws MyException
	 */
	public Usuario ModificarUsuario (Usuario usuario) throws MyException;
	/**
	 * elimina un usuario de la BD
	 * @param usuario
	 * @throws MyException
	 */
	public void EliminarUsuario (Usuario usuario) throws MyException;
	
}

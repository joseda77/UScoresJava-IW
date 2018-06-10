package co.edu.udea.iw.Dao;

import java.util.List;

import co.edu.udea.iw.dto.Equipo;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 *Declaración de métodos al acceso de los datos del equipo en la base datos
 */
public interface EquipoDao {

	/**
	 * 
	 * @param equipo
	 * @return Inserta en la base de datos un equipo creado por el usuario.
	 * @throws MyException
	 */
	public Equipo CrearEquipo (Equipo equipo) throws MyException;
	/**
	 * 
	 * @param equipo
	 * @return Retorna el resultado de  modificar un equipo en la BD
	 * @throws MyException
	 */
	public Equipo ModificarEquipo (Equipo equipo) throws MyException;
	/**
	 * 
	 * @param equipo
	 * Elimina un equipo de la BD
	 * @throws MyException
	 */
	public void EliminarEquipo (Equipo equipo) throws MyException;
	/**
	 * 
	 * @return la lista de todos los equipos en la base de datos
	 * @throws MyException
	 */
	public List<Equipo> ObternerEquipos() throws MyException;
	/**
	 * 
	 * @param codigo
	 * @return un equipo por medio de un codigo ingresado como parametro
	 * @throws MyException
	 */
	public Equipo obtener(String codigo) throws MyException;
	
	
}

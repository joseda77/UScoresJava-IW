package co.edu.udea.iw.Dao;

import java.util.List;
import co.edu.udea.iw.dto.Partido;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 *Declaración de métodos al acceso de los datos del partido en la base datos
 */
public interface PartidoDao {
	/**
	 * 
	 * @param partido
	 * @return Inserta un partido en la base de datos 
	 * @throws MyException
	 */
	public Partido CrearPartido(Partido partido) throws MyException;
	/**
	 * 
	 * @param partido
	 * @return Modifica un partido y lo retorna con los cambios
	 * @throws MyException
	 */
	public Partido ModificarPartido(Partido partido) throws MyException;
	/**
	 * Elimina un partido de la BD
	 * @param partido
	 * @throws MyException
	 */
	public void EliminarPartido(Partido partido) throws MyException;
	/**
	 * 
	 * @return obtiene los partidos que existen enla BD
	 * @throws MyException
	 */
	public List<Partido> ObtenerPartidos() throws MyException;
	/**
	 * 
	 * @param consecutivo
	 * @return obtiene un partido en especifico por medio de su codigo
	 * @throws MyException
	 */
	public Partido obtener(String consecutivo) throws MyException;

}

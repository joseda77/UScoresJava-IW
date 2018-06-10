package co.edu.udea.iw.Dao;

import java.util.List;

import co.edu.udea.iw.dto.TorneoFavorito;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 *Declaración de métodos al acceso de los datos de los torneos favoritos en la base datos
 */
public interface TorneoFavoritoDao {
	/**
	 * 
	 * @return  obtiene todos los torneos favoritos de un usuario  de la bd 
	 * @throws MyException
	 */
	public List<TorneoFavorito> ObtenerTorneosFavoritos(String nombreUsuario) throws MyException;
	/**
	 * 
	 * @param nombreUsuario
	 * @return retorna un torneo  del usuario
	 * @throws MyException
	 */
	
	public TorneoFavorito CrearTorneoFavorito(TorneoFavorito torneofavorito) throws MyException;
	/**
	 * elimina un torneo favorito de la bd
	 * @param torneofavorito
	 * @throws MyException
	 */
	public void EliminarTorneoFavorito(TorneoFavorito torneofavorito) throws MyException;
	/**
	 * 
	 * @param torneofavorito
	 * @return retorna un torneo favorito que se modifico previamente
	 * @throws MyException
	 */
	public TorneoFavorito ModificarTorneoFavorito(TorneoFavorito torneofavorito) throws MyException;
}

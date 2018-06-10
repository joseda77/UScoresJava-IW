package co.edu.udea.iw.BL;

import java.util.List;
import co.edu.udea.iw.dto.TorneoFavorito;
import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora de la interfaz de la logica del negocio de Torneo Favorito
 */
public interface TorneoFavoritoBL {
	/**
	 * 
	 * @return una lista de torneos favoritos
	 * @throws MyException
	 */
	public List<TorneoFavorito> obtenerTorneosFavoritos(String nombreUsuario) throws MyException;

	/**
	 * 
	 * @param torneofavorito
	 * @return agrega un torneo favorito a un usuario
	 * @throws MyException
	 */
	public TorneoFavorito agregarTorneoFavorito(TorneoFavorito torneofavorito) throws MyException;
	/**
	 * elimina un torneo favorito 
	 * @param torneofavorito
	 * @throws MyException
	 */
	public void eliminar(TorneoFavorito torneofavorito) throws MyException;	
}

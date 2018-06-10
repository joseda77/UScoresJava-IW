/**
 * 
 */
package co.edu.udea.iw.BL.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.BL.TorneoFavoritoBL;
import co.edu.udea.iw.Dao.TorneoFavoritoDao;
import co.edu.udea.iw.dto.TorneoFavorito;
import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora de la implementacion de la interfaz TorneoFavoritoBL
 */
@Transactional
public class TorneoFavoritoBLImpl implements TorneoFavoritoBL {

	@Autowired
	TorneoFavoritoDao torneoFavDao;
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.BL.TorneoFavoritoBL#obtenerTorneosFavoritos()
	 * Arreglar los test del dao y bl
	 */
	@Override
	public List<TorneoFavorito> obtenerTorneosFavoritos(String nombreUsuario) throws MyException {
		List <TorneoFavorito> torneo = null;
		try {
			torneo = (List<TorneoFavorito>) torneoFavDao.ObtenerTorneosFavoritos(nombreUsuario);
		} catch (MyException e) {
			throw new MyException(e.getCause().getMessage());
		}
		
		return torneo;
	}


	/* (non-Javadoc)
	 * @see co.edu.udea.iw.BL.TorneoFavoritoBL#agregarTorneoFavorito(co.edu.udea.iw.dto.TorneoFavorito)
	 */
	@Override
	public TorneoFavorito agregarTorneoFavorito(TorneoFavorito torneofavorito) throws MyException {
		try {
			if(torneofavorito == null) {
				throw new MyException("Torneo invalido para agregar");
			}
			torneoFavDao.CrearTorneoFavorito(torneofavorito);
		} catch (MyException e) {
			throw new MyException(e.getCause().getMessage());
		}
		
		return torneofavorito;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.BL.TorneoFavoritoBL#eliminar(co.edu.udea.iw.dto.TorneoFavorito)
	 */
	@Override
	public void eliminar(TorneoFavorito torneofavorito) throws MyException {
		try {
			if(torneofavorito == null) {
				throw new MyException("Torneo invalido para eliminar");
			}
			torneoFavDao.EliminarTorneoFavorito(torneofavorito);
		} catch (MyException e) {
			throw new MyException(e.getCause().getMessage());
		}		
	}

}

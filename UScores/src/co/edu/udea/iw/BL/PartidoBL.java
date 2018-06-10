package co.edu.udea.iw.BL;

import java.util.List;

import co.edu.udea.iw.dto.Equipo;
import co.edu.udea.iw.dto.Partido;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora de la interfaz de la logica del negocio de Partido
 */
public interface PartidoBL {
	
	/**
	 * 
	 * @param consecutivo
	 * @param torneo
	 * @param equipo1
	 * @param equipo2
	 * @param fase
	 * @return valida la informacion entrante y crea el partido
	 * @throws MyException
	 */
	public Partido CrearPartido(String consecutivo, Torneo torneo, Equipo equipo1, Equipo equipo2, String fase)
			throws MyException;
	/**
	 * 
	 * @param consecutivo
	 * @param puntaje1
	 * @param puntaje2
	 * @param fase
	 * @return valida el torneo y actualiza  los datos de un partido
	 * @throws MyException
	 */
	public Partido ModificarPartido(String consecutivo, int puntaje1, int puntaje2, String fase)
			throws MyException;
	/**
	 * Elimina un partido existente
	 * @param consecutivo
	 * @throws MyException
	 */
	public void EliminarPartido(String consecutivo) throws MyException;
	/**
	 * 
	 * @return una lista de partidos
	 * @throws MyException
	 */
	public List<Partido> ObtenerPartidos() throws MyException;
	/**
	 * 
	 * @param consecutivo
	 * @return un partido existente
	 * @throws MyException
	 */
	public Partido obtener(String consecutivo) throws MyException;

}

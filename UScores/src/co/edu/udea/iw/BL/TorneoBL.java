package co.edu.udea.iw.BL;

import co.edu.udea.iw.exception.MyException;
import java.util.List;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.dto.Usuario;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora de la interfaz de la logica del negocio de Torneo
 */
public interface TorneoBL {
	/**
	 * 
	 * @return retorna la lista de torneos de la bd
	 * @throws MyException
	 */
	public List<Torneo> obtenerTorneos() throws MyException;
	/**
	 * 
	 * @param codigo
	 * @return obtiene un torneo por medio de un parametro  ingresado y validando sus parametros
	 * @throws MyException
	 */
	public Torneo obtener(String codigo) throws MyException;
	/**
	 * 
	 * @param codigo
	 * @param nombre
	 * @param deporte
	 * @param tipoTorneo
	 * @param usuario
	 * @return Crea y valida los datos ingresados de un torneo
	 * @throws MyException
	 */
	public Torneo crearTorneo(String codigo, String nombre, String deporte, String tipoTorneo, Usuario usuario) throws MyException;
	/**
	 * 
	 * @param codigo
	 * @param nombre
	 * @param deporte
	 * @param tipoTorneo
	 * @return un torneo y valida la informacion entrante
	 * @throws MyException
	 */
	public Torneo actualizar(String codigo,String nombre, String deporte, String tipoTorneo) throws MyException;
	/**
	 * Elimina y valida de que el torneo exista
	 * @param codigo
	 * @param usuario
	 * @throws MyException
	 */
	public void eliminar(String codigo, Usuario usuario) throws MyException;
	
}

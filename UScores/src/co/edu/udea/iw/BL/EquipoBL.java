package co.edu.udea.iw.BL;

import java.util.List;

import co.edu.udea.iw.dto.Equipo;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora de la interfaz de la logica del negocio de equipo
 */
public interface EquipoBL {
	
	/**
	 * 
	 * @return retorna la lista de equipo
	 * @throws MyException
	 */
	public List<Equipo> obtenerEquipo() throws MyException;
	
	/**
	 * 
	 * @param codigo
	 * @return retorna un solo equipo por medio de un parametro codigo
	 * @throws MyException
	 */
	public Equipo obtener(String codigo) throws MyException;
	/**
	 * 
	 * @param codigo
	 * @param nombre
	 * @param fase
	 * @param puntaje
	 * @param torneo
	 * @return Crea y retorna el equipo por medio de los  parametros ingresados
	 * @throws MyException
	 */
	public Equipo crearEquipo(String codigo, String nombre, String fase, String puntaje,Torneo torneo) throws MyException;
	
	/**
	 * 
	 * @param codigo
	 * @param nombre
	 * @param puntaje
	 * @param fase
	 * @return Actualiza y retorna el equipo por medio de los parametros a actualizar
	 * @throws MyException
	 */
	public Equipo actualizar(String codigo,String nombre, String puntaje, String fase) throws MyException;
	/**
	 * Elimina el equipo por medio del parametro ingresado
	 * @param codigo
	 * @throws MyException
	 */
	public void eliminar(String codigo) throws MyException;
}

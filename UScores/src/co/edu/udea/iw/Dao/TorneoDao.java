package co.edu.udea.iw.Dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 *Declaración de métodos al acceso de los datos del torneo en la base datos
 */
public interface TorneoDao {

	/**
	 * 
	 * @return obtiene todos los torneos de la bd 
	 * @throws MyException
	 */
	public List<Torneo> ObtenerTorneos() throws MyException;
	/**
	 * 
	 * @param codigo
	 * @return Obtiene un torneo por medio de su codigo
	 * @throws MyException
	 */
	public Torneo ObtenerTorneo(String codigo) throws MyException;
	/**
	 * 
	 * @param torneo
	 * @return Inserta un torneo creado en la bd
	 * @throws MyException
	 */
	public Torneo CrearTorneo(Torneo torneo) throws MyException;
	/**
	 * elimina un torneo de la bd
	 * @param torneo 
	 * @throws MyException
	 */
	public void EliminarTorneo(Torneo torneo) throws MyException;
	/***
	 * 
	 * @param torne o
	 * @return retorna un torneo que se modifico previamente
	 * @throws MyException
	 */
	public Torneo ModificarTorneo(Torneo torneo) throws MyException;
}

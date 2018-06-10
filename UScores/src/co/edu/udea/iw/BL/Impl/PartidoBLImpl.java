package co.edu.udea.iw.BL.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.BL.PartidoBL;
import co.edu.udea.iw.Dao.PartidoDao;
import co.edu.udea.iw.dto.Equipo;
import co.edu.udea.iw.dto.Partido;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.exception.MyException;
import co.edu.udea.iw.util.validations.Validaciones;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora de la implementacion de la interfaz PartidoBL
 */
@Transactional
public class PartidoBLImpl implements PartidoBL {

	@Autowired
	PartidoDao partidodao;
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.BL.PartidoBL#CrearPartido(java.lang.String, co.edu.udea.iw.dto.Torneo, co.edu.udea.iw.dto.Equipo, co.edu.udea.iw.dto.Equipo, java.lang.String)
	 */
	@Override
	public Partido CrearPartido(String consecutivo, Torneo torneo, Equipo equipo1, Equipo equipo2, String fase)
			throws MyException {
		
		Partido partido=null;
		try {
			if (Validaciones.isTextoVacio(consecutivo)) {
				throw new MyException("Codigo invalido");
			}
			if (Validaciones.isTextoVacio(fase)) {
				throw new MyException("Fase invalido");
			}
			if(torneo == null) {
				throw new MyException("Torneo Invalido");
			}
			if (equipo1 == null || equipo2 == null) {
				throw new MyException("Equipo invalido");
			}
			partido = new Partido();
			partido.setConsecutivo(consecutivo);
			partido.setEquipo1(equipo1);
			partido.setEquipo2(equipo2);
			partido.setTorneo(torneo);
			partido.setFase(fase);

			partidodao.CrearPartido(partido);

		} catch (MyException e) {
			e.getMessage();
		}

		return partido;
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.BL.PartidoBL#ModificarPartido(java.lang.String, int, int, java.lang.String)
	 */
	@Override
	public Partido ModificarPartido(String consecutivo, int puntaje1, int puntaje2, String fase)
			throws MyException {
		Partido partido=null;
		try {
			if(Validaciones.isTextoVacio(consecutivo)) {
				throw new MyException("Codigo invalido");
			}
			if (Validaciones.isTextoVacio(fase)) {
				throw new MyException("Fase invalido");
			}
			if(puntaje1<0 || puntaje2<0) {
				throw new MyException("Puntaje incorrento");
			}
			partido = partidodao.obtener(consecutivo);
			partido.setPuntajeEquipo1(puntaje1);
			partido.setPuntajeEquipo2(puntaje2);
			partido.setFase(fase);
			
			partidodao.ModificarPartido(partido);
			
		} catch (MyException e) {
			e.getMessage();
		}
		
		return partido;
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.BL.PartidoBL#EliminarPartido(java.lang.String)
	 */
	@Override
	public void EliminarPartido(String consecutivo) throws MyException {
		
		try {
			if(Validaciones.isTextoVacio(consecutivo)) {
				throw new MyException("Codigo incorrecto");
			}
			partidodao.EliminarPartido(partidodao.obtener(consecutivo));
		}catch(MyException e) {
			e.getMessage();
		}

	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.BL.PartidoBL#ObtenerPartidos()
	 */
	@Override
	public List<Partido> ObtenerPartidos() throws MyException {
		return partidodao.ObtenerPartidos();
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.BL.PartidoBL#obtener(java.lang.String)
	 */
	@Override
	public Partido obtener(String consecutivo) throws MyException {
		
		if (consecutivo.equals("")) {
			throw new MyException("Torneo invalido");
		}
		return partidodao.obtener(consecutivo);
	}

}

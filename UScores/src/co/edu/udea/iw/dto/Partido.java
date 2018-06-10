package co.edu.udea.iw.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora del modelo de partido
 */
@XmlRootElement
public class Partido {

	private String consecutivo;
	private Equipo equipo1;
	private Equipo equipo2;
	private Torneo torneo;
	private String fase;
	private int puntajeEquipo1;
	private int puntajeEquipo2;
	
	
	public String getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(String consecutivo) {
		this.consecutivo = consecutivo;
	}
	public Equipo getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}
	public Equipo getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}
	public Torneo getTorneo() {
		return torneo;
	}
	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public int getPuntajeEquipo1() {
		return puntajeEquipo1;
	}
	public void setPuntajeEquipo1(int puntajeEquipo1) {
		this.puntajeEquipo1 = puntajeEquipo1;
	}
	public int getPuntajeEquipo2() {
		return puntajeEquipo2;
	}
	public void setPuntajeEquipo2(int puntajeEquipo2) {
		this.puntajeEquipo2 = puntajeEquipo2;
	}
	
	
	
	
}

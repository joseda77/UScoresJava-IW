package co.edu.udea.iw.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora del modelo de Usuario
 */
@XmlRootElement
public class TorneoFavorito {

	private String nombreUsuario;
	private Torneo torneo;
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public Torneo getTorneo() {
		return torneo;
	}
	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}
	
	
	
}

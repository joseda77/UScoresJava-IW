package co.edu.udea.iw.rest;

import java.rmi.RemoteException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.research.ws.wadl.Request;

import co.edu.udea.iw.BL.EquipoBL;
import co.edu.udea.iw.BL.TorneoBL;
import co.edu.udea.iw.dto.Equipo;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.exception.MyException;

@Path("/equipo")
@Component
public class EquipoService {
	
	@Autowired
	private EquipoBL equipoBL;
	@Autowired
	private TorneoBL torneoBL;
	
	//@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Equipo> obtenerEquipos() throws RemoteException {
		List<Equipo> lista = null;
		System.out.println("Entra aqui 1");
		try {
			lista = equipoBL.obtenerEquipo();
			System.out.println("Entra aqui 2");
		} catch (MyException e) {
			System.out.println("Entra aqui 3");
			System.out.println(e.getCause().getMessage());
		}
		return lista;
	}
	
	//@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Equipo obtenerUnEquipo (@QueryParam("codigo") String codigo) throws RemoteException{
		Equipo equipo = null;
		try {
			equipo = equipoBL.obtener(codigo);
		} catch (MyException e) {
			System.out.println(e.getCause().getMessage());
		}
		return equipo;
	}



	//@POST
	@Consumes("application/json")
	public JSONObject agregarEquipo (JSONObject json) throws RemoteException, JSONException {
		Torneo torneo = null;		
		String codigo = json.getString("codigo");
		String nombre = json.getString("nombre");
		String fase = json.getString("fase");
		String puntaje = json.getString("puntaje");
		String codTorneo = json.getString("torneo");
		JSONObject jsonRes = new JSONObject();
		try {
			torneo = torneoBL.obtener(codTorneo);
			equipoBL.crearEquipo(codigo, nombre, fase, puntaje, torneo);
			jsonRes.append("Message","Equipo creado correctamente");
		} catch (MyException e) {
			System.out.println(e.getCause().getMessage());
		}
		return jsonRes;
	}
	
	
	//@PUT
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Equipo actualizarEquipo (JSONObject json, @QueryParam("codigo") String codigo) throws RemoteException, JSONException{
		String nombre = json.getString("nombre");
		String fase = json.getString("fase");
		String puntaje = json.getString("puntaje");
		Equipo equipo= null;
		try {
			equipo = equipoBL.obtener(codigo);
			if(equipo == null){
				throw new MyException("El torneo no existe!");
			}
			equipoBL.actualizar(codigo, nombre, puntaje, fase);
			equipo = equipoBL.obtener(codigo);
		} catch (MyException e) {
			System.out.println(e.getCause().getMessage());
		}
		return equipo;
	}
	
	//@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject borrarEquipo(@QueryParam("codigo") String codigo) throws RemoteException{
		JSONObject json =new JSONObject();
		try {
			equipoBL.eliminar(codigo);
			json.append("Message","Equipo eliminado correctamente");
		} catch (Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return json;
	}
}
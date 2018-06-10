package co.edu.udea.iw.rest;

import java.rmi.RemoteException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.BL.TorneoBL;
import co.edu.udea.iw.Dao.UsuarioDao;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

@Path("/torneo")
@Component
public class TorneoService {

	@Autowired
	private TorneoBL torneoBL;
	@Autowired
	private UsuarioDao dao;
	
	Torneo torneo;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Torneo> ObtenerTorneos() throws RemoteException {
		List<Torneo> listaTorneo = null;
		try {
			listaTorneo = torneoBL.obtenerTorneos();
		} catch (MyException e) {
			System.out.println("Error: " + e.getCause().getMessage());
			throw new RemoteException(e.getMessage()); //Error opcional para mostrar cualquier cosa
		}
		return listaTorneo;
	}

	@GET
	@Path("/torneo")
	@Produces(MediaType.APPLICATION_JSON)
	public Torneo ObtenerTorneos(@QueryParam("codigo") String codigo) throws RemoteException, MyException {
		System.out.println("El codigo del torneo en obtenerTorneos es: " + codigo);

		try {

			torneo = torneoBL.obtener(codigo);

		} catch (MyException e) {
			throw new RemoteException(e.getMessage());
		}
		return torneo;
	}

	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject CrearTorneo(JSONObject json) throws RemoteException, JSONException {

		String usuario = json.getString("usuario");
		String codigo = json.getString("codigo");
		String nombre = json.getString("nombre");
		String deporte = json.getString("deporte");
		String tipoTorneo = json.getString("tipoTorneo");
		JSONObject jsonRes = new JSONObject();
		try {
			Usuario user = dao.ObtenerUsuario(usuario);
			torneoBL.crearTorneo(codigo, nombre, deporte, tipoTorneo, user);
			jsonRes.put("Message","Torneo creado correctamente");
		} catch (MyException e) {
			System.out.println("El error es" + e.getCause().getMessage());
			jsonRes.put("Message","Error"+e.getCause().getMessage());
            return jsonRes;
		}
		return jsonRes;
	}

	@PUT
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject ActualizarTorneo(@QueryParam("codigo") String codigo, JSONObject json)
			throws RemoteException,JSONException {
		String nombre = json.getString("nombre");
		String deporte = json.getString("deporte");
		String tipoTorneo = json.getString("tipoTorneo");
		JSONObject jsonRes = new JSONObject();
		try {
			torneoBL.actualizar(codigo, nombre, deporte, tipoTorneo);
			jsonRes.put("Message", "Torneo actualizado correctamente");
		} catch (MyException e) {
			System.out.println(e.getCause().getMessage());
			jsonRes.put("Message","Error"+e.getCause().getMessage());
            return jsonRes;
		}
		return jsonRes;
	}
	
	@DELETE
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject EliminarTorneo(@QueryParam("codigo") String codigo, @QueryParam("usuario") String usuario)
			throws RemoteException, JSONException {
		JSONObject jsonRes = new JSONObject();
		try {
			Usuario user = dao.ObtenerUsuario(usuario);
			torneoBL.eliminar(codigo, user);
			jsonRes.put("Message", "Torneo eliminado");
		} catch (MyException e) {
			System.out.println(e.getCause().getMessage());
			jsonRes.put("Message","Error"+e.getCause().getMessage());
            return jsonRes;
		}
		return jsonRes;
	}

}

		
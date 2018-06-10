package co.edu.udea.iw.rest;

import java.rmi.RemoteException;
import java.util.ArrayList;
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

import co.edu.udea.iw.BL.PartidoBL;
import co.edu.udea.iw.Dao.EquipoDao;
import co.edu.udea.iw.Dao.TorneoDao;
import co.edu.udea.iw.Dao.Implement.EquipoDaoImpl;
import co.edu.udea.iw.Dao.Implement.TorneoDaoImpl;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.dto.Equipo;
import co.edu.udea.iw.dto.Partido;
import co.edu.udea.iw.exception.MyException;

@Path("/partido")
@Component
public class PartidoService {

	@Autowired
	private PartidoBL partidoBL;
	@Autowired
	private TorneoDao torneodao;
	@Autowired
	private EquipoDao equipodao;

	@GET
	@Path("/listapartidos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Partido> ObtenerPartidos() throws RemoteException {

		List<Partido> listaPartidos = null;

		try {
			listaPartidos = partidoBL.ObtenerPartidos();

		} catch (MyException e) {
			e.getMessage();
		}

		return listaPartidos;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Partido ObtenerPartido(@QueryParam("consecutivo") String consecutivo) throws RemoteException {

		Partido partido = null;

		try {
			partido = partidoBL.obtener(consecutivo);
		} catch (MyException e) {
			e.getMessage();
		}

		return partido;
	}

	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject CrearPartido(JSONObject json) throws RemoteException, JSONException {

//		String consecutivo = json.getString("consecutivo");
//		String itorneo = json.getString("torneo");
//		String equipo1 = json.getString("equipo1");
//		String equipo2 = json.getString("equipo2");
//		String fase = json.getString("fase");
//		JSONObject jsonRes = new JSONObject();
//		Torneo torneo = null;
//		Equipo equip1 = null;
//		Equipo equip2 = null;
//		try {
//			System.out.println(itorneo);
//			torneo = torneodao.ObtenerTorneo(itorneo);
//			equip1 = equipodao.obtener(equipo1);
//			equip2 = equipodao.obtener(equipo2);
//			partidoBL.CrearPartido(consecutivo, torneo, equip1, equip2, fase);
//			jsonRes.append("Message", "Partido creado correctamente");
//		} catch (MyException e) {
//			jsonRes.append("Message", "Error al crear partido");
//			System.out.println(e.getCause().getMessage());
//		}
		JSONObject jsonRes = new JSONObject();
		jsonRes.append("Message", "Partido creado correctamente");
		return jsonRes;
	}

	@Produces(MediaType.TEXT_PLAIN)
	@PUT
	public String ActualizarPartido(@QueryParam("consecutivo") String consecutivo, @QueryParam("puntaje1") int puntaje1,
			@QueryParam("puntaje1") int puntaje2, @QueryParam("fase") String fase) throws RemoteException {
		try {
			partidoBL.ModificarPartido(consecutivo, puntaje1, puntaje2, fase);
		} catch (MyException e) {
			return e.getMessage();
		}
		return "";
	}

	@Produces(MediaType.TEXT_PLAIN)
	// @DELETE
	public String EliminarPartido(@QueryParam("consecutivo") String consecutivo, @QueryParam("usuario") String usuario)
			throws RemoteException {
		try {
			partidoBL.EliminarPartido(consecutivo);

		} catch (MyException e) {
			return e.getMessage();
		}
		return "";
	}

}

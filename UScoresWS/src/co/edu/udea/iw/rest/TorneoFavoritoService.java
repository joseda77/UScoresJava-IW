package co.edu.udea.iw.rest;

import java.rmi.RemoteException;
import java.util.Iterator;
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
import co.edu.udea.iw.BL.TorneoBL;
import co.edu.udea.iw.BL.TorneoFavoritoBL;
import co.edu.udea.iw.Dao.UsuarioDao;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.dto.TorneoFavorito;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

@Path("/torneofavorito")
@Component
public class TorneoFavoritoService {
	@Autowired
	private TorneoFavoritoBL torneoFavoritoBL;
	@Autowired
	private UsuarioDao dao;
	@Autowired
	TorneoBL torneoBL;
	
	Torneo torneoGen;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TorneoFavorito> ObtenerTorneos(@QueryParam("usuario") String usuario) throws RemoteException {
		System.out.println(usuario);
		List<TorneoFavorito> listaTorneo = null;
		try {
			listaTorneo = torneoFavoritoBL.obtenerTorneosFavoritos(usuario);
		} catch (MyException e) {
			System.out.println("Error: " + e.getCause().getMessage());
		}
		return listaTorneo;
	}
	
	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject CrearTorneo(@QueryParam("usuario") String usuario,JSONObject json) throws RemoteException, JSONException {
		TorneoFavorito torneoAux= null;
		System.out.println(json);
		String torneo = json.getString("codigo");
		JSONObject jsonRes = new JSONObject();
		try {
			Torneo torn = torneoBL.obtener(torneo);
			torneoAux = new TorneoFavorito();
			torneoAux.setNombreUsuario(usuario);
			torneoAux.setTorneo(torn);
			Usuario user = dao.ObtenerUsuario(usuario);
			torneoFavoritoBL.agregarTorneoFavorito(torneoAux);
			jsonRes.put("Message","Torneo agregado correctamente");
		} catch (MyException e) {
			System.out.println("El error es" + e.getCause().getMessage());
			jsonRes.put("Message", e.getCause().getMessage());
			return jsonRes;
		}
		return jsonRes;
	}
	
	@DELETE
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject EliminarTorneo(@QueryParam("usuario") String usuario,@QueryParam("codigo") String codigo)
			throws RemoteException, JSONException {	
		System.out.println(codigo + usuario);
		List<TorneoFavorito> torneos = null;
		TorneoFavorito torneo= null;
		JSONObject jsonRes = new JSONObject();
		try {
			torneos =  torneoFavoritoBL.obtenerTorneosFavoritos(usuario);
			for (int i = 0; i < torneos.size(); i++) {
				System.out.println("Los torneos del usuario son:"+torneos.get(i).getTorneo().getCodigo());
				if(torneos.get(i).getTorneo().getCodigo().equals(codigo)) {
					torneo = torneos.get(i);
				}
			}
			System.out.println("CONTIENE ALGO"+torneo);
			torneoFavoritoBL.eliminar(torneo);
			jsonRes.put("Message", "Torneo Favorito eliminado");
		} catch (MyException e) {
			jsonRes.put("Message", "Error al eliminar torneo");
			System.out.println(e.getCause().getMessage());
			return jsonRes;
		}
		return jsonRes;
	}
	
}

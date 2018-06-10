package co.edu.udea.iw.rest;

import java.rmi.RemoteException;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.BL.UsuarioBL;
import co.edu.udea.iw.exception.MyException;

@Path("/usuario")
@Component 
public class UsuarioService {
	
	@Autowired
	UsuarioBL usuarioBL;
	
	
	@POST
	@Path("/login")
	@Consumes("application/json")  
    public JSONObject Validar(JSONObject json) throws RemoteException, JSONException{
        String user = json.getString("user");
        String pass = json.getString("password");
        JSONObject jsonRes = new JSONObject();
        System.out.println("Entra en usuario service "+ user + pass);
        try {
            if(usuarioBL.autenticar(user, pass).equals("Usuario Correcto")) {
            	jsonRes.put("Message","usuario autenticado");
            }else {
            	jsonRes.put("Message","usuario no autenticado");
            }
        }catch(MyException e){        	
            System.out.println("Contrase�a incorrecta"+e.getCause().getMessage());
            jsonRes.put("Message","Error"+e.getCause().getMessage());
            return jsonRes;
        }
        return jsonRes;
    }
    
	@POST
	@Path("/signup")
	@Consumes("application/json") 
    @Produces(MediaType.APPLICATION_JSON)    
    public JSONObject CrearUsuario(JSONObject json) throws RemoteException, JSONException{
        String user = json.getString("user");
        String pass = json.getString("password");
        String email = json.getString("email");
        JSONObject jsonRes = new JSONObject();
        try {
            usuarioBL.crearUsuario(user, pass, email);
            jsonRes.put("Message","Usuario registrado correctamente");
        }catch (MyException e) {        	
        	System.out.println(e.getCause().getMessage());
        	jsonRes.put("Message","Error"+e.getCause().getMessage());
        	return jsonRes;
        }
        return jsonRes;
        
    }
}

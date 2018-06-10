package co.edu.udea.iw.BL.ImplTest;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.BL.TorneoBL;
import co.edu.udea.iw.BL.TorneoFavoritoBL;
import co.edu.udea.iw.Dao.UsuarioDao;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.dto.TorneoFavorito;
import co.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:co/edu/udea/iw/SpringConfiguration/SpringConfiguration.xml")
@Transactional
public class TorneoFavoritoBLImplTest {

	@Autowired
	TorneoFavoritoBL torneoFavBL;
	@Autowired
	TorneoBL torneoBL;
	@Autowired
	UsuarioDao usuarioDao;
	
	@Test
	public void testObtenerTorneosFavoritos() {
		List<TorneoFavorito> torneos= null;
		try {
			System.out.println("Los torneos favoritos son: "+ torneos);
			torneos =torneoFavBL.obtenerTorneosFavoritos("tello");
			
			for(TorneoFavorito torneo: torneos) {
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("Torneos Favoritos: " + torneo.getTorneo().getNombre());
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			}
		} catch (MyException e) {
			e.printStackTrace();
			//fail(e.getCause().getMessage());
		}
	}

	
	@Test
	public void testAgregarTorneoFavorito() {
		TorneoFavorito torneo= null;
		try {
			Torneo torn= torneoBL.obtener("1");
			torneo = new TorneoFavorito();
			torneo.setNombreUsuario("jaidiber");
			torneo.setTorneo(torn);
			torneoFavBL.agregarTorneoFavorito(torneo);
		} catch (MyException e) {
			e.printStackTrace();
			//fail(e.getCause().getMessage());
		}
	}

	@Test
	public void testEliminar() {
		TorneoFavorito torneo= null;
		try {
			//torneo = torneoFavBL.obtenerTorneoFavorito("jaidiber");
			torneoFavBL.eliminar(torneo);
		} catch (MyException e) {
			e.printStackTrace();
			//fail(e.getCause().getMessage());
		}
	}

}

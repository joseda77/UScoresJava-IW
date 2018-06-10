package co.edu.udea.iw.Dao.ImplementTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.Dao.TorneoFavoritoDao;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.dto.TorneoFavorito;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:co/edu/udea/iw/SpringConfiguration/SpringConfiguration.xml")
@Transactional
public class TorneoFavoritoDaoImplementTest {

	@Autowired
	TorneoFavoritoDao torneofavoritodao;

	@Test
	public void testObtenerTorneosFavoritos() {
		List<TorneoFavorito> torneos = new ArrayList<TorneoFavorito>();

		try {

			torneos = torneofavoritodao.ObtenerTorneosFavoritos("tello");
			for (TorneoFavorito torneoFavorito : torneos) {
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("Torneo: " + torneoFavorito.getTorneo().getNombre());
				System.out.println("Usuario: " + torneoFavorito.getNombreUsuario());
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			}

			assertTrue(torneos.size() > 0);

		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testObtenerTorneoFavorito() {
//		TorneoFavorito torneo = null;
//
//		try {
//
//			torneo = torneofavoritodao.ObtenerTorneosFavoritos("jaidiber");
//
//			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
//			System.out.println("Torneo: " + torneo.getTorneo().getNombre());
//			System.out.println("Usuario: " + torneo.getNombreUsuario());
//			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
//
//			assertNotNull(torneo);
//		} catch (MyException e) {
//			e.printStackTrace();
//		}
	}

	@Test
	public void testCrearTorneoFavorito() {
		TorneoFavorito torneoFavorito = new TorneoFavorito();
		Usuario usuario = new Usuario();
		Torneo torneo = new Torneo();
		try {
			usuario.setNombreUsuario("jaidiber");
			torneo.setCodigo("1");
			torneoFavorito.setTorneo(torneo);
			torneoFavorito.setNombreUsuario("jaidiber");
			torneofavoritodao.CrearTorneoFavorito(torneoFavorito);

		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEliminarTorneoFavorito() {
		TorneoFavorito torneoFavorito = new TorneoFavorito();

		try {
			//torneoFavorito = torneofavoritodao.ObtenerTorneoFavorito("jaidiber");
			torneofavoritodao.EliminarTorneoFavorito(torneoFavorito);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testModificarTorneoFavorito() {
		TorneoFavorito torneoFavorito = new TorneoFavorito();

		try {
			Torneo torneo = new Torneo();
			torneo.setCodigo("2");
			//torneoFavorito = torneofavoritodao.ObtenerTorneoFavorito("jaidiber");
			torneoFavorito.setTorneo(torneo);
			torneofavoritodao.ModificarTorneoFavorito(torneoFavorito);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

}

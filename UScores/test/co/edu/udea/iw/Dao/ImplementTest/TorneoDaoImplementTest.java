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

import co.edu.udea.iw.Dao.TorneoDao;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:co/edu/udea/iw/SpringConfiguration/SpringConfiguration.xml")
@Transactional
public class TorneoDaoImplementTest {

	@Autowired
	TorneoDao torneodao;

	@Test
	public void testObtenerTorneos() {

		List<Torneo> torneos = new ArrayList<Torneo>();

		try {

			torneos = torneodao.ObtenerTorneos();
			for (Torneo torneo : torneos) {
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("Codigo: " + torneo.getCodigo());
				System.out.println("Nombre: " + torneo.getNombre());
				System.out.println("Deporte: " + torneo.getDeporte());
				System.out.println("Tipo de torneo: " + torneo.getTipoTorneo());
				System.out.println("Creador del Torneo: " + torneo.getUsuario().getNombreUsuario());
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			}

			assertTrue(torneos.size() > 0);

		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	@Test
	public void testObtenerTorneo() {
		Torneo torneo = null;

		try {

			torneo = torneodao.ObtenerTorneo("1");

			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			System.out.println("Codigo: " + torneo.getCodigo());
			System.out.println("Nombre: " + torneo.getNombre());
			System.out.println("Deporte: " + torneo.getDeporte());
			System.out.println("Tipo de torneo: " + torneo.getTipoTorneo());
			System.out.println("Creador del Torneo: " + torneo.getUsuario().getNombreUsuario());
			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");

			assertNotNull(torneo);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testCrearTorneo() {
		Torneo torneo = new Torneo();
		Usuario usuario = new Usuario();

		try {
			usuario.setNombreUsuario("jaidiber");
			torneo.setCodigo("100");
			torneo.setNombre("Eagle League");
			torneo.setDeporte("Soccer");
			torneo.setTipoTorneo("liga");
			torneo.setUsuario(usuario);
			torneodao.CrearTorneo(torneo);

		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testEliminarTorneo() {
		Torneo torneo = new Torneo();

		try {
			torneo = torneodao.ObtenerTorneo("1");
			torneodao.EliminarTorneo(torneo);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testModificarTorneo() {
		Torneo torneo = new Torneo();

		try {
			torneo = torneodao.ObtenerTorneo("1");
			torneo.setNombre("Liga Aguila");
			torneo.setTipoTorneo("copa");
			torneodao.ModificarTorneo(torneo);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}

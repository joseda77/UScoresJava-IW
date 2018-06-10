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
import co.edu.udea.iw.Dao.PartidoDao;
import co.edu.udea.iw.dto.Equipo;
import co.edu.udea.iw.dto.Partido;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:co/edu/udea/iw/SpringConfiguration/SpringConfiguration.xml")
@Transactional
public class PartidoDaoImplementTest {

	@Autowired
	PartidoDao partidodao;

	@Test
	public void testCrearPartido() {
		Partido partido = new Partido();
		Torneo torneo = new Torneo();
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();

		try {
			torneo.setCodigo("1");
			equipo1.setCodigo("1");
			equipo2.setCodigo("2");
			partido.setConsecutivo("100");
			partido.setEquipo1(equipo1);
			partido.setEquipo2(equipo2);
			partido.setFase("Octavos");
			partido.setPuntajeEquipo1(3);
			partido.setPuntajeEquipo2(2);
			partido.setTorneo(torneo);
			partidodao.CrearPartido(partido);

		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testModificarPartido() {
		Partido partido = new Partido();

		try {
			partido = partidodao.obtener("1");
			partido.setFase("final");
			partido.setPuntajeEquipo1(1);
			partido.setPuntajeEquipo2(2);
			partidodao.ModificarPartido(partido);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testEliminarPartido() {

		Partido partido = new Partido();
		try {
			partido = partidodao.obtener("1");
			partidodao.EliminarPartido(partido);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerPartidos() {
		List<Partido> partidos = new ArrayList<Partido>();

		try {

			partidos = partidodao.ObtenerPartidos();
			for (Partido partido : partidos) {
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("Consecutivo: " + partido.getConsecutivo());
				System.out.println(
						"Equipo1: " + partido.getEquipo1().getNombre() + " Puntos: " + partido.getPuntajeEquipo1());
				System.out.println(
						"Equipo2: " + partido.getEquipo2().getNombre() + " Puntos: " + partido.getPuntajeEquipo2());
				System.out.println("Torneo: " + partido.getTorneo().getNombre());
				System.out.println("Fase: " + partido.getFase());
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			}

			assertTrue(partidos.size() > 0);

		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getCause().getMessage());
		}
	}

	@Test
	public void testObtener() {
		Partido partido = new Partido();
		try {

			partido = partidodao.obtener("1");
			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			System.out.println("Consecutivo: " + partido.getConsecutivo());
			System.out.println(
					"Equipo1: " + partido.getEquipo1().getNombre() + " Puntos: " + partido.getPuntajeEquipo1());
			System.out.println(
					"Equipo2: " + partido.getEquipo2().getNombre() + " Puntos: " + partido.getPuntajeEquipo2());
			System.out.println("Torneo: " + partido.getTorneo().getNombre());
			System.out.println("Fase: " + partido.getFase());
			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");

			assertNotNull(partido);

		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

}

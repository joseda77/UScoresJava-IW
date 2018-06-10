package co.edu.udea.iw.BL.ImplTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.BL.PartidoBL;
import co.edu.udea.iw.dto.Equipo;
import co.edu.udea.iw.dto.Partido;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.exception.MyException;
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations= "classpath:co/edu/udea/iw/SpringConfiguration/SpringConfiguration.xml")
@Transactional
public class PartidoBLImplTest {

	@Autowired
	PartidoBL partidoBL;
	
	@Test
	public void testCrearPartido() {;
		Torneo torneo = new Torneo();
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();

		try {
			torneo.setCodigo("1");
			equipo1.setCodigo("1");
			equipo2.setCodigo("2");
			partidoBL.CrearPartido("1", torneo, equipo1, equipo2, "Octavos");

		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testModificarPartido() {

		try {
			partidoBL.ModificarPartido("1", 3, 4, "final");
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testEliminarPartido() {
		try {
			partidoBL.EliminarPartido("1");
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerPartidos() {
		try {
			List<Partido> partidos = new ArrayList<Partido>();
			partidos=partidoBL.ObtenerPartidos();
			assertTrue(partidos.size()>0);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtener() {
		try {
			partidoBL.obtener("1");
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}

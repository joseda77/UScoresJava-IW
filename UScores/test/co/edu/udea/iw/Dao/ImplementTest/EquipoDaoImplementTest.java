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
import co.edu.udea.iw.dto.Equipo;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.exception.MyException;
import co.edu.udea.iw.Dao.EquipoDao;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="classpath:co/edu/udea/iw/SpringConfiguration/SpringConfiguration.xml")
@Transactional
public class EquipoDaoImplementTest {

	@Autowired
	EquipoDao equipodao;

	@Test
	public void testCrearEquipo() {
		Equipo equipo = new Equipo();
		Torneo torneo = new Torneo();
		try {
			torneo.setCodigo("1");
			equipo.setCodigo("10");
			equipo.setFase("grupo");
			equipo.setNombre("DIM");
			equipo.setPuntaje("35");
			equipo.setTorneo(torneo);
			equipodao.CrearEquipo(equipo);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getCause().getMessage());
		}
	}

	@Test
	public void testModificarEquipo() {
	
		Equipo equipo = new Equipo();

		try {
			equipo = equipodao.obtener("1");
			equipo.setNombre("Nacional");
			equipo.setFase("cuartos");
			equipodao.ModificarEquipo(equipo);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testEliminarEquipo() {
		Equipo equipo = new Equipo();

		try {
			equipo = equipodao.obtener("1");
			equipodao.EliminarEquipo(equipo);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	 @Test
	public void testObternerEquipos() {
		List<Equipo> equipos = new ArrayList<Equipo>();

		try {
			equipos = equipodao.ObternerEquipos();

			for (Equipo equipo : equipos) {
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("Codigo:" + equipo.getCodigo());
				System.out.println("Nombre: " + equipo.getNombre());
				System.out.println("Fase: " + equipo.getFase());
				System.out.println("Puntaje: " + equipo.getPuntaje());
				System.out.println("Torneo: " + equipo.getTorneo().getNombre());
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			}
			assertTrue(equipos.size() > 0);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getCause().getMessage());
		}
	}

	@Test
	public void testObtener() {
		Equipo equipo = null;

		try {

			equipo = equipodao.obtener("1");

			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			System.out.println("Codigo:" + equipo.getCodigo());
			System.out.println("Nombre: " + equipo.getNombre());
			System.out.println("Fase: " + equipo.getFase());
			System.out.println("Puntaje: " + equipo.getPuntaje());
			System.out.println("Torneo: " + equipo.getTorneo().getNombre());
			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");

			assertNotNull(equipo);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}

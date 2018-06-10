package co.edu.udea.iw.BL.ImplTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.BL.TorneoBL;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:co/edu/udea/iw/SpringConfiguration/SpringConfiguration.xml")
@Transactional
public class TorneoBLImplTest {

	@Autowired
	TorneoBL torneoBL;

	@Test
	public void testObtenerTorneos() {
		try {
			torneoBL.obtenerTorneos();
		} catch (MyException e) {
			fail(e.getCause().getMessage());
		}
	}

	@Test
	public void testObtener() {
		try {
			torneoBL.obtener("1");
		} catch (MyException e) {
			fail(e.getCause().getMessage());
		}
	}

	@Test
	public void testCrearTorneo() {
		try {

			Usuario user = new Usuario();
			user.setContrasena("jaidiber");
			user.setNombreUsuario("jaidiber");

			torneoBL.crearTorneo("35", "Alianza", "Futbol", "45", user);
		} catch (MyException e) {
			fail(e.getCause().getMessage());
		}
	}

	@Test
	public void testActualizar() {
		try {
			torneoBL.actualizar("1","Champions2","Futsal", "Copa");
		} catch (MyException e) {
			fail(e.getCause().getMessage());
		}
	}

	@Test
	public void testEliminar() {
		try {
			Usuario user = new Usuario();
			user.setContrasena("jaidiber");
			user.setNombreUsuario("jaidiber");
			torneoBL.eliminar("1",user);
		} catch (MyException e) {
			fail(e.getCause().getMessage());
		}
	}

}

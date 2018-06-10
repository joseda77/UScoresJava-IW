package co.edu.udea.iw.BL.ImplTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.BL.EquipoBL;
import co.edu.udea.iw.BL.TorneoBL;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:co/edu/udea/iw/SpringConfiguration/SpringConfiguration.xml")
@Transactional
public class EquipoBLImplTest {
	@Autowired
	EquipoBL equipoBl;
	@Autowired
	TorneoBL torneoBL;
	
	@Test
	public void testObtenerEquipo() {
		try {
			equipoBl.obtenerEquipo();
		} catch (MyException e) {
			fail(e.getCause().getMessage());
		}
	}

	@Test
	public void testObtener() {
		try {
			equipoBl.obtener("1");
		} catch (MyException e) {
			fail(e.getCause().getMessage());
		}
	}

	@Test
	public void testCrearEquipo() {
		try {
		Torneo torneo = torneoBL.obtener("1");		
		equipoBl.crearEquipo("54", "DIM", "10", "100", torneo);
		}catch (MyException e) {
			e.printStackTrace();
			fail(e.getCause().getMessage());
			
		}
	}

	@Test
	public void testActualizar() {
		try {
			equipoBl.actualizar("1", "Medallo","32", "Todos");
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getCause().getMessage());
		}
	}

	@Test
	public void testEliminar() {
		try {
			equipoBl.eliminar("2");
		} catch (MyException e) {
			fail(e.getCause().getMessage());
		}
	}

}

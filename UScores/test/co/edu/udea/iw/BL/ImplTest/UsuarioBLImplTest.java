package co.edu.udea.iw.BL.ImplTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.BL.UsuarioBL;
import co.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations= "classpath:co/edu/udea/iw/SpringConfiguration/SpringConfiguration.xml")
@Transactional
public class UsuarioBLImplTest {

	@Autowired
	UsuarioBL usuarioBL;

	@Test
	public void testAutenticar() {
		try {

			usuarioBL.autenticar("jaidiber", "jaidiber");

		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getCause().getMessage());
		}
	}
	
	
	@Test
	public void testCrearUsuario() {
		try {
			usuarioBL.crearUsuario("leon", "laflor", "libresoy@laflor.org");
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getCause().getMessage());
		}
	}

}

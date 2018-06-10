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

import co.edu.udea.iw.Dao.UsuarioDao;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:co/edu/udea/iw/SpringConfiguration/SpringConfiguration.xml")
@Transactional
public class UsuarioDaoImplementTest {

	@Autowired
	UsuarioDao usuariodao;

	@Test
	public void testObtener() {

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			usuarios = usuariodao.ObtenerUsuarios();
			for (Usuario usuario : usuarios) {
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("Nomre Usuario: " + usuario.getNombreUsuario());
				System.out.println("Contrase�a: " + usuario.getContrasena());
				System.out.println("Email: " + usuario.getEmail());
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			}

			assertTrue(usuarios.size() > 0);

		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerString() {

		Usuario usuario = null;

		try {
			
			usuario = usuariodao.ObtenerUsuario("tello");

			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			System.out.println("Nomre Usuario: " + usuario.getNombreUsuario());
			System.out.println("Contrase�a: " + usuario.getContrasena());
			System.out.println("Email: " + usuario.getEmail());
			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");

			assertNotNull(usuario);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	@Test
	public void testCrearUsuario() {
		Usuario usuario = new Usuario();

		try {

			usuario.setNombreUsuario("pepe");
			usuario.setContrasena("casa");
			usuario.setEmail("pepe@gmail.com");

			usuariodao.CrearUsuario(usuario);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testModificarUsuario() {
		Usuario usuario = new Usuario();

		try {
			usuario = usuariodao.ObtenerUsuario("jaidiber");
			usuario.setContrasena("casfaa");
			usuario.setEmail("pedpe@gail.com");
			usuariodao.ModificarUsuario(usuario);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	@Test
	public void testEliminarUsuario() {
		Usuario usuario = new Usuario();

		try {
			usuario = usuariodao.ObtenerUsuario("jaidiber");
			usuariodao.EliminarUsuario(usuario);
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}

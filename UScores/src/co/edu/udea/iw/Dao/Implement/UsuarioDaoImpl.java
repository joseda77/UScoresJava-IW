package co.edu.udea.iw.Dao.Implement;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.Dao.UsuarioDao;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora de la implementacion de la interfaz UsuarioDAO, explicados previamente en su interfaz
 */
@Transactional
public class UsuarioDaoImpl extends HibernateDaoSupport implements UsuarioDao {
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.UsuarioDao#ObtenerUsuarios()
	 */
	@Override
	public List<Usuario> ObtenerUsuarios() throws MyException {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Session session=null;
		try{
			session = this.getSessionFactory().getCurrentSession();
			
			Criteria criteria = session.createCriteria(Usuario.class);
			
			usuarios = criteria.list();
		}catch(HibernateException e){
			throw new MyException(e);
		}		
		return usuarios;
		
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.UsuarioDao#ObtenerUsuario(java.lang.String)
	 */
	@Override
	public Usuario ObtenerUsuario(String nombreUsuario) throws MyException {
		Usuario usuario = null;

		try{
			Session session = this.getSessionFactory().getCurrentSession();
			
			usuario = (Usuario)session.get(Usuario.class, nombreUsuario);

		}catch(HibernateException e){
			throw new MyException(e);
		}
		
		return usuario;

	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.UsuarioDao#CrearUsuario(co.edu.udea.iw.dto.Usuario)
	 */
	@Override
	public Usuario CrearUsuario(Usuario usuario) throws MyException {

		Session session = null;
		
		try {
			session = this.getSessionFactory().getCurrentSession();
			session.save(usuario);
			
		} catch (HibernateException e) {
			throw new MyException(e);
		}
		
		return usuario;

	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.UsuarioDao#ModificarUsuario(co.edu.udea.iw.dto.Usuario)
	 */
	@Override
	public Usuario ModificarUsuario(Usuario usuario) throws MyException {

		Session session = null;
		
		try {
			session = this.getSessionFactory().getCurrentSession();
			session.update(usuario);
			
		} catch (HibernateException e) {
			throw new MyException(e);
		}
		
		
		return usuario;
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.UsuarioDao#EliminarUsuario(co.edu.udea.iw.dto.Usuario)
	 */
	@Override
	public void EliminarUsuario(Usuario usuario) throws MyException {
		
		Session session = null;
		
		try {
			session = this.getSessionFactory().getCurrentSession();
			
			session.delete(usuario);
			
		} catch (HibernateException e) {
			throw new MyException(e);
		}
		
	}

}

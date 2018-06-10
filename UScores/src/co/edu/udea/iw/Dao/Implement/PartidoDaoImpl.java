package co.edu.udea.iw.Dao.Implement;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.Dao.PartidoDao;
import co.edu.udea.iw.dto.Partido;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora de la implementacion de la interfaz PartidoDAO, explicados previamente en su interfaz
 */
@Transactional
public class PartidoDaoImpl extends HibernateDaoSupport implements PartidoDao {
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.PartidoDao#CrearPartido(co.edu.udea.iw.dto.Partido)
	 */
	@Override
	public Partido CrearPartido(Partido partido) throws MyException {
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
			session.save(partido);
		} catch (HibernateException e) {
			throw new MyException(e);
		}
		return partido;
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.PartidoDao#ModificarPartido(co.edu.udea.iw.dto.Partido)
	 */
	@Override
	public Partido ModificarPartido(Partido partido) throws MyException {
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
			session.update(partido);
		} catch (HibernateException e) {
			throw new MyException(e);
		}
		return partido;
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.PartidoDao#EliminarPartido(co.edu.udea.iw.dto.Partido)
	 */
	@Override
	public void EliminarPartido(Partido partido) throws MyException {
		Session session = null;

		try {
			session = this.getSessionFactory().getCurrentSession();
			session.delete(partido);

		} catch (HibernateException e) {
			throw new MyException(e);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.PartidoDao#ObtenerPartidos()
	 */
	@Override
	public List<Partido> ObtenerPartidos() throws MyException {
		List<Partido> partidos = new ArrayList<Partido>();
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();

			Criteria criteria = session.createCriteria(Partido.class);

			partidos = criteria.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		}

		return partidos;
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.PartidoDao#obtener(java.lang.String)
	 */
	@Override
	public Partido obtener(String consecutivo) throws MyException {
		Partido partido = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
			partido = (Partido) session.get(Partido.class, consecutivo);

		} catch (HibernateException e) {
			throw new MyException(e);
		}

		return partido;
	}

}

package co.edu.udea.iw.Dao.Implement;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.Dao.TorneoDao;
import co.edu.udea.iw.dto.Torneo;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora de la implementacion de la interfaz TorneoDAO, explicados previamente en su interfaz
 */
//@Transactional
public class TorneoDaoImpl extends HibernateDaoSupport implements TorneoDao {
	@SuppressWarnings("unchecked")
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.TorneoDao#ObtenerTorneos()
	 */
	@Override
	public List<Torneo> ObtenerTorneos() throws MyException {

		List<Torneo> torneos = new ArrayList<Torneo>();
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();

			Criteria criteria = session.createCriteria(Torneo.class);
			torneos = criteria.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		}

		return torneos;
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.TorneoDao#ObtenerTorneo(java.lang.String)
	 */
	@Override
	public Torneo ObtenerTorneo(String codigo) throws MyException {

		Torneo torneo = null;
		try {

			System.out.println("dao impl antes de session"+codigo);
			Session session = this.getSessionFactory().getCurrentSession();

			System.out.println("dao impl despues de session");
			torneo = (Torneo) session.get(Torneo.class, codigo);

		} catch (HibernateException e) {
			throw new MyException(e);
		}

		return torneo;
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.TorneoDao#CrearTorneo(co.edu.udea.iw.dto.Torneo)
	 */
	@Override
	public Torneo CrearTorneo(Torneo torneo) throws MyException {

		Session session = null;

		try {
			System.out.println("dao impl antes de session");
			session = this.getSessionFactory().getCurrentSession();

			System.out.println("dao impl despues de session");
			session.save(torneo);
		
		} catch (HibernateException e) {
			throw new MyException(e);
		}

		return torneo;

	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.TorneoDao#EliminarTorneo(co.edu.udea.iw.dto.Torneo)
	 */
	@Override
	public void EliminarTorneo(Torneo torneo) throws MyException {
		Session session = null;

		try {
			session = this.getSessionFactory().getCurrentSession();
			session.delete(torneo);
		
		} catch (HibernateException e) {
			throw new MyException(e);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.TorneoDao#ModificarTorneo(co.edu.udea.iw.dto.Torneo)
	 */
	@Override
	public Torneo ModificarTorneo(Torneo torneo) throws MyException {
		Session session = null;

		try {
			session = this.getSessionFactory().getCurrentSession();
			session.update(torneo);
		
		} catch (HibernateException e) {
			throw new MyException(e);
		}

		return torneo;
	}

}

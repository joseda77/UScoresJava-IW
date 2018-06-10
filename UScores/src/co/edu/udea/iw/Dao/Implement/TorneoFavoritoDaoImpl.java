package co.edu.udea.iw.Dao.Implement;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.Dao.TorneoFavoritoDao;
import co.edu.udea.iw.dto.TorneoFavorito;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora de la implementacion de la interfaz TorneoFavoritoDAO, explicados previamente en su interfaz
 */
@Transactional
public class TorneoFavoritoDaoImpl extends HibernateDaoSupport implements TorneoFavoritoDao {

	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.TorneoFavoritoDao#ObtenerTorneosFavoritos()
	 */
	@Override
	public List<TorneoFavorito> ObtenerTorneosFavoritos(String nombreUsuario) throws MyException {
		List<TorneoFavorito> torneosfavoritos = new ArrayList<TorneoFavorito>();
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();

			Criteria criteria = session.createCriteria(TorneoFavorito.class).add(Restrictions.eq("nombreUsuario",  nombreUsuario));
			torneosfavoritos = criteria.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		}

		return torneosfavoritos;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.TorneoFavoritoDao#CrearTorneoFavorito(co.edu.udea.iw.dto.TorneoFavorito)
	 */
	@Override
	public TorneoFavorito CrearTorneoFavorito(TorneoFavorito torneofavorito) throws MyException {
		Session session = null;

		try {
			session = this.getSessionFactory().getCurrentSession();
			session.save(torneofavorito);
		
		} catch (HibernateException e) {
			throw new MyException(e);
		}

		return torneofavorito;
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.TorneoFavoritoDao#EliminarTorneoFavorito(co.edu.udea.iw.dto.TorneoFavorito)
	 */
	@Override
	public void EliminarTorneoFavorito(TorneoFavorito torneofavorito) throws MyException {
		Session session = null;

		try {
			session = this.getSessionFactory().getCurrentSession();
			session.delete(torneofavorito);
		
		} catch (HibernateException e) {
			throw new MyException(e);
		}

	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.TorneoFavoritoDao#ModificarTorneoFavorito(co.edu.udea.iw.dto.TorneoFavorito)
	 */
	@Override
	public TorneoFavorito ModificarTorneoFavorito(TorneoFavorito torneofavorito) throws MyException {
		Session session = null;

		try {
			session = this.getSessionFactory().getCurrentSession();
			session.update(torneofavorito);
		
		} catch (HibernateException e) {
			throw new MyException(e);
		}

		return torneofavorito;
	}

}

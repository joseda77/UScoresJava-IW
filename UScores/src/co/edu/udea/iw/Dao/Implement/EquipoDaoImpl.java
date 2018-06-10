package co.edu.udea.iw.Dao.Implement;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.Dao.EquipoDao;
import co.edu.udea.iw.dto.Equipo;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Jose David Tello - Jaidiber Vanegas
 * 	
 * Clase contenedora de la implementacion de la interfaz EquipoDAO, cada metodo explicado en su interfaz (EquipoDao)
 */
@Transactional
public class EquipoDaoImpl extends HibernateDaoSupport implements EquipoDao {

	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.EquipoDao#CrearEquipo(co.edu.udea.iw.dto.Equipo)
	 */
	@Override
	public Equipo CrearEquipo(Equipo equipo) throws MyException {
		Session session = null;
		session = this.getSessionFactory().getCurrentSession();
		
		session.save(equipo);
		return equipo;
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.EquipoDao#ModificarEquipo(co.edu.udea.iw.dto.Equipo)
	 */
	@Override
	public Equipo ModificarEquipo(Equipo equipo) throws MyException {
		Session session = null;
		session = this.getSessionFactory().getCurrentSession();
		session.update(equipo);
		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.EquipoDao#EliminarEquipo(co.edu.udea.iw.dto.Equipo)
	 */
	@Override
	public void EliminarEquipo(Equipo equipo) throws MyException {
		Session session = null;

		try {
			session = this.getSessionFactory().getCurrentSession();
			session.delete(equipo);

		} catch (HibernateException e) {
			throw new MyException(e);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.EquipoDao#ObternerEquipos()
	 */
	@Override
	public List<Equipo> ObternerEquipos() throws MyException {
		List<Equipo> equipos = new ArrayList<Equipo>();
		Session session =  null;
		try {
		session = this.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Equipo.class);
		equipos =criteria.list();
		}catch (HibernateException e) {
			throw new MyException(e);
		}
		return equipos;		
	}
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.Dao.EquipoDao#obtener(java.lang.String)
	 */
	@Override
	public Equipo obtener(String codigo) throws MyException {
		Equipo equipo = null;
		Session session = null;
		try {
			session = this.getSessionFactory().getCurrentSession();
			
		equipo = (Equipo) session.get(Equipo.class, codigo);
		
		}catch(HibernateException e) {
			throw new MyException(e);
		}
		return equipo;
	}

}


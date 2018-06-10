package co.edu.udea.iw.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.udea.iw.exception.MyException;

public class HibernateSessionFactory {
	
	private static HibernateSessionFactory instancia = null;
	private static SessionFactory sessionFactory = null;
	private static Configuration configuration = new Configuration();
	
	private HibernateSessionFactory(){
		
	}
	
	public static HibernateSessionFactory getInstancia(){
		if(instancia == null){
			instancia = new HibernateSessionFactory();
		}
		return instancia;
	}
	
	public Session getSession() throws MyException{
		
		try{
			if(sessionFactory == null){
				configuration.configure("co/edu/udea/iw/dao/cnf/hibernate.cfg.xml");
				
				sessionFactory = configuration.buildSessionFactory();
			}
			
			return sessionFactory.openSession();
			
			
		}catch(HibernateException e){
			throw new MyException(e);
		}
		
	}

}

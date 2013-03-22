package br.com.amigooo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.amigooo.model.Establishment;
import br.com.amigooo.util.HibernateUtil;

public class EstablishmentImpl extends GenericHibernate<Establishment> implements EstablishmentDao{

	@Override
	public Establishment getEstablishment(Integer id) {
		Establishment establishment = null;
		Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			establishment = (Establishment) session.get(Establishment.class, id);
			session.flush();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return establishment;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Establishment> getEstablishmentList() {
		List<Establishment> establishments = null;
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			establishments = session.createQuery("from Establishment").list();
			session.flush();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
        return establishments;
	}

}

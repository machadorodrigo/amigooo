package br.com.amigooo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.amigooo.model.AccessRequest;
import br.com.amigooo.util.HibernateUtil;

public class AccessRequestImpl extends GenericHibernate<AccessRequest> implements AccessRequestDao{

	@Override
	public AccessRequest getAccessRequest(String registration) {
		AccessRequest accessRequest = null;
		Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			accessRequest = (AccessRequest) session.get(AccessRequest.class, registration);
			session.flush();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return accessRequest;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccessRequest> getAccessRequestList() {
		List<AccessRequest> accessRequests = null;
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			accessRequests = session.createQuery("from AccessRequest").list();
			session.flush();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
        return accessRequests;
	}

}

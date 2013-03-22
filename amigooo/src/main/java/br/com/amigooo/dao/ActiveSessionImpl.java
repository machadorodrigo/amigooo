package br.com.amigooo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.amigooo.model.ActiveSession;
import br.com.amigooo.util.HibernateUtil;

public class ActiveSessionImpl extends GenericHibernate<ActiveSession> implements ActiveSessionDao{

	@Override
	public ActiveSession getActiveSession(Integer id) {
		ActiveSession activeSession = null;
		Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			activeSession = (ActiveSession) session.get(ActiveSession.class, id);
			session.flush();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return activeSession;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActiveSession> getActiveSessionList() {
		List<ActiveSession> activeSessions = null;
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			activeSessions = session.createQuery("from ActiveSession").list();
			session.flush();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
        return activeSessions;
	}

}

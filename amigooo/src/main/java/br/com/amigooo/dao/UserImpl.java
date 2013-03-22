package br.com.amigooo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.amigooo.model.User;
import br.com.amigooo.util.HibernateUtil;

public class UserImpl extends GenericHibernate<User> implements UserDao{
	
	@Override
	public User getUser(String registration) {
		User user = null;
		Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			user = (User) session.get(User.class, registration);
			session.flush();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return user;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersList() {
		List<User> users = null;
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			users = session.createQuery("from User").list();
			session.flush();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
        return users;
    }
}

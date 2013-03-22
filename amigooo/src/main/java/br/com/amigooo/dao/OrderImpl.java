package br.com.amigooo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.amigooo.model.Order;
import br.com.amigooo.util.HibernateUtil;

public class OrderImpl extends GenericHibernate<Order> implements OrderDao{

	@Override
	public Order getOrder(Integer id) {
		Order oder = null;
		Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			oder = (Order) session.get(Order.class, id);
			session.flush();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return oder;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrderList() {
		List<Order> order = null;
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			order = session.createQuery("from Order").list();
			session.flush();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
        return order;
	}
}
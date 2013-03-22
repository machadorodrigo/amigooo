package br.com.amigooo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.amigooo.model.Item;
import br.com.amigooo.util.HibernateUtil;

public class ItemImpl extends GenericHibernate<Item> implements ItemDao {

	@Override
	public Item getItem(Integer id) {
		Item item = null;
		Session session = null;

		try{
			session = HibernateUtil.getSessionFactory().openSession();
			item = (Item) session.get(Item.class, id);
			session.flush();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getItemList() {
		List<Item> item = null;
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			item = session.createQuery("from Item").list();
			session.flush();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
        return item;
	}

}
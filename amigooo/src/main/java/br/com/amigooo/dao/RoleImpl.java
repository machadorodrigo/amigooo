package br.com.amigooo.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.amigooo.model.Role;
import br.com.amigooo.util.HibernateUtil;

public class RoleImpl extends GenericHibernate<Role> implements RoleDao{
	
	@Override
	public Role getRole(String name) {
		Role role = null;
		Session session = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			role = (Role) session.get(Role.class, name);
			session.flush();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return role;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Role> getRolesByList(String name) {
        Session session = null;
        List<Role> roles = null;
        Set<Role> roleSet = null;
        try{
        	session = HibernateUtil.getSessionFactory().openSession();
        	org.hibernate.Query query = session.createQuery("from Role where name in ("+name+")");
        	roles = query.list();
        	roleSet = new HashSet<Role>(roles);
        }catch(HibernateException e){
        	e.printStackTrace();
        }finally{
        	session.close();
        }
        
        return  roleSet;
    }
	
}

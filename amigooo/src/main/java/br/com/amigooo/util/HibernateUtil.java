package br.com.amigooo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.amigooo.model.AccessRequest;
import br.com.amigooo.model.ActiveSession;
import br.com.amigooo.model.Establishment;
import br.com.amigooo.model.Item;
import br.com.amigooo.model.Order;
import br.com.amigooo.model.Role;
import br.com.amigooo.model.User;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	private HibernateUtil() {}

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				configuration.configure("/hibernate.cfg.xml");

				serviceRegistry = new ServiceRegistryBuilder().applySettings(
						configuration.getProperties()).buildServiceRegistry();

				configuration.addAnnotatedClass(AccessRequest.class);
				configuration.addAnnotatedClass(ActiveSession.class);
				configuration.addAnnotatedClass(Establishment.class);
				configuration.addAnnotatedClass(Item.class);
				configuration.addAnnotatedClass(Order.class);
				configuration.addAnnotatedClass(Role.class);
				configuration.addAnnotatedClass(User.class);

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				SchemaExport se = new SchemaExport(configuration);
//				se.create(true, true);
				se.execute(true, false, false, true);
			} catch (Throwable ex) {
				throw new ExceptionInInitializerError(ex);
			}

			return sessionFactory;

		} else {
			return sessionFactory;
		}
	}

//	public static void main(String[] args) {
//		HibernateUtil.getSessionFactory();
//		
//		Extract extract = new Extract();
//		extract.setCategory("Despesa");
//		extract.setDate(new Date());
//		extract.setDescription("AAA");
//		extract.setType(0);
//		extract.setValue(1.99);
//		
//		ExtractImpl extractImpl = new ExtractImpl();
//		
//		extractImpl.save(extract);
//	}
}

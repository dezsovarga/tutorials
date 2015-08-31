package net.dezso.varga.listener;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by dezso.varga on 3/3/2015.
 */
@WebListener
public class LocalEntityManagerFactory implements ServletContextListener {
	private static EntityManagerFactory emf;

	public void contextInitialized(ServletContextEvent event) {
		emf = Persistence.createEntityManagerFactory("jpa-example");
	}
	public void contextDestroyed(ServletContextEvent event) {
		emf.close();
	}
	public static EntityManager createEntityManager() {
		if (emf == null) {
			throw new IllegalStateException("Context is not initialized yet.");
		}
		return emf.createEntityManager();
	}
}

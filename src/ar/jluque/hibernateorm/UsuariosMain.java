package ar.jluque.hibernateorm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UsuariosMain {

	public static void main(String[] args) {

		Usuarios usuario = new Usuarios("Julio", "julio.a.luque@gmail.com", "aaabvva");

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuarios.class)
				.buildSessionFactory();

		try {
			Session ss = sf.openSession();
			ss.beginTransaction();
			ss.save(usuario);
			ss.getTransaction().commit();
			ss.close();
		} finally {
			sf.close();
		}
	}

}

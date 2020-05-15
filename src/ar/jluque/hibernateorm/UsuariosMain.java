package ar.jluque.hibernateorm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UsuariosMain {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuarios.class)
				.buildSessionFactory();

		Session ss = sf.openSession();

		try {
			ss.beginTransaction();
			Usuarios user = new Usuarios("Luisito", "luisito@gmail.com", "12345");
			ss.save(user);
			ss.getTransaction().commit();
			System.out.println(">>>>> Commit Save Id : " + user.getId());

			ss.beginTransaction();

			ss.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("XXXXX Error en la transaccion...");
			e.printStackTrace();

		} finally {
			System.out.println("||||| CERRANDO CONEXIONES");
			ss.close();
			sf.close();

		}
	}

}

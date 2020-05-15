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
			Usuarios user = new Usuarios("Julio", "julio.a.luque@gmail.com", "aaabvva");
			ss.save(user);
			ss.getTransaction().commit();
			System.out.println(">>>>> Commit Save Id : " + user.getId());
			
			ss.beginTransaction();
			Usuarios userDB = ss.get(Usuarios.class, user.getId());
			ss.getTransaction().commit();
			System.out.println("<<<<< Commit Get :" + userDB);
			
		} catch(Exception e)
		{
			System.out.println("XXXXX Error en la transaccion...");
			e.printStackTrace();
		} finally {
			ss.close();
			sf.close();
		}
	}

}

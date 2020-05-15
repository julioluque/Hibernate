package ar.jluque.hibernateorm;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UsuariosMain {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuarios.class)
				.buildSessionFactory();

		Session ss = sf.openSession();

		try {

//			TRANSACCION DE UNA LISTA DE OBJETOS
			ss.beginTransaction();

			List<Usuarios> ListaUsuarios = new ArrayList<Usuarios>();
			for (int i = 1; i <= 400; i++) {
				int iuser = (int) (Math.random() * 1000);
				ListaUsuarios.add(new Usuarios("Usuario_A00" + iuser + "_" + i, "cuenta." + i + ".jldev@gmail.com",
						"A1" + iuser + "Z"));
			}

			for (Usuarios u : ListaUsuarios)
				ss.save(u);

			System.out.println(">>>>> Commit Save " + ListaUsuarios.size() + " ids");
			ss.getTransaction().commit();

			
//			RECUPERANDO LA LISTA COMPLETA DE LA BASE DE DATOS
			ss.beginTransaction();
			List<Usuarios> ListaUsuariosDB = ss.createQuery("from Usuarios").getResultList();
			for (Usuarios uDB : ListaUsuariosDB) {
				System.out.println(uDB);
			}
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

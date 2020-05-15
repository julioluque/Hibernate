package ar.jluque.hibernateorm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientesMain {

	public static void main(String[] args) {

//		1 -> CREAMOS SESSION FACTORY
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class)
				.buildSessionFactory();

//		2 -> CREAMOS OBJETO TIPO SESSION
		Session miSession = miFactory.openSession();

		try {
			
//		3 -> CREAMOS OBJETO CLIENTE
			Clientes cliente1 = new Clientes("Julio", "Luque", "Pipino");
			
//		4 -> EJECUTAMOS TRANSACCION SQL
			miSession.beginTransaction();
			
//		5 -> GUARDAMOS EN BASE DE DATOS
			miSession.save(cliente1);
			
//		6 -> COMMIT / ROLLBACK 
			miSession.getTransaction().commit();
			
//			System.out.println("+ Registro insertado en base de datos...: " + cliente1.getId());
		
			
//		7 -> LECTURA DE BASE DE DATOS
			miSession.beginTransaction();
			Clientes cl = miSession.get(Clientes.class, cliente1.getId());
			System.out.println(cl);
			miSession.getTransaction().commit();
			
			miSession.close();
			
		} catch (Exception e) {
			System.out.println("XXXXXXXXXX Error en la transaccion");
			e.printStackTrace();
			
		} finally {
			
			miFactory.close();
		}


	}

}

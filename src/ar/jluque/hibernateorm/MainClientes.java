package ar.jluque.hibernateorm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClientes {

	public static void main(String[] args) {

//		1 -> CREAMOS SESSION FACTORY
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class)
				.buildSessionFactory();

//		2 -> CREAMOS OBJETO TIPO SESSION
		Session miSession = miFactory.openSession();

		try {
			
//		3 -> CREAMOS OBJETO CLIENTE
			Clientes cliente1 = new Clientes("Julio", "Luque", "Cuevas");
			
//		4 -> EJECUTAMOS TRANSACCION SQL
			miSession.beginTransaction();
			
//		5 -> GUARDAMOS EN BASE DE DATOS
			miSession.save(cliente1);
			
//		6 -> COMMIT / ROLLBACK 
			miSession.getTransaction().commit();
			
			System.out.println("++ Registro insertado en base de datos...");
		
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			miSession.close();
		}


	}

}

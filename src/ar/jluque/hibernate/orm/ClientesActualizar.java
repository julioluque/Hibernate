package ar.jluque.hibernate.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientesActualizar {

	public static void main (String [] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session ss = sf.openSession();
		
		try {
			
			// Actualizacion usando POO
			ss.beginTransaction();
			int clienteId = 16;
			Cliente cliente =ss.get(Cliente.class, clienteId); 
			cliente.setNombre("Joaquin");
			cliente.setApellidos("Borgogna 332");
			ss.getTransaction().commit();
			System.out.println("Registro actualizado por POO");
			
			
			// Actualizacion usando HQL
			ss.beginTransaction();
			ss.createQuery("update Cliente set apellidos ='Podesta' where Id = 15").executeUpdate();
			ss.createQuery("update Cliente set nombre ='Luisana' where Apellidos LIKE 'P%'").executeUpdate();
			ss.getTransaction().commit();
			System.out.println("Registro actualizado por HQL");
			
			
			
			// Eliminar usando POO
			ss.beginTransaction();
			int IdRemove = 12;
			Cliente cliente2 = ss.get(Cliente.class, IdRemove);
			ss.remove(cliente2);
			ss.getTransaction().commit();
			System.out.println("Registro eliminado por POO");
			
			
			// Eliminar usando HQL
			ss.beginTransaction();
			ss.createQuery("delete Cliente where Id = 16").executeUpdate();
			ss.getTransaction().commit();
			System.out.println("Registro Eliminado por Query");
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			ss.close();
			sf.close();
		}
		
	}
}

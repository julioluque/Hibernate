package ar.jluque.hibernate.orm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientesActualizar {

	public static void main (String [] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session ss = sf.openSession();
		
		try {
			
			ss.beginTransaction();
			int idRead = 1;
			Cliente clienteRead = ss.get(Cliente.class, idRead);
			ss.getTransaction().commit();
			System.out.println("Consulta realizada por POO");
			System.out.println(clienteRead);
			System.out.println("-----------");
			
			// Actualizacion usando POO
			ss.beginTransaction();
			int idUpdate = 16;
			Cliente clienteUpdate =ss.get(Cliente.class, idUpdate); 
			clienteUpdate.setNombre("Joaquin");
			clienteUpdate.setApellidos("Borgogna 332");
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
			int IdDelete = 12;
			Cliente clienteDelete = ss.get(Cliente.class, IdDelete);
			ss.remove(clienteDelete);
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

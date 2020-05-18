package ar.jluque.hibernate.orm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientesConsultar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory clientesFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session miSession = clientesFactory.openSession();

		try {
			miSession.beginTransaction();

			System.out.println("CONSULTA CLIENTES COMPLETO");
			List<Cliente> clientesList = miSession.createQuery("from Clientes").getResultList();
			getClientesListDB(clientesList);

			System.out.println("<<<<<< CRITERIA CONSULTAS: ALIAS CONSULTA APELLIDOS LUQUE");
			clientesList = miSession.createQuery("from Clientes cl where cl.apellidos='Luque'").getResultList();
			getClientesListDB(clientesList);

			System.out.println("<<<<<< CRITERIA CONSULTAS: OPERADORES LOGICOS - CONSULTA DIRECCION ALIANZA");
			clientesList = miSession.createQuery("from Clientes cl where cl.apellidos='Luque' and cl.direccion='Alianza'").getResultList();
			getClientesListDB(clientesList);

			miSession.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			miSession.close();
			clientesFactory.close();
		}
	}

	private static void getClientesListDB(List<Cliente> clientesList) {
		for (Cliente clientes : clientesList) {
			System.out.println(clientes);
		}
	}

}

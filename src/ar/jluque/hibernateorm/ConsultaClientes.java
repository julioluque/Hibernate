package ar.jluque.hibernateorm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory clientesFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Clientes.class).buildSessionFactory();
		Session miSession = clientesFactory.openSession();

		try {
			miSession.beginTransaction();

			System.out.println("CONSULTA CLIENTES COMPLETO");
			List<Clientes> clientesList = miSession.createQuery("from Clientes").getResultList();
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

	private static void getClientesListDB(List<Clientes> clientesList) {
		for (Clientes clientes : clientesList) {
			System.out.println(clientes);
		}
	}

}

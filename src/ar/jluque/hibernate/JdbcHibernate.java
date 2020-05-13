package ar.jluque.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcHibernate {
	
	public static void main (String [] args) {
		
		String url = "jdbc:mysql://localhost:3306/springhibernate?useSSL=false";
		String user = "root";
		String password = "1234";
		
//		String url = "jdbc:sqlserver://localhost:1433/springhibernate?useSSL=false";
		
		try {
			
			System.out.println(".......... INTENTANDO CONECTAR A : " + url);
			Connection conexion = DriverManager.getConnection(url, user, password);
			System.out.println(">>>>>>>>>> CONEXION EXITOSA!");

			System.out.println("\n..Transacciones..\n..Transacciones..\n");
			
			System.out.println(".......... CERRANDO LA CONEXION : " + url);
			conexion.close();
			System.out.println("<<<<<<<<<< SE CERRO LA CONEXION!");
			
		}catch(Exception e) {
			System.out.println("XXXXXXXXXX No se pudo establecer conexion con la base de datos : " + url);
			e.printStackTrace();
		} finally {
			
		}
	}

}

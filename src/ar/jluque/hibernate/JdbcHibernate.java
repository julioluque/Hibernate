package ar.jluque.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcHibernate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{

		String urlMySql = "jdbc:mysql://localhost:3306/springhibernate?useSSL=false";
		String userMySql = "root";
		String passwordMySql = "1234";

		String urlOracle = "jdbc:oracle:thin:@localhost:1522:orcl";
		String userOracle = "system";
		String passwordOracle = "delfina";

		String urlSqlServer = "jdbc:sqlserver://ALFREDO-PC\\SQLEXPRESS:1433;databaseName=springhibernate";
		String userSqlServer = "delfina";
		String passwordSqlServer = "delfina";

		try {

			System.out.println(".......... INTENTANDO CONECTAR A : " + urlMySql);
			Connection conexionMySql = DriverManager.getConnection(urlMySql, userMySql, passwordMySql);
			System.out.println(">>>>>>>>>> CONEXION EXITOSA!");

			System.out.println(".......... INTENTANDO CONECTAR A : " + urlOracle);
			Connection conexionOracle = DriverManager.getConnection(urlOracle, userOracle, passwordOracle);
			System.out.println(">>>>>>>>>> CONEXION EXITOSA!");
			
			System.out.println(".......... INTENTANDO CONECTAR A : " + urlSqlServer);
			Connection conexionSqlServer = DriverManager.getConnection(urlSqlServer, userSqlServer, passwordSqlServer);
			System.out.println(">>>>>>>>>> CONEXION EXITOSA!");

			System.out.println("\n..Transacciones..\n..Transacciones..\n");

			System.out.println(".......... CERRANDO LA CONEXIONES : ");
			conexionMySql.close();
			System.out.println("<<<<<<<<<< SE CERRO LA CONEXION!" + urlMySql);
			conexionOracle.close();
			System.out.println("<<<<<<<<<< SE CERRO LA CONEXION!" + urlOracle);
			conexionSqlServer.close();
			System.out.println("<<<<<<<<<< SE CERRO LA CONEXION!" + urlSqlServer);

		} catch (Exception e) {
			System.out.println("XXXXXXXXXX No se pudo establecer conexion con alguna base de datos ");
			e.printStackTrace();
		} finally {

		}
	}

}

package ar.jluque.hibernate.pruebaconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTestConectionHibernate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String db = "MYSQL";
		String url = "jdbc:mysql://localhost:3306/springhibernate?useSSL=false";
		String user = "root";
		String pass = "1234";

//		String db = "ORACLE";
//		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
//		String user = "system";
//		String pass = "delfina";

//		String db = "SQL SERVER";
//		String url = "jdbc:sqlserver://ALFREDO-PC\\SQLEXPRESS:1433;databaseName=springhibernate";
//		String user = "delfina";
//		String pass = "delfina";

//		String db = "POSTGRESQL";
//		String url = "jdbc:postgresql://localhost:5432/springhibernate";
//		String user = "delfina";
//		String pass= "delfina";

		try {

			System.out.println(".......... INTENTANDO CONECTAR A : " + db + " con : " + url);
			Connection conexionSqlServer = DriverManager.getConnection(url, user, pass);
			System.out.println(">>>>>>>>>> CONEXION EXITOSA!");
			System.out.println("\n..Transacciones..\n");
			System.out.println(".......... CERRANDO LA CONEXION");
			conexionSqlServer.close();
			System.out.println("<<<<<<<<<< SE CERRO LA CONEXION!" + url);

		} catch (Exception e) {
			System.out.println("XXXXXXXXXX No se pudo establecer conexion con alguna base de datos ");
			e.printStackTrace();
		} finally {

		}
	}

}

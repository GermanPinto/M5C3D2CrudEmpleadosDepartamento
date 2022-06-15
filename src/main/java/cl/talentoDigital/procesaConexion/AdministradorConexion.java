package cl.talentoDigital.procesaConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;




public class AdministradorConexion {

	protected static Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	protected Connection generaConexion() {

		// Oracle
		String usuario = "ALUMNO_M5V2";
		String contrasena = "1234";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//localhost:1521/ORCL";

		// MySql
		/*
		 * String usuario="root"; String contrasena="1234"; String driver =
		 * "com.mysql.jdbc.Driver"; String url ="jdbc:mysql://localhost:3306/javag0002";
		 */

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, usuario, contrasena);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return con;
	}
	
	protected Connection generaConexionSingleton() {
		if(con==null) {
			con=generaConexion();
			return con;
		}else {
			return con;
		}	
	}
	
	protected Connection generaPoolConexion() {
		Context initContext;
		try {
			initContext = new InitialContext();
			DataSource ds =(DataSource) initContext.lookup("java:/comp/env/jdbc/ConexionOracle");
			try {
				
				con=ds.getConnection();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return con;
	}

}

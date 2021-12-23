package tk.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	// Propiedades
	private static Connection conn = null;
	private String driver;
	private String url;
	private String usuario;
	private String password;

	// Constructor
	private Conexion() {

		String url = "jdbc:mysql://localhost:3306/test";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "usuario";
		String password = "password";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, usuario, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	} // Fin constructor
		// M�todos
	public Connection getConnection() {
		if (conn == null) {
			new Conexion();
		}
		return conn;
	} // Fin getConnection
}

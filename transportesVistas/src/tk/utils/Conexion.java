package tk.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection conn = null;		// Instancia única

	// CONSTRUCTOR
	private Conexion() {
		String url = "jdbc:mysql://localhost:3306/test";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String password = "*****";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, usuario, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	// MÉTODOS
	public static Connection getConnection() {
		if (conn == null) {
			new Conexion();
		}
		return conn;
	}
}

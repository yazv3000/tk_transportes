package tk.principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TookhaMain {
	public static void main(String[] args) {
		// Connection con = Conexion.getConnection();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TRANSPORTES", "root","uoxUEsDIeA#$");
					// here sonoo is database name, root is username and password
					Statement stmt = (Statement) con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from CLIENTE");
					while (rs.next())
						System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}

	}
	
	
	
	/*
	 * public static Usuario user;
	public static int tipoUsuario = 0;		// 0 - cliente, 1 - administrador, 2 - vendedor
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio inicio = new Inicio();
					CtrlInicio ctrl_inicio = new CtrlInicio(inicio); 
					inicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
	 */

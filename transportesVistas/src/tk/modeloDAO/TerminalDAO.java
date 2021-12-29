package tk.modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tk.modelo.Terminal;
import tk.utils.Conexion;

public class TerminalDAO {
	Conexion conectar;
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Terminal obtenerTerminal(int codBuscado) {	
			
		Terminal terminal = null;
		String sql = "SELECT * FROM TERMINAL WHERE codigoTe=?";
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, codBuscado);
			rs = ps.executeQuery();
			
			int codigoTe = rs.getInt(1);
			String nombreTerm = rs.getString(2);
			String nombreCiudad = rs.getString(3);
			
			terminal = new Terminal(codigoTe, nombreTerm, nombreCiudad);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null)	rs.close();
				if(ps != null)	ps.close();
				if(con != null)  con.close();
			} catch (Exception e2){}
		}
		return terminal;
	}
}

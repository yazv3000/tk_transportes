package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Administrador;
import modelo.Cliente;
import modelo.Vendedor;
import modelo.Usuario;
import tk.utils.Conexion;


public class UsuarioDAO {
	
	Conexion conectar;
	Connection con = null;
	PreparedStatement ps;
	ResultSet rs;
	Usuario user;
	
	public Usuario iniciarSesion(Usuario user){		// Recibe un objeto Usuario con email y constraseña (encriptada)
		
		String correoIn = user.getEmail();
		String contraIn = user.getContrasena();
		String tabla = "";
		
		if(user instanceof Cliente)	
			tabla = "CLIENTE";
		else 
			if (user instanceof Administrador)	
			tabla = "ADMINISTRADOR";
		else
			if (user instanceof Vendedor)	
			tabla = "VENDEDOR";
		
		String sql = "SELECT * FROM "+tabla+" WHERE email = ?  AND contrasena = ?";
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, correoIn);
			ps.setString(2, contraIn);
			rs = ps.executeQuery();
			
			// Verificar que el Usuario esté registrado para el inicio de sesión
			if (!rs.next()) {
				System.out.println("No registrado");
				con.close();
				return null;
			} 
			
			else {
				
				if(user instanceof Cliente)	{
					
					int codCl = rs.getInt(1);
					String nom = rs.getString(2);
					String apePat = rs.getString(3);
					String apeMat = rs.getString(4);
					int dni = rs.getInt(5);
					String sexo = rs.getString(6);
					int celular = rs.getInt(7);
					String direcc = rs.getString(8);
					String email = rs.getString(9);
					String contra = rs.getString(10);
					
					con.close();
					return new Cliente(codCl, nom, apePat, apeMat, dni, sexo, celular, direcc, email, contra);
					
				} else if(user instanceof Vendedor)	{
					
					int codVe = rs.getInt(1);
					String nom = rs.getString(2);
					String apePat = rs.getString(3);
					String apeMat = rs.getString(4);
					int dni = rs.getInt(5);
					String sexo = rs.getString(6);
					int celular = rs.getInt(7);
					String direcc = rs.getString(8);
					String email = rs.getString(9);
					String contra = rs.getString(10);
					con.close();
					return new Vendedor(codVe, nom, apePat, apeMat, dni, sexo, celular, direcc, email, contra);
					
				}
				else if (user instanceof Administrador) {
					
					String codAdmin = rs.getString(1);
					String email = rs.getString(2);
					String contra = rs.getString(3);
					
					con.close();
					return new Administrador(codAdmin, email, contra);
				}
				
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

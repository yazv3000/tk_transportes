package tk.modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import tk.interfaces.CRUD;
import tk.interfaces.IBuscable;
import tk.modelo.Vendedor;
import tk.utils.Conexion;

public class VendedorDAO implements CRUD<Vendedor>, IBuscable<Vendedor>{
	Conexion conectar;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// ENTIDAD
	Vendedor vendedor;
	
	public VendedorDAO() {	}
	
	public Vendedor obtenerVendedor(int codBuscado) {	
		
		Vendedor vendedor = null;
		String sql = "SELECT * FROM VENDEDOR WHERE codigoVe=?";
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, codBuscado);
			rs = ps.executeQuery();
			
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
			
			vendedor = new Vendedor(codVe, nom, apePat, apeMat, dni, sexo, celular, direcc, email, contra);
			
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
		return vendedor;
	}
	
	// GENERAR UNA LISTA CON LOS CLIENTES REGISTRADOS
	@Override
	public List<Vendedor> listarTodos() {
	
		List<Vendedor> lista = new ArrayList<Vendedor>();
		
		String sql = "SELECT * FROM VENDEDOR";		// Selecciona todos los campos de la tabla
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			generarVendedores(rs, lista);					// Genera los clientes y los agrega a la list
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null)	rs.close();
				if(ps != null)	ps.close();
				if(con != null) con.close();
			} catch (Exception e2){}
		}
		
		return lista;
	}
	
	private void generarVendedores(ResultSet rs, List<Vendedor> lista) {
		
		/*															TABLA CLIENTE 
		 * 
		 *	codigoCl | nombre | apePaterno | apeMaterno | dni | sexo | celular | direccion | email | contrasena
		 */
		
		try {
			while (rs.next()) {
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
				
				Vendedor vendedor = new Vendedor(codVe, nom, apePat, apeMat, dni, sexo, celular, direcc, email, contra);
				lista.add(vendedor);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// GENERAR EL CÓDIGO AUTOINCREMENTABLE PARA UN NUEVO CLIENTE
	public int generarCodigo() {		
			
		int nuevoCodigo = -1;
		String sql = "SELECT MAX(codigoCl) FROM VENDEDOR;";
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			nuevoCodigo =  rs.getInt(1)+1;

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null)	rs.close();
				if(ps != null)	ps.close();
				if(con != null) con.close();
			} catch (Exception e2){}
		}
		
		return nuevoCodigo;
	}

	// REGISTRAR UN CLIENTE O INSERTARLO DESDE EL FORMULARIO DE MANTENIMIENTO
	@Override
	public int insertar(Vendedor v){
		
		String sql = "INSERT INTO VENDEDOR (codigoVe, nombre, apePaterno, apeMaterno, dni, sexo, celular, direccion, email, contrasena) "
											+ "VALUES(			 ?,	  			?,		  		?, 	   	 			?, 	  		?,    ?, 	   	 ?, 	       ?, 		 		 ?, 			?	  );";

		int valdrInsertar = -1;
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, v.getCodigoVe());
			ps.setString(2, v.getNombre());
			ps.setString(3, v.getApePaterno());
			ps.setString(4, v.getApeMaterno());
			ps.setInt(5, v.getDni());
			ps.setString(6, v.getSexo());
			ps.setInt(7, v.getCelular());
			ps.setString(8, v.getDireccion());
			ps.setString(9, v.getEmail());
			ps.setString(10, v.getContrasena());
			
			valdrInsertar = ps.executeUpdate();		// 1 - insertó el registro correctamente
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null)	rs.close();
				if(ps != null)	ps.close();
				if(con != null)  con.close();
			} catch (Exception e2){}
		}
		
		return valdrInsertar;	
	}
	
	// ACTUALIZAR LA BASE DE DATOS CON LOS CAMBIOS A UN CLIENTE
	@Override
	public int modificar(Vendedor v) {
		
		int valdrModificar = -1;
		
		String sql = "UPDATE VENDEDOR SET nombre=?, apePaterno=?, apematerno=?, dni=?, sexo=?, celular=?, direccion=?, email=?"
				   + "WHERE codigoVe=?";
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, v.getNombre());
			ps.setString(2, v.getApePaterno());
			ps.setString(3, v.getApeMaterno());
			ps.setInt(4, v.getDni());
			ps.setString(5, v.getSexo());
			ps.setInt(6, v.getCelular());
			ps.setString(7, v.getDireccion());
			ps.setString(8, v.getEmail());
			// No modificar la contraseña desde el mantenimiento
			ps.setString(9, v.getCodigoVe()+"");
			
			valdrModificar = ps.executeUpdate();

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps != null)	ps.close();
				if(con != null)  con.close();
			} catch (Exception e2){}
		}
		
		return valdrModificar;
	}
	
	// ELIMINAR UN CLIENTE DE LA BASE DATOS
	@Override
	public int eliminar(Vendedor v) {
		return eliminar(v.getCodigoVe());
	}
	
	@Override
	public int eliminar(int codigoVe) {
		
		String sql = "DELETE FROM VENDEDOR WHERE codigoVe=?";
		
		int valdrEliminar = -1;
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigoVe);
			
			valdrEliminar = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps != null)	ps.close();
				if(con != null)  con.close();
			} catch (Exception e2){}
		}
		
		return valdrEliminar;
	}

	// MÉTODOS DE BÚSQUEDA
	@Override
	public List<Vendedor> buscar(String tipo, int num) {
		
		String sql;
		
		switch (tipo) {
			case "CODIGO":
			case "CÓDIGO":
				sql = "SELECT * FROM VENDEDOR WHERE codigoVe = ?";
			break;
			
			case "CELULAR":
				sql = "SELECT * FROM VENDEDOR WHERE celular = ?";
			break;
				
			default:
				JOptionPane.showMessageDialog(null,"Tipo de búsqueda inválido");
				return null;
		}
		
		List<Vendedor> lista = new ArrayList<Vendedor>();
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			generarVendedores(rs, lista);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null)	rs.close();
				if(ps != null)	ps.close();
				if(con != null) con.close();
			} catch (Exception e2){}
		}
		
		return lista;
		
	}
	
	@Override
	public List<Vendedor> buscar(String tipo, String texto) {
		
		String sql;
		
		switch (tipo) {
			case "NOMBRES":
				sql = "SELECT * FROM VENDEDOR WHERE nombre like ?";
			break;
			
			case "APELLIDOS":
				sql = "SELECT * FROM VENDEDOR WHERE (apePaterno || ' ' || apeMaterno) LIKE ?";
			break;
			
			case "DIRECCION":
			case "DIRECCIÓN":
				sql = "SELECT * FROM VENDEDOR WHERE direccion like ?;";
			break;
	
			case "EMAIL":
				sql = "SELECT * FROM VENDEDOR WHERE email like ?;";
			break;
			
			default:
				JOptionPane.showMessageDialog(null,"Tipo de búsqueda inválido");
				return null;
		}
		
		List<Vendedor> lista = new ArrayList<Vendedor>();

		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+texto+"%");
			rs = ps.executeQuery();
			
			generarVendedores(rs, lista);

		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			try {
				if(rs != null)	rs.close();
				if(ps != null)	ps.close();
				if(con != null) con.close();
			} catch (Exception e2){}
		}
		
		return lista;
		
	}
}
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
import tk.modelo.Cliente;
import tk.utils.Conexion;

public class ClienteDAO implements CRUD<Cliente>, IBuscable<Cliente>{
	Conexion conectar;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// ENTIDAD
	Cliente cliente;
	
	public ClienteDAO() {	}
	
	public Cliente obtenerCliente(int codBuscado) {	
		
		Cliente cliente = null;
		String sql = "SELECT * FROM CLIENTE WHERE codigoCl=?";
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, codBuscado);
			rs = ps.executeQuery();
			
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
			
			cliente = new Cliente(codCl, nom, apePat, apeMat, dni, sexo, celular, direcc, email, contra);
			
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
		return cliente;
	}
	
	// GENERAR UNA LISTA CON LOS CLIENTES REGISTRADOS
	@Override
	public List<Cliente> listarTodos() {
	
		List<Cliente> lista = new ArrayList<Cliente>();
		
		String sql = "SELECT * FROM CLIENTE";		// Selecciona todos los campos de la tabla
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			generarClientes(rs, lista);					// Genera los clientes y los agrega a la list
			
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
	
	private void generarClientes(ResultSet rs, List<Cliente> lista) {
		
		/*															TABLA CLIENTE 
		 * 
		 *	codigoCl | nombre | apePaterno | apeMaterno | dni | sexo | celular | direccion | email | contrasena
		 */
		
		try {
			while (rs.next()) {
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
				
				Cliente cliente = new Cliente(codCl, nom, apePat, apeMat, dni, sexo, celular, direcc, email, contra);
				lista.add(cliente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// GENERAR EL CÓDIGO AUTOINCREMENTABLE PARA UN NUEVO CLIENTE
	public int generarCodigo() {		
			
		int nuevoCodigo = -1;
		String sql = "SELECT MAX(codigoCl) FROM CLIENTE;";
		
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
	public int insertar(Cliente c){
		
		String sql = "INSERT INTO CLIENTE (codigoCl, nombre, apePaterno, apeMaterno, dni, sexo, celular, direccion, email, contrasena) "
											+ "VALUES(			 ?,	  			?,		  		?, 	   	 			?, 	  		?,    ?, 	   	 ?, 	       ?, 		 		 ?, 			?	  );";

		int valdrInsertar = -1;
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, c.getCodigoCl());
			ps.setString(2, c.getNombre());
			ps.setString(3, c.getApePaterno());
			ps.setString(4, c.getApeMaterno());
			ps.setInt(5, c.getDni());
			ps.setString(6, c.getSexo());
			ps.setInt(7, c.getCelular());
			ps.setString(8, c.getDireccion());
			ps.setString(9, c.getEmail());
			ps.setString(10, c.getContrasena());
			
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
	public int modificar(Cliente c) {
		
		int valdrModificar = -1;
		
		String sql = "UPDATE CLIENTE SET nombre=?, apePaterno=?, apematerno=?, dni=?, sexo=?, celular=?, direccion=?, email=?"
				   + "WHERE codigoCl=?";
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getApePaterno());
			ps.setString(3, c.getApeMaterno());
			ps.setInt(4, c.getDni());
			ps.setString(5, c.getSexo());
			ps.setInt(6, c.getCelular());
			ps.setString(7, c.getDireccion());
			ps.setString(8, c.getEmail());
			// No modificar la contraseña desde el mantenimiento
			ps.setString(9, c.getCodigoCl()+"");
			
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
	public int eliminar(Cliente c) {
		return eliminar(c.getCodigoCl());
	}
	
	@Override
	public int eliminar(int codigoCl) {
		
		String sql = "DELETE FROM CLIENTE WHERE codigoCl=?";
		
		int valdrEliminar = -1;
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigoCl);
			
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
	public List<Cliente> buscar(String tipo, int num) {
		
		String sql;
		
		switch (tipo) {
			case "CODIGO":
			case "CÓDIGO":
				sql = "SELECT * FROM CLIENTE WHERE codigoCl = ?";
			break;
			
			case "CELULAR":
				sql = "SELECT * FROM CLIENTE WHERE celular = ?";
			break;
				
			default:
				JOptionPane.showMessageDialog(null,"Tipo de búsqueda inválido");
				return null;
		}
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			generarClientes(rs, lista);
			
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
	public List<Cliente> buscar(String tipo, String texto) {
		
		String sql;
		
		switch (tipo) {
			case "NOMBRES":
				sql = "SELECT * FROM CLIENTE WHERE nombre like ?";
			break;
			
			case "APELLIDOS":
				sql = "SELECT * FROM CLIENTE WHERE (apePaterno || ' ' || apeMaterno) LIKE ?";
			break;
			
			case "DIRECCION":
			case "DIRECCIÓN":
				sql = "SELECT * FROM CLIENTE WHERE direccion like ?;";
			break;
	
			case "EMAIL":
				sql = "SELECT * FROM CLIENTE WHERE email like ?;";
			break;
			
			default:
				JOptionPane.showMessageDialog(null,"Tipo de búsqueda inválido");
				return null;
		}
		
		List<Cliente> lista = new ArrayList<Cliente>();

		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+texto+"%");
			rs = ps.executeQuery();
			
			generarClientes(rs, lista);

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

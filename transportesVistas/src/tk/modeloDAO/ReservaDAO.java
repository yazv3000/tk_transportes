package tk.modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import tk.interfaces.CRUD;
import tk.interfaces.IBuscable;
import tk.modelo.Cliente;
import tk.modelo.Reserva;
import tk.modelo.Viaje;
import tk.utils.Conexion;

public class ReservaDAO implements CRUD<Reserva>, IBuscable<Reserva>{
	Conexion conectar;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// ENTIDAD
	Cliente cliente;
	
	public ReservaDAO() {	}
	
	// GENERAR UNA LISTA CON LOS CLIENTES REGISTRADOS
	@Override
	public List<Reserva> listarTodos() {
	
		List<Reserva> lista = new ArrayList<Reserva>();
		
		String sql = "SELECT * FROM CLIENTE";		// Selecciona todos los campos de la tabla
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			generarReservas(rs, lista);					// Genera los clientes y los agrega a la list
			
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
	
	private void generarReservas(ResultSet rs, List<Reserva> lista) {
		
		try {
			while (rs.next()) {
				int codRe = rs.getInt(1);
				int codVi = rs.getInt(2);
				int codCl = rs.getInt(3);
				int asiento = rs.getInt(4);
				Calendar fecReserv = Calendar.getInstance();
				fecReserv.setTime(rs.getDate(5));
				double precioBase = rs.getDouble(6);

				Viaje viaje = null;

				ClienteDAO daoCl = new ClienteDAO();
				Cliente cliente = daoCl.obtenerCliente(codCl);
				
				/*VendedorDAO daoVe = new VendedorDAO();
				Vendedor vendedor = daoVe.obtenerVendedor(codCl);*/

				Reserva reserva = new Reserva(codRe, null, cliente, asiento, fecReserv, precioBase);
				lista.add(reserva);
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
	public int insertar(Reserva r){
		
		String sql = "INSERT INTO CLIENTE (codigoCl, nombre, apePaterno, apeMaterno, dni, sexo, celular, direccion, email, contrasena) "
											+ "VALUES(			 ?,	  			?,		  		?, 	   	 			?, 	  		?,    ?, 	   	 ?, 	       ?, 		 		 ?, 			?	  );";

		int valdrInsertar = -1;
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			/*ps.setInt(1, r.getCodigoCl());
			ps.setString(2, r.getNombre());
			ps.setString(3, r.getApePaterno());
			ps.setString(4, r.getApeMaterno());
			ps.setInt(5, r.getDni());
			ps.setString(6, r.getSexo());
			ps.setInt(7, r.getCelular());
			ps.setString(8, r.getDireccion());
			ps.setString(9, r.getEmail());
			ps.setString(10, r.getContrasena());*/
			
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
	public int modificar(Reserva c) {
		
		int valdrModificar = -1;
		
		String sql = "UPDATE CLIENTE SET nombre=?, apePaterno=?, apematerno=?, dni=?, sexo=?, celular=?, direccion=?, email=?"
				   + "WHERE codigoCl=?";
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			/*ps.setString(1, c.getNombre());
			ps.setString(2, c.getApePaterno());
			ps.setString(3, c.getApeMaterno());
			ps.setInt(4, c.getDni());
			ps.setString(5, c.getSexo());
			ps.setInt(6, c.getCelular());
			ps.setString(7, c.getDireccion());
			ps.setString(8, c.getEmail());
			// No modificar la contraseña desde el mantenimiento
			ps.setString(9, c.getCodigoCl()+"");*/
			
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
	public int eliminar(Reserva r) {
		return eliminar(r.getCodigo());
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
	public List<Reserva> buscar(String tipo, int num) {
		
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
		
		List<Reserva> lista = new ArrayList<Reserva>();
		
		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			generarReservas(rs, lista);
			
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
	public List<Reserva> buscar(String tipo, String texto) {
		
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
		
		List<Reserva> lista = new ArrayList<Reserva>();

		try {
			con = conectar.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+texto+"%");
			rs = ps.executeQuery();
			
			generarReservas(rs, lista);

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

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
import tk.modelo.Ruta;
import tk.modelo.Terminal;
import tk.utils.Conexion;

public class RutaDAO implements CRUD<Ruta>, IBuscable<Ruta>{

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// ENTIDAD	
	Ruta ruta;
	
	public RutaDAO() {	}
	
	// GENERAR UNA LISTA CON LAS RUTAS REGISTRADAS
	@Override
	public List<Ruta> listarTodos() {
	
		List<Ruta> lista = new ArrayList<Ruta>();
		
		String sql = "SELECT * FROM RUTA";		// Selecciona todos los campos de la tabla
		
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			generarRutas(rs, lista);					// Genera los clientes y los agrega a la list
			
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
	public List<Ruta> listarRutasDispo(String rutaO, String rutaD){
		List<Ruta> lista = new ArrayList<Ruta>();
		
		String sql = "SELECT * FROM RUTA WHERE ";		// Selecciona todos los campos de la tabla
		
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			generarRutas(rs, lista);					// Genera los clientes y los agrega a la list
			
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
	private void generarRutas(ResultSet rs, List<Ruta> lista) {
		
		/*															TABLA CLIENTE 
		 * 
		 *	codigoCl | nombre | apePaterno | apeMaterno | dni | sexo | celular | direccion | email | contrasena
		 */
		try {
			while (rs.next()) {
				int codRu = rs.getInt(1);
				String tipoServ = rs.getString(2);
				String horaP = rs.getString(3);
				String horaL = rs.getString(4);
				String duracion = rs.getString(5);
				int codTeO = rs.getInt(6);
				int codTeD = rs.getInt(7);
				double precio = rs.getDouble(8);
				
				TerminalDAO daoteO = new TerminalDAO();
				Terminal terminalO = daoteO.obtenerTerminal(codTeO);
				
				TerminalDAO daoteD = new TerminalDAO();
				Terminal terminalD = daoteD.obtenerTerminal(codTeD);
				
				Ruta ruta = new Ruta(codRu, tipoServ, horaP, horaL, duracion, terminalO, terminalD, precio);
				lista.add(ruta);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// GENERAR EL CÓDIGO AUTOINCREMENTABLE PARA UN NUEVO CLIENTE
	public int generarCodigo() {		
			
		int nuevoCodigo = -1;
		String sql = "SELECT MAX(codigoRu) FROM RUTA;";
		
		try {
			con = Conexion.getConnection();
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
	public int insertar(Ruta r){
		
		String sql = "INSERT INTO RUTA (codigoRu, nombre, apePaterno, apeMaterno, dni, sexo, celular, direccion, email, contrasena) "
											+ "VALUES(			 ?,	  			?,		  		?, 	   	 			?, 	  		?,    ?, 	   	 ?, 	       ?, 		 		 ?, 			?	  );";

		int valdrInsertar = -1;
		
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, r.getCodRuta());
			ps.setString(2, r.getTipoServicio());
			ps.setString(3, r.getHoraP());
			ps.setString(4, r.getHoraL());
			ps.setString(5, r.getDuracion());
			ps.setInt(6, r.getTerminalO().getCodigoTe());
			ps.setInt(7, r.getTerminalD().getCodigoTe());
			ps.setDouble(8, r.getPrecio());
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
	public int modificar(Ruta r) {
		
		int valdrModificar = -1;
		
		String sql = "UPDATE CLIENTE SET nombre=?, apePaterno=?, apematerno=?, dni=?, sexo=?, celular=?, direccion=?, email=?"
				   + "WHERE codigoCl=?";
		
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, r.getTipoServicio());
			ps.setString(2, r.getHoraP());
			ps.setString(3, r.getHoraL());
			ps.setString(4, r.getDuracion());
			ps.setInt(5, r.getTerminalO().getCodigoTe());
			ps.setInt(6, r.getTerminalD().getCodigoTe());
			ps.setDouble(7, r.getPrecio());
			// No modificar la contraseña desde el mantenimiento
			ps.setString(8, r.getCodRuta()+"");
			
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
	public int eliminar(Ruta r) {
		return eliminar(r.getCodRuta());
	}
	
	@Override
	public int eliminar(int codigoRu) {
		
		String sql = "DELETE FROM RUTA WHERE codigoRu=?";
		
		int valdrEliminar = -1;
		
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigoRu);
			
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
	public List<Ruta> buscar(String tipo, int num) {
		
		String sql;
		
		switch (tipo) {
			case "CODIGO":
			case "CÓDIGO":
				sql = "SELECT * FROM RUTA WHERE codigoRu = ?";
			break;
			
			case "CELULAR":
				sql = "SELECT * FROM RUTA WHERE celular = ?";
			break;
				
			default:
				JOptionPane.showMessageDialog(null,"Tipo de búsqueda inválido");
				return null;
		}
		
		List<Ruta> lista = new ArrayList<Ruta>();
		
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			generarRutas(rs, lista);
			
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
	public List<Ruta> buscar(String tipo, String texto) {
		
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
		
		List<Ruta> lista = new ArrayList<Ruta>();

		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+texto+"%");
			rs = ps.executeQuery();
			
			generarRutas(rs, lista);

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

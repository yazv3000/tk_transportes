package tk.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tk.interfaces.ICtrlMantenimiento;
import tk.modelo.Vendedor;
import tk.modeloDAO.VendedorDAO;
import tk.vista.MantVendedor;
import tk.vista.Menu;

public class CtrlVendedor implements ICtrlMantenimiento {		// Implementa la interfaz ICtrlMantenimiento

	// VISTA
	MantVendedor mc;
	
	// MODELO
	VendedorDAO clDao = new VendedorDAO();
	Vendedor objVendedor;
	
	// LISTA CLIENTES
	public List<Vendedor> listaClientes = new ArrayList<Vendedor>();

	// INDICE LISTA / FILA SELECCIONADA
	int indexCliente = -1;

	// CONSTRUCTOR
	public CtrlVendedor(MantVendedor formulario_mc) {
		
		listaClientes = clDao.listarTodos();
		this.mc = formulario_mc;
		this.mc.btnVolver.addActionListener(this);
		this.mc.btnBuscar.addActionListener(this);
		this.mc.btnInsertar.addActionListener(this);
		this.mc.btnModificar.addActionListener(this);
		this.mc.btnEliminar.addActionListener(this);
		this.mc.tablaVendedores.addMouseListener(this);
	}
	
	// EVENTOS
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// VOLVER AL FORMULARIO PRINCIPAL
		if (e.getSource() == mc.btnVolver) {
			Menu fp = new Menu();
			CtrlMenu ctrl_fp = new CtrlMenu(fp);
			fp.setVisible(true);
			mc.dispose();
		}
		
		// BUSCAR UN CLIENTE
		else if(e.getSource() == mc.btnBuscar) {
			buscarRegistros();
			actualizarVista();
		}
		
		// INSERTAR UN NUEVO CLIENTE
		else if(e.getSource() == mc.btnInsertar) {
			if(validarNoVacio()) {
				if(insertarNuevo()) {
					actualizarVista();
				}
			} else {
				JOptionPane.showMessageDialog(mc, "Primero llene todos los campos");
			}
		}
		
		// MODIFICAR UN CLIENTE
		else if(e.getSource() == mc.btnModificar) {
			if(objVendedor != null){
				if(modificarRegistro()){
					actualizarVista();
				}
			}else{
				JOptionPane.showMessageDialog(mc, "Primero seleccione el cliente a modificar");
			}
		}
		
		// ELIMINAR UN CLIENTE	
		else if(e.getSource() == mc.btnEliminar) {
			if(objVendedor != null){
				if(eliminarRegistro()) {
					actualizarVista();
				}
			}else{
			JOptionPane.showMessageDialog(mc, "Primero seleccione el vendedor a eliminar");
			}
		}
	} 
	
	// SELECCIONAR UN CLIENTE DE LA TABLA
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == mc.tablaVendedores) {
			filaSeleccionada();
		}
	}
	
	// MOSTRAR VENDEDORES DE LA LISTA EN LA TABLA
	@Override
	public void listar(JTable tabla) {
		
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		
		Object[] object = new Object[8];
		
		/*							TABLA MANTENIMIENTO VENDEDORES
		 * 
		 * 		"CÓD" | "NOMBRES" | "APELLIDOS" | "DNI" | "SEXO" | "CELULAR" | "DIRECCIÓN" | "E-MAIL" 
		 */
		
		for(int i=0; i<listaClientes.size(); i++) {
			object[0] = listaClientes.get(i).getCodigoVe();
			object[1] = listaClientes.get(i).getNombre();
			object[2] = listaClientes.get(i).getApePaterno() + (listaClientes.get(i).getApeMaterno() != null ? " / "+listaClientes.get(i).getApeMaterno() :  "");
			object[3] = listaClientes.get(i).getDni();
			object[4] = listaClientes.get(i).getSexo();
			object[5] = listaClientes.get(i).getCelular();
			object[6] = listaClientes.get(i).getDireccion();
			object[7] = listaClientes.get(i).getEmail();
			modelo.addRow(object);
		}
		
		tabla.setModel(modelo);
	}

	// RECUPERAR DATOS DE UN REGISTRO (VENDEDOR)
	@Override
	public void filaSeleccionada() {
		indexCliente = mc.tablaVendedores.getSelectedRow();
		objVendedor = listaClientes.get(indexCliente);
		mostrarDatosRegistro();
	}

	// MOSTRAR EN DETALLE CLIENTE SELECCIONADO
	@Override
	public void mostrarDatosRegistro() {
		
		// Mostrar datos del cliente seleccionado en las cajas de texto
		mc.txtCodigo.setText(""+objVendedor.getCodigoVe());
		mc.txtNombres.setText(objVendedor.getNombre());
		mc.txtApePat.setText(objVendedor.getApePaterno());
		mc.txtApeMat.setText(objVendedor.getApeMaterno());
		mc.txtDni.setText(""+objVendedor.getDni());
		
		if(objVendedor.getSexo().equals("M")) {
			mc.comboBox_sx.setSelectedIndex(0);
		}else{
			mc.comboBox_sx.setSelectedIndex(1);
		}
		
		mc.txtCelular.setText(""+objVendedor.getCelular());
		mc.txtDireccion.setText(objVendedor.getDireccion());
		mc.txtEmail.setText(objVendedor.getEmail());
	}
	
	// INSERTAR UN NUEVO CLIENTE
	@Override
	public boolean insertarNuevo() {
		
		String nombre = mc.txtNombres.getText().trim();
		String apepa = mc.txtApePat.getText().trim();
		String apemat = mc.txtApeMat.getText().trim();
		if(apemat.isEmpty()) 	apemat = null;
		
		String sexo;
		if(mc.comboBox_sx.getSelectedItem().equals("MASCULINO")) 	sexo = "M";
		else 	sexo = "F";
		
		int dni, celular;
		
		try{
			dni = Integer.parseInt(mc.txtDni.getText());
			celular = Integer.parseInt(mc.txtCelular.getText());
		}
		catch (Exception e) {
	        JOptionPane.showMessageDialog(mc, "Error. Debe ingresar un número en los campos DNI y celular");
			return false;
		}
		
		String direc = mc.txtDireccion.getText().trim();
		String email = mc.txtEmail.getText().trim();
		
		String password = ingresarContrasena();
		if(password == null) {			return false;		}
		
		// Instancia del nuevo cliente
		objVendedor = new Vendedor(nombre, apepa, apemat, dni, sexo, celular, direc, email, password);
	
		// Encriptando contraseña
		/*String contra_hashed = objCliente.encriptarPassword(password);
		objCliente.setContrasena(contra_hashed);*/

		// Insertamos el cliente a la base de datos
		int valdrInsertar = clDao.insertar(objVendedor);
		
		// Validación de la operación inserción
		if (valdrInsertar == 1) {
			listaClientes.add(objVendedor);				 		// Se agrega a la lista
            JOptionPane.showMessageDialog(mc, "Cliente agregado con Éxito.");
			return true;
        } else {
            JOptionPane.showMessageDialog(mc, "No se insertó el cliente\nError con la base de datos");
			return false;
        }
	}

	private String ingresarContrasena() {
        JPasswordField contrasena = new JPasswordField(10);
	    int action = JOptionPane.showConfirmDialog(null, contrasena,"Ingrese una contraseña para este cliente",JOptionPane.OK_CANCEL_OPTION);
	    
	    System.out.println("Acción " + action);
	    
	    if(action == -1) {
	    	JOptionPane.showMessageDialog(null,"Operación cancelada");
	    	return null;
	    } else if (action == 2) {
	    	JOptionPane.showMessageDialog(null,"Deberá ingresar una contraseña para este cliente");
	    	return null;
	    }
	    
	    String password = new String(contrasena.getPassword());		// passsword sin encriptar
	    
		return password;
    }
	
	private boolean validarNoVacio() {
		return !mc.txtNombres.getText().isEmpty() 
				&& !mc.txtApePat.getText().isEmpty() 
				&& !mc.txtDni.getText().isEmpty()
				&& !mc.txtCelular.getText().isEmpty()
				&& !mc.txtDireccion.getText().isEmpty()
				&& !mc.txtEmail.getText().isEmpty();
	}
	
	// MODIFICAR EL CLIENTE SELECCIONADO
	@Override
	public boolean modificarRegistro(){
		
		String nombre = mc.txtNombres.getText().trim();
		String apepa = mc.txtApePat.getText().trim();
		String apemat = mc.txtApeMat.getText().trim();
		if(apemat.isEmpty()) 	apemat = null;
		
		String sexo;
		if(mc.comboBox_sx.getSelectedItem().equals("MASCULINO")) 	sexo = "M";
		else			sexo = "F";
		
		int dni, celular;
		try{
			dni = Integer.parseInt(mc.txtDni.getText());
			celular = Integer.parseInt(mc.txtCelular.getText());
		}
		catch (Exception e) {
	        JOptionPane.showMessageDialog(mc, "Error. Debe ingresar un número en los campos DNI y celular");
			return false;
		}
		
		String direc = mc.txtDireccion.getText();
		String email = mc.txtEmail.getText();

		// Actualizar los datos del objeto
		objVendedor.setNombre(nombre);
		objVendedor.setApePaterno(apepa);
		objVendedor.setApeMaterno(apemat);
		objVendedor.setDni(dni);
		objVendedor.setSexo(sexo);
		objVendedor.setCelular(celular);
		objVendedor.setDireccion(direc);
		objVendedor.setEmail(email);
		
		int valdrModificar = clDao.modificar(objVendedor);
		
		// Validación de la operación actualización
		if (valdrModificar >= 1) {
            JOptionPane.showMessageDialog(mc, "¡Cliente modificado con éxito!");
			return true;
        } else {
            JOptionPane.showMessageDialog(mc, "No se pudo actualizar el cliente\nError con la base de datos");
			return false;
        }
	}

	// ELIMINAR EL VENDEDOR SELECCIONADO
	@Override
	public boolean eliminarRegistro() {
		int validar = clDao.eliminar(objVendedor.getCodigoVe());
		if(validar == 1) {
			listaClientes.remove(indexCliente);
			JOptionPane.showMessageDialog(mc, "¡Eliminado con exito!");
			return true;
		}
		else {
			JOptionPane.showMessageDialog(mc, "No se pudo borrar el vendedor\nError con la base de datos");
			return false;
		}	
	}
	
	// BUSCAR UNO O MÁS CLIENTES
	public void buscarRegistros() {
		
		String txtbuscado = mc.txtBusqueda.getText();
		List <Vendedor> resultados = null;
		
		if(!txtbuscado.isEmpty()) {		// Valida que el texto no esté vacío
			
			if(mc.chxBExacta.isSelected()) {
				listaClientes = clDao.listarTodos();		// recupera la lista completa
			}
			
			// BÚSQUEDAS DE TIPO NUMÉRICO
			if (mc.rdbCodigo.isSelected() || mc.rdbCelular.isSelected()) {	
				try {
					int num = Integer.parseInt(txtbuscado);
					
					if (mc.rdbCodigo.isSelected()) 
						resultados = clDao.buscar("CODIGO", num);
					
					else if(mc.rdbCelular.isSelected())
						resultados = clDao.buscar("CELULAR", num);
					
					if(resultados != null)		listaClientes = resultados;
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "¡Error! Ingrese un valor numérico");
				}
					
				// BÚSQUEDAS DE TEXTO
				} else if (mc.rdbNombres.isSelected()) {
					if (mc.chxBExacta.isSelected()) {											
						resultados = listaClientes.stream()
																	.filter(c -> c.getNombre().equalsIgnoreCase(txtbuscado))		// Coincidencia exacta de nombres
																	.collect(Collectors.toList());
					} else															
						resultados = clDao.buscar("NOMBRES", txtbuscado);		// Coincidencia aproximada de nombres (like)
				}
				
				else if(mc.rdbApellidos.isSelected()) {
					if (mc.chxBExacta.isSelected()) {											// Coincidencia exacta de apellidos
						resultados = listaClientes.stream()
																	.filter(c -> c.getApellidos().equalsIgnoreCase(txtbuscado))
																	.collect(Collectors.toList());
					} else																		
						resultados = clDao.buscar("APELLIDOS", txtbuscado);	// Coincidencia aproximada apellidos, muestra los clientes que al menos un apellido coincida
				}
				else if(mc.rdbDireccion.isSelected()) {		
					
					if (mc.chxBExacta.isSelected()) {		
						resultados = listaClientes.stream()
																	.filter(c -> c.getDireccion().equalsIgnoreCase(txtbuscado))
																	.collect(Collectors.toList());
					} else 																		
						resultados = clDao.buscar("DIRECCION", txtbuscado);	// Coincidencia aproximada de dirección, ej. "Av." muestra todos los que viven en Avenidas
				}
				else if(mc.rdbEmail.isSelected()) {
					
					if (mc.chxBExacta.isSelected()) {				
						resultados = listaClientes.stream()
																	.filter(c -> c.getEmail().equalsIgnoreCase(txtbuscado))
																	.collect(Collectors.toList());
					} else 																			
						resultados = clDao.buscar("EMAIL", txtbuscado);	
				}
			
				if(resultados != null)		listaClientes = resultados;
			
			} else 			// Con el texto vacío, lista todos los clientes
				listaClientes = clDao.listarTodos();
	}

	// MÉTODOS PARA ACTUALIZAR EL FORMULARIO
	public void limpiarTabla() {
		DefaultTableModel modelo = (DefaultTableModel) mc.tablaVendedores.getModel();
		modelo.setRowCount(0);
	}
	
	// MÉTODOS PARA ACTUALIZAR EL FORMULARIO
	public void actualizarVista() {
		limpiarTabla();
		listar(mc.tablaVendedores);
		limpiarCajas();
	}
	
	public void limpiarCajas() {
		mc.txtCodigo.setText("");
		mc.txtNombres.setText("");
		mc.txtApePat.setText("");
		mc.txtApeMat.setText("");
		mc.txtDni.setText("");
		mc.txtCelular.setText("");
		mc.txtDireccion.setText("");
		mc.txtEmail.setText("");

		objVendedor = null;
		indexCliente = -1;
	}	
	
	// OTROS MÉTODOS DE LA INTERFAZ MOUSE_INPUT_LISTENER
	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) {	}

	@Override
	public void mouseDragged(MouseEvent e) { }

	@Override
	public void mouseMoved(MouseEvent e) { }
}

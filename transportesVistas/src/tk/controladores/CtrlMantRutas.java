package tk.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tk.interfaces.ICtrlMantenimiento;
import tk.modelo.Ruta;
import tk.modeloDAO.RutaDAO;
import tk.vista.Menu;
import tk.vista.MantRutas;

public class CtrlMantRutas implements ICtrlMantenimiento {		// Implementa la interfaz ICtrlMantenimiento

	// VISTA
	MantRutas mr;
	
	// MODELO
	RutaDAO clDao = new RutaDAO();
	Ruta objRuta;
	
	// LISTA CLIENTES
	public List<Ruta> listaClientes = new ArrayList<Ruta>();

	// INDICE LISTA / FILA SELECCIONADA
	int indexRuta = -1;

	// CONSTRUCTOR
	public CtrlMantRutas(MantRutas formulario_mr) {
		
		listaClientes = clDao.listarTodos();
		this.mr = formulario_mr;
		this.mr.btnVolver.addActionListener(this);
		this.mr.btnBuscar.addActionListener(this);
		this.mr.btnInsertar.addActionListener(this);
		this.mr.btnModificar.addActionListener(this);
		this.mr.btnEliminar.addActionListener(this);
		this.mr.tablaClientes.addMouseListener(this);
	}
	
	// EVENTOS
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// VOLVER AL FORMULARIO PRINCIPAL
		if (e.getSource() == mr.btnVolver) {
			Menu fp = new Menu();
			CtrlMenu ctrl_fp = new CtrlMenu(fp);
			fp.setVisible(true);
			mr.dispose();
		}
		
		// BUSCAR UN CLIENTE
		else if(e.getSource() == mr.btnBuscar) {
			actualizarVista();
		}
		
		// INSERTAR UN NUEVO CLIENTE
		else if(e.getSource() == mr.btnInsertar) {

		}
		
		// MODIFICAR UN CLIENTE
		else if(e.getSource() == mr.btnModificar) {
			if(objRuta != null){
				if(modificarRegistro()){
					actualizarVista();
				}
			}else{
				JOptionPane.showMessageDialog(mr, "Primero seleccione el cliente a modificar");
			}
		}
		
		// ELIMINAR UN CLIENTE	
		else if(e.getSource() == mr.btnEliminar) {
			if(objRuta != null){
				if(eliminarRegistro()) {
					actualizarVista();
				}
			}else{
			JOptionPane.showMessageDialog(mr, "Primero seleccione el cliente a eliminar");
			}
		}
	} 
	
	// SELECCIONAR UN CLIENTE DE LA TABLA
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == mr.tablaClientes) {
			filaSeleccionada();
		}
	}
	
	// MOSTRAR CLIENTES DE LA LISTA EN LA TABLA
	@Override
	public void listar(JTable tabla) {
		
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		
		Object[] object = new Object[8];
		
		
		for(int i=0; i<listaClientes.size(); i++) {
			/*object[0] = listaClientes.get(i).getCodigoCl();
			object[1] = listaClientes.get(i).getNombre();
			object[2] = listaClientes.get(i).getApePaterno() + (listaClientes.get(i).getApeMaterno() != null ? " / "+listaClientes.get(i).getApeMaterno() :  "");
			object[3] = listaClientes.get(i).getDni();
			object[4] = listaClientes.get(i).getSexo();
			object[5] = listaClientes.get(i).getCelular();
			object[6] = listaClientes.get(i).getDireccion();
			object[7] = listaClientes.get(i).getEmail();*/
			modelo.addRow(object);
		}
		
		tabla.setModel(modelo);
	}

	// RECUPERAR DATOS DE UN REGISTRO (CLIENTE)
	@Override
	public void filaSeleccionada() {
		indexRuta = mr.tablaClientes.getSelectedRow();
		objRuta = listaClientes.get(indexRuta);
		mostrarDatosRegistro();
	}


	// MÉTODOS PARA ACTUALIZAR EL FORMULARIO
	public void limpiarTabla() {
		DefaultTableModel modelo = (DefaultTableModel) mr.tablaClientes.getModel();
		modelo.setRowCount(0);
	}
	
	// MÉTODOS PARA ACTUALIZAR EL FORMULARIO
	public void actualizarVista() {
		limpiarTabla();
		listar(mr.tablaClientes);
		limpiarCajas();
	}
	
	public void limpiarCajas() {


		objRuta = null;
		indexRuta = -1;
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

	@Override
	public void mostrarDatosRegistro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean insertarNuevo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarRegistro() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarRegistro() {
		// TODO Auto-generated method stub
		return false;
	}
}

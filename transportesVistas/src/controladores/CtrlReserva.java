package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tk.interfaces.ICtrlMantenimiento;
import tk.vista.MantVendedor;
import tk.vista.FormularioPrincipal;
import tk.vista.MantReservas;
import modelo.Reserva;
import DAO.ReservaDAO;

public class CtrlReserva implements ICtrlMantenimiento {		// Implementa la interfaz ICtrlMantenimiento

	// VISTA
	MantReservas mc;
	
	// MODELO
	ReservaDAO reDao = new ReservaDAO();
	Reserva objReserva;

	// LISTA RESERVAS
	public List<Reserva> listaReservas = new ArrayList<Reserva>();

	// INDICE LISTA / FILA SELECCIONADA
	int indexReserva = -1;


	public CtrlReserva(MantReservas formulario_mc) {
		
		listaReservas = reDao.listarTodos();
		this.mc = formulario_mc;
		this.mc.btnVolver.addActionListener(this);
		this.mc.btnBuscar.addActionListener(this);
		this.mc.btnInsertar.addActionListener(this);
		this.mc.btnModificar.addActionListener(this);
		this.mc.btnEliminar.addActionListener(this);
		this.mc.tablaReservas.addMouseListener(this);
	}


	// MÉTODOS PARA ACTUALIZAR EL FORMULARIO
	public void limpiarTabla() {
		DefaultTableModel modelo = (DefaultTableModel) mc.tablaReservas.getModel();
		modelo.setRowCount(0);
	}
	
	// MÉTODOS PARA ACTUALIZAR EL FORMULARIO
	public void actualizarVista() {
		limpiarTabla();
		listar(mc.tablaReservas);
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

		objReserva = null;
		indexReserva = -1;
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void listar(JTable tabla) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void filaSeleccionada() {
		// TODO Auto-generated method stub
		
	}


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

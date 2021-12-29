package tk.controladores;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import tk.modelo.Asiento;
import tk.modelo.Cliente;
import tk.modelo.Viaje;
import tk.vista.Autenticacion;
import tk.vista.BuscarRuta;
import tk.vista.IngresoDatos;

public class CtrlIngresoDatos implements ActionListener{
	// VISTA
	IngresoDatos fIngresoDatos;
	
	// ENTIDADES
	Cliente cliente;
	Viaje viaje;
	Asiento asiento;
	
	//CONSTRUCTOR
	public CtrlIngresoDatos(Cliente cliente, Viaje viaje, IngresoDatos formulario_ingDatos) {
		
		this.fIngresoDatos = formulario_ingDatos;
		this.cliente = cliente;
		this.viaje = viaje;
		
		// botones frame
		this.fIngresoDatos.btnCambiarAsIda.addActionListener(this);
		this.fIngresoDatos.btnCambiarAsRet.addActionListener(this);
		this.fIngresoDatos.btnCancelar.addActionListener(this);
		this.fIngresoDatos.btnElegirAsIda.addActionListener(this);
		this.fIngresoDatos.btnElegirAsRet.addActionListener(this);
		this.fIngresoDatos.btnReservar.addActionListener(this);
		this.fIngresoDatos.btnReservarSoloIda.addActionListener(this);
		this.fIngresoDatos.btnVolver.addActionListener(this);
	}
	
	//EVENTOS
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fIngresoDatos.btnVolver) {
			BuscarRuta fBuscarRuta = new BuscarRuta();
			CtrlBuscarRuta ctrl_br = new CtrlBuscarRuta(fBuscarRuta);
			fBuscarRuta.setVisible(true);
			fIngresoDatos.dispose();
		}
		else if(e.getSource() == fIngresoDatos.btnCancelar) {
			cancelarReserva();
		}
		else if(e.getSource() == fIngresoDatos.btnReservar) {
			Autenticacion fIniciarSesion = new Autenticacion();
			CtrlAutenticacion ctrl_is = new CtrlAutenticacion(fIniciarSesion);
			fIniciarSesion.setVisible(true);
			fIngresoDatos.dispose();
		}
	}
	//METODOS
	public void cancelarReserva() {
		JLabel mensaje = new JLabel ("¿Esta seguro de cancelar su reserva?");
		mensaje.setFont(new Font("Georgia Ref", Font.PLAIN, 13));
		
		int rpta = JOptionPane.showConfirmDialog(null, mensaje, "CANCELANDO RESERVA ...", JOptionPane.YES_NO_OPTION);
		if(rpta==0) {
			BuscarRuta fBuscarRuta = new BuscarRuta();
			CtrlBuscarRuta ctrl_br = new CtrlBuscarRuta(fBuscarRuta);
			fBuscarRuta.setVisible(true);
			fIngresoDatos.dispose();
		}
	}

}

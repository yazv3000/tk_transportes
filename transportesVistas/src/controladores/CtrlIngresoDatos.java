package controladores;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import DAO.TerminalDAO;
import tk.vista.FBuscarRuta;
import tk.vista.FCiudades;
import tk.vista.FIngresoDatos;
import tk.vista.FIniciarSesion;

public class CtrlIngresoDatos implements ActionListener{
	//VISTA
	FIngresoDatos fIngresoDatos;
	
	//MODELO
	TerminalDAO termiDao = new TerminalDAO();
	
	//CONSTRUCTOR
	public CtrlIngresoDatos(FIngresoDatos formulario_ingDatos) {
		this.fIngresoDatos = formulario_ingDatos;
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
			FBuscarRuta fBuscarRuta = new FBuscarRuta();
			CtrlBuscarRuta ctrl_br = new CtrlBuscarRuta(fBuscarRuta);
			fBuscarRuta.setVisible(true);
			fIngresoDatos.dispose();
		}
		else if(e.getSource() == fIngresoDatos.btnCancelar) {
			cancelarReserva();
		}
		else if(e.getSource() == fIngresoDatos.btnReservar) {
			FIniciarSesion fIniciarSesion = new FIniciarSesion();
			CtrlIniciarSesion ctrl_is = new CtrlIniciarSesion(fIniciarSesion);
			fIniciarSesion.setVisible(true);
			fIngresoDatos.dispose();
		}
	}
	//METODOS
	public void cancelarReserva() {
		JLabel mensaje = new JLabel ("¿Esta segur@ de cancelar su reserva?");
		mensaje.setFont(new Font("Georgia Ref", Font.PLAIN, 13));
		
		int rpta = JOptionPane.showConfirmDialog(null, mensaje, "CANCELANDO RESERVA ...", JOptionPane.YES_NO_OPTION);
		if(rpta==0) {
			FBuscarRuta fBuscarRuta = new FBuscarRuta();
			CtrlBuscarRuta ctrl_br = new CtrlBuscarRuta(fBuscarRuta);
			fBuscarRuta.setVisible(true);
			fIngresoDatos.dispose();
		}
	}

}

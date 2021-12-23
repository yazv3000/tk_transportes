package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.ClienteDAO;
import DAO.TerminalDAO;
import tk.vista.FBuscarRuta;
import tk.vista.FCiudades;
import tk.vista.FIniciarSesion;

public class CtrlIniciarSesion implements ActionListener{
	//VISTA
	 FIniciarSesion inicioSesion;
	
	//MODELO
	ClienteDAO termiDao = new ClienteDAO();
	
	//CONSTRUCTOR
	public CtrlIniciarSesion(FIniciarSesion formulario_IS) {
		this.inicioSesion = formulario_IS;
		this.inicioSesion.btnIngresar.addActionListener(this);
	}
	//EVENTOS
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inicioSesion.btnIngresar) {
			
		}
	}
	//METODOS
		
}

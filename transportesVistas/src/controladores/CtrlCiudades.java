package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import DAO.RutaDAO;
import DAO.TerminalDAO;
import modelo.Ruta;
import tk.vista.FCiudades;
import tk.vista.FBuscarRuta;

public class CtrlCiudades implements ActionListener{
	//VISTA
	FCiudades fCiudades;
	
	//MODELO
	TerminalDAO termiDao = new TerminalDAO();
	
	//CONSTRUCTOR
	public CtrlCiudades(FCiudades formulario_cart) {
		this.fCiudades = formulario_cart;
		this.fCiudades.btnBuscar.addActionListener(this);
	}
	//EVENTOS
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fCiudades.btnBuscar) {
			FBuscarRuta fBuscarRuta = new FBuscarRuta();
			CtrlBuscarRuta ctrl_br = new CtrlBuscarRuta(fBuscarRuta);
			fBuscarRuta.setVisible(true);
			fCiudades.dispose();
		}
	}
	//METODOS
	
}

package tk.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import tk.modeloDAO.UsuarioDAO;
import tk.principal.TookhaMain;
import tk.vista.Autenticacion;
import tk.vista.BuscarRuta;

public class CtrlAutenticacion implements ActionListener, ItemListener{
	
	// VISTA
	 Autenticacion inicioSesion;
	
	// MODELO
	UsuarioDAO termiDao = new UsuarioDAO();
	
	// CONSTRUCTOR
	public CtrlAutenticacion(Autenticacion formulario_IS) {
		this.inicioSesion = formulario_IS;
		this.inicioSesion.btnIngresar.addActionListener(this);
		this.inicioSesion.cbxRol.addItemListener(this);
	}
	
	//EVENTOS
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inicioSesion.btnIngresar) {
			switch(TookhaMain.tipoUsuario){					// 0=>CLIENTE - 1=>ADMINISTRADOR - 2=>VENDEDOR
            case 0 -> {	     
            	BuscarRuta fBuscarRuta = new BuscarRuta();
    			CtrlBuscarRuta ctrl_br = new CtrlBuscarRuta(fBuscarRuta);
    			fBuscarRuta.setVisible(true);
    			inicioSesion.dispose();
            }
            case 1 -> {
            	
            }
            case 2 -> {
            	
            }
        }
		}
	}
	// METODOS

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == inicioSesion.cbxRol) {
			String rol = inicioSesion.cbxRol.getSelectedItem().toString();
			if(rol.equalsIgnoreCase("ADMINISTRADOR")) {
				TookhaMain.tipoUsuario = 1;
			}else if (rol.equalsIgnoreCase("VENDEDOR")) {
				TookhaMain.tipoUsuario = 2;
			}else {
				TookhaMain.tipoUsuario = 0;
			}
			
		}
	}
}

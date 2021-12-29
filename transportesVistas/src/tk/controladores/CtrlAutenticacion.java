package tk.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tk.modeloDAO.UsuarioDAO;
import tk.principal.TookhaMain;
import tk.vista.Autenticacion;

public class CtrlAutenticacion implements ActionListener{
	
	// VISTA
	 Autenticacion inicioSesion;
	
	// MODELO
	UsuarioDAO termiDao = new UsuarioDAO();
	
	// CONSTRUCTOR
	public CtrlAutenticacion(Autenticacion formulario_IS) {
		this.inicioSesion = formulario_IS;
		this.inicioSesion.btnIngresar.addActionListener(this);
	}
	
	//EVENTOS
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inicioSesion.btnIngresar) {
			switch(TookhaMain.tipoUsuario){
            case 0 -> {										// FRAME INGRESO DATOS / SELECCIONAR ASIENTO
                System.out.println("Algo");
                System.out.println("I do");
            }
            case 1 -> System.out.println("Algoas");
            case 2 -> System.out.println("Algoagfdhg");
        }
		}
	}
	// METODOS
		
}

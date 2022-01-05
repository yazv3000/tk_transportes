package tk.principal;

import java.awt.EventQueue;

import tk.controladores.CtrlInicio;
import tk.modelo.Usuario;
import tk.vista.Inicio;

public class TookhaMain {
	public static Usuario user;
	public static int tipoUsuario = 0;		// 0 - cliente, 1 - administrador, 2 - vendedor
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio inicio = new Inicio();
					CtrlInicio ctrl_inicio = new CtrlInicio(inicio); 
					inicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
}

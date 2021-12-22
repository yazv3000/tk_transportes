package tk.interfaces;

import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.event.MouseInputListener;

public interface ICtrlMantenimiento extends ActionListener, MouseInputListener{	// Extiende las inferfaces ActionListener y MouseInputListener

	public void listar(JTable tabla);

	public void filaSeleccionada();
	
	public void mostrarDatosRegistro();
	
	public boolean insertarNuevo();
	
	public boolean modificarRegistro();
	
	public boolean eliminarRegistro();
}

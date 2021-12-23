package tk.interfaces;

import java.util.List;

public interface IBuscable<T> { 	// Implementado en ClienteDAO y FuncionDAO
	
	public List<T> buscar(String tipo, int num);			// b�squedas num�ricas
	
	public List<T> buscar(String tipo, String texto);		// b�squedas de cadena de texto
}

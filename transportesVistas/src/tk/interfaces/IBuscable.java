package tk.interfaces;

import java.util.List;

public interface IBuscable<T> { 	// Implementado en ClienteDAO y FuncionDAO
	
	public List<T> buscar(String tipo, int num);			// búsquedas numéricas
	
	public List<T> buscar(String tipo, String texto);		// búsquedas de cadena de texto
}

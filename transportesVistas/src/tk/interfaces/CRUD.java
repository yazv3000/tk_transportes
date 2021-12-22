package tk.interfaces;

import java.util.List;

public interface CRUD<T> {		// CLASE GENÉRICA, el tipo de objeto se define en los DAO de Cliente, Funcion y Película
	
	public List<T> listarTodos();
	
	public int insertar(T objeto);
	
	public int modificar(T objeto);
	
	public int eliminar(int codigo);
	
	public int eliminar(T objeto);
	
}



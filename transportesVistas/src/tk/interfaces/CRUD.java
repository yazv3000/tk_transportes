package tk.interfaces;

import java.util.List;

public interface CRUD<T> {		// CLASE GEN�RICA, el tipo de objeto se define en los DAO de Cliente, Funcion y Pel�cula
	
	public List<T> listarTodos();
	
	public int insertar(T objeto);
	
	public int modificar(T objeto);
	
	public int eliminar(int codigo);
	
	public int eliminar(T objeto);
	
}



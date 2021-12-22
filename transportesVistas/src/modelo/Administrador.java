package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Administrador extends Usuario 		// RELACIÓN DE HERENCIA  | CLASE PADRE: USUARIO   CLASE DERIVADA: ADMINISTRADOR

{	 
	// ATRIBUTOS
	private String codAdmin;
	
	// CONSTRUCTOR
	// Constructor sin parámetros
	public Administrador() {}
	
	public Administrador(String codAdmin, String email, String contraseña) {
		super(email, contraseña);
		this.codAdmin = codAdmin;
	}
	
	// Constructor con email y contraseña (usado para la autenticación)
	public Administrador(String email, String contrasena) {
		super(email, contrasena);
	}
	
	// MÉTODOS GETTER & SETTER
	public String getCodAdmin() {return codAdmin;}
	public void setCodAdmin(String codAdmin) {this.codAdmin = codAdmin;}
	

	// MÉTODO ABSTRACTO DE LA CLASE PADRE
	@Override
	public boolean iniciarSesion() {
		UsuarioDAO adminDao = new UsuarioDAO();
		Administrador admin = (Administrador) adminDao.iniciarSesion(this);
		
		if(admin == null)	return false;
		
		this.setCodAdmin(admin.getCodAdmin());
	
		return true;	
	}
}

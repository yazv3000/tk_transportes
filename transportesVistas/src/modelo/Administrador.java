package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Administrador extends Usuario 		// RELACI�N DE HERENCIA  | CLASE PADRE: USUARIO   CLASE DERIVADA: ADMINISTRADOR

{	 
	// ATRIBUTOS
	private String codAdmin;
	
	// CONSTRUCTOR
	// Constructor sin par�metros
	public Administrador() {}
	
	public Administrador(String codAdmin, String email, String contrase�a) {
		super(email, contrase�a);
		this.codAdmin = codAdmin;
	}
	
	// Constructor con email y contrase�a (usado para la autenticaci�n)
	public Administrador(String email, String contrasena) {
		super(email, contrasena);
	}
	
	// M�TODOS GETTER & SETTER
	public String getCodAdmin() {return codAdmin;}
	public void setCodAdmin(String codAdmin) {this.codAdmin = codAdmin;}
	

	// M�TODO ABSTRACTO DE LA CLASE PADRE
	@Override
	public boolean iniciarSesion() {
		UsuarioDAO adminDao = new UsuarioDAO();
		Administrador admin = (Administrador) adminDao.iniciarSesion(this);
		
		if(admin == null)	return false;
		
		this.setCodAdmin(admin.getCodAdmin());
	
		return true;	
	}
}

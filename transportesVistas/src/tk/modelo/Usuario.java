package tk.modelo;

public abstract class Usuario {
	
	// ATRIBUTOS
	protected String email;
	protected String contrasena;
	
	// CONSTRUCTORES
	public Usuario(){}

	public Usuario(String email, String contraseña) {
		this.email = email.trim();
		this.contrasena = contraseña;
	}

	// MÉTODO GETTER & SETTER
	public String getEmail() {		return email;	}
	public void setEmail(String email) {		this.email = email.trim();	}

	public String getContrasena() {		return contrasena;	}
	public void setContrasena(String contrasena) {		this.contrasena = contrasena;	}

	// MÉTODOS ABSTRACTROS
	public abstract boolean iniciarSesion();
}

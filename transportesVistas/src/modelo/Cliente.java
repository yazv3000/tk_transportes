package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cliente extends Usuario 	// RELACIÓN DE HERENCIA  | CLASE PADRE: USUARIO   CLASE DERIVADA: CLIENTE
{										
	// ATRIBUTOS
	private int codigoCl;
	private String nombre, apePaterno, apeMaterno;
	private int dni;
	private String sexo;
	private int celular;
	private String direccion;

	// CONSTRUCTORES
	public Cliente() {}			// Constructor sin parámetros
	
	// Constructor sin codigo (para generar nuevos clientes)
	public Cliente(String nom, String apePat, String apeMat, int dni, String sexo, int celular, String direcc, String email, String contraseña) {
		
		super(email, contraseña);	// llamada al constructor de la clase padre Usuario
		
		ClienteDAO clDao = new ClienteDAO();
		this.codigoCl = clDao.generarCodigo();

		if(this.codigoCl == -1) {
			System.out.println("Ocurrió un error");
		}
		
		this.nombre = nom.trim();
		this.apePaterno = apePat.trim();
		this.apeMaterno = (apeMat !=null ? apeMat.trim() : null);
		this.dni = dni;
		this.sexo = sexo;
		this.celular = celular;
		this.direccion = direcc.trim();
	}

	// Constructor con codigo (para listar un cliente)
	public Cliente(int codCl, String nom, String apePat, String apeMat, int dni, String sexo, int celular, String direcc, String email, String contraseña) {
		
		super(email, contraseña);	// llamada al constructor de la clase padre Usuario
		
		this.codigoCl = codCl;
		this.nombre = nom.trim();
		this.apePaterno = apePat.trim();
		this.apeMaterno = (apeMat !=null ? apeMat.trim() : null);
		this.dni = dni;
		this.sexo = sexo;
		this.celular = celular;
		this.direccion = direcc.trim();
	}
	
	// Constructor con email y contraseña (usado para la autenticación)
	public Cliente(String email, String contrasena) {
		super(email, contrasena);
	}
	
	// MÉTODOS GETTER & SETTER
	public int getCodigoCl() {		return codigoCl;	}
	public void setCodigoCl(int codigoCl) {	this.codigoCl = codigoCl;}

	public String getNombre() {		return nombre;	}
	public void setNombre(String nombre) {		this.nombre = nombre.trim();	}

	public String getApePaterno() {		return apePaterno;	}
	public void setApePaterno(String apePaterno) {		this.apePaterno = apePaterno.trim();	}

	public String getApeMaterno() {		return apeMaterno;	}
	public void setApeMaterno(String apeMaterno) {		this.apeMaterno = (apeMaterno !=null ? apeMaterno.trim() : null);	}
	public String getApellidos() {
		if(apeMaterno != null)	return apePaterno+" "+apeMaterno;
		return apePaterno;
	}
	
	public String getNombreCompleto() {
		StringBuilder nom = new StringBuilder();
		nom.append(this.nombre).append(" ").append(this.apePaterno);
		
		if(this.apeMaterno != null) 
			nom.append(" ").append(this.apeMaterno);
			
		return nom.toString();
	}
	
	public int getDni() {		return dni;	}
	public void setDni(int dni) {		this.dni = dni;	}

	public String getSexo() {		return sexo;	}
	public void setSexo(String sexo) {		this.sexo = sexo;	}

	public int getCelular() {		return celular;	}
	public void setCelular(int celular) {		this.celular = celular;	}

	public String getDireccion() {		return direccion;	}
	public void setDireccion(String direccion) {		this.direccion = direccion;	}
	
	// MÉTODOS ABSTRACTOS
	@Override
	public boolean iniciarSesion() {
		
		UsuarioDAO clDao = new UsuarioDAO();
		
		Cliente cl = (Cliente) clDao.iniciarSesion(this);
		
		if(cl == null)	return false;
		
		this.setCodigoCl(cl.getCodigoCl());
		this.setNombre(cl.getNombre());
		this.setApePaterno(cl.getApePaterno());
		this.setApeMaterno(cl.getApeMaterno());
		this.setDni(cl.getDni());
		this.setSexo(cl.getSexo());
		this.setCelular(cl.getCelular());
		this.setDireccion(cl.getDireccion());
		
		return true;
	}

}




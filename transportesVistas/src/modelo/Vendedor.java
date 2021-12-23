package modelo;

import DAO.VendedorDAO;
import DAO.UsuarioDAO;

public class Vendedor extends Usuario{
	// ATRIBUTOS
	private int codigoVe;
	private String nombre, apePaterno, apeMaterno;
	private int dni;
	
	private String sexo;
	private int celular;
	private String direccion;
	
	// CONSTRUCTORES
	public Vendedor() {}			// Constructor sin parámetros
	
	// Constructor sin codigo (para generar nuevos clientes)
	public Vendedor(String nom, String apePat, String apeMat, int dni, String sexo, int celular, String direcc, String email, String contraseña) {
		
		super(email, contraseña);	// llamada al constructor de la clase padre Usuario
		
		VendedorDAO veDao = new VendedorDAO();
		this.codigoVe = veDao.generarCodigo();
		if(this.codigoVe == -1) {
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
	public Vendedor(int codVe, String nom, String apePat, String apeMat, int dni, String sexo, int celular, String direcc, String email, String contraseña) {
		
		super(email, contraseña);	// llamada al constructor de la clase padre Usuario
		
		this.codigoVe = codVe;
		this.nombre = nom.trim();
		this.apePaterno = apePat.trim();
		this.apeMaterno = (apeMat !=null ? apeMat.trim() : null);
		this.dni = dni;
		this.sexo = sexo;
		this.celular = celular;
		this.direccion = direcc.trim();
	}
	
	// Constructor con email y contraseña (usado para la autenticación)
	public Vendedor(String email, String contrasena) {
		super(email, contrasena);
	}
	
	// MÉTODOS GETTER & SETTER
	public int getCodigoVe() {		return codigoVe;	}
	public void setCodigoVe(int codigoVe) {	this.codigoVe = codigoVe;}

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
	
	@Override
	public boolean iniciarSesion() {
		UsuarioDAO veDao = new UsuarioDAO();
		
		Vendedor ve = (Vendedor) veDao.iniciarSesion(this);
		
		if(ve == null)	return false;
		
		this.setCodigoVe(ve.getCodigoVe());
		this.setNombre(ve.getNombre());
		this.setApePaterno(ve.getApePaterno());
		this.setApeMaterno(ve.getApeMaterno());
		this.setDni(ve.getDni());
		this.setSexo(ve.getSexo());
		this.setCelular(ve.getCelular());
		this.setDireccion(ve.getDireccion());
		
		return true;
	}

}

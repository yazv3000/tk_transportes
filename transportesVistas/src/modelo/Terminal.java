package modelo;

public class Terminal {

	// ATRIBUTOS
	private int codigoTe;
	private String nombreTerminal;
	private String nombreCiudad;
	
	// CONSTRUCTOR
	public Terminal () {}
	
	public Terminal(int codigoTe, String nombreTerminal, String nombreCiudad) {
		this.codigoTe = codigoTe;
		this.nombreTerminal = nombreTerminal;
		this.nombreCiudad = nombreCiudad;
	}
	
	// GETTERS AND SETTERS
	public int getCodigoTe() {	return codigoTe;}
	public void setCodigoTe(int codigoTe) {	this.codigoTe = codigoTe;}
	
	public String getNombreCiudad() {		return nombreCiudad;	}
	public void setNombreCiudad(String nombreCiudad) {		this.nombreCiudad = nombreCiudad;	}
	
	public String getNombreTerminal() {		return nombreTerminal;	}
	public void setNombreTerminal(String nombreTerminal) {		this.nombreTerminal = nombreTerminal;	}
	
}

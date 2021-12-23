package modelo;

import tk.vista.componentesEspeciales.PanelRuta;

/** EMPRESA DE TRANSPORTES UTP
 *  Versión 1.0		07/07/2021
 *  Versión 2.0 		19/07/2021
 *  @authors Y. A. Zapata Vargas, L. R. Puma Herencia
 */

//"TIPO DE SERVICIO", "HORA DE PARTIDA", ORIGEN", "TERMINAL ORIGEN", "DURACIÓN", 
//								"HORA DE LLEGADA", DESTINO", "TERMINAL DESTINO", "PRECIO",
public class Ruta {
	private int codRuta;
	private String tipoServicio, horaP, horaL, duracion;
	private Terminal terminalO, terminalD;
	private double precio;
	private PanelRuta panelRuta;
	// CONSTRUCTORES
	// Constructor con valores por defecto
	public Ruta() {
			this.codRuta = 00;
			this.tipoServicio = "S";
			this.horaP = "00:00";
			this.horaL = "00:00";
			this.duracion = "00:00";
			this.terminalO = null;
			this.terminalD = null;
			this.precio = 0.0;
	}

	// Constructor con parámetros
	public Ruta (int codRuta,String tipoServicio, String horaP, String horaL, String duracion, Terminal terminalO,
		Terminal terminalD, double precio)
	{
		this.codRuta = codRuta;
		this.tipoServicio = tipoServicio;
		this.horaP = horaP;
		this.horaL = horaL;
		this.duracion = duracion;
		this.terminalO = terminalO;
		this.terminalD = terminalD;
		this.precio = precio;
	}
		
	// MÉTODOS GETTER AND SETTER
	public int getCodRuta() {return codRuta;}
	public void setCodRuta(int codRuta) {this.codRuta = codRuta;}
	
	public String getTipoServicio() {	return tipoServicio;	}
	public void setTipoServicio(String tipoServicio) {	this.tipoServicio = tipoServicio;	}
	
	public Terminal getTerminalO() {	return terminalO;	}
	public void setTerminalO(Terminal terminalO) {	this.terminalO = terminalO;	}
	
	public Terminal getTerminalD() {	return terminalD;	}
	public void setTerminalD(Terminal terminalD) {	this.terminalD = terminalD;	}
	
	public double getPrecio() {	return precio;}
	public void setPrecio(double precio) {	this.precio = precio;	}

	public String getHoraP() {		return horaP;}
	public void setHoraP(String horaP) {this.horaP = horaP;}

	public String getHoraL() { 		return horaL;	}
	public void setHoraL(String horaL) {		this.horaL = horaL;	}

	public String getDuracion() {		return duracion;	}
	public void setDuracion(String duracion) {		this.duracion = duracion;	}
	
	public void generarPanelRuta(){	
		panelRuta = new PanelRuta();	
	}
	
	public PanelRuta getPanelRuta() {	
		panelRuta.configurar(this);	
		return panelRuta;
	}
	
}

package modelo;

import javax.swing.JButton;

/** EMPRESA DE TRANSPORTES UTP
 *  Versión 1.0		07/07/2021
 *  Versión 2.0 	19/07/2021
 *  @authors Y. A. Zapata Vargas, L. R. Puma Herencia
 */

public class Asiento {
	
	//ATRIBUTOS
	private int nroAsiento;
	private boolean disponible;
	private JButton botonAsiento;

	//CONSTRUCTORES
	public Asiento() {
		this.nroAsiento = 0;
		this.disponible = true;
		this.botonAsiento = new JButton();
	}

	public Asiento(int nro, String numeroAsiento, boolean disponible) {
		this.nroAsiento = nro;
		this.disponible = disponible;
		this.botonAsiento = new JButton();
	}
	//GETTER AND SETTER
	public int getNroAsiento() {return nroAsiento;}
	public void setNroAsiento(int nroAsiento) {this.nroAsiento = nroAsiento;}
	
	public boolean isDisponible() {		return disponible;	}
	public void setDisponible(boolean disponible) {		this.disponible = disponible;	}
	
	public JButton getBotonAsiento() {return botonAsiento;}

}

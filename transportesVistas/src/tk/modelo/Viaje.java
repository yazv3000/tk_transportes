package tk.modelo;

import java.util.Calendar;


/** EMPRESA DE TRANSPORTES UTP
 *  Versión 1.0		07/07/2021
 *  Versión 2.0 		19/07/2021
 *  @authors Y. A. Zapata Vargas, L. R. Puma Herencia
 */

public class Viaje {
	
	// CAMPOS
	private Calendar fechaIda = Calendar.getInstance();	
	private Calendar fechaRetorno = null;	
	private String origen = "", destino  = "";
	private boolean idayVuelta;
	private double precioTotal = -0.5;	//valores por defecto
	private Ruta ruta_1 = new Ruta();
	private Ruta ruta_2;		
    

	// MÉTODOS GETTER AND SETTER
	
	// Origen
	public String getOrigen() {		return origen;	}
	public void setOrigen(String origen) {		this.origen = origen;	}
	
	// Destino
	public String getDestino() {		return destino;	}
	public void setDestino(String destino) {		this.destino = destino;	}
	
	// Fecha Ida
	public Calendar getFechaIda() {	return fechaIda;		}
	public void setFechaIda(Calendar fechaIda) {		this.fechaIda = fechaIda;	}

	//Fecha Retorno
	public Calendar getFechaRetorno() {		return fechaRetorno;	}
	public void setFechaRetorno(Calendar fechaRetorno) {		this.fechaRetorno = fechaRetorno;	}


	// Viaje de ida y vuelta / solo ida
    public boolean esIdayVuelta() {		return idayVuelta;	}
	public void setIdayVuelta(boolean idayVuelta) {	this.idayVuelta = idayVuelta;	}
	
	// Ruta 1 (IDA)
	public Ruta getRuta_1() {		return ruta_1;	}
	public void setRuta_1(Ruta ruta_1) {		this.ruta_1 = ruta_1;	}
	
	// Ruta 2 (RETORNO)
	public Ruta getRuta_2() {		return ruta_2;	}
	public void setRuta_2(Ruta ruta_2) {		this.ruta_2 = ruta_2;	}

	// Precio total
	public double getPrecioTotal() {		return precioTotal;	}
	public void setPrecioTotal(double precioTotal) {		this.precioTotal = precioTotal;	}

	
	// MÉTODOS PÚBLICOS
	public void calcularPrecioTotal() 
	{
		if(ruta_1!=null){
			precioTotal = ruta_1.getPrecio();
			if(ruta_2!=null){
				precioTotal += ruta_2.getPrecio();
			}
		}
	}
}

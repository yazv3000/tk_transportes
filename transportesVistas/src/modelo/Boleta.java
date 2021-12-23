package modelo;

public class Boleta{
	
	//ATRIBUTOS
	private int numerodeBoleto;
	private Reserva reserva;
	private Vendedor vendedor;
	private double precioTotal;
	
	//CONSTRUCTORES
	public Boleta() {}
	
	// Constructor con parámetros
	public Boleta(int numerodeBoleto, Reserva reserva, Vendedor vendedor, double precioTotal) {
		this.numerodeBoleto = numerodeBoleto;
		this.reserva = reserva;
		this.vendedor = vendedor;
		this.precioTotal = precioTotal;
	}
	
	// MÉTODOS GETTER AND SETTER
	public int getNumerodeBoleto() {	return numerodeBoleto;	}
	
	public void setNumerodeBoleto(int numerodeBoleto) {	this.numerodeBoleto = numerodeBoleto;	}
	
	public Reserva getReserva() { return this.reserva;}
	
	public double getPrecioTotal(){	return this.precioTotal;}
	
	public Vendedor getVendedor(){return this.vendedor;}
	public void setVendedor(Vendedor vendedor){ this.vendedor = vendedor;}
	
	// MÉTODO PRIVADOS
	private void calcularPrecioTotal() {
		
	}
	//FALTA IMPLEMENTAR WEY
}

package modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Reserva {

	// ATRIBUTOS
	private int codigoRe;
	private Viaje viaje;
	private Cliente cliente;
	private Asiento asientoReservado;
	private Calendar fechaDeReserva;
	private double precioBase;

	// CONSTRUCTORES

	public Reserva() {}

	// Constructor sin codigo (para generar nuevas boletas)
	public Reserva(Viaje viaje, Cliente cliente, Asiento asientoReservado, Calendar fechaDeReserva, double precioBase) {
		ReservaDAO reDao = new ReservaDAO();
		this.codigoRe = reDao.generarCodigo();

		if(this.codigoRe == -1) {
			System.out.println("Ocurrió un error");
		}
		this.viaje = viaje;
		this.cliente = cliente;
		this.asientoReservado = asientoReservado;
		this.fechaDeReserva = fechaDeReserva;
		this.precioBase = precioBase;
	}	

	// Constructor con código (para recuperar registros de boletas de la BD)
	public Reserva(int codigoRe, Viaje viaje, Cliente cliente, Asiento asientoReservado, Calendar fechaDeReserva, double precioBase)  {
		this.codigoRe = codigoRe;
		this.viaje = viaje;
		this.cliente = cliente;
		this.asientoReservado = asientoReservado;
		this.fechaDeReserva = fechaDeReserva;
		this.precioBase = precioBase;
	}

	// MÉTODOS GETTER & SETTER

	public int getCodigo() {	return codigoRe;}

	public Cliente getCliente() {return cliente;}
	public void setCliente(Cliente cliente) {		this.cliente = cliente;	}
	
	public Viaje getViaje() {		return viaje;	}
	
	public Asiento getUbicacion() {		return asientoReservado;	}
	public void setUbicacionReservada(Asiento ubic) {		this.asientoReservado = ubic;	}
	
	public double getPrecioBase(){	return this.precioBase;	}

	public Calendar getFechaDeReserva() { return fechaDeReserva; }
	
	public Calendar getFechadeIda() {return this.viaje.getFechaIda();}
	
	public Calendar getFechadeRetorno() {return this.viaje.getFechaRetorno(); }
	
	pu
}

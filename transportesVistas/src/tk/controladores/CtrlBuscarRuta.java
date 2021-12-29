package tk.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import tk.modelo.Ruta;
import tk.modeloDAO.RutaDAO;
import tk.vista.BuscarRuta;

public class CtrlBuscarRuta implements ActionListener{
	//VISTA
	BuscarRuta fbuscRuta;
	
	//MODELO
	RutaDAO ruDao = new RutaDAO();
	
	//LISTA FUNCIONES
	public List<Ruta> listaRutas = new ArrayList<Ruta>();
	
	//CONSTRUCTOR
	public CtrlBuscarRuta(BuscarRuta formulario_buscRuta) {
		listaRutas = ruDao.listarTodos();
		this.fbuscRuta = formulario_buscRuta;
		this.fbuscRuta.botonBuscar.addActionListener(this);
		this.fbuscRuta.btnSaltar.addActionListener(this);
		this.fbuscRuta.btnVolver.addActionListener(this);
	}
	
	//EVENTOS
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fbuscRuta.botonBuscar) {
			BuscarRuta horarioServicio = new BuscarRuta();
			
		}
		else {
			
		}
	}
	//METODOS
		
}

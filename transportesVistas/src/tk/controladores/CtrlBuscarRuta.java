package tk.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

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
	public CtrlBuscarRuta(BuscarRuta formulario_buscRuta, String ciudadO, String ciudadD) {
		listaRutas = ruDao.listar(ciudadO, ciudadD);
		this.fbuscRuta = formulario_buscRuta;
		this.fbuscRuta.botonBuscar.addActionListener(this);
		this.fbuscRuta.btnSaltar.addActionListener(this);
		this.fbuscRuta.btnVolver.addActionListener(this);
	}
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
	
	public void listar(){

		GroupLayout gl = new GroupLayout(fbuscRuta.panelAux);
		ParallelGroup pg = gl.createParallelGroup(Alignment.LEADING);
		SequentialGroup sq = gl.createSequentialGroup();

		for(int i=0; i<7; i++) {
			listaRutas.get(i).generarPanelRuta();			// Instancia de la clase Ruta
			pg.addComponent(listaRutas.get(i).getPanelRuta(), 710, 710, 710);
			sq.addGap(15);
			sq.addComponent(listaRutas.get(i).getPanelRuta(), 100, 100, 100);
		}
		sq.addGap(10);
		
		//  Horizontal
		gl.setHorizontalGroup(
				gl.createParallelGroup(Alignment.LEADING)
					.addGroup(gl.createSequentialGroup()
						.addGap(10)
						.addGroup(pg)));
		
		// Vertical
		gl.setVerticalGroup(
				gl.createParallelGroup(Alignment.LEADING)
					.addGroup(sq));
		
		fbuscRuta.panelAux.setLayout(gl);
	}
	
	public 
}

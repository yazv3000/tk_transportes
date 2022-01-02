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
import utp.controlador.Color;
import utp.controlador.Date;
import utp.controlador.JPanel;
import utp.controlador.JScrollPane;

public class CtrlBuscarRuta implements ActionListener{
	//VISTA
	BuscarRuta fbuscRuta;
	
	//MODELO
	RutaDAO ruDao = new RutaDAO();
	
	//LISTA FUNCIONES
	public List<Ruta> listaRutas = new ArrayList<Ruta>();
	
	//CONSTRUCTOR
	public CtrlBuscarRuta(BuscarRuta formulario_buscRuta, String ciudadO, String ciudadD) {
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
	public void generarRutas()
	{	// LAYOUT DEL PANEL AUXILIAR
		
		GroupLayout gl = new GroupLayout(panelAux);
		SequentialGroup secuencial = gl.createSequentialGroup();
		ParallelGroup paralelo =  gl.createParallelGroup(Alignment.LEADING);
		
			//--------- BUCLE PARA INCLUIR LAS RUTAS	 ---------- 						 // Usado en la versión 1.0
			/*for (int i=1; i<=listaRutas.tamanoLista(); i++) {
				Ruta objRuta	= (Ruta) listaRutas.getPosicion(i).getElemento();			// Instancia de la clase Ruta
				JPanel pRuta = objRuta.getPanelRuta();											// panel con los datos de la ruta
				
				 paralelo.addComponent(pRuta, GroupLayout.DEFAULT_SIZE, 710,  GroupLayout.PREFERRED_SIZE);
				 secuencial.addGap(15);
				 secuencial.addComponent(pRuta, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE);
			}---------------------------------------------------------------*/
			
			//----- ALGORITMO PARA INCLUIR LAS RUTAS	--------						// Desde versión 2.0
			incluirRutasRecursivo(secuencial, paralelo, 1);
			secuencial.addGap(15);
			//----------------------------------------------------------------
			
		gl.setHorizontalGroup(
				gl.createParallelGroup(Alignment.LEADING)
					.addGroup(gl.createSequentialGroup()
						.addContainerGap()
						.addGroup(paralelo)
						.addContainerGap())
		);
		gl.setVerticalGroup(
				gl.createParallelGroup(Alignment.LEADING)
					.addGroup(secuencial)
		);
		
		panelAux.setLayout(gl);
		contentPane2.add(scrollPane);
	}
}

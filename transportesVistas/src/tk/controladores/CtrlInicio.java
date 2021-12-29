package tk.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import tk.modeloDAO.TerminalDAO;
import tk.vista.BuscarRuta;
import tk.vista.Inicio;

public class CtrlInicio implements ActionListener, ItemListener{
	
	//VISTA
	Inicio inicio;
	
	//MODELO
	TerminalDAO termiDao = new TerminalDAO();
	
	//CONSTRUCTOR
	public CtrlInicio(Inicio f_inicio) {
		this.inicio = f_inicio;
		this.inicio.btnBuscar.addActionListener(this);
		this.inicio.ciudadesOrigen.addItemListener(this);
	}
	
	
	//EVENTOS
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inicio.btnBuscar) {
			BuscarRuta fBuscarRuta = new BuscarRuta();
			CtrlBuscarRuta ctrl_br = new CtrlBuscarRuta(fBuscarRuta);
			fBuscarRuta.setVisible(true);
			inicio.dispose();
		}
	}
	//METODOS


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

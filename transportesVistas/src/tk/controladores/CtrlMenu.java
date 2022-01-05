package tk.controladores;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.border.BevelBorder;
import javax.swing.event.MouseInputListener;

import tk.principal.TookhaMain;
import tk.vista.*;

public class CtrlMenu implements ActionListener, MouseInputListener{
	
	// VISTA
	private Menu fp;
	    
	// CONSTRUCTOR
    public CtrlMenu(Menu formulario_fp) {
    	this.fp = formulario_fp;
    	this.fp.btnCerrarSesion.addActionListener(this);
    	this.fp.pnl_clientes.addMouseListener(this);
    	this.fp.pnl_vendedores.addMouseListener(this);
    	this.fp.pnl_rutas.addMouseListener(this);
        this.fp.pnl_reservas.addMouseListener(this);
    	this.fp.pnl_boletos.addMouseListener(this);
    	//PERMITE LA VISIVILIDAD DE PANELES CON RESPECTO AL TIPO DE USUARUI [Cliente-Administrador]
    	accesibilidadPaneles();
    }
	// EVENTOS
 	@Override
 	public void actionPerformed(ActionEvent e) {
 		
		 // VOLVER AL FORMULARIO PRINCIPAL
 		if(e.getSource() == fp.btnCerrarSesion) {
 			Autenticacion login = new Autenticacion();
			CtrlAutenticacion ctrl_login = new CtrlAutenticacion(login);
			login.setVisible(true);
			fp.dispose();
			TookhaMain.tipoUsuario = 0;
 		} 	
 	}
 	
 	// SELECCIONAR UN FORMULARIO
	@Override
	public void mouseClicked(MouseEvent e) {

	     if(e.getSource() == fp.pnl_clientes){
	    	MantClientes mclientes = new MantClientes();
	     	/*CtrlCliente ctrlCl = new CtrlCliente(mclientes); 
	     	ctrlCl.listar(mclientes.tablaClientes);*/
	     	mclientes.setVisible(true);
	     	fp.dispose();
	     }
	     
	     if(e.getSource() == fp.pnl_vendedores){
	    	MantVendedor mv = new MantVendedor();
	     	/*CtrlFuncion ctrlFu = new CtrlFuncion(mfunciones);
	     	ctrlFu.listar(mfunciones.tablaFunciones);*/
	     	mv.setVisible(true);
	     	fp.dispose();
		 }
	     
         if(e.getSource() == fp.pnl_rutas){
	    	MantRutas ru = new MantRutas();
	     	/*CtrlFuncion ctrlFu = new CtrlFuncion(ru);
	     	ctrlFu.listar(ru.tablaFunciones);*/
	     	ru.setVisible(true);
	     	fp.dispose();
		 }

          if(e.getSource() == fp.pnl_reservas){
	    	MantReservas re = new MantReservas();
	     	/*CtrlFuncion ctrlFu = new CtrlFuncion(re);
	     	ctrlFu.listar(re.tablaFunciones);*/
	     	re.setVisible(true);
	     	fp.dispose();
		 }

         if(e.getSource() == fp.pnl_boletos){
	    	BusquedaBoletos bb = new BusquedaBoletos();
	     	/*CtrlFuncion ctrlFu = new CtrlFuncion(bb);
	     	ctrlFu.listar(bb.tablaFunciones);*/
	     	bb.setVisible(true);
	     	fp.dispose();
		 }


	}
	
	// APARIENCIA PANELES MOUSE ENTERED - MOUSE EXITED
	@Override
    public void mouseEntered(MouseEvent e) { 
    	
    	Color colorIn = new Color(55, 95, 220);
    	BevelBorder borde = new BevelBorder(BevelBorder.RAISED, new Color(40, 40, 40), null, new Color(40, 40, 40), null);
    	
    	if(e.getSource() == fp.pnl_clientes){
    		 fp.pnl_clientes.setBackground(colorIn);
    		 fp.pnl_clientes.setBorder(borde);
    	}
    	 
    	if(e.getSource() == fp.pnl_vendedores){
    		 fp.pnl_vendedores.setBackground(colorIn);
    		 fp.pnl_vendedores.setBorder(borde);
    	}
    	 
    	if(e.getSource() == fp.pnl_rutas){
    		 fp.pnl_rutas.setBackground(colorIn);
    		 fp.pnl_rutas.setBorder(borde);
    	}
    	 
    	if(e.getSource() == fp.pnl_reservas){
    		 fp.pnl_reservas.setBackground(colorIn);
    		 fp.pnl_reservas.setBorder(borde);
    	}
        if(e.getSource() == fp.pnl_boletos){
    		 fp.pnl_boletos.setBackground(colorIn);
    		 fp.pnl_boletos.setBorder(borde);
    	}
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    	
    	Color colorIn = new Color(65, 105, 225);
    	BevelBorder borde = new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK);

    	if(e.getSource() == fp.pnl_clientes){
    		 fp.pnl_clientes.setBackground(colorIn);
    		 fp.pnl_clientes.setBorder(borde);
    	}
    	 
    	if(e.getSource() == fp.pnl_vendedores){
    		 fp.pnl_vendedores.setBackground(colorIn);
    		 fp.pnl_vendedores.setBorder(borde);
    	}
    	 
    	if(e.getSource() == fp.pnl_rutas){
    		 fp.pnl_rutas.setBackground(colorIn);
    		 fp.pnl_rutas.setBorder(borde);
    	}
    	 
    	if(e.getSource() == fp.pnl_reservas){
    		 fp.pnl_reservas.setBackground(colorIn);
    		 fp.pnl_reservas.setBorder(borde);
    	}
        if(e.getSource() == fp.pnl_boletos){
    		 fp.pnl_boletos.setBackground(colorIn);
    		 fp.pnl_boletos.setBorder(borde);
    	}
    }
	
    //METODOS
    public void accesibilidadPaneles() {
    	if(TookhaMain.tipoUsuario == 2) {
    		fp.pnl_clientes.setVisible(false);
    		fp.pnl_vendedores.setVisible(false);
    		fp.pnl_rutas.setVisible(false);
    		//Hacer visible el panel con imagen 
			fp.pnl_vndr.setVisible(true);
    	}else {
    		fp.pnl_clientes.setVisible(true);
    		fp.pnl_vendedores.setVisible(true);
    		fp.pnl_rutas.setVisible(true);
    	}
    }
	// OTROS MÉTODOS DE LA INTERFAZ MOUSE_INPUT_LISTENER
    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseDragged(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) {	}
    
}

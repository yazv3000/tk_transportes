package tk.vista.componentesEspeciales;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import tk.modelo.Asiento;

public class BotonAsiento extends JButton{

	private static final long serialVersionUID = 1L;
	private static BotonAsiento btnUbicSeleccionado = null;
	
	Asiento ubic;
	boolean seleccionado = false;

	public BotonAsiento(Asiento ubic){
		this.ubic = ubic;
		configurar();
	}

	public void configurar(){
		
		setText(ubic.getNroAsiento()+"");
		setMargin(new Insets(0,0,0,0));
		
		if(!ubic.isDisponible()){
			setText("X");
			setBackground(Color.BLACK);
			setForeground(Color.WHITE);
		}
		
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ubic.isDisponible()){
					JOptionPane.showMessageDialog(null, "Ubicación ocupada");
				}else if(!seleccionado) {
					seleccionar();
				}else {
					deseleccionar();
				}
			}	
		});

	}
	
	public void seleccionar() {
		if (btnUbicSeleccionado == null) {
			btnUbicSeleccionado = this;
			this.setBackground(new Color(100, 149, 237));
			this.seleccionado = true;
			
			System.out.println(ubic.getNroAsiento());
		} else {
			btnUbicSeleccionado.setBackground(new Color(240, 240, 240));
			btnUbicSeleccionado.seleccionado = false;
			btnUbicSeleccionado = null;
			
			seleccionar();
		}
	}
	
	public void deseleccionar() {
		this.setBackground(new Color(240, 240, 240));
		this.seleccionado = false;
		btnUbicSeleccionado = null;
	}
	
	public static Asiento getUbicacionSeleccionada() {
		if(btnUbicSeleccionado!= null) 
			return btnUbicSeleccionado.ubic;
		else 
			return null;
		
	}
}

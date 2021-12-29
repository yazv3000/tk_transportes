package tk.vista.componentesEspeciales;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import tk.modelo.Ruta;

public class PanelRuta extends JPanel{
	//BOTONES
	JButton btnSeleccionar;
	// MÉTODO GETTER DEL PANEL CON LOS DATOS DE LA RUTA 
	public void configurar(Ruta ruta)
	{
		setForeground(new Color(0, 0, 139));
		setBorder(new LineBorder(new Color(0, 0, 128), 2));
		agregarDatosRuta(ruta);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnSeleccionar.setBounds(585, 60, 110, 25);
		this.add(btnSeleccionar);
		
		JLabel lbl_desde = new JLabel("Desde S/.");
		lbl_desde.setForeground(new Color(0, 0, 139));
		lbl_desde.setFont(new Font("Georgia Ref", Font.PLAIN, 11));
		lbl_desde.setBounds(585, 20, 68, 25);
		this.add(lbl_desde);
		
		JLabel lblPrecio = new JLabel(""+ruta.getPrecio());
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setForeground(new Color(0, 0, 139));
		lblPrecio.setFont(new Font("Garamond", Font.BOLD, 20));
		lblPrecio.setBounds(635, 20, 60, 25);
		this.add(lblPrecio);
		
	}

	public void agregarDatosRuta(Ruta ruta) {			// DATOS DE LA RUTA
		// Tipo de servicio
		JLabel txtBus = new JLabel();
		txtBus.setBounds(10, 10, 100, 80);
		txtBus.setForeground(new Color(0, 0, 139));
		txtBus.setFont(new Font("Georgia", Font.BOLD, 25));
		ImageIcon wallpaper; 
		if (ruta.getTipoServicio().equals("E")) 
			wallpaper = new ImageIcon("src/imagenes/busEvolution.jpeg");
		else
			wallpaper = new ImageIcon("src/imagenes/busSuite.jpeg");
		
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(txtBus.getWidth(),txtBus.getHeight(),Image.SCALE_DEFAULT));
		txtBus.setIcon(icono);
		this.add(txtBus);
		
		
		// Hora de partida del bus
		JLabel lblHoraIda = new JLabel(ruta.getHoraP());
		lblHoraIda.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraIda.setForeground(new Color(0, 0, 139));
		lblHoraIda.setFont(new Font("Garamond", Font.BOLD, 20));
		lblHoraIda.setBounds(115, 15, 140, 25);
		this.add(lblHoraIda);
		
		// Ciudad de Origen
		JLabel lblOrigen = new JLabel(ruta.getTerminalO().getNombreCiudad());
		lblOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrigen.setForeground(new Color(0, 0, 139));
		lblOrigen.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		lblOrigen.setBounds(115, 45, 140, 20);
		this.add(lblOrigen);
		
		// Lugar de embarque
		JLabel lblEmbarque = new JLabel(ruta.getTerminalO().getNombreTerminal());
		lblEmbarque.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmbarque.setForeground(new Color(0, 0, 139));
		lblEmbarque.setFont(new Font("Georgia Ref", Font.PLAIN, 10));
		lblEmbarque.setBounds(115, 65, 140, 20);
		this.add(lblEmbarque);
		
		// Duración del viaje
		JLabel lblDuracion = new JLabel("Duraci\u00F3n");
		lblDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuracion.setForeground(new Color(0, 0, 139));
		lblDuracion.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		lblDuracion.setBounds(275, 15, 140, 25);
		this.add(lblDuracion);
		
		ImageIcon imgrec = (new ImageIcon(Ruta.class.getResource("/imagenes/rec.jpg")));
		JLabel img = new JLabel(imgrec);
		img.setBounds(285, 44, 122, 22);
		this.add(img);
		
		JLabel lblTime = new JLabel(ruta.getDuracion());
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setForeground(new Color(0, 0, 139));
		lblTime.setFont(new Font("Garamond", Font.PLAIN, 14));
		lblTime.setBounds(275, 65, 140, 20);
		this.add(lblTime);
		
		// Hora aproximada de llegada del bus
		JLabel lblHoraLlegada = new JLabel(ruta.getHoraL());
		lblHoraLlegada.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraLlegada.setForeground(new Color(0, 0, 139));
		lblHoraLlegada.setFont(new Font("Garamond", Font.BOLD, 20));
		lblHoraLlegada.setBounds(425, 15, 140, 20);
		this.add(lblHoraLlegada);
		
		// Ciudad de destino
		JLabel lblDestino = new JLabel(ruta.getTerminalD().getNombreCiudad());
		lblDestino.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestino.setForeground(new Color(0, 0, 139));
		lblDestino.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		lblDestino.setBounds(425, 45, 140, 20);
		this.add(lblDestino);
		
		// Lugar de desembarque
		JLabel lblDesembarque = new JLabel(ruta.getTerminalD().getNombreTerminal());
		lblDesembarque.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesembarque.setForeground(new Color(0, 0, 139));
		lblDesembarque.setFont(new Font("Georgia Ref", Font.PLAIN, 10));
		lblDesembarque.setBounds(425, 65, 140, 20);
		this.add(lblDesembarque);
	}
}

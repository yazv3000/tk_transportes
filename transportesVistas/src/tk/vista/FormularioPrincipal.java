package tk.vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class FormularioPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioPrincipal frame = new FormularioPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// CONSTRUCTOR
	public FormularioPrincipal() {
		initializeFrame();
	}
	
	// MÉTODO PARA CREAR EL FORMULARIO PRINCIPAL FORMULARIO PRINCIPAL
	public void initializeFrame() {
		ImageIcon icono = new ImageIcon("src/imagenes/logo_utp.jpg");
		setIconImage(icono.getImage());
		
		setBounds(100, 100, 800, 530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel(null);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// ENCABEZADO
		JPanel encabezado = new JPanel((LayoutManager) null);
		encabezado.setBackground(new Color(0, 0, 139));
		encabezado.setBounds(10, 0, 765, 60);
		contentPane.add(encabezado);
		
		JLabel lblFormularios = new JLabel("FORMULARIOS");
		lblFormularios.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormularios.setForeground(Color.WHITE);
		lblFormularios.setFont(new Font("Georgia Ref", Font.BOLD, 25));
		lblFormularios.setBounds(0, 0, 765, 60);
		encabezado.add(lblFormularios);
		
		JButton btnCerrarSesion = new JButton("<html>Cerrar<br>Sesi\u00F3n</html>");
		btnCerrarSesion.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnCerrarSesion.setBounds(10, 10, 90, 40);	
		encabezado.add(btnCerrarSesion);
		
		// PANEL CON IMÁGENES
		JPanel panel_Img = new ImagenFondo();
		panel_Img.setBackground(Color.GREEN);
		panel_Img.setBounds(10, 70, 455, 410);
		contentPane.add(panel_Img);
		
		// BÚSQUEDA DE PASAJEROS
		JPanel panel_1 = new JPanel(null);
		panel_1.setBackground(new Color(65, 105, 225));
		panel_1.setBounds(475, 70, 300, 200);
		contentPane.add(panel_1);
		
		// Label Búsqueda de Pasajeros
		JLabel lblBusqueda = new JLabel("B\u00DASQUEDA DE");
		lblBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
		lblBusqueda.setForeground(Color.WHITE);
		lblBusqueda.setFont(new Font("Georgia Ref", Font.PLAIN, 20));
		lblBusqueda.setBounds(0, 45, 300, 30);
		panel_1.add(lblBusqueda);
		
		JLabel lblPasajeros = new JLabel("PASAJEROS");
		lblPasajeros.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasajeros.setForeground(Color.WHITE);
		lblPasajeros.setFont(new Font("Georgia Ref", Font.PLAIN, 20));
		lblPasajeros.setBounds(0, 75, 300, 30);
		panel_1.add(lblPasajeros);
		
		// Botón ingresar al formulario Búsqueda de Pasajeros
		JButton btnIngresarBP = new JButton("Ingresar");
		btnIngresarBP.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnIngresarBP.setBounds(90, 140, 120, 30);
		panel_1.add(btnIngresarBP);
		
		// BÚSQUEDA DE BOLETOS DE VIAJE
		JPanel panel_2 = new JPanel(null);
		panel_2.setBackground(new Color(65, 105, 225));
		panel_2.setBounds(475, 280, 300, 200);
		contentPane.add(panel_2);
		
		// Label Búsqueda de Boletos de Viaje
		JLabel lblBsqueda = new JLabel("B\u00DASQUEDA DE");
		lblBsqueda.setHorizontalAlignment(SwingConstants.CENTER);
		lblBsqueda.setForeground(Color.WHITE);
		lblBsqueda.setFont(new Font("Georgia Ref", Font.PLAIN, 20));
		lblBsqueda.setBounds(0, 45, 300, 30);
		panel_2.add(lblBsqueda);
		
		JLabel lblBoletos = new JLabel("BOLETOS DE VIAJE");
		lblBoletos.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoletos.setForeground(Color.WHITE);
		lblBoletos.setFont(new Font("Georgia Ref", Font.PLAIN, 20));
		lblBoletos.setBounds(0, 75, 300, 30);
		panel_2.add(lblBoletos);
		
		// Botón ingresar al formulario Búsqueda de Boletos de Viaje
		JButton btnIngresarBB = new JButton("Ingresar");
		btnIngresarBB.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnIngresarBB.setBounds(90, 140, 120, 30);
		panel_2.add(btnIngresarBB);
	}
	
	// IMAGEN
	class ImagenFondo extends JPanel{
		private static final long serialVersionUID = 1L;
		
		private Image imagen;
		//METODOS
		public void paint (Graphics g)
		{
			imagen = new ImageIcon(getClass().getResource("/imagenes/BeFunky-collage (1).jpg")).getImage();
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
			super.paint(g);
		}
	}
}

package tk.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class Menu extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public JButton btnCerrarSesion;
	public JPanel pnl_rutas, pnl_clientes, pnl_vendedores, pnl_reservas, pnl_boletos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// CONSTRUCTOR
	public Menu() {
		initializeFrame();
	}
	
	// MÉTODO PARA CREAR EL FORMULARIO PRINCIPAL FORMULARIO PRINCIPAL
	public void initializeFrame() {
		ImageIcon icono = new ImageIcon("src/imagenes/logo_utp.jpg");
		setIconImage(icono.getImage());
		
		setSize(900, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
		JPanel contentPane = new JPanel(null);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// ENCABEZADO
		JPanel encabezado = new JPanel((LayoutManager) null);
		encabezado.setBackground(new Color(0, 0, 139));
		encabezado.setBounds(10, 0, 866, 60);
		contentPane.add(encabezado);
		
		JLabel lblFormularios = new JLabel("FORMULARIOS");
		lblFormularios.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormularios.setForeground(Color.WHITE);
		lblFormularios.setFont(new Font("Georgia Ref", Font.BOLD, 25));
		lblFormularios.setBounds(0, 0, 866, 60);
		encabezado.add(lblFormularios);
		
		btnCerrarSesion = new JButton("<html>Cerrar<br>Sesi\u00F3n</html>");
		btnCerrarSesion.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnCerrarSesion.setBounds(10, 10, 90, 40);	
		encabezado.add(btnCerrarSesion);
		
		// PANEL CON IMÁGENES
		JPanel panel_Img = new ImagenFondo();
		panel_Img.setBackground(Color.GREEN);
		panel_Img.setBounds(10, 70, 455, 410);
		contentPane.add(panel_Img);
		
		// BÚSQUEDA DE PASAJEROS
		pnl_clientes = new JPanel(null);
		pnl_clientes.setBackground(new Color(65, 105, 225));
		pnl_clientes.setBounds(526, 70, 350, 100);
		contentPane.add(pnl_clientes);
		
		JLabel lblMantClientes = new JLabel("<html><center>MANTENIMIENTO <br>DE CLIENTES<center></html>");
		lblMantClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantClientes.setForeground(Color.WHITE);
		lblMantClientes.setFont(new Font("Georgia Ref", Font.PLAIN, 20));
		lblMantClientes.setBounds(0, 28, 350, 48);
		pnl_clientes.add(lblMantClientes);
		
		pnl_vendedores = new JPanel((LayoutManager) null);
		pnl_vendedores.setBackground(new Color(65, 105, 225));
		pnl_vendedores.setBounds(526, 180, 350, 100);
		contentPane.add(pnl_vendedores);
		
		JLabel lblMantVendedores = new JLabel("<html><center>MANTENIMIENTO <br>DE VENDEDORES<center></html>");
		lblMantVendedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantVendedores.setForeground(Color.WHITE);
		lblMantVendedores.setFont(new Font("Georgia Ref", Font.PLAIN, 20));
		lblMantVendedores.setBounds(0, 25, 351, 50);
		pnl_vendedores.add(lblMantVendedores);
		
		pnl_rutas = new JPanel((LayoutManager) null);
		pnl_rutas.setBackground(new Color(65, 105, 225));
		pnl_rutas.setBounds(526, 290, 350, 100);
		contentPane.add(pnl_rutas);
		
		JLabel lblMantRutas = new JLabel("<html><center>MANTENIMIENTO <br>DE RUTAS<center></html>");
		lblMantRutas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantRutas.setForeground(Color.WHITE);
		lblMantRutas.setFont(new Font("Georgia Ref", Font.PLAIN, 20));
		lblMantRutas.setBounds(0, 25, 350, 50);
		pnl_rutas.add(lblMantRutas);
		
		pnl_reservas = new JPanel((LayoutManager) null);
		pnl_reservas.setBackground(new Color(65, 105, 225));
		pnl_reservas.setBounds(526, 400, 350, 95);
		contentPane.add(pnl_reservas);
		
		JLabel lblReservas = new JLabel("<html><center>RESERVAS<center></html>");
		lblReservas.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservas.setForeground(Color.WHITE);
		lblReservas.setFont(new Font("Georgia Ref", Font.PLAIN, 20));
		lblReservas.setBounds(0, 24, 350, 48);
		pnl_reservas.add(lblReservas);
		
		pnl_boletos = new JPanel((LayoutManager) null);
		pnl_boletos.setBackground(new Color(65, 105, 225));
		pnl_boletos.setBounds(526, 503, 350, 95);
		contentPane.add(pnl_boletos);
		
		JLabel lblBoletos = new JLabel("<html><center>BOLETOS DE<br> VIAJE<center></html>");
		lblBoletos.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoletos.setForeground(Color.WHITE);
		lblBoletos.setFont(new Font("Georgia Ref", Font.PLAIN, 20));
		lblBoletos.setBounds(0, 24, 350, 48);
		pnl_boletos.add(lblBoletos);
		
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

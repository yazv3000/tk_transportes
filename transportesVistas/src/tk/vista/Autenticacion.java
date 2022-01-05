package tk.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;


/** CORREO: admin@transportes.utp.pe
 *  CONTRASEÑA: 2021
 * 
 ** EMPRESA DE TRANSPORTES UTP
 *  Versión 1.0		07/07/2021
 *  Versión 2.0 		19/07/2021
 *  @authors Y. A. Zapata Vargas, L. R. Puma Herencia
 */

public class Autenticacion extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	private JPanel panelPrincipal = new JPanel(null);
	private JTextField email;
	private JPasswordField contraseña;
	public JButton btnIngresar, btnVolver;
	public JComboBox cbxRol;
	
	// Método main
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Autenticacion login = new Autenticacion();
						login.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
	
	// CONSTRUCTOR
	public Autenticacion() {
		initializeFrame();
	}

	// MÉTODO PARA CREAR EL FORMULARIO DE INCIO DE SESIÓN PARA EL ADMINISTRADOR
	public void initializeFrame() {
		ImageIcon icono = new ImageIcon("src/imagenes/logo_utp.jpg");
		setIconImage(icono.getImage());
		
		setBounds(100, 100, 800, 530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
		JPanel contentPane = new JPanel(null);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panelPrincipal.setBackground(new Color(65, 105, 225));
		panelPrincipal.setBounds(240, 70, 300, 410);
		contentPane.add(panelPrincipal);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setIcon(new ImageIcon(Autenticacion.class.getResource("/imagenes/ingreso.png")));
		btnIngresar.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		btnIngresar.setBounds(77, 321, 150, 40);
		panelPrincipal.add(btnIngresar);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(50, 98, 200, 20);
		panelPrincipal.add(email);
		
		contraseña = new JPasswordField();
		contraseña.setBounds(50, 190, 200, 20);
		panelPrincipal.add(contraseña);
		
		JLabel lblEmail = new JLabel("CORREO ELECTR\u00D3NICO :");
		lblEmail.setIcon(new ImageIcon(Autenticacion.class.getResource("/imagenes/user.png")));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblEmail.setBounds(50, 68, 210, 20);
		panelPrincipal.add(lblEmail);
		
		JLabel lblContra = new JLabel("CONSTRASE\u00D1A :");
		lblContra.setIcon(new ImageIcon(Autenticacion.class.getResource("/imagenes/contra.png")));
		lblContra.setForeground(Color.WHITE);
		lblContra.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblContra.setBounds(47, 160, 180, 20);
		panelPrincipal.add(lblContra);
		
		cbxRol = new JComboBox();
		cbxRol.setModel(new DefaultComboBoxModel(new String[] {"CLIENTE", "ADMINISTRADOR", "VENDEDOR"}));
		cbxRol.setBounds(77, 250, 150, 22);
		cbxRol.setSelectedItem(0);
		panelPrincipal.add(cbxRol);
		
		JPanel encabezado = new JPanel((LayoutManager) null);
		encabezado.setBackground(new Color(0, 0, 139));
		encabezado.setBounds(10, 0, 765, 60);
		contentPane.add(encabezado);
		
		JLabel lblInicioDeSesin = new JLabel("INICIO DE SESI\u00D3N");
		lblInicioDeSesin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioDeSesin.setForeground(Color.WHITE);
		lblInicioDeSesin.setFont(new Font("Georgia Ref", Font.BOLD, 25));
		lblInicioDeSesin.setBounds(0, 0, 765, 60);
		encabezado.add(lblInicioDeSesin);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnVolver.setBounds(10, 10, 70, 25);
		encabezado.add(btnVolver);
		
		JPanel panel_Img1 = new ImagenFondo();
		panel_Img1.setBackground(Color.GREEN);
		panel_Img1.setBounds(10, 70, 220, 410);
		contentPane.add(panel_Img1);
		
		JPanel panel_Img2 = new ImagenFondo2();
		panel_Img2.setBackground(Color.GREEN);
		panel_Img2.setBounds(550, 70, 225, 410);
		contentPane.add(panel_Img2);
	}
	
	// IMÁGENES
	class ImagenFondo extends JPanel {
		private static final long serialVersionUID = 1L;
		
		Image imagen;
		//METODOS
		public void paint (Graphics g)
		{
			imagen = new ImageIcon(getClass().getResource("/imagenes/collage2.jpg")).getImage();
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
			super.paint(g);
		}
	}
	class ImagenFondo2 extends JPanel {
		private static final long serialVersionUID = 1L;
		
		private Image imagen;
		//METODOS
		public void paint (Graphics g)
		{
			imagen = new ImageIcon(getClass().getResource("/imagenes/collage3.jpg")).getImage();
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
			super.paint(g);
		}
	}
}
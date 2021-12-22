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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


/** CORREO: admin@transportes.utp.pe
 *  CONTRASE�A: 2021
 * 
 ** EMPRESA DE TRANSPORTES UTP
 *  Versi�n 1.0		07/07/2021
 *  Versi�n 2.0 		19/07/2021
 *  @authors Y. A. Zapata Vargas, L. R. Puma Herencia
 */

public class IniciarSesion extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	private JPanel panelPrincipal = new JPanel(null);
	private JTextField email;
	private JPasswordField contrase�a;

	// M�todo main
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						IniciarSesion login = new IniciarSesion();
						login.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
	
	// CONSTRUCTOR
	public IniciarSesion() {
		initializeFrame();
	}

	// M�TODO PARA CREAR EL FORMULARIO DE INCIO DE SESI�N PARA EL ADMINISTRADOR
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
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.setIcon(new ImageIcon(IniciarSesion.class.getResource("/imagenes/ingreso.png")));
		btnIngresar.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		btnIngresar.setBounds(75, 305, 150, 40);
		panelPrincipal.add(btnIngresar);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(50, 110, 200, 20);
		panelPrincipal.add(email);
		
		contrase�a = new JPasswordField();
		contrase�a.setBounds(50, 210, 200, 20);
		panelPrincipal.add(contrase�a);
		
		JLabel lblEmail = new JLabel("CORREO ELECTR\u00D3NICO :");
		lblEmail.setIcon(new ImageIcon(IniciarSesion.class.getResource("/imagenes/user.png")));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblEmail.setBounds(47, 80, 210, 20);
		panelPrincipal.add(lblEmail);
		
		JLabel lblContra = new JLabel("CONSTRASE\u00D1A :");
		lblContra.setIcon(new ImageIcon(IniciarSesion.class.getResource("/imagenes/contra.png")));
		lblContra.setForeground(Color.WHITE);
		lblContra.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblContra.setBounds(47, 180, 180, 20);
		panelPrincipal.add(lblContra);
		
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
		
		JButton btnVolver = new JButton("Volver");
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
	
	// IM�GENES
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
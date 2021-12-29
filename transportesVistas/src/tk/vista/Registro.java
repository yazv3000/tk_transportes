package tk.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import tk.controladores.CtrlRegistro;
import tk.modelo.Cliente;
import tk.principal.TookhaMain;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public JButton btnRegistrar;
	public JLabel lblInicieSesion;
	
	public JTextField txtCodigo, txtNombres, txtApePat, txtApeMat; 
	public JTextField txtDni, txtCelular, txtDireccion, txtEmail;
	public JComboBox<String> comboBox_sx;
	public JPasswordField passwordField;
	public JButton btnVolver;
	
	/** Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TookhaMain.user = new Cliente();
					Registro frame = new Registro();
					CtrlRegistro ctrl_registro = new CtrlRegistro(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	// CONSTRUCTOR
	public Registro() {
		initializeFrame();
	}

	// MÉTODO PARA CREAR EL FORMULARIO DE REGISTRO
	public void initializeFrame() {

		ImageIcon icono = new ImageIcon("src/imagenes/logo_utp.jpg");
		setIconImage(icono.getImage());
		
		setSize(800, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
		JPanel contentPane = new JPanel(null);
		setContentPane(contentPane);
		
		//------------------------ CLIENTE NUEVO ------------------------//
		
		JPanel panelPrincipal = new JPanel(null);
		panelPrincipal.setBackground(new Color(65, 105, 225));
		panelPrincipal.setBounds(192, 80, 460, 580);
		contentPane.add(panelPrincipal);
		
		
		JLabel lblClienteNuevo = new JLabel("CLIENTE NUEVO :");
		lblClienteNuevo.setForeground(Color.WHITE);
		lblClienteNuevo.setFont(new Font("Eras Bold ITC", Font.PLAIN, 14));
		lblClienteNuevo.setBounds(30, 25, 200, 24);
		panelPrincipal.add(lblClienteNuevo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 50, 410, 4);
		panelPrincipal.add(separator);
		
		//---------- CÓDIGO DEL CLIENTE -----------//		
		JLabel lblCodigo = new JLabel("C\u00D3DIGO                   :");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblCodigo.setBounds(30, 80, 160, 24);
		panelPrincipal.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(200, 80, 220, 24);
		panelPrincipal.add(txtCodigo);

		//---------- NÚMERO DE DOCUMENTO ----------//
		JLabel lblNroDoc = new JLabel("DNI                           :");
		lblNroDoc.setForeground(Color.WHITE);
		lblNroDoc.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblNroDoc.setBounds(30, 120, 160, 24);
		panelPrincipal.add(lblNroDoc);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(200, 120, 220, 24);
		panelPrincipal.add(txtDni);
		
		//---------------- NOMBRES ----------------//
		JLabel lblNombres = new JLabel("NOMBRES                :");
		lblNombres.setForeground(Color.WHITE);
		lblNombres.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblNombres.setBounds(30, 160, 160, 24);
		panelPrincipal.add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(200, 160, 220, 24);
		panelPrincipal.add(txtNombres);
		
		//--------------- APELLIDOS ---------------//
		JLabel lblApellidos = new JLabel("APELLIDOS             :");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblApellidos.setBounds(30, 200, 160, 24);
		panelPrincipal.add(lblApellidos);
		
		txtApePat = new JTextField();
		txtApePat.setColumns(10);
		txtApePat.setBounds(200, 200, 105, 24);
		panelPrincipal.add(txtApePat);
		
		txtApeMat = new JTextField();
		txtApeMat.setColumns(10);
		txtApeMat.setBounds(315, 200, 105, 24);
		panelPrincipal.add(txtApeMat);
		
		//----------------- SEXO ------------------//	
		JLabel lblSexo = new JLabel("SEXO                         :");
		lblSexo.setForeground(Color.WHITE);
		lblSexo.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblSexo.setBounds(30, 240, 160, 24);
		panelPrincipal.add(lblSexo);
		
		comboBox_sx = new JComboBox<String>();
		comboBox_sx.setModel(new DefaultComboBoxModel<String>(new String[] {"MASCULINO", "FEMENINO"}));
		comboBox_sx.setBounds(200, 240, 220, 24);
		panelPrincipal.add(comboBox_sx);
		
		//---------------- CELULAR ----------------//
		JLabel lblCelular = new JLabel("CELULAR                :");
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblCelular.setBounds(30, 280, 160, 24);
		panelPrincipal.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(200, 280, 220, 24);
		panelPrincipal.add(txtCelular);
		
		//--------------- DIRECCIÓN ---------------//
		JLabel lblDireccion = new JLabel("DIRECCI\u00D3N            :");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblDireccion.setBounds(30, 320, 160, 24);
		panelPrincipal.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(200, 320, 220, 24);
		panelPrincipal.add(txtDireccion);
		
		//----------------- E-MAIL ----------------//
		JLabel lblEmail = new JLabel("E-MAIL                     :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblEmail.setBounds(30, 360, 160, 24);
		panelPrincipal.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(200, 360, 220, 24);
		panelPrincipal.add(txtEmail);
		
		//-------------- CONTRASENA ---------------//
		
		
		//---------------------- BOTÓN DE REGISTRO ----------------------//
		btnRegistrar = new JButton("    Reg\u00EDstrese");
		btnRegistrar.setFont(new Font("Eras Bold ITC", Font.PLAIN, 12));
		btnRegistrar.setBounds(150, 460, 180, 40);
		btnRegistrar.setFocusPainted(false);
		panelPrincipal.add(btnRegistrar);
		
		
		//----------------------- INICIO DE SESIÓN ----------------------//
		lblInicieSesion = new JLabel("<html>\u00BFYa tiene cuenta? <u>Inicie Sesi\u00F3n</u></html>");
		lblInicieSesion.setFont(new Font("Eras Bold ITC", Font.PLAIN, 12));
		lblInicieSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicieSesion.setForeground(Color.WHITE);
		lblInicieSesion.setBounds(140, 530, 200, 24);
		panelPrincipal.add(lblInicieSesion);
		
		JLabel lblContrasena = new JLabel("CONTRASE\u00D1A         :");
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblContrasena.setBounds(30, 400, 160, 24);
		panelPrincipal.add(lblContrasena);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 400, 220, 24);
		panelPrincipal.add(passwordField);
		
		
		// IMÁGEN DE FONDO
		JPanel panel = new ImagenFondo();
		panel.setBounds(0, 50, 986, 633);
		contentPane.add(panel);
		
		JPanel encabezado = new JPanel((LayoutManager) null);
		encabezado.setBackground(new Color(0, 0, 139));
		encabezado.setBounds(10, 0, 765, 60);
		contentPane.add(encabezado);
		
		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setForeground(Color.WHITE);
		lblRegistro.setFont(new Font("Georgia Ref", Font.BOLD, 25));
		lblRegistro.setBounds(0, 0, 765, 60);
		encabezado.add(lblRegistro);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnVolver.setBounds(10, 10, 70, 25);
		encabezado.add(btnVolver);
	}
	
	// IMÁGENES
	class ImagenFondo extends JPanel {

		private static final long serialVersionUID = 1L;
		
		Image imagen;
		
		//MÉTODOS
		public void paint (Graphics g){
			imagen = new ImageIcon(getClass().getResource("/imagenes/registro.jpg")).getImage();
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
			super.paint(g);
		}
	}
}

package tk.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import tk.controladores.CtrlInicio;

public class Inicio extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	// COMPONENTES DEL FRAME
	public JComboBox<String> ciudadesOrigen, ciudadesDestino;
	public JDateChooser dcFechaIda, dcFechaRetorno;
	public JButton btnBuscar;
	public JLabel lbIngresoAdmin;
	
	/* Launch the application. */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio inicio = new Inicio();
					CtrlInicio ctrl_inicio = new CtrlInicio(inicio); 
					inicio.setVisible(true);				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// CONSTRUCTOR
	public Inicio() {

		ciudadesOrigen = new JComboBox<String>();			// crea los comboBox para elegir las ciudades de origen y destino
		ciudadesDestino = new JComboBox<String>();
		
		dcFechaIda = new JDateChooser();							// crea los dateChosser para elegir la fecha de ida y, opcionanlmente, la fecha de retorno
		dcFechaRetorno = new JDateChooser();

		initializeFrame();							// Inicializa el frame
	}

	
	// MÉTODO PARA CREAR EL FORMULARIO DE INICIO (BUSCAR RUTA)
	public void initializeFrame() {	// método para crear los contenidos del frame
		

		setIconImage(new ImageIcon("src/imagenes/logo_utp.jpg").getImage());
		
		setSize(800, 530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.setLocationRelativeTo(null); 


		JPanel contentPane = new JPanel(null);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// ENCABEZADO: EMPRESA DE TRANSPORTES [...]
		JPanel encabezado = new JPanel(null);
		encabezado.setBounds(10, 0, 765, 60);
		encabezado.setBackground(new Color(0, 0, 139));
		
		JLabel lblEmpresa = new JLabel("EMPRESA DE TRANSPORTES");
		lblEmpresa.setBounds(0, 0, 765, 60);
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setForeground(Color.WHITE);
		lblEmpresa.setFont(new Font("Georgia Ref", Font.BOLD, 25));
		encabezado.add(lblEmpresa);
		contentPane.add(encabezado);
		
		// PANEL PRINCIPAL: PARA SELECCIONAR ORIGEN - DESTINO - FECHA IDA (Y RETORNO)
		JPanel panelPrincipal = new JPanel(null);
		panelPrincipal.setBounds(10, 70, 400, 343);
		panelPrincipal.setBackground(new Color(65, 105, 225));
		
		JLabel lbllSaludo = new JLabel("Hola, \u00BFa d\u00F3nde nos vamos de viaje?");
		lbllSaludo.setHorizontalAlignment(SwingConstants.CENTER);
		lbllSaludo.setForeground(Color.WHITE);
		lbllSaludo.setFont(new Font("Gabriola", Font.BOLD, 20));
		lbllSaludo.setBounds(0, 30, 400, 29);
		panelPrincipal.add(lbllSaludo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 60, 360, 2);
		panelPrincipal.add(separator);
		
		//------------------------- SELECCIONAR ORIGEN ---------------------------// 
		JLabel lblOrigen = new JLabel("ORIGEN                             :");
		lblOrigen.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/city.png")));
		lblOrigen.setForeground(Color.WHITE);
		lblOrigen.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblOrigen.setBounds(30, 80, 180, 20);
		panelPrincipal.add(lblOrigen);
		
		ciudadesOrigen.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		ciudadesOrigen.setBackground(SystemColor.window);
		ciudadesOrigen.setBounds(220, 80, 160, 20);
		panelPrincipal.add(ciudadesOrigen);
		//-----------------------------------------------------------------------------------// 

		//------------------------- SELECCIONAR DESTINO -------------------------//
		JLabel lblDestino = new JLabel("DESTINO                          :");
		lblDestino.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/city.png")));
		lblDestino.setForeground(Color.WHITE);
		lblDestino.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblDestino.setBounds(30, 125, 180, 20);
		panelPrincipal.add(lblDestino);
		
		ciudadesDestino.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		ciudadesDestino.setBackground(Color.WHITE);
		ciudadesDestino.setBounds(220, 125, 160, 20);
		panelPrincipal.add(ciudadesDestino);
		//------------------------------------------------------------------------------------// 
		
		//--------------------- SELECCIONAR FECHA DE IDA -----------------------//
		JLabel lblFechaDeIda = new JLabel("FECHA DE IDA               :");
		lblFechaDeIda.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/calendario.png")));
		lblFechaDeIda.setForeground(Color.WHITE);
		lblFechaDeIda.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblFechaDeIda.setBounds(30, 173, 180, 20);
		panelPrincipal.add(lblFechaDeIda);
		
		dcFechaIda.setDateFormatString("dd/MM/yyyy");		// estable el formato día/mes/año
		dcFechaIda.setBounds(220, 170, 160, 20);
		panelPrincipal.add(dcFechaIda);
		//-----------------------------------------------------------------------------------// 
		
		//---------------- SELECCIONAR FECHA DE RETORNO ------------------//
		JLabel lblFechaDeRetorno = new JLabel("FECHA DE RETORNO :");
		lblFechaDeRetorno.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/calendario.png")));
		lblFechaDeRetorno.setForeground(Color.WHITE);
		lblFechaDeRetorno.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblFechaDeRetorno.setBounds(30, 215, 180, 20);
		panelPrincipal.add(lblFechaDeRetorno);
		
		JLabel lblOpcional = new JLabel("(Opcional)");
		lblOpcional.setForeground(Color.WHITE);
		lblOpcional.setFont(new Font("Georgia Ref", Font.ITALIC, 12));
		lblOpcional.setBounds(55, 235, 160, 14);
		panelPrincipal.add(lblOpcional);
		
		dcFechaRetorno.setDateFormatString("dd/MM/yyyy");	// estable el formato día/mes/año
		dcFechaRetorno.setBounds(220, 215, 160, 20);
		panelPrincipal.add(dcFechaRetorno);
		//---------------------------------------------------------------------------------// 
		
		//------------------------ BOTÓN BUSCAR RUTAS ------------------------//	
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/buscar_rutas.png")));
		btnBuscar.setBounds(120, 280, 140, 40);
		btnBuscar.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		panelPrincipal.add(btnBuscar);
		contentPane.add(panelPrincipal);
		//---------------------------------------------------------------------------------// 
		
		// PANEL INFERIOR: PARA ENTRAR COMO ADMINISTRADOR O VENDEDOR
		JPanel panelInferior = new JPanel((LayoutManager) null);
		panelInferior.setBackground(new Color(0, 0, 139));
		panelInferior.setBounds(10, 423, 765, 60);
		contentPane.add(panelInferior);
		
		lbIngresoAdmin = new JLabel("Auteticaci\u00F3n - Personal");
		lbIngresoAdmin.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/key.png")));
		lbIngresoAdmin.setBounds(250, 20, 265, 20);
		lbIngresoAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lbIngresoAdmin.setFont(new Font("Georgia Ref", Font.ITALIC, 14));
		lbIngresoAdmin.setForeground(new Color(65, 105, 225));
		panelInferior.add(lbIngresoAdmin);
		
		JPanel panel = new ImagenFondo();
		panel.setBackground(Color.GREEN);
		panel.setBounds(420, 71, 355, 342);
		contentPane.add(panel);
	}
	
	
	// IMAGEN
	class ImagenFondo extends JPanel	{
		private static final long serialVersionUID = 1L;
		private Image imagen;
		//METODOS
		public void paint (Graphics g)
		{
			imagen = new ImageIcon(getClass().getResource("/imagenes/BeFunky-collage.jpg")).getImage();
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
			super.paint(g);
		}
	}
}

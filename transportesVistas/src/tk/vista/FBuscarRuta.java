package tk.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.io.File;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class FBuscarRuta extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	private String origen;
	private String destino;
	private Date fecha;
	private int filtradorServicios=-1;
	public static int controladorBack = 0;

	// CAMPOS DEL FRAME
	private JCheckBox cbxEvolution, cbxSuite; 		// checkBoxs de los tipos de crucero: Evolution | Suite 
	private JPanel contentPane2 = new JPanel(null);
	public JButton btnVolver, btnSaltar, botonBuscar;
	
	/* Launch the application. */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FBuscarRuta hs = new FBuscarRuta();
					hs.setVisible(true);				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// CONSTRUCTORES
	public FBuscarRuta() {	
		this("AREQUIPA", "LIMA", new Date());	// Rutas por defecto
	}
		
	public FBuscarRuta(String orig, String dest, Date fech) {
		this.origen = orig;
		this.destino = dest;
		this.fecha = fech;
		
		if(controladorBack>1)	controladorBack=0;				// esta variable controla si con el botón Volver, regresa al formulario BuscarRuta o a los horarios de la ruta de ida
		
		initializeFrame();
	}
		
	
	
	// MÉTODO PARA CREAR EL FORMULARIO DE HORARIOS Y SERVICIOS
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
		
		// ENCABEZADO: EMPRESA DE TRANSPORTES UTP
		JPanel encabezado = new JPanel(null);
		encabezado.setBounds(10, 0, 765, 60);
		encabezado.setBackground(new Color(0, 0, 139));

		JLabel lblEncabezado = new JLabel("HORARIOS Y SERVICIOS"+((controladorBack==0)?" - IDA":((controladorBack==1)?" - RETORNO":"")));
		lblEncabezado.setBounds(0, 0, 765, 60);
		lblEncabezado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEncabezado.setForeground(Color.WHITE);
		lblEncabezado.setFont(new Font("Georgia Ref", Font.BOLD, 25));	
		encabezado.add(lblEncabezado);
		contentPane.add(encabezado);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnVolver.setBounds(10, 10, 70, 25);
		encabezado.add(btnVolver);
		
		btnSaltar = new JButton("Solo Ida");
		btnSaltar.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnSaltar.setBounds(655, 12, 90, 25);
		if(controladorBack==0) btnSaltar.setVisible(false);
		encabezado.add(btnSaltar);
		
		//--------------------- PANEL PARA FILTRAR HORARIOS Y SERVICIOS ----------------------//
		
		JPanel panelFiltros = new JPanel(null);
		panelFiltros.setBounds(10, 70, 765, 90);
		panelFiltros.setBackground(new Color(65, 105, 225));
		contentPane.add(panelFiltros);
		
		//Label Tipo de Servicio
		JLabel lblTipoDe = new JLabel("TIPO DE");
		lblTipoDe.setForeground(Color.WHITE);
		lblTipoDe.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblTipoDe.setBounds(20, 25, 100, 20);
		panelFiltros.add(lblTipoDe);
		
		JLabel lblServicio = new JLabel("SERVICIO  :");
		lblServicio.setForeground(Color.WHITE);
		lblServicio.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblServicio.setBounds(20, 45, 100, 20);
		panelFiltros.add(lblServicio);
		
		// CheckBoxs
		cbxEvolution = new JCheckBox("Crucero Evolution");
		cbxEvolution.setForeground(Color.WHITE);
		cbxEvolution.setBackground(new Color(65, 105, 225));
		cbxEvolution.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		cbxEvolution.setBounds(110, 20, 140, 20);
		cbxEvolution.setSelected(true);
		panelFiltros.add(cbxEvolution);

		cbxSuite = new JCheckBox("Confort Suite");
		cbxSuite.setForeground(Color.WHITE);
		cbxSuite.setBackground(new Color(65, 105, 225));
		cbxSuite.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		cbxSuite.setBounds(110, 55, 140, 20);
		cbxSuite.setSelected(true);
		panelFiltros.add(cbxSuite);

		// Línea divisoria
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(370, 10, 2, 70);
		panelFiltros.add(separator);

		//------------------------------------- DATOS DEL VIAJE -----------------------------------------//
		
		// Ciudad de Origen y de Destino
		JLabel lblOrigen = new JLabel("ORIGEN   :");
		lblOrigen.setForeground(Color.WHITE);
		lblOrigen.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		lblOrigen.setBounds(390, 20, 70, 20);
		panelFiltros.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("DESTINO :");
		lblDestino.setForeground(Color.WHITE);
		lblDestino.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		lblDestino.setBounds(390, 54, 70, 20);
		panelFiltros.add(lblDestino);
		
		JTextField txtOrigen = new JTextField(origen.toUpperCase());								
		txtOrigen.setEditable(false);
		txtOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		txtOrigen.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		txtOrigen.setBounds(460, 18, 90, 20);
		txtOrigen.setColumns(10);
		panelFiltros.add(txtOrigen);
		
		JTextField txtDestino = new JTextField(destino.toUpperCase());	
		txtDestino.setEditable(false);
		txtDestino.setHorizontalAlignment(SwingConstants.CENTER);
		txtDestino.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		txtDestino.setBounds(460, 52, 90, 20);
		txtDestino.setColumns(10);
		panelFiltros.add(txtDestino);
		
		// Fecha de Ida (y retorno)
		JLabel lblFecIda = new JLabel("FEC. IDA             :");
		lblFecIda.setForeground(Color.WHITE);
		lblFecIda.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		lblFecIda.setBounds(575, 20, 100, 20);
		panelFiltros.add(lblFecIda);
		
		JLabel lblFecRetorno = new JLabel("FEC. RETORNO :");
		lblFecRetorno.setForeground(Color.WHITE);
		lblFecRetorno.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		lblFecRetorno.setBounds(575, 54, 100, 20);
		panelFiltros.add(lblFecRetorno);
		
		JTextField txtFechaIda = new JTextField("Viaje.getStrFecIda()");		// Fecha de ida
		txtFechaIda.setEditable(false);
		txtFechaIda.setHorizontalAlignment(SwingConstants.CENTER);
		txtFechaIda.setFont(new Font("Garamond", Font.PLAIN, 12));
		txtFechaIda.setBounds(675, 18, 70, 20);
		txtFechaIda.setColumns(10);
		panelFiltros.add(txtFechaIda);
		
		JTextField txtFechaRetorno = new JTextField("Viaje.getStrFecRet()");		// Fecha de retorno es opcional
		txtFechaRetorno.setEditable(false);
		txtFechaRetorno.setHorizontalAlignment(SwingConstants.CENTER);
		txtFechaRetorno.setFont(new Font("Garamond", Font.PLAIN, 12));
		txtFechaRetorno.setBounds(675, 52, 70, 20);
		txtFechaRetorno.setColumns(10);
		panelFiltros.add(txtFechaRetorno);
		
		//------------------------------------------------------------------------------------------------------// 
		contentPane2.setBackground(Color.DARK_GRAY);
		contentPane2.setBounds(10, 170, 765, 313);
		contentPane.add(contentPane2);

		botonBuscar = new JButton("BUSCAR");
		botonBuscar.setMargin(new Insets(2,2,2,2));
		botonBuscar.setIcon(new ImageIcon(FBuscarRuta.class.getResource("/imagenes/search.png")));
		botonBuscar.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		botonBuscar.setBounds(260, 30, 90, 30);
		panelFiltros.add(botonBuscar);
	}
}

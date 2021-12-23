package tk.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class MantRutas extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	// COMPONENTES DEL FRAME
	public JTable tablaClientes = new JTable();
	
	public JTextField txtCodigo, txtNombres, txtApePat, txtApeMat; 
	public JTextField txtDni, txtCelular, txtDireccion, txtEmail;
	public JComboBox<String> comboBox_sx;
	
	public ButtonGroup grupoTB;
	public JTextField txtBusqueda;
	public JRadioButton rdbEmail, rdbNombres, rdbCodigo, rdbApellidos, rdbDireccion, rdbCelular;
	
	// Botones de matenimiento
	public JButton btnInsertar, btnModificar, btnEliminar;
	
	// Otros botones
	public JButton btnVolver;
	public JButton btnBuscar;
	public  JCheckBox chxBExacta;
	
	/* Launch the application. */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantRutas mc = new MantRutas();
					CtrlCliente c = new CtrlCliente(mc);
					c.listar(mc.tablaClientes);
					mc.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//CONSTRUCTOR
	public MantRutas() {
		
		tablaClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CÓD", "NOMBRES","APELLIDOS", "DNI", "SEXO", "CELULAR", "DIRECCIÓN","E-MAIL" 
			}
		));

		initializeFrame();
	}
	
	// MÉTODO PARA CREAR EL FORMULARIO DE MANTENIMIENTO DE CLIENTES
	public void initializeFrame() {
		
		setTitle("TK-TRANSPORTES");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MantRutas.class.getResource("/imagenes/logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1150, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		JPanel contentPane = new JPanel(null);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//-------------------------- ENCABEZADO --------------------------//
		
		// ENCABEZADO: BÚSQUEDA DE BOLETOS
		JPanel encabezado = new JPanel(null);
		encabezado.setBackground(new Color(0, 0, 139));
		encabezado.setBounds(10, 0, 1116, 60);
		contentPane.add(encabezado);
		
		JLabel lblMantClientes = new JLabel("MANTENIMIENTO DE CLIENTES");
		lblMantClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantClientes.setForeground(Color.WHITE);
		lblMantClientes.setFont(new Font("Georgia Ref", Font.BOLD, 25));
		lblMantClientes.setBounds(0, 0, 1116, 60);
		encabezado.add(lblMantClientes);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnVolver.setBounds(10, 10, 70, 25);
		encabezado.add(btnVolver);
		
		
		//---------------------- TABLA DE REGISTROS ----------------------//
		JPanel panelTabla = new JPanel();
		panelTabla.setBounds(10, 214, 1116, 459);
		panelTabla.setBackground(new Color(65, 105, 225));
		contentPane.add(panelTabla);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 234, 700, 426);
		contentPane.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(tablaClientes);
		
		tablaClientes.setRowHeight(18);
		tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(20);
		tablaClientes.getColumnModel().getColumn(3).setPreferredWidth(40);
		tablaClientes.getColumnModel().getColumn(4).setPreferredWidth(20);
		tablaClientes.getColumnModel().getColumn(5).setPreferredWidth(40);
		tablaClientes.getColumnModel().getColumn(6).setPreferredWidth(100);
	
		
		//-------------------------- BÚSQUEDAS --------------------------//
		
		JPanel panelOpciones = new JPanel(null);
		panelOpciones.setBounds(10, 65, 1116, 142);
		panelOpciones.setBackground(new Color(65, 105, 225));
		contentPane.add(panelOpciones);
		
		JLabel lblTipoDeB = new JLabel("TIPO DE B\u00DASQUEDA    :");
		lblTipoDeB.setForeground(Color.WHITE);
		lblTipoDeB.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblTipoDeB.setBounds(30, 20, 180, 27);
		panelOpciones.add(lblTipoDeB);
		
		grupoTB = new ButtonGroup();
		
		// RADIO BUTTON BUSCAR POR CÓDIGO
		rdbCodigo = new JRadioButton("C\u00D3DIGO");
		rdbCodigo.setForeground(Color.WHITE);
		rdbCodigo.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		rdbCodigo.setBackground(new Color(65, 105, 225));
		rdbCodigo.setBounds(230, 20, 120, 24);
		grupoTB.add(rdbCodigo);
		panelOpciones.add(rdbCodigo);
		
		// RADIO BUTTON BUSCAR POR NOMBRES
		rdbNombres = new JRadioButton("NOMBRES");
		rdbNombres.setForeground(Color.WHITE);
		rdbNombres.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		rdbNombres.setBackground(new Color(65, 105, 225));
		rdbNombres.setBounds(370, 20, 120, 24);
		grupoTB.add(rdbNombres);
		panelOpciones.add(rdbNombres);
		
		// RADIO BUTTON BUSCAR POR APELLIDOS
		rdbApellidos = new JRadioButton("APELLIDOS");
		rdbApellidos.setForeground(Color.WHITE);
		rdbApellidos.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		rdbApellidos.setBackground(new Color(65, 105, 225));
		rdbApellidos.setBounds(510, 20, 120, 24);
		grupoTB.add(rdbApellidos);
		panelOpciones.add(rdbApellidos);
		
		// RADIO BUTTON BUSCAR POR CELULAR
		rdbCelular = new JRadioButton("CELULAR");
		rdbCelular.setForeground(Color.WHITE);
		rdbCelular.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		rdbCelular.setBackground(new Color(65, 105, 225));
		rdbCelular.setBounds(230, 50, 120, 24);
		grupoTB.add(rdbCelular);
		panelOpciones.add(rdbCelular);
		
		// RADIO BUTTON BUSCAR POR DIRECCIÓN
		rdbDireccion = new JRadioButton("DIRECCI\u00D3N");
		rdbDireccion.setForeground(Color.WHITE);
		rdbDireccion.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		rdbDireccion.setBackground(new Color(65, 105, 225));
		rdbDireccion.setBounds(370, 50, 120, 24);
		grupoTB.add(rdbDireccion);
		panelOpciones.add(rdbDireccion);

		// RADIO BUTTON BUSCAR POR E-MAIL
		rdbEmail = new JRadioButton("E-MAIL");
		rdbEmail.setForeground(Color.WHITE);
		rdbEmail.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		rdbEmail.setBackground(new Color(65, 105, 225));
		rdbEmail.setBounds(510, 50, 120, 24);
		grupoTB.add(rdbEmail);
		panelOpciones.add(rdbEmail);
		
		// TEXTO A BUSCAR
		JLabel lblTextoBuscado = new JLabel("TEXTO BUSCADO         :");
		lblTextoBuscado.setForeground(Color.WHITE);
		lblTextoBuscado.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblTextoBuscado.setBounds(30, 100, 180, 27);
		panelOpciones.add(lblTextoBuscado);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setColumns(10);
		txtBusqueda.setBounds(230, 100, 220, 26);
		panelOpciones.add(txtBusqueda);
		
		// CHECKBOX  - BUSQUEDA EXACTA
		chxBExacta = new JCheckBox("COINCIDIR");
		chxBExacta.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		chxBExacta.setForeground(Color.WHITE);
		chxBExacta.setBackground(new Color(65, 105, 225));
		chxBExacta.setBounds(610, 100, 110, 27);
		panelOpciones.add(chxBExacta);

		//-------------------- BOTONES DE MANTEMIENTO --------------------//
		btnBuscar = new JButton("  Buscar");
		btnBuscar.setIcon(new ImageIcon(MantRutas.class.getResource("/imagenes/search.png")));
		btnBuscar.setBounds(470, 100, 120, 30);
		btnBuscar.setFont(new Font("Eras Bold ITC", Font.PLAIN, 12));
		panelOpciones.add(btnBuscar);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setFont(new Font("Eras Bold ITC", Font.PLAIN, 12));
		btnInsertar.setBounds(750, 620, 100, 30);
		contentPane.add(btnInsertar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Eras Bold ITC", Font.PLAIN, 12));
		btnModificar.setBounds(873, 620, 100, 30);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Eras Bold ITC", Font.PLAIN, 12));
		btnEliminar.setBounds(996, 620, 100, 30);
		contentPane.add(btnEliminar);
		
		
		//--------------------- CLIENTE SELECCIONADO --------------------//
		
		// CÓDIGO DEL CLIENTE
		JLabel lblCodigo = new JLabel("C\u00D3DIGO         :");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblCodigo.setBounds(760, 220, 110, 24);
		contentPane.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(880, 220, 216, 24);
		contentPane.add(txtCodigo);
		
		// NOMBRE DEL CLIENTE
		JLabel lblNombres = new JLabel("NOMBRES      :");
		lblNombres.setForeground(Color.WHITE);
		lblNombres.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblNombres.setBounds(760, 268, 110, 24);
		contentPane.add(lblNombres);

		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(880, 268, 216, 24);
		contentPane.add(txtNombres);
		
		// APELLIDOS DEL CLIENTE
		JLabel lblApellidos = new JLabel("APELLIDOS   :");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblApellidos.setBounds(760, 316, 110, 24);
		contentPane.add(lblApellidos);

		txtApePat = new JTextField();
		txtApePat.setColumns(10);
		txtApePat.setBounds(880, 316, 100, 24);
		contentPane.add(txtApePat);
	
		txtApeMat = new JTextField();
		txtApeMat.setColumns(10);
		txtApeMat.setBounds(986, 316, 110, 24);
		contentPane.add(txtApeMat);
		
		// DNI
		JLabel lblDni = new JLabel("DNI                   :");
		lblDni.setForeground(Color.WHITE);
		lblDni.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblDni.setBounds(760, 364, 110, 24);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(880, 364, 216, 24);
		contentPane.add(txtDni);

		// SEXO
		JLabel lblSexo = new JLabel("SEXO               :");
		lblSexo.setForeground(Color.WHITE);
		lblSexo.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblSexo.setBounds(760, 412, 110, 24);
		contentPane.add(lblSexo);

		comboBox_sx = new JComboBox<String>();
		comboBox_sx.setModel(new DefaultComboBoxModel<String>(new String[] {"MASCULINO", "FEMENINO"}));
		comboBox_sx.setToolTipText("");
		comboBox_sx.setBounds(880, 412, 216, 24);
		contentPane.add(comboBox_sx);
		
		// CELULAR DEL CLIENTE
		JLabel lblCelular = new JLabel("CELULAR       :");
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblCelular.setBounds(760, 460, 110, 24);
		contentPane.add(lblCelular);

		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(880, 460, 216, 24);
		contentPane.add(txtCelular);
		
		// DIRECCIÓN
		JLabel lblDireccion = new JLabel("DIRECCI\u00D3N   :");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblDireccion.setBounds(760, 508, 110, 24);
		contentPane.add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(880, 508, 216, 24);
		contentPane.add(txtDireccion);

		// E-MAIL DEL CLIENTE
		JLabel lblEmail = new JLabel("E-MAIL           :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblEmail.setBounds(760, 556, 110, 24);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(880, 556, 216, 24);
		contentPane.add(txtEmail);
		
	}
}

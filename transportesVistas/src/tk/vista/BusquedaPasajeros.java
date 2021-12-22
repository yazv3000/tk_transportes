package tk.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class BusquedaPasajeros extends JFrame {
	private static final long serialVersionUID = 1L;

	// CAMPOS DEL FRAME
	private JTable table;
	private JTextField textoBuscado;
	private JRadioButton rdbBNombres, rdbBApellidos, rdbBFecha;	// radioButtons para la Búsqueda
	private JRadioButton rdbONombres, rdbOApellidos, rdbOFecha, rdbOAsc, rdbODesc;	// radioButtons para el Ordenamiento
	
	// Método main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaPasajeros frame = new BusquedaPasajeros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// CONSTRUCTOR
	public BusquedaPasajeros() {
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOMBRES", "APELLIDOS", "Nº BOLETO", "ORIGEN", "DESTINO", "FECHA DE VIAJE"
			}
		));
		
		initializeFrame();
	}
	
	// MÉTODO PARA CREAR EL FORMULARIO BÚSQUEDA DE PASAJEROS 	(solo accesible para el administrador)
	public void initializeFrame() {
		ImageIcon icono = new ImageIcon("src/imagenes/logo_utp.jpg");
		setIconImage(icono.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 530);
		setResizable(false);
		this.setLocationRelativeTo(null); 
		
		JPanel contentPane = new JPanel(null);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// ENCABEZADO: BÚSQUEDA DE PASAJEROS
		JPanel encabezado = new JPanel(null);
		encabezado.setBackground(new Color(0, 0, 139));
		encabezado.setBounds(10, 0, 765, 60);
		contentPane.add(encabezado);
		
		JLabel lblBsquedaDePasajeros = new JLabel("B\u00DASQUEDA DE PASAJEROS");
		lblBsquedaDePasajeros.setHorizontalAlignment(SwingConstants.CENTER);
		lblBsquedaDePasajeros.setForeground(Color.WHITE);
		lblBsquedaDePasajeros.setFont(new Font("Georgia Ref", Font.BOLD, 25));
		lblBsquedaDePasajeros.setBounds(0, 0, 770, 60);
		encabezado.add(lblBsquedaDePasajeros);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnVolver.setBounds(10, 10, 70, 25);
		encabezado.add(btnVolver);
		
		// PANEL CON OPCIONES PARA BUSCAR Y ORDENAR
		JPanel panelOpciones = new JPanel(null);
		panelOpciones.setBackground(new Color(65, 105, 225));
		panelOpciones.setBounds(10, 70, 765, 108);
		contentPane.add(panelOpciones);
		
		//---------------------------------- BÚSQUEDAS ----------------------------------// 
		// Label tipo de búsqueda
		JLabel lblTipoBusqueda = new JLabel("TIPO DE B\u00DASQUEDA :");
		lblTipoBusqueda.setForeground(Color.WHITE);
		lblTipoBusqueda.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblTipoBusqueda.setBounds(20, 10, 150, 20);
		panelOpciones.add(lblTipoBusqueda);
		
		ButtonGroup grupoB = new ButtonGroup();
		
		// Radio Button Buscar por Nombres
		rdbBNombres = new JRadioButton("Nombres");
		rdbBNombres.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbBNombres.setForeground(Color.WHITE);
		rdbBNombres.setBackground(new Color(65, 105, 225));
		rdbBNombres.setBounds(20, 35, 100, 20);
		grupoB.add(rdbBNombres);
		panelOpciones.add(rdbBNombres);
		
		// Radio Button Buscar por Apellidos
		rdbBApellidos = new JRadioButton("Apellidos");
		rdbBApellidos.setForeground(Color.WHITE);
		rdbBApellidos.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbBApellidos.setBackground(new Color(65, 105, 225));
		rdbBApellidos.setBounds(130, 35, 100, 20);
		grupoB.add(rdbBApellidos);
		panelOpciones.add(rdbBApellidos);
		
		// Radio Button Buscar por Fecha de Viaje
		rdbBFecha = new JRadioButton("Fecha de Viajes");
		rdbBFecha.setForeground(Color.WHITE);
		rdbBFecha.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbBFecha.setBackground(new Color(65, 105, 225));
		rdbBFecha.setBounds(240, 35, 120, 20);
		grupoB.add(rdbBFecha);
		panelOpciones.add(rdbBFecha);
		
		// Texto buscado
		textoBuscado = new JTextField();
		textoBuscado.setBounds(20, 70, 200, 24);
		panelOpciones.add(textoBuscado);
		textoBuscado.setColumns(10);
		
		// Botón buscar
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(BusquedaPasajeros.class.getResource("/imagenes/search.png")));
		btnBuscar.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnBuscar.setBounds(250, 69, 100, 26);
		panelOpciones.add(btnBuscar);
		
		
		//---- Línea de sepación ------
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(380, 10, 2, 88);
		panelOpciones.add(separator);
		
		//----------------------------------  ORDENAMIENTO ----------------------------------// 
		// Label tipo de ordenamiento
		JLabel lblTipoOrden = new JLabel("TIPO DE ORDENAMIENTO :");
		lblTipoOrden.setForeground(Color.WHITE);
		lblTipoOrden.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblTipoOrden.setBounds(412, 10, 200, 20);
		panelOpciones.add(lblTipoOrden);
		
		ButtonGroup grupoTO = new ButtonGroup();
		ButtonGroup grupoMO = new ButtonGroup();
		
		// Radio Button Ordenar por Nombres
		rdbONombres = new JRadioButton("Nombres");
		rdbONombres.setForeground(Color.WHITE);
		rdbONombres.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbONombres.setBackground(new Color(65, 105, 225));
		rdbONombres.setBounds(412, 35, 100, 20);
		grupoTO.add(rdbONombres);
		panelOpciones.add(rdbONombres);
		
		// Radio Button Ordenar por Apellidos
		rdbOApellidos = new JRadioButton("Apellidos");
		rdbOApellidos.setForeground(Color.WHITE);
		rdbOApellidos.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbOApellidos.setBackground(new Color(65, 105, 225));
		rdbOApellidos.setBounds(520, 35, 100, 20);
		grupoTO.add(rdbOApellidos);
		panelOpciones.add(rdbOApellidos);
		
		// Radio Button Ordenar por Fechas de viaje
		rdbOFecha = new JRadioButton("Fecha de Viajes");
		rdbOFecha.setForeground(Color.WHITE);
		rdbOFecha.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbOFecha.setBackground(new Color(65, 105, 225));
		rdbOFecha.setBounds(620, 35, 120, 21);
		grupoTO.add(rdbOFecha);
		panelOpciones.add(rdbOFecha);
		
		// Radio Button Ordenamiento de manera ascendente (A -> Z, fechaMenor -> fechaMayor)
		rdbOAsc = new JRadioButton("Ascendente");
		rdbOAsc.setForeground(Color.WHITE);
		rdbOAsc.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbOAsc.setBackground(new Color(65, 105, 225));
		rdbOAsc.setBounds(412, 70, 100, 20);
		grupoMO.add(rdbOAsc);
		panelOpciones.add(rdbOAsc);
		
		// Radio Button Ordenamiento de manera descendente (Z -> A, fechaMayor -> fechaMenor)
		rdbODesc = new JRadioButton("Descendente");
		rdbODesc.setForeground(Color.WHITE);
		rdbODesc.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbODesc.setBackground(new Color(65, 105, 225));
		rdbODesc.setBounds(520, 70, 100, 21);
		grupoMO.add(rdbODesc);
		panelOpciones.add(rdbODesc);

		// Botón ordenar
		JButton btnOrdenar = new JButton("Ordenar");
		btnOrdenar.setIcon(new ImageIcon(BusquedaPasajeros.class.getResource("/imagenes/sort.png")));
		btnOrdenar.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnOrdenar.setBounds(625, 68, 110, 26);
		panelOpciones.add(btnOrdenar);
		
		// PANEL DE LA TABLA CON LOS REGISTROS DE PASAJEROS
		JPanel panelTabla = new JPanel(null); 
		panelTabla.setBackground(new Color(65, 105, 225));
		panelTabla.setBounds(10, 188, 765, 295);
		contentPane.add(panelTabla);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 745, 275);
		scrollPane.setViewportView(table);
		panelTabla.add(scrollPane);
	}
	
}

package tk.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;

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

import com.toedter.calendar.JDateChooser;


public class BusquedaBoletos extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// CAMPOS DEL FRAME
	private JTable table;
	private JTextField textoBusqueda;
	private JRadioButton rdbBOrigen, rdbBDestino, rdbBRangoFechas;
	private JRadioButton rdbOOrigen, rdbODestino, rdbOFecha;
	private JRadioButton rdbOAsc, rdbODesc;
	private JDateChooser dcFecha_1, dcFecha_2;
	
	// Método main
	public static void main(String[] args) {		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaBoletos frame = new BusquedaBoletos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// CONSTRUCTOR
	public BusquedaBoletos() {
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ORIGEN", "DESTINO", "FECHA DE VIAJE", "Nº BOLETO", "NOMBRES", "APELLIDOS"
			}
		));
		
		initializeFrame();
	}
	
	// MÉTODO PARA CREAR EL FORMULARIO DE BÚSQUEDA DE BOLETOS 	(solo accesible para el administrador)
	public void initializeFrame() {
		ImageIcon icono = new ImageIcon("src/imagenes/logo_utp.jpg");
		setIconImage(icono.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 530);
		setResizable(false);
		this.setLocationRelativeTo(null); 
		
		JPanel contentPane = new JPanel(null);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// ENCABEZADO: BÚSQUEDA DE BOLETOS
		JPanel encabezado = new JPanel(null);
		encabezado.setBackground(new Color(0, 0, 139));
		encabezado.setBounds(10, 0, 765, 60);
		contentPane.add(encabezado);
		
		JLabel lblBsquedaDeBoletos = new JLabel("B\u00DASQUEDA DE BOLETOS DE VIAJE");
		lblBsquedaDeBoletos.setHorizontalAlignment(SwingConstants.CENTER);
		lblBsquedaDeBoletos.setForeground(Color.WHITE);
		lblBsquedaDeBoletos.setFont(new Font("Georgia Ref", Font.BOLD, 25));
		lblBsquedaDeBoletos.setBounds(0, 0, 770, 60);
		encabezado.add(lblBsquedaDeBoletos);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnVolver.setBounds(10, 10, 70, 25);
		encabezado.add(btnVolver);
		
		// PANEL CON OPCIONES PARA BUSCAR
		JPanel panelOpciones1 = new JPanel(null);
		panelOpciones1.setBackground(new Color(65, 105, 225));
		panelOpciones1.setBounds(10, 70, 765, 108);
		contentPane.add(panelOpciones1);
		
		//---------------------------------- BÚSQIUEDAS ----------------------------------// 
		// Label tipo de búsqueda
		JLabel lblTipoBusqueda = new JLabel("TIPO DE B\u00DASQUEDA :");
		lblTipoBusqueda.setForeground(Color.WHITE);
		lblTipoBusqueda.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblTipoBusqueda.setBounds(30, 10, 150, 20);
		panelOpciones1.add(lblTipoBusqueda);
		
		ButtonGroup grupoB = new ButtonGroup();
		
		// Radio Button Buscar por Origen
		rdbBOrigen = new JRadioButton("Origen");
		rdbBOrigen.setForeground(Color.WHITE);
		rdbBOrigen.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbBOrigen.setBackground(new Color(65, 105, 225));
		rdbBOrigen.setBounds(30, 35, 80, 20);
		grupoB.add(rdbBOrigen);
		panelOpciones1.add(rdbBOrigen);
		
		// Radio Button Buscar por Destino
		rdbBDestino = new JRadioButton("Destino");
		rdbBDestino.setForeground(Color.WHITE);
		rdbBDestino.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbBDestino.setBackground(new Color(65, 105, 225));
		rdbBDestino.setBounds(130, 35, 80, 20);
		grupoB.add(rdbBDestino);
		panelOpciones1.add(rdbBDestino);
		
		
		// Texto buscado (para ciudad de Origen o Destino)
		JLabel lblCiudad = new JLabel("Ciudad :");
		lblCiudad.setForeground(Color.WHITE);
		lblCiudad.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		lblCiudad.setBounds(240, 35, 60, 20);
		panelOpciones1.add(lblCiudad);
		
		textoBusqueda = new JTextField();
		textoBusqueda.setColumns(10);
		textoBusqueda.setBounds(300, 35, 120, 20);
		panelOpciones1.add(textoBusqueda);
		
		// Radio Button Buscar por Fechas de viaje
		rdbBRangoFechas = new JRadioButton("Rango de Fechas de Viaje");
		rdbBRangoFechas.setForeground(Color.WHITE);
		rdbBRangoFechas.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbBRangoFechas.setBackground(new Color(65, 105, 225));
		rdbBRangoFechas.setBounds(30, 69, 180, 21);
		panelOpciones1.add(rdbBRangoFechas);
		
		// DateChoosers para buscar en un rango de fechas
		JLabel lblDesde = new JLabel("Desde :");
		lblDesde.setForeground(Color.WHITE);
		lblDesde.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		lblDesde.setBounds(240, 70, 60, 20);
		panelOpciones1.add(lblDesde);
		
		dcFecha_1 = new JDateChooser();
		dcFecha_1.setDateFormatString("dd/MM/yyyy");
		dcFecha_1.setBounds(300, 70, 120, 20);
		panelOpciones1.add(dcFecha_1);

		//--
		JLabel lblHasta = new JLabel("Hasta :");
		lblHasta.setForeground(Color.WHITE);
		lblHasta.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		lblHasta.setBounds(445, 70, 60, 20);
		panelOpciones1.add(lblHasta);
		
		dcFecha_2 = new JDateChooser();
		dcFecha_2.setDateFormatString("dd/MM/yyyy");
		dcFecha_2.setBounds(500, 70, 120, 20);
		panelOpciones1.add(dcFecha_2);
		
		// Botón buscar
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(BusquedaBoletos.class.getResource("/imagenes/search.png")));
		btnBuscar.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnBuscar.setBounds(645, 67, 100, 25);
		panelOpciones1.add(btnBuscar);
		
		//--------------------------------------------------------------------------------------//
		
		//-------------------------------- ORDENAMIENTO --------------------------------// 
		JPanel panelOpciones2 = new JPanel((LayoutManager) null);
		panelOpciones2.setBackground(new Color(65, 105, 225));
		panelOpciones2.setBounds(10, 418, 765, 65);
		contentPane.add(panelOpciones2);
		
		// Label tipo de ordenamiento
		JLabel lblTipoDeOrdenamiento = new JLabel("TIPO DE ORDENAMIENTO :");
		lblTipoDeOrdenamiento.setForeground(Color.WHITE);
		lblTipoDeOrdenamiento.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblTipoDeOrdenamiento.setBounds(30, 10, 200, 20);
		panelOpciones2.add(lblTipoDeOrdenamiento);
		
		ButtonGroup grupoTO = new ButtonGroup();
		ButtonGroup grupoMO = new ButtonGroup();
		
		// Radio Button Ordenar por Origen
		rdbOOrigen = new JRadioButton("Origen");
		rdbOOrigen.setForeground(Color.WHITE);
		rdbOOrigen.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbOOrigen.setBackground(new Color(65, 105, 225));
		rdbOOrigen.setBounds(30, 35, 80, 20);
		grupoTO.add(rdbOOrigen);
		panelOpciones2.add(rdbOOrigen);
		
		// Radio Button Ordenar por Destino 
		rdbODestino = new JRadioButton("Destino");
		rdbODestino.setForeground(Color.WHITE);
		rdbODestino.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbODestino.setBackground(new Color(65, 105, 225));
		rdbODestino.setBounds(130, 35, 80, 20);
		grupoTO.add(rdbODestino);
		panelOpciones2.add(rdbODestino);
		
		// Radio Button Ordenar por Fechas de viaje
		rdbOFecha = new JRadioButton("Fechas de Viaje");
		rdbOFecha.setForeground(Color.WHITE);
		rdbOFecha.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbOFecha.setBackground(new Color(65, 105, 225));
		rdbOFecha.setBounds(230, 35, 120, 20);
		grupoTO.add(rdbOFecha);
		panelOpciones2.add(rdbOFecha);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(381, 30, 2, 25);
		panelOpciones2.add(separator);
		
		// Radio Button Ordenamiento de manera ascendente (A -> Z, fechaMenor -> fechaMayor)
		rdbOAsc = new JRadioButton("Ascendente");
		rdbOAsc.setForeground(Color.WHITE);
		rdbOAsc.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbOAsc.setBackground(new Color(65, 105, 225));
		rdbOAsc.setBounds(400, 35, 100, 20);
		grupoMO.add(rdbOAsc);
		panelOpciones2.add(rdbOAsc);
		
		rdbODesc = new JRadioButton("Descendente");
		rdbODesc.setForeground(Color.WHITE);
		rdbODesc.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		rdbODesc.setBackground(new Color(65, 105, 225));
		rdbODesc.setBounds(510, 35, 120, 20);
		grupoMO.add(rdbODesc);
		panelOpciones2.add(rdbODesc);
		
		// Botón ordenar
		JButton btnOrdenar = new JButton("Ordenar");
		btnOrdenar.setIcon(new ImageIcon(BusquedaBoletos.class.getResource("/imagenes/sort.png")));
		btnOrdenar.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnOrdenar.setBounds(640, 28, 105, 26);
		panelOpciones2.add(btnOrdenar);
		
		// PANEL DE LA TABLA CON LOS REGISTROS DE BOLETOS DE VIAJE
		JPanel panelTabla = new JPanel(null);
		panelTabla.setBackground(new Color(65, 105, 225));
		panelTabla.setBounds(10, 189, 765, 218);
		contentPane.add(panelTabla);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 745, 196);
		scrollPane.setViewportView(table);
		panelTabla.add(scrollPane);
	}
}
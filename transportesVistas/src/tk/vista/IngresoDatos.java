package tk.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/** EMPRESA DE TRANSPORTES UTP
 *  Versión 1.0		07/07/2021
 *  Versión 2.0 		19/07/2021
 *  @authors Y. A. Zapata Vargas, L. R. Puma Herencia
 */

public class IngresoDatos extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// CAMPOS DEL FRAME
	public static String txtlbl;
	private JLabel lblselecAs = new JLabel();
	
	private JTextField txtNombres, txtApellidos;
	private JTextField txtOrigen, txtDestino, txtFechaIda, txtFechaRetorno;
	
	private JTextField txtPrecioTotal, txtPrecioIda, txtPrecioRet;
	private JTextField txtNAsientoIda, txtNAsientoRet;
	private JTextField txtDniPasaporte;
	
	private JPanel panelOmniBus = new JPanel(null);
	private JPanel contentPane = new JPanel(null);
	
	public JButton btnVolver, btnCambiarAsIda, btnElegirAsIda, btnElegirAsRet, btnCambiarAsRet, btnCancelar, btnReservarSoloIda, btnReservar;
	
	
	/* Launch the application. */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresoDatos ingd = new IngresoDatos();
					ingd.setVisible(true);				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// CONSTRUCTOR
	public IngresoDatos() {
		
		txtlbl = "ida";
	
		initializeFrame();
		
	}
	
	// MÉTODOS PRIVADOS
	private void generarOmnibus()//Asiento[] asientos)
	{
		lblselecAs.setText("Asientos de "+txtlbl);

		// PANEL DEL OMNIBUS Y SUS ASIENTOS
		panelOmniBus.setBounds(410, 119, 181, 281);
		panelOmniBus.setBackground(new Color(0, 0, 139));
		contentPane.add(panelOmniBus);
				
		// COLUMNA DE LA IZQUIERDA
		JPanel columnaIzq = new JPanel();
		columnaIzq.setBounds(10, 21, 70, 250);
		panelOmniBus.add(columnaIzq);
		columnaIzq.setBackground(new Color(65, 105, 225));
		columnaIzq.setLayout(new GridLayout(10, 2, 0, 2));
			
		JPanel columnaDer = new JPanel();
		columnaDer.setBounds(100, 21, 71, 250);
		panelOmniBus.add(columnaDer);
		columnaDer.setBackground(new Color(65, 105, 225));
		columnaDer.setLayout(new GridLayout(10, 2, 0, 2));
		
		//BUCLE PARA CREAR LOS ASIENTOS DEL OMNIBUS
		for (int j = 0; j < 40; j++) 
		{
			if(j<20){
				columnaIzq.add(new JButton(j+"")); //asientos[j].getBotonAsiento());
			}else{
				columnaDer.add(new JButton(j+""));//asientos[j].getBotonAsiento());
			}
		}
	}

	
	// MÉTODO PARA CREAR EL FORMULARIO DE INGRESO DE DATOS DEL CLIENTE
	public void initializeFrame() {
		ImageIcon icono = new ImageIcon("src/imagenes/logo_utp.jpg");
		setIconImage(icono.getImage());
		
		setBounds(100, 100, 800, 530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// ENCABEZADO: RESERVA DE ASIENTO
		JPanel encabezado = new JPanel(null);
		encabezado.setBounds(10, 0, 765, 60);
		encabezado.setBackground(new Color(0, 0, 139));
		
		JLabel lblEncabezado = new JLabel("RESERVAR ASIENTO");
		lblEncabezado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEncabezado.setForeground(Color.WHITE);
		lblEncabezado.setFont(new Font("Georgia Ref", Font.BOLD, 25));
		lblEncabezado.setBounds(0, 0, 770, 60);
		encabezado.add(lblEncabezado);
		contentPane.add(encabezado);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Georgia Ref", Font.PLAIN, 12));
		btnVolver.setBounds(10, 10, 70, 25);
		encabezado.add(btnVolver);
		
		// PANEL PRINCIPAL - INGRESO DE DATOS
		JPanel panelPrincipal = new JPanel(null);
		panelPrincipal.setBackground(new Color(65, 105, 225));
		panelPrincipal.setBounds(10, 70, 380, 410);
		contentPane.add(panelPrincipal);
		
		// Label indicativo 1
		JLabel lblIngreseSusDatos = new JLabel("Ingrese sus datos :");
		lblIngreseSusDatos.setForeground(Color.WHITE);
		lblIngreseSusDatos.setFont(new Font("Gabriola", Font.BOLD, 20));
		lblIngreseSusDatos.setBounds(20, 10, 130, 40);
		panelPrincipal.add(lblIngreseSusDatos);
		
		// Línea separatoria
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 40, 340, 2);
		panelPrincipal.add(separator_1);
		
		//-------------------------- INGRESAR  NOMBRES ---------------------------//
		JLabel lblNombres = new JLabel("NOMBRES                         :");
		lblNombres.setForeground(Color.WHITE);
		lblNombres.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblNombres.setBounds(20, 60, 160, 20);
		panelPrincipal.add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(200, 60, 160, 20);
		panelPrincipal.add(txtNombres);
		txtNombres.setColumns(10);
		//----------------------------------------------------------------------------------// 
		
		//-------------------------- INGRESAR APELLIDOS  -------------------------//
		JLabel lblApellidos = new JLabel("APELLIDOS                      :");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblApellidos.setBounds(20, 95, 160, 20);
		panelPrincipal.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(200, 95, 160, 20);
		panelPrincipal.add(txtApellidos);
		//----------------------------------------------------------------------------------// 
		
		//--------------------- INGRESAR DNI O PASAPORTE  ----------------------//
		JLabel lblDniPasaporte = new JLabel("DNI / PASAPORTE       :");
		lblDniPasaporte.setForeground(Color.WHITE);
		lblDniPasaporte.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblDniPasaporte.setBounds(20, 130, 160, 20);
		panelPrincipal.add(lblDniPasaporte);
		
		txtDniPasaporte = new JTextField();
		txtDniPasaporte.setColumns(10);
		txtDniPasaporte.setBounds(200, 130, 160, 20);
		panelPrincipal.add(txtDniPasaporte);
		//----------------------------------------------------------------------------------// 
		
		// Label indicativo 2
		JLabel lblDatosViaje = new JLabel("Datos del viaje :");
		lblDatosViaje.setForeground(Color.WHITE);
		lblDatosViaje.setFont(new Font("Gabriola", Font.BOLD, 20));
		lblDatosViaje.setBounds(20, 206, 130, 40);
		panelPrincipal.add(lblDatosViaje);
		
		// Línea separatoria
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 236, 340, 2);
		panelPrincipal.add(separator_2);
		
		//---------------------------- DATOS DEL VIAJE -------------------------------//
		// ORIGEN
		JLabel lblOrigen = new JLabel("ORIGEN                              :");
		lblOrigen.setForeground(Color.WHITE);
		lblOrigen.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblOrigen.setBounds(20, 256, 160, 20);
		panelPrincipal.add(lblOrigen);
		
		txtOrigen = new JTextField("Viaje.getOrigen()");
		txtOrigen.setEditable(false);
		txtOrigen.setColumns(10);
		txtOrigen.setBounds(200, 256, 160, 20);
		panelPrincipal.add(txtOrigen);
		
		// DESTINO
		JLabel lblDestino = new JLabel("DESTINO                           :");
		lblDestino.setForeground(Color.WHITE);
		lblDestino.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblDestino.setBounds(20, 291, 160, 20);
		panelPrincipal.add(lblDestino);
		
		txtDestino = new JTextField("Viaje.getDestino()");
		txtDestino.setEditable(false);
		txtDestino.setColumns(10);
		txtDestino.setBounds(200, 291, 160, 20);
		panelPrincipal.add(txtDestino);
		
		// FECHA DE IDA
		JLabel lblFechaIda = new JLabel("FECHA DE IDA                :");
		lblFechaIda.setForeground(Color.WHITE);
		lblFechaIda.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblFechaIda.setBounds(20, 326, 160, 20);
		panelPrincipal.add(lblFechaIda);
		
		txtFechaIda = new JTextField("Viaje.getStrFecIda()");
		txtFechaIda.setEditable(false);
		txtFechaIda.setColumns(10);
		txtFechaIda.setBounds(200, 326, 160, 20);
		panelPrincipal.add(txtFechaIda);
		
		// FECHA DE RETORNO
		JLabel lblFechaRetorno = new JLabel("FECHA DE RETORNO :");
		lblFechaRetorno.setForeground(Color.WHITE);
		lblFechaRetorno.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblFechaRetorno.setBounds(20, 361, 160, 20);
		panelPrincipal.add(lblFechaRetorno);
		
		txtFechaRetorno = new JTextField("Viaje.getStrFecRet()");
		txtFechaRetorno.setEditable(false);
		txtFechaRetorno.setColumns(10);
		txtFechaRetorno.setBounds(200, 361, 160, 20);
		panelPrincipal.add(txtFechaRetorno);
		//----------------------------------------------------------------------------------// 
		JPanel panelPrecio = new JPanel(null);
		panelPrecio.setBackground(new Color(65, 105, 225));
		panelPrecio.setBounds(410, 410, 365, 70);
		contentPane.add(panelPrecio);

		JButton btnReservar = new JButton("RESERVAR");
		btnReservar.setForeground(new Color(0, 204, 0));
		btnReservar.setBounds(220, 18, 130, 30);
		btnReservar.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		panelPrecio.add(btnReservar);
		
		
		txtPrecioTotal = new JTextField("S/."+"Viaje.getPrecioTotal()");
		txtPrecioTotal.setFont(new Font("Garamond", Font.PLAIN, 14));
		txtPrecioTotal.setEditable(false);
		txtPrecioTotal.setColumns(10);
		txtPrecioTotal.setBounds(80, 18, 100, 35);
		panelPrecio.add(txtPrecioTotal);
		
		JLabel lblPrecioTotal_1 = new JLabel("PRECIO");
		lblPrecioTotal_1.setForeground(Color.WHITE);
		lblPrecioTotal_1.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblPrecioTotal_1.setBounds(10, 15, 70, 20);
		panelPrecio.add(lblPrecioTotal_1);
		
		JLabel lblPrecioTotal_2 = new JLabel("TOTAL :");
		lblPrecioTotal_2.setForeground(Color.WHITE);
		lblPrecioTotal_2.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblPrecioTotal_2.setBounds(10, 35, 70, 20);
		panelPrecio.add(lblPrecioTotal_2);
		
		JPanel panel_1 = new JPanel((LayoutManager) null);
		panel_1.setBackground(new Color(65, 105, 225));
		panel_1.setBounds(410, 69, 181, 40);
		contentPane.add(panel_1);
				
		lblselecAs.setForeground(Color.WHITE);
		lblselecAs.setFont(new Font("Gabriola", Font.BOLD, 20));
		lblselecAs.setBounds(10, 10, 200, 40);
		panel_1.add(lblselecAs);
		
		JPanel panel_2 = new JPanel((LayoutManager) null);
		panel_2.setBackground(new Color(65, 105, 225));
		panel_2.setBounds(605, 70, 171, 330);
		contentPane.add(panel_2);
		
		JLabel lblDatosAsIda = new JLabel("ASIENTO IDA:");
		lblDatosAsIda.setForeground(Color.WHITE);
		lblDatosAsIda.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblDatosAsIda.setBounds(10, 10, 120, 20);
		panel_2.add(lblDatosAsIda);
		
		JButton btnCambiarAsIda = new JButton("Cambiar");
		btnCambiarAsIda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNAsientoIda.setText("");		//muestra el campo vacío

				panelOmniBus.removeAll();
				panelOmniBus.repaint();
				panelOmniBus.revalidate();

				txtlbl = "ida";
				/*generarOmnibus(asientosIda);
				Asiento.controlador_1=0;*/
				//asientosIda[Integer.parseInt(nAsientoIda)-1].resetAsiento();
			}
		});
		btnCambiarAsIda.setFont(new Font("Georgia Ref", Font.PLAIN, 10));
		btnCambiarAsIda.setBounds(70, 71, 85, 20);
		panel_2.add(btnCambiarAsIda);
		
		JButton btnElegirAsIda = new JButton("Elegir");
		btnElegirAsIda.setFont(new Font("Georgia Ref", Font.PLAIN, 10));
		btnElegirAsIda.setBounds(70, 40, 85, 20);
		panel_2.add(btnElegirAsIda);
		
		JButton btnReservarSoloIda = new JButton("Reservar solo Ida");
		btnReservarSoloIda.setFont(new Font("Georgia Ref", Font.PLAIN, 10));
		btnReservarSoloIda.setBounds(10, 132, 144, 20);
		panel_2.add(btnReservarSoloIda);
		
		txtNAsientoIda = new JTextField();
		txtNAsientoIda.setHorizontalAlignment(SwingConstants.CENTER);
		txtNAsientoIda.setFont(new Font("Garamond", Font.PLAIN, 14));
		txtNAsientoIda.setEditable(false);
		txtNAsientoIda.setColumns(10);
		txtNAsientoIda.setBounds(10, 40, 50, 50);
		panel_2.add(txtNAsientoIda);
		
		txtPrecioIda = new JTextField("S/."+"Viaje.getRuta_1().getPrecio()");
		txtPrecioIda.setFont(new Font("Garamond", Font.PLAIN, 14));
		txtPrecioIda.setEditable(false);
		txtPrecioIda.setColumns(10);
		txtPrecioIda.setBounds(10, 102, 144, 20);
		panel_2.add(txtPrecioIda);
		
		JLabel lblDatosAsRet = new JLabel("ASIENTO RETORNO:");
		lblDatosAsRet.setForeground(Color.WHITE);
		lblDatosAsRet.setFont(new Font("Georgia Ref", Font.PLAIN, 14));
		lblDatosAsRet.setBounds(10, 177, 150, 20);
		panel_2.add(lblDatosAsRet);
		
		JButton btnElegirAsRet = new JButton("Elegir");
		btnElegirAsRet.setFont(new Font("Georgia Ref", Font.PLAIN, 10));
		btnElegirAsRet.setBounds(70, 207, 85, 20);
		panel_2.add(btnElegirAsRet);
		
		JButton btnCambiarAsRet = new JButton("Cambiar");
		btnCambiarAsRet.setFont(new Font("Georgia Ref", Font.PLAIN, 10));
		btnCambiarAsRet.setBounds(70, 238, 85, 20);
		panel_2.add(btnCambiarAsRet);
		
		txtNAsientoRet = new JTextField("");
		txtNAsientoRet.setHorizontalAlignment(SwingConstants.CENTER);
		txtNAsientoRet.setFont(new Font("Garamond", Font.PLAIN, 14));
		txtNAsientoRet.setEditable(false);
		txtNAsientoRet.setColumns(10);
		txtNAsientoRet.setBounds(10, 207, 50, 52);
		panel_2.add(txtNAsientoRet);
		
		txtPrecioRet = new JTextField();
		txtPrecioRet.setFont(new Font("Garamond", Font.PLAIN, 14));
		txtPrecioRet.setEditable(false);
		txtPrecioRet.setColumns(10);
		txtPrecioRet.setBounds(10, 269, 144, 20);
		panel_2.add(txtPrecioRet);
		
		/*
		if(Viaje.getRuta_2()!=null){
			txtPrecioRet.setText("S/."+Viaje.getRuta_2().getPrecio());
		}*/

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(Color.RED);
		btnCancelar.setFont(new Font("Georgia Ref", Font.PLAIN, 10));
		btnCancelar.setBounds(10, 299, 144, 20);
		panel_2.add(btnCancelar);
		
		if(false){//!Viaje.esIdayVuelta()) {	//Si el viaje es solo ida
			btnReservarSoloIda.setEnabled(false);
			btnReservarSoloIda.setBackground(Color.LIGHT_GRAY);
			txtNAsientoRet.setEnabled(false);
			txtNAsientoRet.setBackground(Color.LIGHT_GRAY);
			btnElegirAsRet.setEnabled(false);
			btnElegirAsRet.setBackground(Color.LIGHT_GRAY);
			btnCambiarAsRet.setEnabled(false);
			btnCambiarAsRet.setBackground(Color.LIGHT_GRAY);
			txtPrecioRet.setEnabled(false);
			txtPrecioRet.setBackground(Color.LIGHT_GRAY);
			lblDatosAsRet.setEnabled(false);
		}
	}
	
}

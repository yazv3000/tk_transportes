package tk.controladores;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

public class QueLoco extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueLoco frame = new QueLoco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QueLoco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(31, 41, 750, 300);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBackground(Color.DARK_GRAY);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.CYAN);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.GREEN);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.MAGENTA);
		
		
		GroupLayout gl = new GroupLayout(panel);
		
	
		/*gl.setHorizontalGroup(
			gl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl.createSequentialGroup()
					.addGap(10)
					.addGroup(gl.createParallelGroup(Alignment.LEADING)
						.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 710, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 710, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 710, GroupLayout.PREFERRED_SIZE)))
		);
		gl.setVerticalGroup(
			gl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl.createSequentialGroup()
					.addGap(10)
					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl);
		*/
		
		ParallelGroup pg = gl.createParallelGroup(Alignment.LEADING);
		SequentialGroup sq = gl.createSequentialGroup();
		
		// comentario
		/*pg.addComponent(panel1, 710, 710, 710);
		pg.addComponent(panel2, 710, 710, 710);
		pg.addComponent(panel3, 710, 710, 710);
		
		sq.addGap(10);
		sq.addComponent(panel1, 100, 100, 100);
		sq.addGap(10);
		sq.addComponent(panel2, 100, 100, 100);
		sq.addGap(10);
		sq.addComponent(panel3, 100, 100, 100);
		*/
		// comentario
		
		// solo para crear paneles
		JPanel[] arreglo = new JPanel[7];
		for(int i=0; i<7; i++) {
			JPanel pnl = new JPanel();
			pnl.add(new JLabel("Panel "+(i+1)));
			arreglo[i] = pnl;
		}
		
		// BUCLE PARA AGREGAR
		for(int i=0; i<7; i++) {
			pg.addComponent(arreglo[i], 710, 710, 710);
			sq.addGap(15);
			sq.addComponent(arreglo[i], 100, 100, 100);
		}
		sq.addGap(10);
		
		//  Horizontal
		gl.setHorizontalGroup(
				gl.createParallelGroup(Alignment.LEADING)
					.addGroup(gl.createSequentialGroup()
						.addGap(10)
						.addGroup(pg)));
		
		// Vertical
		gl.setVerticalGroup(
				gl.createParallelGroup(Alignment.LEADING)
					.addGroup(sq));
		
		panel.setLayout(gl);
		
	}
	
}

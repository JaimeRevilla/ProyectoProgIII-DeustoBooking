package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaSofas extends JFrame{
	private JTextField txtMuebleCasa;
	private JTextField txtEspejos;
	private JTextField txtSillas;
	private JTextField txtTelevisiones;
	private JTextField txtSofas;
	private JTextField txtCamas;
	private JTextField txtMenuPrincipal;
	private JTextField txtReloj;
	private JButton btnAgregar;
	public VentanaSofas() {
		
		setBounds(250, 225, 1000, 508);
		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(0, 3, 0, 0));
		
		txtReloj = new JTextField();
		txtReloj.setText("FECHA");
		panelNorte.add(txtReloj);
		txtReloj.setColumns(10);
		
		txtMenuPrincipal = new JTextField();
		txtMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtMenuPrincipal.setText("MENU SOFAS");
		panelNorte.add(txtMenuPrincipal);
		txtMenuPrincipal.setColumns(10);
		
		JButton btnCarrito = new JButton("IMAGEN CARRITO");
		panelNorte.add(btnCarrito);
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAtras = new JButton("ATRAS");
		panelSur.add(btnAtras);
		
		btnAgregar = new JButton("AGREGAR A CARRITO");
		panelSur.add(btnAgregar);
		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(2, 3, 0, 0));
		
		txtMuebleCasa = new JTextField();
		txtMuebleCasa.setText("\"\"");
		panelCentro.add(txtMuebleCasa);
		txtMuebleCasa.setColumns(10);
		
		txtEspejos = new JTextField();
		txtEspejos.setText("\"\"");
		panelCentro.add(txtEspejos);
		txtEspejos.setColumns(10);
		
		txtSillas = new JTextField();
		txtSillas.setText("\"\"");
		panelCentro.add(txtSillas);
		txtSillas.setColumns(10);
		
		txtTelevisiones = new JTextField();
		txtTelevisiones.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelevisiones.setText("\"\"");
		panelCentro.add(txtTelevisiones);
		txtTelevisiones.setColumns(10);
		
		txtSofas = new JTextField();
		txtSofas.setText("\"\"");
		panelCentro.add(txtSofas);
		txtSofas.setColumns(10);
		
		txtCamas = new JTextField();
		txtCamas.setText("\"\"");
		panelCentro.add(txtCamas);
		txtCamas.setColumns(10);
		
		JPanel panelCentroOeste = new JPanel();
		getContentPane().add(panelCentroOeste, BorderLayout.WEST);
		
		JComboBox comboBox_1 = new JComboBox();
		panelCentroOeste.add(comboBox_1);
		
		btnCarrito.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCesta v1 = new VentanaCesta();
			}
		});
		
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setVisible(true);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSofas frame = new VentanaSofas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

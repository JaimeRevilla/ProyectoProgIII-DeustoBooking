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

public class VentanaSillas extends JFrame{
	private JTextField txtMuebleCasa;
	private JTextField txtEspejos;
	private JTextField txtSillas;
	private JTextField txtTelevisiones;
	private JTextField txtSofas;
	private JTextField txtCamas;
	private JTextField txtMenuPrincipal;
	private JTextField txtReloj;
	private JButton btnAgregar;
	public VentanaSillas() {
		
		setBounds(450, 125, 800, 408);
		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		txtReloj = new JTextField();
		txtReloj.setText("FECHA");
		panel.add(txtReloj);
		txtReloj.setColumns(10);
		
		txtMenuPrincipal = new JTextField();
		txtMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtMenuPrincipal.setText("MENU SILLAS");
		panel.add(txtMenuPrincipal);
		txtMenuPrincipal.setColumns(10);
		
		JButton btnCarrito = new JButton("IMAGEN CARRITO");
		panel.add(btnCarrito);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnAtras = new JButton("ATRAS");
		panel_2.add(btnAtras);
		
		btnAgregar = new JButton("AGREGAR A CARRITO");
		panel_2.add(btnAgregar);
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(2, 3, 0, 0));
		
		txtMuebleCasa = new JTextField();
		txtMuebleCasa.setText("\"\"");
		panel_4.add(txtMuebleCasa);
		txtMuebleCasa.setColumns(10);
		
		txtEspejos = new JTextField();
		txtEspejos.setText("\"\"");
		panel_4.add(txtEspejos);
		txtEspejos.setColumns(10);
		
		txtSillas = new JTextField();
		txtSillas.setText("\"\"");
		panel_4.add(txtSillas);
		txtSillas.setColumns(10);
		
		txtTelevisiones = new JTextField();
		txtTelevisiones.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelevisiones.setText("\"\"");
		panel_4.add(txtTelevisiones);
		txtTelevisiones.setColumns(10);
		
		txtSofas = new JTextField();
		txtSofas.setText("\"\"");
		panel_4.add(txtSofas);
		txtSofas.setColumns(10);
		
		txtCamas = new JTextField();
		txtCamas.setText("\"\"");
		panel_4.add(txtCamas);
		txtCamas.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.WEST);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_1.add(comboBox_1);
		
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
					VentanaSillas frame = new VentanaSillas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

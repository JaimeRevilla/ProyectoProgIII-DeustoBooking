package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;


public class VentanaMuebleCasa extends JFrame {
	private JTextField txtMuebleCasa;
	private JTextField txtEspejos;
	private JTextField txtSillas;
	private JTextField txtTelevisiones;
	private JTextField txtSofas;
	private JTextField txtCamas;
	private JButton btnAgregar;
	private JLabel lblMenucasa;
	private JLabel lblFecha;
	private JPanel panel_3;
	private JPanel panel_5;
	private JPanel panel_7;
	public VentanaMuebleCasa() {
		
		setBounds(450, 125, 800, 408);
		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		panel_3 = new JPanel();
		panel.add(panel_3);
		
		lblFecha = new JLabel("FECHA");
		panel_3.add(lblFecha);
		
		panel_5 = new JPanel();
		panel.add(panel_5);
		
		lblMenucasa = new JLabel("MENU MUEBLES DE CASA");
		panel_5.add(lblMenucasa);
		
		panel_7 = new JPanel();
		panel.add(panel_7);
		
		JButton btnCarrito = new JButton("IMAGEN CARRITO");
		panel_7.add(btnCarrito);
		
		
		btnCarrito.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCesta v1 = new VentanaCesta();
			}
		});
		
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
		
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		/*HILO DE FECHA*/
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				while (true) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					long milis = System.currentTimeMillis();
					Date fecha = new Date(milis);
					String f = sdf.format(fecha);
					lblFecha.setText("Fecha Actual: " + f);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					lblFecha.setText("");
				}
				
				
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();
		
		setVisible(true);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMuebleCasa frame = new VentanaMuebleCasa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

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
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;


public class VentanaPrincipal extends JFrame {
	private JFrame vent;
	private JButton btnLog;
	private JLabel lblFecha;
	private JLabel lblMenu;
	private JButton btnMuebleCasa;
	private JButton btnEspejos;
	private JButton btnSillas;
	private JButton btnTv;
	private JButton btnSofas;
	private JButton btnCamas;
	public VentanaPrincipal() {
		vent = this;
		
		setBounds(450, 125, 800, 408);
		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		lblMenu = new JLabel("MENU PRINCIPAL");
		panel.add(lblMenu);
		
		JButton btnimgcarrito = new JButton("IMAGEN CARRITO");
		panel.add(btnimgcarrito);
		
		btnLog = new JButton("Log");
		panel.add(btnLog);
		
		lblFecha = new JLabel("FECHA");
		panel.add(lblFecha);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnsalir = new JButton("SALIR");
		panel_2.add(btnsalir);
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(2, 3, 0, 0));
		
		btnMuebleCasa = new JButton("MUEBLE CASA");
		panel_4.add(btnMuebleCasa);
		
		btnEspejos = new JButton("ESPEJOS");
		panel_4.add(btnEspejos);
		
		btnSillas = new JButton("SILLAS");
		panel_4.add(btnSillas);
		
		btnTv = new JButton("TV");
		panel_4.add(btnTv);
		
		btnSofas = new JButton("SOFAS");
		panel_4.add(btnSofas);
		
		btnCamas = new JButton("CAMAS");
		panel_4.add(btnCamas);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.WEST);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_1.add(comboBox_1);
		
		setVisible(true);
		
		btnimgcarrito.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCesta v1 = new VentanaCesta();
			}
		});
		
		btnLog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicial v1 = new VentanaInicial();
			}
		});
		
		btnMuebleCasa.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaMuebleCasa v1 = new VentanaMuebleCasa();
			}
		});
		
		btnEspejos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaEspejos v1 = new VentanaEspejos();
			}
		});
		
		btnSillas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaSillas v1 = new VentanaSillas();
			}
		});

		btnTv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaTv v1 = new VentanaTv();
			}
		});

		btnSofas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaSofas v1 = new VentanaSofas();
			}
		});

		btnCamas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCamas v1 = new VentanaCamas();
			}
		});
		
		btnsalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);;
			}
		});

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

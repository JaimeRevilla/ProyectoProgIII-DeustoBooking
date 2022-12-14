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
import javax.swing.ImageIcon;


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
	private JPanel panelNorteFecha;
	private JPanel panelNorteCentro;
	private JPanel panelNorteCarrito;
	public static String dni;
	private JButton btnNewButton;
	public VentanaPrincipal() {
		vent = this;
		
		setBounds(250, 225, 1000, 508);
		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(0, 3, 0, 0));
		
		panelNorteFecha = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelNorteFecha.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelNorte.add(panelNorteFecha);
		
		lblFecha = new JLabel("");
		panelNorteFecha.add(lblFecha);
		
		panelNorteCentro = new JPanel();
		panelNorte.add(panelNorteCentro);
		
		lblMenu = new JLabel("MENU PRINCIPAL");
		panelNorteCentro.add(lblMenu);
		
		panelNorteCarrito = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelNorteCarrito.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelNorte.add(panelNorteCarrito);
		
		JButton btnCarrito = new JButton();
		btnCarrito.setIcon(new ImageIcon("imagenes/pngegg.png"));
		panelNorteCarrito.add(btnCarrito);
		
		btnLog = new JButton("");
		btnLog.setIcon(new ImageIcon("imagenes/btnlogin.png"));
		panelNorteCarrito.add(btnLog);
		
		btnLog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicial v1 = new VentanaInicial();
			}
		});
		
		btnCarrito.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCesta v1 = new VentanaCesta();
			}
		});
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("A");
		
		
		JButton btnsalir = new JButton("SALIR");
		panelSur.add(btnsalir);
		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(2, 3, 0, 0));
		
		btnMuebleCasa = new JButton("MUEBLE CASA");
		btnMuebleCasa.setIcon(new ImageIcon("imagenes/mueble.png"));
		btnMuebleCasa.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMuebleCasa.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelCentro.add(btnMuebleCasa);
		
		btnEspejos = new JButton("ESPEJOS");
		btnEspejos.setIcon(new ImageIcon("imagenes/espejo.png"));
		btnEspejos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEspejos.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelCentro.add(btnEspejos);
		
		btnSillas = new JButton("SILLAS");
		btnSillas.setIcon(new ImageIcon("imagenes/silla.png"));
		btnSillas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSillas.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelCentro.add(btnSillas);
		
		btnTv = new JButton("TV");
		btnTv.setIcon(new ImageIcon("imagenes/tv.com.png"));
		btnTv.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTv.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelCentro.add(btnTv);
		
		btnSofas = new JButton("SOFAS");
		btnSofas.setIcon(new ImageIcon("imagenes/sofa.png"));
		btnSofas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSofas.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelCentro.add(btnSofas);
		
		btnCamas = new JButton("CAMAS");
		btnCamas.setIcon(new ImageIcon("imagenes/cama.com.png"));
		btnCamas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCamas.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelCentro.add(btnCamas);
		
		JPanel panelCentroOeste = new JPanel();
		getContentPane().add(panelCentroOeste, BorderLayout.WEST);
		
		JComboBox comboBox_1 = new JComboBox();
		panelCentroOeste.add(comboBox_1);
		
		btnMuebleCasa.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaEspejos v1 = new VentanaEspejos("MUEBLE CASA");
			}
		});
		
		btnEspejos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaEspejos v1 = new VentanaEspejos("ESPEJO");
			}
		});
		
		btnSillas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaEspejos v1 = new VentanaEspejos("SILLAS");
			}
		});

		btnTv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaEspejos v1 = new VentanaEspejos("TV");
			}
		});

		btnSofas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaEspejos v1 = new VentanaEspejos("SOFAS");
			}
		});

		btnCamas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaEspejos v1 = new VentanaEspejos("CAMAS");
			}
		});
		
		btnsalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);;
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
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

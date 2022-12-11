package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPrincipalAdmin extends JFrame{
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
	public static String dniA;
	private JButton btnStock;
	private JButton btnContabilidad;
	
	public VentanaPrincipalAdmin() {
		vent = this;
		
		setBounds(250, 225, 1000, 508);
		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(0, 3, 0, 0));
		
		panelNorteFecha = new JPanel();
		panelNorte.add(panelNorteFecha);
		
		lblFecha = new JLabel("");
		panelNorteFecha.add(lblFecha);
		
		panelNorteCentro = new JPanel();
		panelNorte.add(panelNorteCentro);
		
		lblMenu = new JLabel("MENU ADMIN");
		panelNorteCentro.add(lblMenu);
		
		panelNorteCarrito = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelNorteCarrito.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelNorte.add(panelNorteCarrito);
		
		JButton btnimgcarrito = new JButton("CARRITO");
		panelNorteCarrito.add(btnimgcarrito);
		
		btnLog = new JButton("LOG");
		panelNorteCarrito.add(btnLog);
		
		btnLog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicial v1 = new VentanaInicial();
			}
		});
		
		btnimgcarrito.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCesta v1 = new VentanaCesta();
			}
		});
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		btnContabilidad = new JButton("CONTABILIDAD");
		btnContabilidad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaContabilidad v1 = new VentanaContabilidad ();
			}
		});
		panelSur.add(btnContabilidad);
		
		JButton btnsalir = new JButton("SALIR");
		panelSur.add(btnsalir);
		
		btnStock = new JButton("STOCK");
		btnStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaStock v1 = new VentanaStock();
			}
		});
		panelSur.add(btnStock);
		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(2, 3, 0, 0));
		
		btnMuebleCasa = new JButton("MUEBLE CASA");
		panelCentro.add(btnMuebleCasa);
		
		btnEspejos = new JButton("ESPEJOS");
		panelCentro.add(btnEspejos);
		
		btnSillas = new JButton("SILLAS");
		panelCentro.add(btnSillas);
		
		btnTv = new JButton("TV");
		panelCentro.add(btnTv);
		
		btnSofas = new JButton("SOFAS");
		panelCentro.add(btnSofas);
		
		btnCamas = new JButton("CAMAS");
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
					VentanaPrincipalAdmin frame = new VentanaPrincipalAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
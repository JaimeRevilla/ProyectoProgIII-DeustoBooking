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

import Clases.BaseDatos;
import Clases.Producto;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
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
	
	static Connection con ;
	private JButton btnRecursividad;
	public VentanaPrincipal() {
		vent = this;
		
		setBounds(250, 225, 1000, 508);
		
		con = BaseDatos.initBD("data/DeustoIkea.db");
		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(new Color(100, 149, 237));
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(0, 3, 0, 0));
		
		panelNorteFecha = new JPanel();
		panelNorteFecha.setBackground(new Color(100, 149, 237));
		FlowLayout flowLayout_1 = (FlowLayout) panelNorteFecha.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelNorte.add(panelNorteFecha);
		
		lblFecha = new JLabel("");
		panelNorteFecha.add(lblFecha);
		
		panelNorteCentro = new JPanel();
		panelNorteCentro.setBackground(new Color(100, 149, 237));
		panelNorte.add(panelNorteCentro);
		
		lblMenu = new JLabel("");
		lblMenu.setIcon(new ImageIcon("imagenes/ikeaprincipal.png"));
		panelNorteCentro.add(lblMenu);
		
		panelNorteCarrito = new JPanel();
		panelNorteCarrito.setBackground(new Color(100, 149, 237));
		FlowLayout flowLayout = (FlowLayout) panelNorteCarrito.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelNorte.add(panelNorteCarrito);
		
		btnRecursividad = new JButton("¿Cuanto quieres gastar?");
		btnRecursividad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Producto> elementos = new ArrayList<>();
				//CREAR UN METODO PARA DEVOLVER UNA LISTA DE PRODUCTOS.
				for(Producto p: BaseDatos.obtenerProductoRecursividad(con)) {
					elementos.add(p);
				}
				while(elementos.size()>10) {
					elementos.remove(0);
				}
				double disponible = Double.parseDouble(JOptionPane.showInputDialog(null, "Cantidad requirida de dinero \n (El importe minimo debe ser más de 500€): ", "CANTIDAD", JOptionPane.INFORMATION_MESSAGE));
				double sobranteMax = Double.parseDouble(JOptionPane.showInputDialog(null, "Cantidad sobrante de dinero: ", "CANTIDAD", JOptionPane.INFORMATION_MESSAGE));
				
				List<List<Producto>> result = combinaciones(elementos, disponible, sobranteMax);
				VentanaRecursividad v1 = new VentanaRecursividad(combinaciones(elementos, disponible, sobranteMax));
				
				System.out.println(String.format("Combinaciones de menos de %.2f€ y sobrante máximo de %.2f€", disponible, sobranteMax));
				
				result.forEach(r -> System.out.println(r));
				    	
				
//				/*Comparator<Flight> compId = (f1, f2) -> { return f1.getCode().compareTo(f2.getCode()); };
//				 * Collections.sort(elementos,compId);
//				 * elementos.forEach(f -> System.out.println(f));
//				 * */

			}
		});
		panelNorteCarrito.add(btnRecursividad);
		
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
		panelSur.setBackground(new Color(100, 149, 237));
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("A");
		
		
		JButton btnsalir = new JButton("SALIR");
		panelSur.add(btnsalir);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(new Color(100, 149, 237));
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(2, 3, 0, 0));
		
		btnMuebleCasa = new JButton("ARMARIOS");
		btnMuebleCasa.setForeground(new Color(0, 0, 0));
		btnMuebleCasa.setBackground(new Color(255, 255, 255));
		btnMuebleCasa.setIcon(new ImageIcon("imagenes/mueble.png"));
		btnMuebleCasa.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMuebleCasa.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelCentro.add(btnMuebleCasa);
		
		btnEspejos = new JButton("ESPEJOS");
		btnEspejos.setForeground(new Color(0, 0, 0));
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
		panelCentroOeste.setBackground(new Color(100, 149, 237));
		getContentPane().add(panelCentroOeste, BorderLayout.WEST);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("TODO");
		comboBox_1.addItem("MUEBLE CASA");
		comboBox_1.addItem("ESPEJOS");
		comboBox_1.addItem("SILLAS");
		comboBox_1.addItem("TV");
		comboBox_1.addItem("SOFAS");
		comboBox_1.addItem("CAMAS");

		panelCentroOeste.add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String itemSeleccionado = (String)comboBox_1.getSelectedItem();
				if ("MUEBLE CASA".equals(itemSeleccionado)) {
					btnEspejos.setVisible(false);
					btnSillas.setVisible(false);
					btnTv.setVisible(false);
					btnSofas.setVisible(false);
					btnCamas.setVisible(false);
					btnMuebleCasa.setVisible(true);
				} else if ("ESPEJOS".equals(itemSeleccionado)) {
					btnMuebleCasa.setVisible(false);
					btnSillas.setVisible(false);
					btnTv.setVisible(false);
					btnSofas.setVisible(false);
					btnCamas.setVisible(false);
					btnEspejos.setVisible(true);

				} else if ("SILLAS".equals(itemSeleccionado)) {
					btnEspejos.setVisible(false);
					btnMuebleCasa.setVisible(false);
					btnTv.setVisible(false);
					btnSofas.setVisible(false);
					btnCamas.setVisible(false);
					btnSillas.setVisible(true);

				} else if ("TV".equals(itemSeleccionado)) {
					btnEspejos.setVisible(false);
					btnSillas.setVisible(false);
					btnMuebleCasa.setVisible(false);
					btnSofas.setVisible(false);
					btnCamas.setVisible(false);
					btnTv.setVisible(true);

				} else if ("SOFAS".equals(itemSeleccionado)) {
					btnEspejos.setVisible(false);
					btnSillas.setVisible(false);
					btnTv.setVisible(false);
					btnMuebleCasa.setVisible(false);
					btnCamas.setVisible(false);
					btnSofas.setVisible(true);

				} else if ("CAMAS".equals(itemSeleccionado)) {
					btnEspejos.setVisible(false);
					btnSillas.setVisible(false);
					btnTv.setVisible(false);
					btnSofas.setVisible(false);
					btnMuebleCasa.setVisible(false);
					btnCamas.setVisible(true);

				}else if ("TODO".equals(itemSeleccionado)) {
					btnEspejos.setVisible(true);
					btnSillas.setVisible(true);
					btnTv.setVisible(true);
					btnSofas.setVisible(true);
					btnMuebleCasa.setVisible(true);
					btnCamas.setVisible(true);
				}
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
				VentanaEspejos v2 = new VentanaEspejos();
			}
		});
		
		btnSillas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaSillas v3 = new VentanaSillas();
			}
		});

		btnTv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaTv v4 = new VentanaTv();
			}
		});

		btnSofas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaSofas v5 = new VentanaSofas();
			}
		});

		btnCamas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCamas v6 = new VentanaCamas();
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
	
	//RECURSIVIDAD
	/**
	 * Metodo recursivo
	 * @param result
	 * @param elementos
	 * @param disponible
	 * @param sobranteMax
	 * @param temp
	 */
	
	private static void combinacionesR(List<List<Producto>> result, List<Producto> elementos, double disponible,double sobranteMax,List<Producto> temp) {
		if (disponible < 0) {
			return; //Sal del método recursivo
		} else if (disponible < sobranteMax) {
			Comparator<Producto> comp = (p1, p2) -> { 
				return Integer.compare(p1.getCod(), p2.getCod()); 
				};
		    Collections.sort(temp,comp);
			if (!result.contains(temp)) {
		    
				result.add(new ArrayList<>(temp));        	
		        
			}
		    
		} else {
		
			for(Producto p : elementos) {
				temp.add(p);
				combinacionesR(result, elementos, disponible-p.getPrecio(), sobranteMax, temp);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	/**
	 * Metodo para llamar al metodo recursivo
	 * @param elementos
	 * @param disponible
	 * @param sobranteMax
	 * @return
	 */
	public static List<List<Producto>> combinaciones(List<Producto> elementos, double disponible, double sobranteMax) {
		List<List<Producto>> result = new ArrayList<>();
		combinacionesR(result, elementos, disponible, sobranteMax, new ArrayList<>());
		return result;
		
	}




	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					//mainRecursividad(args);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
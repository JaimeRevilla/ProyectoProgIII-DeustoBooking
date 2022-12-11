package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Clases.BaseDatos;
import Clases.Espejo;
import Clases.Principal;
import Clases.Producto;
import Clases.TipoEspejo;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class VentanaEspejos extends JFrame{

	private JTextField txtMuebleCasa;
	private JTextField txtEspejos;
	private JTextField txtSillas;
	private JTextField txtTelevisiones;
	private JTextField txtSofas;
	private JTextField txtCamas;
	private JButton btnAgregar;
	private JButton btnEspejoCircular;
	private JRadioButton rbEspejoRectangular;
	private JRadioButton rbEspejoCuadrado;
	private JRadioButton rbEspejoOvalado;
	private JRadioButton rbEspejoCircular;
	public static int cod;

	public static String tipoEspejo;
	public VentanaEspejos(String nombreProducto) {
		
		setBounds(250, 225, 1000, 508);
		
		Connection con = BaseDatos.initBD("data/DeustoIkea.db");
		
		BaseDatos.crearTablasUsuario(con);

		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panelNorteFecha = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelNorteFecha.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelNorte.add(panelNorteFecha);
		
		JLabel lblFecha = new JLabel("");
		panelNorteFecha.add(lblFecha);
		
		JPanel panelNorteCentro = new JPanel();
		panelNorte.add(panelNorteCentro);
		
		JLabel lblMenu = new JLabel("MENU ESPEJOS");
		panelNorteCentro.add(lblMenu);
		
		JPanel panel_14 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_14.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelNorte.add(panel_14);
		
		JButton btnCarrito = new JButton("");
		btnCarrito.setIcon(new ImageIcon("imagenes/pngegg.png"));
		panel_14.add(btnCarrito);
		
		btnCarrito.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCesta v1 = new VentanaCesta();
			}
		});
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAtras = new JButton("ATRAS");
		panelSur.add(btnAtras);
		
		btnAgregar = new JButton("AGREGAR A CARRITO");
		panelSur.add(btnAgregar);
		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(1, 3, 1,3));
		
		JPanel panelCentroIzquierda = new JPanel();
		panelCentro.add(panelCentroIzquierda);
		panelCentroIzquierda.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panelCentroIzquierda.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		//DUDA
		/*JButton btnEspejoRectangular = new JButton("EspejoRectangular");
		btnEspejoRectangular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Producto> a = BaseDatos.obtenerProductoTipo(con,"ESPEJO");
				for(Producto p: a) {
					try {
						BaseDatos.restarUnidadesAProducto(con, nombreProducto, p.getStock());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		panel_2.add(btnEspejoRectangular);
		*/
		rbEspejoRectangular = new JRadioButton("Espejo Rectangular");
		panel_2.add(rbEspejoRectangular);
		
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblEspejoRectangular = new JLabel("EspejoRectangular:");
		panel_3.add(lblEspejoRectangular);
		
		JPanel panel_1 = new JPanel();
		panelCentroIzquierda.add(panel_1);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		/*JButton btnEspejoCuadrado = new JButton("EspejoCuadrado");
		panel_6.add(btnEspejoCuadrado);*/
		rbEspejoCuadrado = new JRadioButton("Espejo Cuadrado");
		panel_6.add(rbEspejoCuadrado);
		
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		
		JLabel lblEspejoCuadrado = new JLabel("EspejoCuadrado:");
		panel_7.add(lblEspejoCuadrado);
		
		int stock1 = BaseDatos.obtenerStockProducto(con, "Espejo4");
		double precio1 = BaseDatos.obtenerPrecioProducto(con,"Espejo4");
		if (stock1 == 0) {
			lblEspejoRectangular.setText("Espejos rectangulares" + ":" + "\n" + "NO HAY NINGUNA UNIDAD EN STOCK");
		}else {
			lblEspejoRectangular.setText("Espejos rectangulares" + ": " + "Unidades restantes: " + stock1 + " unidades    " + "Precio: " + precio1 + " euros");
			
		}
		int stock2 = BaseDatos.obtenerStockProducto(con, "Espejo2");
		double precio2 = BaseDatos.obtenerPrecioProducto(con,"Espejo2");
		if (stock1 == 0) {
			lblEspejoCuadrado.setText("Espejos cuadrados" + ":" + "\n" + "NO HAY NINGUNA UNIDAD EN STOCK");
		}else {
			lblEspejoCuadrado.setText("Espejos cuadrados" + ": " + "Unidades restantes: " + stock2 + " unidades    " + "Precio: " + precio2 + " euros");
			
		}
		
		/**
		 * ESPEJOS CIRCULARES
		 */
		JPanel panelCentroCentroDerecha = new JPanel();
		panelCentro.add(panelCentroCentroDerecha);
		panelCentroCentroDerecha.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panelCentroCentroDerecha.add(panel_4);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		
		/*btnEspejoCircular = new JButton("EspejoCircular");
		panel_8.add(btnEspejoCircular);*/
		
		rbEspejoOvalado = new JRadioButton("Espejo Ovalado");
		panel_8.add(rbEspejoOvalado);
	
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		
		JLabel lblEspejoCircular = new JLabel("EspejoCircular:");
		panel_9.add(lblEspejoCircular);
		
		JPanel panel_5 = new JPanel();
		panelCentroCentroDerecha.add(panel_5);
		
		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10);
		
		/*JButton btnOvalado = new JButton("EspejoOvalado");
		panel_10.add(btnOvalado);*/
		
		rbEspejoCircular = new JRadioButton("Espejo Circular");
		panel_10.add(rbEspejoCircular);
		
		JPanel panel_11 = new JPanel();
		panel_5.add(panel_11);
		
		JLabel lblEspejoOvalado = new JLabel("EspejoOvalado:");
		panel_11.add(lblEspejoOvalado);
		
		int stock3 = BaseDatos.obtenerStockProducto(con, "Espejo1");
		double precio3 = BaseDatos.obtenerPrecioProducto(con,"Espejo1");
		if (stock3 == 0) {
			lblEspejoCircular.setText("Espejos circulares" + ":" + "\n" + "NO HAY NINGUNA UNIDAD EN STOCK");
		}else {
			lblEspejoCircular.setText("Espejos ciculares" + ": " + "Unidades restantes: " + stock3 + " unidades    " + "Precio: " + precio3 + " euros");
			
		}
		
		int stock4 = BaseDatos.obtenerStockProducto(con, "Espejo3");
		double precio4 = BaseDatos.obtenerPrecioProducto(con,"Espejo3");
		if (stock4 == 0) {
			lblEspejoOvalado.setText("Espejos ovalado" + ":" + "\n" + "NO HAY NINGUNA UNIDAD EN STOCK");
		}else {
			lblEspejoOvalado.setText("Espejos ovalado" + ": " + "Unidades restantes: " + stock4 + " unidades    " + "Precio: " + precio4 + " euros");
			
		}
		
		
//		ArrayList<Producto> a = BaseDatos.obtenerProductoTipo(con,"ESPEJO");
//		for(Producto p: a) {
//			JLabel l = new JLabel(p.toString());
//			panelCentro.add(l);
//		}
		JPanel panelCentroOeste = new JPanel();
		getContentPane().add(panelCentroOeste, BorderLayout.WEST);
		
		JComboBox comboBox_1 = new JComboBox();
		panelCentroOeste.add(comboBox_1);
		

		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rbEspejoCuadrado.isSelected()) {
					ArrayList<Producto> al = BaseDatos.obtenerProductoTipo(con, TipoEspejo.CUADRADO.toString());
					if(al.size()>0) {
						VentanaInicioSesion.carrito.add(al.get(0));
						BaseDatos.restarUnidadesAProducto(con, al.get(0).getNombre(), al.get(0).getStock());
						BaseDatos.insertarCarrito(con, VentanaInicioSesion.dni, al.get(0).getCod(), al.get(0).getNombre(), al.get(0).getTipo(), al.get(0).getMarca(), al.get(0).getTamanyo(), al.get(0).getPrecio());
						VentanaInicioSesion.mapa.put(VentanaInicioSesion.dni, al);
					}
				}
				if(rbEspejoRectangular.isSelected()) {
					ArrayList<Producto> al = BaseDatos.obtenerProductoTipo(con, TipoEspejo.RECTANGULAR.toString());
					if(al.size()>0) {
						VentanaInicioSesion.carrito.add(al.get(0));
						BaseDatos.restarUnidadesAProducto(con, al.get(0).getNombre(), 1);
						BaseDatos.insertarCarrito(con, VentanaInicioSesion.dni, al.get(0).getCod(), al.get(0).getNombre(), al.get(0).getTipo(), al.get(0).getMarca(), al.get(0).getTamanyo(), al.get(0).getPrecio());
						VentanaInicioSesion.mapa.put(VentanaInicioSesion.dni, al);
					}
				}
				if(rbEspejoOvalado.isSelected()) {
					ArrayList<Producto> al = BaseDatos.obtenerProductoTipo(con, TipoEspejo.OVALADO.toString());
					if(al.size()>0) {
						VentanaInicioSesion.carrito.add(al.get(0));
						BaseDatos.restarUnidadesAProducto(con, al.get(0).getNombre(), 1);
						BaseDatos.insertarCarrito(con, VentanaInicioSesion.dni, al.get(0).getCod(), al.get(0).getNombre(), al.get(0).getTipo(), al.get(0).getMarca(), al.get(0).getTamanyo(), al.get(0).getPrecio());
						VentanaInicioSesion.mapa.put(VentanaInicioSesion.dni, al);
					}
				}
				if(rbEspejoCircular.isSelected()) {
					ArrayList<Producto> al = BaseDatos.obtenerProductoTipo(con, TipoEspejo.CIRCULAR.toString());
					if(al.size()>0) {
						VentanaInicioSesion.carrito.add(al.get(0));
						BaseDatos.restarUnidadesAProducto(con, al.get(0).getNombre(), 1);
						BaseDatos.insertarCarrito(con, VentanaInicioSesion.dni, al.get(0).getCod(), al.get(0).getNombre(), al.get(0).getTipo(), al.get(0).getMarca(), al.get(0).getTamanyo(), al.get(0).getPrecio());
						VentanaInicioSesion.mapa.put(VentanaInicioSesion.dni, al);
					}
				}
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
					VentanaEspejos frame = new VentanaEspejos("ESPEJO");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

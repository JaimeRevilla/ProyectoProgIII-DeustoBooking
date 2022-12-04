package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Clases.BaseDatos;
import Clases.Principal;
import Clases.Producto;

public class VentanaEspejos extends JFrame{

	private JTextField txtMuebleCasa;
	private JTextField txtEspejos;
	private JTextField txtSillas;
	private JTextField txtTelevisiones;
	private JTextField txtSofas;
	private JTextField txtCamas;
	private JTextField txtMenuPrincipal;
	private JTextField txtReloj;
	private JButton btnAgregar;
	private JButton btnEspejoCircular;
	public VentanaEspejos(String nombreProducto) {
		
		setBounds(450, 125, 800, 408);
		
		Connection con = BaseDatos.initBD("data/DeustoIkea.db");
		
		BaseDatos.crearTablasUsuario(con);

		
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
		txtMenuPrincipal.setText("MENU "+nombreProducto);
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
		panelCentro.setLayout(new GridLayout(1, 3, 1,3));
		
		JPanel panelCentroIzquierda = new JPanel();
		panelCentro.add(panelCentroIzquierda);
		panelCentroIzquierda.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panelCentroIzquierda.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JButton btnEspejoRectangular = new JButton("EspejoRectangular");
		panel_2.add(btnEspejoRectangular);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblEspejoRectangular = new JLabel("EspejoRectangular:");
		panel_3.add(lblEspejoRectangular);
		
		JPanel panel_1 = new JPanel();
		panelCentroIzquierda.add(panel_1);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		JButton btnEspejoCuadrado = new JButton("EspejoCuadrado");
		panel_6.add(btnEspejoCuadrado);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		
		JLabel lblEspejoCuadrado = new JLabel("EspejoCuadrado:");
		panel_7.add(lblEspejoCuadrado);
		
		int stock1 = BaseDatos.obtenerStockProducto(con, "Rectangular");
		double precio1 = BaseDatos.obtenerPrecioProducto(con,"Rectangular");
		if (stock1 == 0) {
			lblEspejoRectangular.setText("Espejos rectangulares" + ":" + "\n" + "NO HAY NINGUNA UNIDAD EN STOCK");
		}else {
			lblEspejoRectangular.setText("Espejos rectangulares" + ": " + "Unidades restantes: " + stock1 + " unidades    " + "Precio: " + precio1 + " euros");
			
		}
		int stock2 = BaseDatos.obtenerStockProducto(con, "Rectangular");
		double precio2 = BaseDatos.obtenerPrecioProducto(con,"Rectangular");
		if (stock1 == 0) {
			lblEspejoCuadrado.setText("Espejos rectangulares" + ":" + "\n" + "NO HAY NINGUNA UNIDAD EN STOCK");
		}else {
			lblEspejoCuadrado.setText("Espejos rectangulares" + ": " + "Unidades restantes: " + stock2 + " unidades    " + "Precio: " + precio2 + " euros");
			
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
		
		btnEspejoCircular = new JButton("EspejoCircular");
		panel_8.add(btnEspejoCircular);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		
		JLabel lblEspejoCircular = new JLabel("EspejoCircular:");
		panel_9.add(lblEspejoCircular);
		
		JPanel panel_5 = new JPanel();
		panelCentroCentroDerecha.add(panel_5);
		
		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10);
		
		JButton btnOvalado = new JButton("EspejoOvalado");
		panel_10.add(btnOvalado);
		
		JPanel panel_11 = new JPanel();
		panel_5.add(panel_11);
		
		JLabel lblEspejoOvalado = new JLabel("EspejoOvalado:");
		panel_11.add(lblEspejoOvalado);
		
		int stock3 = BaseDatos.obtenerStockProducto(con, "Circular");
		double precio3 = BaseDatos.obtenerPrecioProducto(con,"Circular");
		if (stock3 == 0) {
			lblEspejoCircular.setText("Espejos circulares" + ":" + "\n" + "NO HAY NINGUNA UNIDAD EN STOCK");
		}else {
			lblEspejoCircular.setText("Espejos ciculares" + ": " + "Unidades restantes: " + stock3 + " unidades    " + "Precio: " + precio3 + " euros");
			
		}
		
		int stock4 = BaseDatos.obtenerStockProducto(con, "Ovalado");
		double precio4 = BaseDatos.obtenerPrecioProducto(con,"Ovalado");
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
					VentanaEspejos frame = new VentanaEspejos("ESPEJO");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

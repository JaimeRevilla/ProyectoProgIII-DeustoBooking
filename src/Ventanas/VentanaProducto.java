package Ventanas;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.Scrollable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Clases.BaseDatos;
import Clases.Producto;

import javax.swing.JLabel;
import javax.swing.JTable;

public class VentanaProducto extends JFrame{
	
	private Connection con;
	
	private PanelConFondo panelFoto;
	private JTable tablaFotos;
	public static DefaultTableModel modeloFotos;
	
	private DefaultTableModel modelProducto;
	private JTable tablaProducto;
	private JScrollPane scrProducto;

	public VentanaProducto() {
		
		setBounds(250, 225, 1000, 508);
		
		con = BaseDatos.initBD("data/DeustoIkea.db");

		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JSplitPane panelCentro = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		panelFoto = new PanelConFondo(null);
		panelCentro.add(panelFoto);
		
		JPanel panelNorte = new JPanel();
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		JPanel panelNorteIzq = new JPanel();
		panelNorte.add(panelNorteIzq);
		
		JLabel lblFecha = new JLabel("FECHA");
		panelNorteIzq.add(lblFecha);
		
		JPanel panelNorteCentro = new JPanel();
		panelNorte.add(panelNorteCentro);
		
		JLabel lblProducto = new JLabel("MENU PRODUCTOS");
		panelNorteCentro.add(lblProducto);
		
		JPanel panelNorteDerecha = new JPanel();
		panelNorte.add(panelNorteDerecha);
		
		JLabel lblCarrito = new JLabel("CARRITO");
		panelNorteDerecha.add(lblCarrito);
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAtras = new JButton("ATRAS");
		panelSur.add(btnAtras);
		
		
//		JButton btnAñadir = new JButton("AÑADIR");
		JSpinner spCantidad = new JSpinner();
		
		modelProducto = new DefaultTableModel();
		String [] titulos = {"CODIGO", "NOMBRE", "TIPO", "MARCA", "TAMAÑO", "PRECIO", "STOCK", "", ""};
		modelProducto.setColumnIdentifiers(titulos);
		ArrayList<Producto> productos = BaseDatos.obtenerProducto(con, "Producto");
		for(Producto p : productos) {
			Object [] datos = {p.getCod(), p.getNombre(), p.getTipo(), p.getMarca(), p.getTamanyo(), p.getPrecio(), p.getStock(), spCantidad, new JButton("AÑADIR")};
			modelProducto.addRow(datos);
		}
		
		tablaProducto = new JTable(modelProducto);
		scrProducto = new JScrollPane(tablaProducto);
		
		panelCentro.add(scrProducto);
		
		
		
		tablaProducto.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tablaProducto.rowAtPoint(e.getPoint());
				String tipo = (String) modelProducto.getValueAt(fila, 2);
				String ruta = BaseDatos.getRuta(con, tipo);
				ImageIcon imagen = new ImageIcon(ruta);
				panelFoto.setImagen(imagen.getImage());
				panelFoto.repaint();
				
			}
		});
		
		setVisible(true);
		
	}

	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProducto frame = new VentanaProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


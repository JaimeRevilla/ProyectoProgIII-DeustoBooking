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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument.Content;

import Clases.BaseDatos;
import Clases.Carrito;
import Clases.Producto;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;


public class VentanaCesta extends JFrame {
	private JTextField txtListaDeLa;
	
	private Connection con;
	public static DefaultTableModel model;
	private JTable tablaCesta;
	private JScrollPane scrollTabla;

	private PanelConFondo panelFoto;
	private JTable tablaFotos;
	public static DefaultTableModel modeloFotos;


	
	//public static ArrayList<Carrito> carrito;
	public VentanaCesta() {
		
		setBounds(250, 225, 1000, 508);
		
		con = BaseDatos.initBD("data/DeustoIkea.db");
		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JSplitPane panelCentro = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);
		panelCentro.setBackground(new Color(100, 149, 237));
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		String texto = "Lista de la compra\n";
		double total = 0;
		for(Producto p: VentanaInicioSesion.carrito) {
			texto = texto + p;
			total = total + p.getPrecio();
		}
		texto = texto + total + " €\n";
		
		panelFoto = new PanelConFondo(null);
		panelFoto.setBackground(new Color(100, 149, 237));
		panelCentro.add(panelFoto);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("MENU CARRITO");
		panel_1.add(lblNewLabel);
		
		JPanel panelCentroEste = new JPanel();
		panelCentroEste.setBackground(new Color(100, 149, 237));
		getContentPane().add(panelCentroEste, BorderLayout.EAST);
		panelCentroEste.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("imagenes/compra.png"));
		panelCentroEste.add(btnNewButton);
		
		JButton btnFactura = new JButton("");
		btnFactura.setIcon(new ImageIcon("imagenes/factura.png"));
		panelCentroEste.add(btnFactura);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(new Color(100, 149, 237));
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnatras = new JButton("ATRAS");
		panelSur.add(btnatras);
		
		
		ArrayList<Carrito> carritos = BaseDatos.obtenerListaCarrito(con, VentanaInicial.dni);
		model = new DefaultTableModel();
		String [] titulos = {"DNI", "CODIGO", "NOMBRE", "TIPO", "MARCA", "TAMANYO","CANTIDAD", "PRECIO"};
		model.setColumnIdentifiers(titulos);
		for(Carrito c: carritos) {
			Object [] datos = {c.getDni(), c.getCod(), c.getNom(), c.getTipo(), c.getMarca(), c.getTamanyo(),c.getCantidad(),c.getPrecio()};
			model.addRow(datos);
		}
		tablaCesta = new JTable(model);		
		
		scrollTabla = new JScrollPane(tablaCesta);
		
		JButton btnBorrarProducto = new JButton("");
		btnBorrarProducto.setIcon(new ImageIcon("imagenes/borrar.png"));
		btnBorrarProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int fila = tablaCesta.getSelectedRow();
				if(tablaCesta.getSelectedRow()>=0) {
					String valor = tablaCesta.getValueAt(fila, 3).toString();
					model = (DefaultTableModel)tablaCesta.getModel();
					model.removeRow(tablaCesta.getSelectedRow());	
					BaseDatos.eliminarFilaPorCodigoProd(con, valor);
//					BaseDatos.obtenerListaCarrito(con, VentanaEspejos.tipoEspejo);
					System.out.println("Se esta eliminando el producto");
				}else {
					JOptionPane.showMessageDialog(null, "Para eliminar un producto seleccione el producto");
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				factura();
				
			}
		});
		
		panelCentroEste.add(btnBorrarProducto);
		
		panelCentro.add(scrollTabla);
		
		btnFactura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaFactura v1 = new VentanaFactura(cargarFichero());
				
			}
		});
	
		
		btnatras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		tablaCesta.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int fila = tablaCesta.rowAtPoint(e.getPoint());
				String tipo = (String)model.getValueAt(fila, 3);
				System.out.println(tipo);
				String ruta = BaseDatos.getRuta(con, tipo);
				System.out.println(ruta);
				ImageIcon i = new ImageIcon(ruta);
				System.out.println(i);
				panelFoto.setImagen(i.getImage());
				panelFoto.repaint();
			}
		});
		
		setVisible(true);

	}
	
	public static void factura() {
		try (PrintWriter pw = new PrintWriter(new FileOutputStream("Factura"+VentanaInicial.dni+".txt"));){
			Date fechaSistema = new Date(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			pw.println(sdf.format(fechaSistema));
			for(int i=0; i<model.getRowCount();i++) {
				String dni = (String) model.getValueAt(i, 0);
				int cod = (int) model.getValueAt(i, 1);
				String nom = (String) model.getValueAt(i, 2);
				String tipo = (String) model.getValueAt(i, 3);
				String marca = (String) model.getValueAt(i, 4);
				String tam = (String) model.getValueAt(i, 5);
				int cant =(int)model.getValueAt(i, 6);
				double precio = (double) model.getValueAt(i, 7);
				pw.println(dni+";"+cod+";"+nom+";"+tipo+";"+marca+";"+tam+";"+cant+";"+precio);
				System.out.println(String.format("El fichero se ha creado correctamente para el:%s",VentanaInicial.dni));
			}
		} catch (FileNotFoundException e) {
			System.out.println(String.format("Error cesta:%s",e.getMessage()));
			e.printStackTrace();
		}
	}
	public static ArrayList<Carrito> cargarFichero() {
		ArrayList<Carrito> carrito = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("Factura"+VentanaInicioSesion.dni+".txt"));){
			String linea = br.readLine();
			linea = br.readLine();
			while(linea!=null) {
				
				String [] dato = linea.split(";");
				for(String s: dato) {
					System.out.println(s);
				}
				String dni = dato[0];
				int cod = Integer.parseInt(dato[1]);
				String nom = dato[2];
				String tipo = dato[3];
				String marca = dato[4];
				String tam = dato[5];
				int cant = Integer.parseInt(dato[6]);
				double prec = Double.parseDouble(dato[6]);
				Carrito ca = new Carrito(dni, cod, nom, tipo, marca, tam,cant, prec);
				carrito.add(ca);
				linea = br.readLine();
				System.out.println(linea);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(String.format("Error Factura:%s",e.getMessage()));
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println(String.format("Error Factura1:%s",e1.getMessage()));
			e1.printStackTrace();
		}
		return carrito;
	}

	//Crear un metodo de cargar csv para que se pueda añadir a la Jlist de la cesta del usuario que se haya registrado
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCesta frame = new VentanaCesta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

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

import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
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
	private DefaultTableModel model;
	private JTable tablaCesta;
	private JScrollPane scrollTabla;

	private JList<Carrito> listaFactura;
	private DefaultListModel<Carrito> modelLista;
	private JScrollPane panelLista;
	
	
	public VentanaCesta() {
		
		setBounds(250, 225, 1000, 508);
		
		con = BaseDatos.initBD("data/DeustoIkea.db");
		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtListaDeLa = new JTextField();
		String texto = "Lista de la compra\n";
		double total = 0;
		for(Producto p: VentanaInicioSesion.carrito) {
			texto = texto + p;
			total = total + p.getPrecio();
		}
		texto = texto + total + " €\n";
		txtListaDeLa.setText(texto);
		panelCentro.add(txtListaDeLa);
		txtListaDeLa.setColumns(10);
		
		JPanel panelCentroEste = new JPanel();
		getContentPane().add(panelCentroEste, BorderLayout.EAST);
		panelCentroEste.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("REALIZAR COMPRA");
		panelCentroEste.add(btnNewButton);
		
		
		
		JButton btnFactura = new JButton("VER FACTURA");
		
		panelCentroEste.add(btnFactura);
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnatras = new JButton("ATRAS");
		panelSur.add(btnatras);
		
		
		ArrayList<Carrito> carritos = BaseDatos.obtenerListaCarrito(con, VentanaInicioSesion.dni);
		model = new DefaultTableModel();
		String [] titulos = {"DNI", "CODIGO", "NOMBRE", "TIPO", "MARCA", "TAMANYO", "PRECIO"};
		model.setColumnIdentifiers(titulos);
		for(Carrito c: carritos) {
			Object [] datos = {c.getDni(), c.getCod(), c.getNom(), c.getTipo(), c.getMarca(), c.getTamanyo(), c.getPrecio()};
			model.addRow(datos);
		}
		tablaCesta = new JTable(model);		
		
		scrollTabla = new JScrollPane(tablaCesta);
		
//		JButton btnBorrarProducto = new JButton("BORRAR PRODUCTO");
//		btnBorrarProducto.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(tablaCesta.getSelectedRow()>=0) {
//					model = (DefaultTableModel)tablaCesta.getModel();
//					model.removeRow(tablaCesta.getSelectedRow());	
//					BaseDatos.eliminarFila(con, VentanaInicioSesion.dni);
//				}else {
//					JOptionPane.showMessageDialog(null, "Para eliminar un producto seleccione el producto");				
//				}
////				ArrayList<Producto> p = VentanaInicioSesion.carrito;
////				int row = tablaCesta.getSelectedRow();
////				String celda = tablaCesta.getModel().getValueAt(row, 0).toString();
////				if(!(row == 0)) {
////					JOptionPane.showMessageDialog(null, "Para eliminar un producto seleccione el producto");
////				}else {
////					tablaCesta.remove(row);
////				}
//				}
//		});
		
		JButton btnBorrarProducto = new JButton("BORRAR PRODUCTO");
		btnBorrarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = tablaCesta.getSelectedRow();
					if(tablaCesta.getSelectedRow()>=0) {
						String valor = tablaCesta.getValueAt(fila, 0).toString();
						model = (DefaultTableModel)tablaCesta.getModel();
						model.removeRow(tablaCesta.getSelectedRow());	
						BaseDatos.eliminarFilaPorCodigoProd(con, valor);
						BaseDatos.obtenerListaCarrito(con, VentanaEspejos.tipoEspejo);
						System.out.println("Se esta eliminando el producto");
					}else {
						JOptionPane.showMessageDialog(null, "Para eliminar un producto seleccione el producto");
					}
//				}catch(Exception ex) {
//					JOptionPane.showMessageDialog(null, "Para eliminar un producto seleccione el producto");
//				}
				
//				if (tablaCesta.getSelectedRow()>=0) {
//					model = (DefaultTableModel)tablaCesta.getModel();
//					model.removeRow(tablaCesta.getSelectedRow());	
//					//Producto p = VentanaInicioSesion.mapa.get(VentanaInicioSesion.dni).get(model.getRowCount());
//					BaseDatos.eliminarFilaPorCodigoProd(con, VentanaEspejos.cod);
//				}else {
//					JOptionPane.showMessageDialog(null, "Para eliminar un producto seleccione el producto");				
//				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Factura();
				
			}
		});
		
		panelCentroEste.add(btnBorrarProducto);
		
		panelCentro.add(scrollTabla, BorderLayout.CENTER);
		
		btnFactura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaFactura v1 = new VentanaFactura();
				cargarFichero();
			}
		});
		
		btnatras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setVisible(true);

	}
	
	private void Factura() {
		try (PrintWriter pw = new PrintWriter(new FileOutputStream("Factura"+VentanaInicioSesion.dni+".txt"));){
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
				double precio = (double) model.getValueAt(i, 6);
				pw.println(dni+";"+cod+";"+nom+";"+tipo+";"+marca+";"+tam+";"+precio);
				System.out.println(String.format("El fichero se ha creado correctamente para el:%s",VentanaInicioSesion.dni));
			}
		} catch (FileNotFoundException e) {
			System.out.println(String.format("Error cesta:%s",e.getMessage()));
			e.printStackTrace();
		}
	}
	
//	private void Factura() {
//		ObjectOutputStream oos = null;
//		
//		try {
//			FileOutputStream fos = new FileOutputStream(VentanaInicioSesion.dni+".txt");
//			BufferedOutputStream bos = new BufferedOutputStream(fos);
//			oos = new ObjectOutputStream(bos);
//			
//			for (Producto p : VentanaInicioSesion.carrito) {
//				oos.writeObject(p);
//			}
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if(oos!=null) {
//				try {
//					oos.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	
//	}
	
	private void cargarFichero() {
		try (BufferedReader br = new BufferedReader(new FileReader("Factura"+VentanaInicioSesion.dni+".txt"));){
			String linea = br.readLine();
			while(linea!=null) {
				String [] dato = linea.split(";");
				Carrito ca = new Carrito(dato[0],Integer.parseInt((String)dato[1]),dato[2],dato[3],dato[4],dato[5],Double.parseDouble((String)dato[6]));
				System.out.println(ca);
				modelLista.addElement(ca);
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

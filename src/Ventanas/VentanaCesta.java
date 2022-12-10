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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
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
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;


public class VentanaCesta extends JFrame {
	private JTextField txtListaDeLa;
	
	private Connection con;
	private DefaultTableModel model;
	private JTable tablaCesta;
	private JScrollPane scrollTabla;
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
		
		JLabel lblNewLabel = new JLabel("precio total");
		panelCentroEste.add(lblNewLabel);
		
		JButton btnFactura = new JButton("FACTURA");
		
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
		
		panelCentro.add(scrollTabla, BorderLayout.CENTER);
		
		btnFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaFactura v1 = new VentanaFactura();
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

package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clases.BaseDatos;
import Clases.Carrito;
import Clases.Producto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaStock extends JFrame{
	
	private Connection con;
	public static DefaultTableModel model;
	private JTable tablaStock;
	private JScrollPane scrollTabla;
	private JFrame vent;
	
	
	public VentanaStock() {
		
		setBounds(250, 225, 1000, 508);
		
		con = BaseDatos.initBD("data/DeustoIkea.db");
		
		JPanel panelNorte = new JPanel();
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("TABLA PRODUCTO CON INFORMACION");
		panelNorte.add(lblNewLabel);
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(1, 4, 0, 0));
		
		JButton btnEliminar = new JButton("Eliminar");
		panelSur.add(btnEliminar);
		
		JButton btnAnadir = new JButton("Añadir");
		panelSur.add(btnAnadir);
		
		JButton btnActualizar = new JButton("Actualizar");
		panelSur.add(btnActualizar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelSur.add(btnSalir);

		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro);
		
		setVisible(true);
		ArrayList<Producto> productos = BaseDatos.obtenerProductoTipo(con, VentanaEspejos.tipoEspejo);
		model = new DefaultTableModel();
		String [] titulos = {"CODIGO", "NOMBRE", "TIPO", "MARCA", "TAMANYO", "PRECIO", "STOCK"};
		model.setColumnIdentifiers(titulos);
		for(Producto p: productos) {
			Object [] datos = {p.getCod(), p.getNombre(), p.getTipo(), p.getMarca(), p.getTamanyo(), p.getPrecio(), p.getStock()};
			model.addRow(datos);
		}
		tablaStock = new JTable(model);		
		
		scrollTabla = new JScrollPane(tablaStock);
		
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int fila = tablaStock.getSelectedRow();
					if(tablaStock.getSelectedRow()>=0) {
						String valor = tablaStock.getValueAt(fila, 3).toString();
						model = (DefaultTableModel)tablaStock.getModel();
						model.removeRow(tablaStock.getSelectedRow());	
						BaseDatos.eliminarFilaPorCodigoProd(con, valor);
						BaseDatos.obtenerProductoTipo(con, VentanaEspejos.tipoEspejo);
						System.out.println("Se esta eliminando el producto");
					}else {
						JOptionPane.showMessageDialog(null, "Para eliminar un producto seleccione el producto");
					}
			}
	});
		panelCentro.add(scrollTabla);
		
	
	}
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaStock frame = new VentanaStock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
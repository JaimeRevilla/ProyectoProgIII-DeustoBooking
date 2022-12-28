package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Clases.BaseDatos;
import Clases.Carrito;
import Clases.Producto;

import javax.swing.JLabel;
import javax.swing.JTable;

public class VentanaSillas extends JFrame{
	
	private Connection con;

	private JTextField txtReloj;
	private JButton btnAgregar;
	private JLabel lblNewLabel;
	private JPanel panelCentral;
	private JTable tablaSillas;
	public static DefaultTableModel modelSill;
	private JScrollPane scrSillas;
	public VentanaSillas() {
		
		setBounds(250, 225, 1000, 508);
		
		con = BaseDatos.initBD("data/DeustoIkea.db");

		
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
		
		lblNewLabel = new JLabel("MENU SILLAS");
		panelNorte.add(lblNewLabel);
		
		JButton btnCarrito = new JButton("IMAGEN CARRITO");
		panelNorte.add(btnCarrito);
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAtras = new JButton("ATRAS");
		panelSur.add(btnAtras);
		
		btnAgregar = new JButton("AGREGAR A CARRITO");
		panelSur.add(btnAgregar);
		
		panelCentral = new JPanel();
		
		
		
		
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		
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
		
		
		
		JButton btnAgregar = new JButton("añadir");
		JSpinner spnCant = new JSpinner();
		ArrayList<Producto> sillas = BaseDatos.obtenerProducto(con, "silla");
		System.out.println(sillas);
		modelSill = new DefaultTableModel();
		String [] titulos = {"CODIGO", "NOMBRE", "TIPO", "MARCA", "TAMANYO", "PRECIO", "STOCK", "IMAGEN", "CANTIDAD", "AÑADIR"};
		modelSill.setColumnIdentifiers(titulos);
		for(Producto p: sillas) {
			Object [] datos = {p.getCod(), p.getNombre(), p.getTipo(), p.getMarca(), p.getTamanyo(), p.getPrecio(), p.getStock(), p.getRuta(), spnCant, btnAgregar};
			modelSill.addRow(datos);
		}
		tablaSillas = new JTable(modelSill);
		
		//scrSillas = new JScrollPane(tablaSillas);
		panelCentral.add(tablaSillas);
		
		
//		tablaSillas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//			
//			@Override
//			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
//					int row, int column) {
//				if (row == table.getModel().getRowCount()) {
//		            return new JButton("Agregar");
//		        } else {
//		            setBackground(new Color(0xffffff));
//		            return this;
//		        }
//			}
//		});
		
		
		
		setVisible(true);


	}
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSillas frame = new VentanaSillas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

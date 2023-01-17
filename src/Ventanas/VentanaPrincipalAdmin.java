package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Clases.BaseDatos;
import Clases.Producto;

import javax.swing.JTextField;

public class VentanaPrincipalAdmin extends JFrame{
	private JFrame vent;
	private JLabel lblFecha;
	private JLabel lblMenu;
	private JPanel panelNorteFecha;
	private JPanel panelNorteCentro;
	private JPanel panelNorteCarrito;
	public static String dniA;
	private JButton btnContabilidad;
	private JTextField filtro;
	private JLabel lblProducto;
	
	private DefaultTableModel modelProducto;
	private JTable tablaProducto;
	private JScrollPane scrollProducto;
	
	private ArrayList<Producto> datosProductos;
	
	private BaseDatos bd;
	private Connection con;
	
	public VentanaPrincipalAdmin() {
		vent = this;
		con = BaseDatos.initBD("data/DeustoIkea.db");
		datosProductos = new ArrayList<>();
		setBounds(250, 225, 1000, 508);
		
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
		panelNorte.add(panelNorteCarrito);
		panelNorteCarrito.setLayout(new GridLayout(1, 2, 0, 0));
		
		lblProducto = new JLabel("Introduce producto:");
		panelNorteCarrito.add(lblProducto);
		
		filtro = new JTextField();
		panelNorteCarrito.add(filtro);
		filtro.setColumns(20);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(new Color(100, 149, 237));
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
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(new Color(100, 149, 237));
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(2, 3, 0, 0));
		
		btnsalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);;
			}
		});
		
		modelProducto = new DefaultTableModel();
		cargarCSV();
		cargarArray();
		tablaProducto = new JTable(modelProducto);
		scrollProducto = new JScrollPane(tablaProducto);
		panelCentro.add(scrollProducto);
		
		//FILTRO PRODUCTO
		filtro.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String nombre = filtro.getText();
				while(modelProducto.getRowCount()>0) {
					modelProducto.removeRow(0);
				}
				for(Producto p: datosProductos) {
					if(p.getNombre().startsWith(nombre)) {
						Object [] fila = {p.getCod(),p.getNombre(),p.getTipo(),p.getMarca(),p.getTamanyo(),p.getPrecio(),p.getStock(),p.getRuta()};
						modelProducto.addRow(fila);
					}
				}
				lblProducto.setText("Numero productos: "+modelProducto.getRowCount());
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String nombre = filtro.getText();
				while(modelProducto.getRowCount()>0) {
					modelProducto.removeRow(0);
				}
				for(Producto p: datosProductos) {
					if(p.getNombre().startsWith(nombre)) {
						Object [] fila = {p.getCod(),p.getNombre(),p.getTipo(),p.getMarca(),p.getTamanyo(),p.getPrecio(),p.getStock(),p.getRuta()};
						modelProducto.addRow(fila);
					}
				}
				lblProducto.setText("Número de datos: "+modelProducto.getRowCount());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}
		});
		
		modelProducto.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				int fila = e.getFirstRow();
				int cod = Integer.parseInt((String)modelProducto.getValueAt(fila, 0));
				String nom = (String) modelProducto.getValueAt(fila, 1);
				String tipo = (String) modelProducto.getValueAt(fila, 2);
				String marca = (String) modelProducto.getValueAt(fila, 3);
				String tam = (String) modelProducto.getValueAt(fila, 4);
				double precio = Double.parseDouble((String) modelProducto.getValueAt(fila, 5));
				int stock = Integer.parseInt((String)modelProducto.getValueAt(fila, 6));
				datosProductos.get(fila).setCod(cod);
				datosProductos.get(fila).setNombre(nom);
				datosProductos.get(fila).setTipo(tipo);
				datosProductos.get(fila).setMarca(marca);
				datosProductos.get(fila).setTamanyo(tam);
				datosProductos.get(fila).setPrecio(precio);
				datosProductos.get(fila).setStock(stock);
				BaseDatos.modificarDato(con,datosProductos.get(fila));
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

	
	public void cargarArray(){
		for(int i=0;i<modelProducto.getRowCount();i++) {
			int cod = Integer.parseInt((String)modelProducto.getValueAt(i, 0));
			String nom = (String) modelProducto.getValueAt(i, 1);
			String tipo = (String) modelProducto.getValueAt(i, 2);
			String marca = (String) modelProducto.getValueAt(i, 3);
			String tam = (String) modelProducto.getValueAt(i, 4);
			double precio = Double.parseDouble((String) modelProducto.getValueAt(i, 5));
			int stock = Integer.parseInt((String)modelProducto.getValueAt(i, 6));
			String ruta = (String)modelProducto.getValueAt(i, 7);

			Producto p = new Producto(cod, nom, tipo, marca, tam, precio, stock, ruta);
			datosProductos.add(p);
		}
	}

	public void cargarCSV() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("producto.csv"));
			String linea = br.readLine();
			String [] titulos = linea.split(";");
			modelProducto.setColumnIdentifiers(titulos);
			
			linea = br.readLine();
			while(linea!=null) {
				String [] datos = linea.split(";");
				modelProducto.addRow(datos);
				linea = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
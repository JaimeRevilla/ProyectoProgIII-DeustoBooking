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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
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
		
		JPanel panelNorteFecha = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelNorteFecha.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelNorte.add(panelNorteFecha);
		
		JLabel lblFecha = new JLabel("");
		panelNorteFecha.add(lblFecha);
		
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
		
		
//		COMENTADO
//		JButton btnAgregar = new JButton("añadir");
//		JSpinner spnCant = new JSpinner();
		ArrayList<Producto> sillas = BaseDatos.obtenerProducto(con, "silla");
		
		System.out.println(sillas);

		String [] titulos = {"CODIGO", "NOMBRE", "TIPO", "MARCA", "TAMANYO", "PRECIO", "STOCK", "IMAGEN", "", ""};
		modelSill = new DefaultTableModel();
		modelSill.setColumnIdentifiers(titulos);
		for(Producto p: sillas) {
			Object [] datos = {p.getCod(), p.getNombre(), p.getTipo(), p.getMarca(), p.getTamanyo(), p.getPrecio(), p.getStock(), p.getRuta(), "Cantidad", "Añadir"};
			modelSill.addRow(datos);
		}
		
		
		//DUDA
//		TableCellRenderer tableRenderer;
//		tablaSillas = new JTable(new JTableButtonModel());
//		tableRenderer = tablaSillas.getDefaultRenderer(JButton.class);
//		tablaSillas.setDefaultRenderer(JButton.class,  new JTableButtonRenderer(tableRenderer));
		tablaSillas = new JTable(modelSill);
		scrSillas = new JScrollPane(tablaSillas);
		
		
		
		
		
//		tablaSillas.addMouseListener(new MouseAdapter() {
//		
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				int fila = tablaSillas.rowAtPoint(e.getPoint());
//				int columna = tablaSillas.columnAtPoint(e.getPoint());
//				if (columna == 10) { //La del botón
//					//Código relacionado con la acción del botón
//				}
//		
//			}
//		});
//		
//		
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
		
		panelCentral.add(scrSillas, BorderLayout.CENTER);

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
	
	//DUDA
//	class JTableButtonRenderer implements TableCellRenderer {
//		   private TableCellRenderer defaultRenderer;
//		   public JTableButtonRenderer(TableCellRenderer renderer) {
//		      defaultRenderer = renderer;
//		   }
//		   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//		      if(value instanceof Component)
//		         return (Component)value;
//		         return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//		   }
//	}
//	
//	
//	class JTableButtonModel extends AbstractTableModel {
//		private Object[][] rows = {{"CODIGO"},{"TIPO"},{"MARCA"},{"TAMANYO"},{"PRECIO"},{"STOCK"},{"IMAGEN"},{"CANTIDAD"},{"AÑADIR"}};
//		private String[] columns = {"AÑadir","CANTIDAD","MARCA","TAMANYO","PRECIO","STOCK","IMAGEN","CANTIDAD","AÑADIR"};
//		
//		public String getColumnName(int column) {
//			return columns[column];
//		}
//		public int getRowCount() {
//			return rows.length;
//		}
//		public int getColumnCount() {
//		      return columns.length;
//		}
//		public Object getValueAt(int row, int column) {
//			return rows[row][column];
//		}
//		public boolean isCellEditable(int row, int column) {
//			return false;
//		}
//		public Class getColumnClass(int column) {
//		      return getValueAt(0, column).getClass();
//		}
//	}

	

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

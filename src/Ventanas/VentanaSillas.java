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

import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
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
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import Clases.BaseDatos;
import Clases.Carrito;
import Clases.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class VentanaSillas extends JFrame{
	
	private Connection con;
	
	private PanelConFondo panelFoto;

	private JButton btnAgregar;
	private JLabel lblNewLabel;
	private JPanel panelCentral;
	
	private JTable tablaSillas;
	public static JTableButtonModel modelSill;
	private JScrollPane scrSillas;
	
	private ArrayList<Producto> al;
	
	private tabla_spinner tablaSpinner;
	private JSpinner spinner;
	
	public VentanaSillas() {
		
		setBounds(250, 225, 1000, 508);
		
		con = BaseDatos.initBD("data/DeustoIkea.db");

		tablaSpinner = new tabla_spinner();
		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(new Color(100, 149, 237));
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panelNorteFecha = new JPanel();
		panelNorteFecha.setBackground(new Color(100, 149, 237));
		FlowLayout flowLayout = (FlowLayout) panelNorteFecha.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelNorte.add(panelNorteFecha);
		
		JLabel lblFecha = new JLabel("");
		panelNorteFecha.add(lblFecha);
		
		lblNewLabel = new JLabel("MENU SILLAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(100, 149, 237));
		panelNorte.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(100, 149, 237));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelNorte.add(panel_2);
		
		JButton btnCarrito_1 = new JButton("");
		btnCarrito_1.setIcon(new ImageIcon("imagenes/pngegg.png"));
		panel_2.add(btnCarrito_1);
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAtras = new JButton("ATRAS");
		panelSur.add(btnAtras);
	
		
		
		panelCentral = new JPanel(new GridLayout(2, 1));
		
		
		
		
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		

		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		modelSill = new JTableButtonModel();
		
		
		tablaSillas = new JTable(modelSill);
		TableCellRenderer tbcr = tablaSillas.getDefaultRenderer(JButton.class);
		tablaSillas.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tbcr));
		TableColumn tc = tablaSillas.getColumnModel().getColumn(7);
		tc.setCellEditor(new tabla_spinner());
		tc.setCellRenderer(new tabla_spinner());
		scrSillas = new JScrollPane(tablaSillas);
		panelCentral.add(scrSillas);
		
		JPanel panelAbajo = new JPanel();
		panelCentral.add(panelAbajo);
		panelAbajo.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panelAbajo.add(panel);
		
		
		
		panelFoto = new PanelConFondo(null);
		panelFoto.setBackground(new Color(100, 149, 237));
		panelAbajo.add(panelFoto);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panelAbajo.add(panel_1);
		

		
		
		
		tablaSillas.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tablaSillas.rowAtPoint(e.getPoint());
				String tipo = (String) modelSill.getValueAt(fila, 2);
				String ruta = BaseDatos.getRuta(con, tipo);
				ImageIcon imagen = new ImageIcon(ruta);
				panelFoto.setImagen(imagen.getImage());
				panelFoto.repaint();
					System.out.println("dentro");
					int columna = 0;
					System.out.println(columna);
					if(tablaSillas.columnAtPoint(e.getPoint()) == modelSill.getColumnCount()-1) {
						System.out.println("if");
						if(spinner.getComponentCount()>0) {
							int cantidadBD = spinner.getComponentCount();
							System.out.println(cantidadBD);
							BaseDatos.insertarCarrito(con, VentanaInicial.dni, al.get(fila).getCod(), al.get(fila).getNombre(), al.get(fila).getTipo(), al.get(fila).getMarca(), al.get(fila).getTamanyo(),cantidadBD, al.get(fila).getPrecio());
						}else {
							System.out.println("error");
						}
//						int cantidadBD = spinner.getComponentCount();
//						System.out.println(cantidadBD);
//						BaseDatos.insertarCarrito(con, VentanaInicial.dni, al.get(fila).getCod(), al.get(fila).getNombre(), al.get(fila).getTipo(), al.get(fila).getMarca(), al.get(fila).getTamanyo(),cantidadBD, al.get(fila).getPrecio());
					}
//				if(tablaSillas.columnAtPoint(e.getPoint()) == modelSill.getColumnCount()-1) {
//					System.out.println(fila);
//					//String o = JOptionPane.showInputDialog(null, "Cantidad requirida: ", "CANTIDAD", JOptionPane.INFORMATION_MESSAGE);
////					int cantidad = tablaSillas.columnAtPoint(e.getPoint());
////					System.out.println(cantidad);
//					BaseDatos.insertarCarrito(con, VentanaInicial.dni, al.get(fila).getCod(), al.get(fila).getNombre(), al.get(fila).getTipo(), al.get(fila).getMarca(), al.get(fila).getTamanyo(),0, al.get(fila).getPrecio());
//					
//				}
				
				
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
	class tabla_spinner extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

		JSpinner spinner=new JSpinner();
	    Object valorActual;   
	    @Override
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	        return spinner;//y retornamos el label
	    }
	    @Override
	    public Component getTableCellRendererComponent
	        (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

	        //si el datos es un objetc osea jlabel
	        if (value instanceof JSpinner) {
	            spinner=(JSpinner) value;//lo convertimos a JLabel 
	            return spinner;//y retornamos el label
	        }

	        return spinner;
	    }
	    @Override
	    public Object getCellEditorValue() {
	        return spinner;
	    }	
	}
	
	class JTableButtonRenderer implements TableCellRenderer {
			private TableCellRenderer defaultRenderer;
			public JTableButtonRenderer(TableCellRenderer renderer) {
				defaultRenderer = renderer;
			}
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				if(value instanceof Component) {
					return (Component)value;
			        
				}
				return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		}
		
	class JTableButtonModel extends AbstractTableModel {
			private Object[][] rows;
			private String[] columns = {"CODIGO", "NOMBRE", "TIPO", "MARCA", "TAMAÑO", "PRECIO", "STOCK", "", ""};
			   
			public String getColumnName(int column) {
				return columns[column];
			}
			public JTableButtonModel() {
				super();
				ArrayList<Object[]> alObject = new ArrayList<>();
				al = BaseDatos.obtenerProducto(con, "Silla");
				for(Producto p : al) {
					JButton btnAnadir = new JButton("AÑADIR");
						
					Object [] datos = {p.getCod(), p.getNombre(), p.getTipo(), p.getMarca(), p.getTamanyo(), p.getPrecio(), p.getStock(), 
									   0, btnAnadir};
					alObject.add(datos);
				}
				Object[][] ob1 = new Object[alObject.size()][alObject.get(0).length]; 
				int ob2 = 0;
				for(Object[] ob : alObject) {
					ob1[ob2] = ob; 
					ob2++;
				}
				this.rows =  ob1;
			}
			
			public int getRowCount() {
				return rows.length;
			}
			
			public int getColumnCount() {
				return columns.length;
			}
			
			public Object getValueAt(int row, int column) {
				return rows[row][column];
			}
			
			public boolean isCellEditable(int row, int column) {
				if (column == 7)
					return true;
				return false;
			}
			
			public Class getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
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
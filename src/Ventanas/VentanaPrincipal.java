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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;


public class VentanaPrincipal extends JFrame {
	private JTextField txtMuebleCasa;
	private JTextField txtEspejos;
	private JTextField txtSillas;
	private JTextField txtTelevisiones;
	private JTextField txtSofas;
	private JTextField txtCamas;
	private JTextField txtMenuPrincipal;
	private JTextField txtReloj;
	public VentanaPrincipal() {
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		txtReloj = new JTextField();
		txtReloj.setText("FECHA");
		panel.add(txtReloj);
		txtReloj.setColumns(10);
		
		txtMenuPrincipal = new JTextField();
		txtMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtMenuPrincipal.setText("MENU PRINCIPAL");
		panel.add(txtMenuPrincipal);
		txtMenuPrincipal.setColumns(10);
		
		JButton btnNewButton = new JButton("IMAGEN CARRITO");
		panel.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("SALIR");
		panel_2.add(btnNewButton_1);
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(2, 3, 0, 0));
		
		txtMuebleCasa = new JTextField();
		txtMuebleCasa.setText("MUEBLE CASA");
		panel_4.add(txtMuebleCasa);
		txtMuebleCasa.setColumns(10);
		
		txtEspejos = new JTextField();
		txtEspejos.setText("ESPEJOS");
		panel_4.add(txtEspejos);
		txtEspejos.setColumns(10);
		
		txtSillas = new JTextField();
		txtSillas.setText("SILLAS");
		panel_4.add(txtSillas);
		txtSillas.setColumns(10);
		
		txtTelevisiones = new JTextField();
		txtTelevisiones.setText("TELEVISIONES");
		panel_4.add(txtTelevisiones);
		txtTelevisiones.setColumns(10);
		
		txtSofas = new JTextField();
		txtSofas.setText("SOFAS");
		panel_4.add(txtSofas);
		txtSofas.setColumns(10);
		
		txtCamas = new JTextField();
		txtCamas.setText("CAMAS");
		panel_4.add(txtCamas);
		txtCamas.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.WEST);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_1.add(comboBox_1);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

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


public class VentanaCesta extends JFrame {
	private JTextField txtListaDeLa;
	public VentanaCesta() {
		
		setBounds(450, 125, 800, 408);
		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtListaDeLa = new JTextField();
		txtListaDeLa.setText("lista de la compra");
		panel.add(txtListaDeLa);
		txtListaDeLa.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("REALIZAR COMPRA");
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("precio total");
		panel_1.add(lblNewLabel);
		
		JButton btnFactura = new JButton("FACTURA");
		
		panel_1.add(btnFactura);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnatras = new JButton("ATRAS");
		panel_2.add(btnatras);
		
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

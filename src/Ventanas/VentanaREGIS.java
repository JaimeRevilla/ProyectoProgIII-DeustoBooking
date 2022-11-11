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


public class VentanaREGIS extends JFrame {
	private JTextField fieldId;
	private JPasswordField fieldContr;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public VentanaREGIS() {
		
		setBounds(450, 125, 800, 408);
		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelHora = new JPanel();
		panelHora.setBackground(Color.BLACK);
		panelHora.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		getContentPane().add(panelHora, BorderLayout.NORTH);
		panelHora.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("OPCIONES");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelHora.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DATOS");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelHora.add(lblNewLabel_1);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Color.BLACK);
		panelBotones.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("SALIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelBotones.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String refexContrasenia = "[A-Z][a-z]{0,20}[0-9][^A-Za-z0-9]";
				String contrasenia = fieldContr.getText();
				
				if(Pattern.matches(refexContrasenia, contrasenia)) {
					JOptionPane.showMessageDialog(null, "Bienvenido", "SESIÓN INICIADA", JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, "La contraseña es erronea", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelBotones.add(btnNewButton_1);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(new Color(128, 255, 255));
		panelDatos.setForeground(new Color(128, 255, 255));
		getContentPane().add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel labelNom = new JLabel("Nombre:");
		panelDatos.add(labelNom);
		
		fieldId = new JTextField();
		panelDatos.add(fieldId);
		fieldId.setColumns(10);
		
		JLabel labelContr = new JLabel("Contraseña:");
		panelDatos.add(labelContr);
		
		fieldContr = new JPasswordField();
		panelDatos.add(fieldContr);
		
		JLabel labelCiudad = new JLabel("Ciudad");
		panelDatos.add(labelCiudad);
		
		textField_2 = new JTextField();
		panelDatos.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel labelCodPost = new JLabel("Codigo Postal");
		panelDatos.add(labelCodPost);
		
		textField_1 = new JTextField();
		panelDatos.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel labelDni = new JLabel("Dni");
		panelDatos.add(labelDni);
		
		textField = new JTextField();
		panelDatos.add(textField);
		textField.setColumns(10);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaREGIS frame = new VentanaREGIS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

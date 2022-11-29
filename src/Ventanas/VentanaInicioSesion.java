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

import Clases.BaseDatos;
import Clases.Usuario;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;


public class VentanaInicioSesion extends JFrame {
	private JTextField txtDni;
	private JPasswordField txtContr;
	private Connection connection;
	
	public VentanaInicioSesion() {
		Connection con = BaseDatos.initBD("data/DeustoIkea.db");
		
		BaseDatos.crearTablasUsuario(con);
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
				System.exit(0);
				BaseDatos.closeBD(connection);
			}
			
		});
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelBotones.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LOG IN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dni = txtDni.getText();
				String erDni = "[0-9]{3}[A-Z]";
				String contrasenia = txtContr.getText();
				String erContr = "[0-9]{3}";
				
				if(Pattern.matches(erDni, dni) && Pattern.matches(erContr, contrasenia)) {
					//Comprobamos si el usuario esta registrado
					Usuario u = new Usuario();
					u = BaseDatos.obtenerUsuario(con, dni);
					if(u != null) {
						if(u.getContrasenia().equals(contrasenia)) {
							JOptionPane.showMessageDialog(null, "Bienvenido", "SESIÓN INICIADA", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "La contraseña es erronea!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "No existe un requisito asociado a ese Dni", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Los datos no cumplen los requisitos", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					
				}
				txtDni.setText("");
				txtContr.setText("");
				
//				/*
//				if(Pattern.matches(refexContrasenia, contrasenia)) {
//					JOptionPane.showMessageDialog(null, "Bienvenido", "SESIÓN INICIADA", JOptionPane.INFORMATION_MESSAGE);
//					
//				}else {
//					JOptionPane.showMessageDialog(null, "La contraseña es erronea", "ERROR", JOptionPane.ERROR_MESSAGE);
//				}*/
//				if(contrasenia.equals(BaseDatos.obtenerContrasena(connection, txtDni.getText()))) {
//					JOptionPane.showMessageDialog(null, "Bienvenido", "SESIÓN INICIADA", JOptionPane.INFORMATION_MESSAGE);
//					
//					new VentanaPrincipal();
//					
//				}else {
//					JOptionPane.showMessageDialog(null, "La contraseña es erronea", "ERROR", JOptionPane.ERROR_MESSAGE);
//				}
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
		panelDatos.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel labelDni = new JLabel("Dni:");
		panelDatos.add(labelDni);
		
		txtDni = new JTextField();
		panelDatos.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel labelContr = new JLabel("Contraseña:");
		panelDatos.add(labelContr);
		
		txtContr = new JPasswordField();
		panelDatos.add(txtContr);
		
		setVisible(true);
		
		connection= BaseDatos.initBD("data/DeustoIkea");
		BaseDatos.crearTablasUsuario(connection);
		BaseDatos.crearTablasProducto(connection);
		BaseDatos.crearTablasCarrito(connection);
		BaseDatos.insertarUsuario(connection, "Admin","111A","admin@gmail.com","casa", "Aa00Za", 1 );
		

	}
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicioSesion frame = new VentanaInicioSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

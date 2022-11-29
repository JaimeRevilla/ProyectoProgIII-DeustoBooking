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

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;


public class VentanaRegis extends JFrame {
	
	private JTextField txtNombre;
	private JPasswordField txtContr;
	private JTextField txtDni;
	private JTextField txtCodigoPostal;
	private JTextField txtCiudad;
	private JFrame vent;
	
	public VentanaRegis() {
		vent = this;
		
		//Conexion  con la base de datos y  creamos la tabla 
		
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
				
				String nombre = txtNombre.getText();
				String contrasenia = txtContr.getText();
				String erContr = "[0-9]{3}";
				boolean contraseniaCorrecta = Pattern.matches(erContr, contrasenia);
				String ciudad = txtCiudad.getText();
				String codigoPostal = txtCodigoPostal.getText();
				String dni = txtDni.getText();
				String erDni = "[0-9]{3}[A-Z]";
				boolean dniCorrecta = Pattern.matches(erDni, dni);
				
				if(!contraseniaCorrecta) {
					JOptionPane.showInputDialog(null,"La contrasenia introducida es incorrecta!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else if(!dniCorrecta) {
					JOptionPane.showInputDialog(null,"El dni introducido es incorrecto!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					boolean encontrada = BaseDatos.buscarUsuario(con, dni);
					if(!encontrada) {
						BaseDatos.insertarUsuario(con, nombre, contrasenia, ciudad, codigoPostal, dni, 0);
						JOptionPane.showInputDialog(null,"Registro realizado correctamente!", "REGISTRO REALIZADO", JOptionPane.ERROR_MESSAGE);
						System.out.println("El usuario ha sido registrado correctamente!");
					}else {
						JOptionPane.showInputDialog(null,"Registro realizado es incorrecta! Existe ya un usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
						System.out.println("El usuario no ha sido registrado correctamente! Existe un usuario con el mismo dni");
					}
					txtNombre.setText("");
					txtContr.setText("");
					txtCiudad.setText("");
					txtCodigoPostal.setText("");
					txtDni.setText("");
					
				}
				
				
				
				
//				String refexContrasenia = "[A-Z][a-z]{0,20}[0-9][^A-Za-z0-9]";
//				String contrasenia = txtContr.getText();
//				
//				if(Pattern.matches(refexContrasenia, contrasenia)) {
//					JOptionPane.showMessageDialog(null, "Bienvenido", "SESIÓN INICIADA", JOptionPane.INFORMATION_MESSAGE);
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
		panelDatos.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel labelNom = new JLabel("Nombre:");
		panelDatos.add(labelNom);
		
		txtNombre = new JTextField();
		panelDatos.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel labelContr = new JLabel("Contraseña:");
		panelDatos.add(labelContr);
		
		txtContr = new JPasswordField();
		panelDatos.add(txtContr);
		
		JLabel labelCiudad = new JLabel("Ciudad");
		panelDatos.add(labelCiudad);
		
		txtCiudad = new JTextField();
		panelDatos.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		JLabel labelCodPost = new JLabel("Codigo Postal");
		panelDatos.add(labelCodPost);
		
		txtCodigoPostal = new JTextField();
		panelDatos.add(txtCodigoPostal);
		txtCodigoPostal.setColumns(10);
		
		JLabel labelDni = new JLabel("Dni");
		panelDatos.add(labelDni);
		
		txtDni = new JTextField();
		panelDatos.add(txtDni);
		txtDni.setColumns(10);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegis frame = new VentanaRegis();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

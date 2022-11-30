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
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Clases.BaseDatos;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;


public class VentanaRegis extends JFrame {
	
	private JTextField txtNombre;
	private JTextField txtDni;
	private JFrame vent;
	private JTextField txtMail;
	private JTextField txtDomicilio;
	private JTextField textContr;
	private JTextField txtContr;
	private JPasswordField passwordField;
	
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
		
		JButton btnSalir = new JButton("SALIR");
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelBotones.add(btnSalir);
		
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//nombre String, dni String, email String, domicilio String, contrasenia String, permisos int
				String nombre = txtNombre.getText();
				String dni = txtDni.getText();
				String erDni = "[0-9]{3}[A-Z]";
				boolean dniCorrecta = Pattern.matches(erDni, dni);
				String mail = txtMail.getText();
				String domicilio = txtDomicilio.getText();
				String contrasenia = passwordField.getText();
				String erContr = "[0-9]{3}";
				boolean contraseniaCorrecta = Pattern.matches(erContr, contrasenia);
				
				if(!contraseniaCorrecta) {
					JOptionPane.showMessageDialog(null,"La contrasenia introducida es incorrecta!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else if(!dniCorrecta) {
					JOptionPane.showMessageDialog(null,"El dni introducido es incorrecto!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					System.out.println();
					boolean encontrada = BaseDatos.buscarUsuario(con, dni);
					if(!encontrada) {
						BaseDatos.insertarUsuario(con, nombre, dni, mail, domicilio, contrasenia, 0);
						JOptionPane.showMessageDialog(null,"Registro realizado correctamente!", "REGISTRO REALIZADO", JOptionPane.DEFAULT_OPTION);
						System.out.println("El usuario ha sido registrado correctamente!");
					}else {
						JOptionPane.showMessageDialog(null,"Registro realizado es incorrecta! \n Existe ya un usuario", "ERROR", JOptionPane.INFORMATION_MESSAGE);
						System.out.println("El usuario no ha sido registrado correctamente! Existe un usuario con el mismo dni");
					}
					txtNombre.setText("");
					txtDni.setText("");
					txtMail.setText("");
					txtDomicilio.setText("");
					passwordField.setText("");
					
					
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
		
		btnSignUp.setBackground(Color.WHITE);
		btnSignUp.setForeground(Color.BLACK);
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelBotones.add(btnSignUp);
		
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
		
		JLabel labelDni = new JLabel("Dni");
		panelDatos.add(labelDni);
		
		txtDni = new JTextField();
		panelDatos.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblMail = new JLabel("Email");
		panelDatos.add(lblMail);
		
		txtMail = new JTextField();
		panelDatos.add(txtMail);
		txtMail.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Ciudad");
		panelDatos.add(lblDomicilio);
		
		txtDomicilio = new JTextField();
		panelDatos.add(txtDomicilio);
		txtDomicilio.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		panelDatos.add(lblContrasenia);
		
		passwordField = new JPasswordField();
		panelDatos.add(passwordField);
		
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

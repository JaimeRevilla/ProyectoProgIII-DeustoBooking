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


public class VentanaInicial extends JFrame {
	public VentanaInicial() {
		
		setBounds(450, 125, 800, 408);
		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 4, 0, 0));
		
		JLabel lblNewLabel = new JLabel("BIENVENIDO PULSA LO QUE DESEA REALIZAR");
		panel.add(lblNewLabel);
		
		JButton btnsignup = new JButton("SIGN UP");
		btnsignup.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(btnsignup);
		
		JButton btnlogin = new JButton("LOG IN");
		btnlogin.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(btnlogin);
		
		JButton btnMenuPrincipal = new JButton("MENU PRINCIPAL");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnMenuPrincipal);
				
		setVisible(true);
		
		btnsignup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaRegis v1 = new VentanaRegis();
			}
		});
		
		btnlogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicioSesion v1 = new VentanaInicioSesion();
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicial frame = new VentanaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

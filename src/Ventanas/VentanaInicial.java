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
	private JTextField txtBienvenidoPulsaLo;
	public VentanaInicial() {
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(128, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 4, 0, 0));
		
		txtBienvenidoPulsaLo = new JTextField();
		txtBienvenidoPulsaLo.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtBienvenidoPulsaLo.setText("BIENVENIDO PULSA LO QUE DESEA REALIZAR");
		panel.add(txtBienvenidoPulsaLo);
		txtBienvenidoPulsaLo.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(btnNewButton);
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

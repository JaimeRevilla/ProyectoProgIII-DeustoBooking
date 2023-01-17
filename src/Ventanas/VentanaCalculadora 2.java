package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VentanaCalculadora extends JFrame{
	private final JPanel panel_6 = new JPanel();
	
public VentanaCalculadora() {
		
		setBounds(250, 225, 350, 400);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnSalir = new JButton("Salir");
		panel.add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(5, 1, 0, 0));
		panel_1.add(panel_6);
		
		JLabel lblNewLabel = new JLabel("CALCULATOR");
		panel_6.add(lblNewLabel);
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		
		JTextArea textArea = new JTextArea();
		panel_7.add(textArea);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btn1 = new JButton("1");
		panel_2.add(btn1);
		
		JButton btn2 = new JButton("2");
		panel_2.add(btn2);
		
		JButton btn3 = new JButton("3");
		panel_2.add(btn3);
		
		JButton btnSuma = new JButton("+");
		panel_2.add(btnSuma);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btn4 = new JButton("4");
		panel_3.add(btn4);
		
		JButton btn5 = new JButton("5");
		panel_3.add(btn5);
		
		JButton btn6 = new JButton("6");
		panel_3.add(btn6);
		
		JButton btnMenos = new JButton("-");
		panel_3.add(btnMenos);
		
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btn7 = new JButton("7");
		panel_4.add(btn7);
		
		JButton btn8 = new JButton("8");
		panel_4.add(btn8);
		
		JButton btn9 = new JButton("9");
		panel_4.add(btn9);
		
		JButton btnMulti = new JButton("*");
		panel_4.add(btnMulti);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btn0 = new JButton("0");
		panel_5.add(btn0);
		
		JButton btnPunto = new JButton(".");
		panel_5.add(btnPunto);
		
		JButton btnC = new JButton("C");
		panel_5.add(btnC);
		
		JButton btnIgual = new JButton("=");
		panel_5.add(btnIgual);
		
		btnSalir.addActionListener(new ActionListener() {
			
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
					VentanaCalculadora frame = new VentanaCalculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
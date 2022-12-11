package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaContabilidad extends JFrame{
	
	private JFrame vent;
	
	public VentanaContabilidad() {
		
		setBounds(250, 225, 1000, 508);
		
		JPanel panelNorte = new JPanel();	
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblVentas = new JLabel("VENTAS");
		panelNorte.add(lblVentas);
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelSur.add(btnAtras);
		
		JButton btnCalculadora = new JButton("CALCULADORA");
		btnCalculadora.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCalculadora vC = new VentanaCalculadora();
			}
		});
		panelSur.add(btnCalculadora);
		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaContabilidad frame = new VentanaContabilidad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
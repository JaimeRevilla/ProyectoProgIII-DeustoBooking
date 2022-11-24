package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VentanaContabilidad extends JFrame{
	
	private JFrame vent;
	
	public VentanaContabilidad() {
		
		JPanel panel = new JPanel();	
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblVentas = new JLabel("VENTAS");
		panel.add(lblVentas);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnAtras = new JButton("Atras");
		panel_1.add(btnAtras);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		

	}
}
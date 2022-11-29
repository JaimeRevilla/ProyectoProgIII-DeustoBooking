package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaFactura extends JFrame{
	private JTable tablaFactura;
	
	
	
	public VentanaFactura() {
		
		setBounds(450, 125, 800, 408);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnAtras = new JButton("ATRAS");
		
		panel.add(btnAtras);
		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		tablaFactura = new JTable();
		panelCentro.add(tablaFactura);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblFactura_1 = new JLabel("FACTURA");
		panel_1.add(lblFactura_1);
		
		btnAtras.addActionListener(new ActionListener() {
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
					VentanaFactura frame = new VentanaFactura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

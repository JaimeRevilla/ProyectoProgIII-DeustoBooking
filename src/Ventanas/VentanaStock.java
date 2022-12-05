package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaStock extends JFrame{

	private JFrame vent;
	
	public VentanaStock() {
		
		setBounds(250, 225, 1000, 508);
		
		JPanel panelNorte = new JPanel();
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("LISTA PRODUCTO CON INFORMACION");
		panelNorte.add(lblNewLabel);
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(1, 4, 0, 0));
		
		JButton btnEliminar = new JButton("Eliminar");
		panelSur.add(btnEliminar);
		
		JButton btnAnadir = new JButton("Añadir");
		panelSur.add(btnAnadir);
		
		JButton btnActualizar = new JButton("Actualizar");
		panelSur.add(btnActualizar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelSur.add(btnSalir);

		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);

	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaStock frame = new VentanaStock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
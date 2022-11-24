package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class VentanaStock extends JFrame{

	private JFrame vent;
	
	public VentanaStock() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("LISTA PRODUCTO CON INFORMACION");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 4, 0, 0));
		
		JButton btnEliminar = new JButton("Eliminar");
		panel_1.add(btnEliminar);
		
		JButton btnAnadir = new JButton("Añadir");
		panel_1.add(btnAnadir);
		
		JButton btnActualizar = new JButton("Actualizar");
		panel_1.add(btnActualizar);
		
		JButton btnSalir = new JButton("Salir");
		panel_1.add(btnSalir);

		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);

	}
}
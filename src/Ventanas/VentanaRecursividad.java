package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JTextArea;

import Clases.Producto;
import java.awt.Color;

public class VentanaRecursividad extends JFrame {
	private List<List<Producto>> productosR;
	private JTextArea jt;
	
	public VentanaRecursividad(List<List<Producto>> productos) {
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		setBounds(250, 225, 1000, 508);
		this.productosR = productos;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		jt= new JTextArea();
		jt.setBackground(new Color(100, 149, 237));
		getContentPane().add(jt);
		escribirEnTextArea(jt);
		this.setVisible(true);
		
	}

	public void escribirEnTextArea(JTextArea jt) {
		for(List<Producto> p : productosR) {
			for(Producto pro : p) {
				jt.setText(jt.getText() + "\n"+ pro.toString());
				
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRecursividad frame = new VentanaRecursividad(null);
					//mainRecursividad(args);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

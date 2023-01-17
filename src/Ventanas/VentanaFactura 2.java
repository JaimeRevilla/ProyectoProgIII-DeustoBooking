package Ventanas;

import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import Clases.Carrito;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaFactura extends JFrame{
	private JList<Carrito> listaFactura;
	private DefaultListModel<Carrito> model;
	private JScrollPane panelLista;
	public static ArrayList<Carrito> carrito;
	
	
	public VentanaFactura(ArrayList<Carrito> carrito) {
		this.carrito = carrito;
		setBounds(250, 225, 1000, 508);
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAtras = new JButton("ATRAS");
		
		panelSur.add(btnAtras);
		
		model = new DefaultListModel<>();
		listaFactura = new JList<>(model);
		panelLista = new JScrollPane(listaFactura);
		cargarModelo();
		
		getContentPane().add(panelLista, BorderLayout.CENTER);

		JPanel panelNorte = new JPanel();
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblFactura_1 = new JLabel("FACTURA");
		panelNorte.add(lblFactura_1);
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		setVisible(true);
	}

//	private void cargarFichero() {
//		System.out.println("error1");
//		ArrayList<Carrito> car = new ArrayList<>();
//		System.out.println("error2");
//		try (BufferedReader br = new BufferedReader(new FileReader("Factura"+VentanaInicioSesion.dni+".txt"));){
//			System.out.println("error3");
//			String linea = br.readLine();
//			while(linea!=null) {
//				
//			
//				String [] dato = linea.split(";");
//				
//				String dni = dato[0];
//				int cod = Integer.parseInt(dato[1]);
//				String nom = dato[2];
//				String tipo = dato[3];
//				String marca = dato[4];
//				String tam = dato[5];
//				double prec = Double.parseDouble(dato[6]);
//				System.out.println("error6");
//				//Carrito ca = new Carrito(dni, cod, nom, tipo, marca, tam, prec);
//				car.add(new Carrito(dni, cod, nom, tipo, marca, tam, prec));
//				//model.addElement(ca);
//				//car.add(ca);
//				System.out.println(car.get(0));
//				linea = br.readLine();
//				System.out.println(linea);
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println(String.format("Error Factura:%s",e.getMessage()));
//			e.printStackTrace();
//		} catch (IOException e1) {
//			System.out.println(String.format("Error Factura1:%s",e1.getMessage()));
//			e1.printStackTrace();
//		}
//	}
//	
	private void cargarModelo() {
		model.removeAllElements();
		for(Carrito c: carrito) {
			model.addElement(c);
		}
	}
	
}

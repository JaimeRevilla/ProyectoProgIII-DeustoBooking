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
import java.awt.event.ActionEvent;

public class VentanaFactura extends JFrame{
	private JList<Carrito> listaFactura;
	private DefaultListModel<Carrito> model;
	private JScrollPane panelLista;
	
	
	public VentanaFactura() {
		
		setBounds(250, 225, 1000, 508);
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAtras = new JButton("ATRAS");
		
		panelSur.add(btnAtras);
		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);

		model = new DefaultListModel<>();
		listaFactura = new JList<>(model);
		panelLista = new JScrollPane(listaFactura);
		panelLista.add(listaFactura);
		//cargarFichero();
		VentanaCesta.cargarFichero();
		
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
//		try (BufferedReader br = new BufferedReader(new FileReader("Factura"+VentanaInicioSesion.dni+".txt"));){
//			String linea = br.readLine();
//			while(linea!=null) {
//				String [] dato = linea.split(";");
//				Carrito ca = new Carrito(dato[0],Integer.parseInt((String)dato[1]),dato[2],dato[3],dato[4],dato[5],Double.parseDouble((String)dato[6]));
//				System.out.println(ca);
//				model.addElement(ca);
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

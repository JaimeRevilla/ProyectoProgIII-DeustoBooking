package Clases;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		Connection con = BaseDatos.initBD("data/DeustoIkea.db");
		
		BaseDatos.crearTablas(con);
		
		
		//Perimsos --> 0 = Usuario / 1 = Admin
		//INSERCCION DE USUARIO
		Usuario usuario = new Usuario("daniel", "111A", "dani@mail.com", "caceres", "111A", 0); 
		System.out.println("Insertando usuario ...");
		System.out.println(String.format("Datos del usuario insertado: %s", usuario.getNombre() + " " + " " + 
							usuario.getDni() + " " + usuario.getEmail() + " " + 
							usuario.getDomicilio() + " " + usuario.getContrasenia() + " " + usuario.isPermisos()));
		
		
		Usuario usuario1 = new Usuario("ADMIN", "000A", "ADMIN@mail.com", "mostoles", "000A", 1); 
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Insertando admin ...");
		System.out.println(String.format("Datos del admin insertado: %s", usuario1.getNombre() + " " + " " + 
							usuario1.getDni() + " " + usuario1.getEmail() + " " + 
							usuario1.getDomicilio() + " " + usuario1.getContrasenia() + " " + usuario1.isPermisos()));
		
		BaseDatos.insertarUsuario(con, "daniel", "111A", "dani@mail.com", "caceres", "111A", 0);
		BaseDatos.insertarUsuario(con, "ADMIN", "000A", "ADMIN@mail.com", "mostoles", "000A", 1);
		
		//INSERCCION DE PRODUCTOS
		Producto producto = new Producto(0, "Armario1", "ABEDUL", "IKEA", "200x200", 200.50, 2);
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Insertando producto 1 ...");
		System.out.println(String.format("Datos del producto insertado: %s", "Producto 1 (" + producto.getCod() + " " + " " + 
							producto.getNombre() + " " + producto.getTipo() + " " + 
							producto.getMarca() + " " + producto.getTamanyo() + " " + producto.getPrecio() + " " + producto.getStock() + ")"));
		
		System.out.println("Insertando producto 2 ...");
		System.out.println(String.format("Datos del producto insertado: %s", "Producto 2 (" + producto.getCod() + " " + " " + 
							producto.getNombre() + " " + producto.getTipo() + " " + 
							producto.getMarca() + " " + producto.getTamanyo() + " " + producto.getPrecio() + " " + producto.getStock() + ")"));
		
		System.out.println("Insertando producto 3 ...");
		System.out.println(String.format("Datos del producto insertado: %s", "Producto 3 (" + producto.getCod() + " " + " " + 
							producto.getNombre() + " " + producto.getTipo() + " " + 
							producto.getMarca() + " " + producto.getTamanyo() + " " + producto.getPrecio() + " " + producto.getStock() + ")"));
		
		BaseDatos.insertarProducto(con, 0, "Armario1", "ABEDUL", "IKEA", "200x200", 200.50, 2);
		BaseDatos.insertarProducto(con, 1, "Cama1", "LITERA", "IKEA", "200x200", 100.50, 12);
		BaseDatos.insertarProducto(con, 2, "Espejo1", "CIRCULAR", "IKEA", "50x100", 50.50, 20);
		
		//INSERCCION DE CARRITO
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Insertando carrito 1 ...");
		BaseDatos.insertarCarrito(con, "111A", 0, "Armario1", "ABEDUL", "IKEA", "200x200", 200.50);
		System.out.println("Insertando carrito 2 ...");
		BaseDatos.insertarCarrito(con, "222B", 1, "Cama1", "LITERA", "IKEA", "200x200", 100.50);
		
		//ELIMINACION DE TUPLAS
//		System.out.println("-----------------------------------------------------------------------");
//		System.out.println(String.format("Usuario con el dni : %s borrado!", usuario.getDni()));
//		BaseDatos.eleminarUsuario(con, "111A");
		
		//OBTENCION TUPLA USUARIO
		System.out.println("-----------------------------------------------------------------------");
		System.out.println(String.format("Información del usuari con el dni : %s ", usuario.getDni() ));
		BaseDatos.obtenerUsuario(con, "111A");
		System.out.println(String.format("Datos del usuario insertado: %s", usuario.getNombre() + " " + " " + 
							usuario.getDni() + " " + usuario.getEmail() + " " + 
							usuario.getDomicilio() + " " + usuario.getContrasenia() + " " + usuario.isPermisos()));
		
		//MODIFICACION ATRIBUTO CONTRASEÑA
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Modificar contraseña ...");
		System.out.println(String.format("Contraseña actual : %s", usuario.getContrasenia()));
		System.out.println("Contraseña nueva : 111B");
		BaseDatos.modificarConUsuario(con, "111A", "111B");
	}

}

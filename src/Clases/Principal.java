package Clases;

import java.sql.Connection;

public class Principal {

	public static void main(String[] args) {
		
		Connection con = BaseDatos.initBD("data/DeustoIkea.db");
		
		BaseDatos.crearTablas(con);
		
		//Perimsos --> 0 = Usuario / 1 = Admin
		//INSERCCION DE USUARIO
		System.out.println("Usuario insertado");
		BaseDatos.insertarUsuario(con, "daniel", "111A", "dani@mail.com", "caceres", "111A", 0);
		BaseDatos.insertarUsuario(con, "ADMIN", "000A", "ADMIN@mail.com", "mostoles", "000A", 1);
		
		//INSERCCION DE PRODUCTOS
		System.out.println("Producto insertado");
		BaseDatos.insertarProducto(con, 0, "Armario1", "ABEDUL", "IKEA", "200x200", 200.50, 2);
		BaseDatos.insertarProducto(con, 1, "Cama1", "LITERA", "IKEA", "200x200", 100.50, 12);
		BaseDatos.insertarProducto(con, 2, "Espejo1", "CIRCULAR", "IKEA", "50x100", 50.50, 20);
		
		//INSERCCION DE CARRITO
		System.out.println("Carrito insertado");
		BaseDatos.insertarCarrito(con, "111A", 0, "Armario1", "ABEDUL", "IKEA", "200x200", 200.50);
		BaseDatos.insertarCarrito(con, "222B", 1, "Cama1", "LITERA", "IKEA", "200x200", 100.50);
		
		//
		System.out.println("borrar usuario");
		BaseDatos.eleminarUsuario(con, "111A");
		System.out.println("usuario borrado");
	}

}

package Clases;

import java.sql.Connection;

public class Principal {

	public static void main(String[] args) {
		
		Connection con = BaseDatos.initBD("data/DeustoIkea.db");
		
		BaseDatos.crearTablas(con);
		
		//Perimsos --> 0 = Usuario / 1 = Admin
		
		System.out.println("usuario insertado");
		BaseDatos.insertarUsuario(con, "daniel", "111A", "dani@mail.com", "caceres", "111A", 0);
		BaseDatos.insertarUsuario(con, "ADMIN", "000A", "ADMIN@mail.com", "mostoles", "000A", 1);

	}

}

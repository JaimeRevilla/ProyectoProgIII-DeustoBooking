package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {


	/**
	 * Método que realiza la conexión con la base de datos
	 * @param BBDDCliente : Nombre de la base de datos a la que nos vamos a conectar
	 * @return Devuelve la conexión a la base de datos
	 */
	public static Connection initBD(String BBDDCliente) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:"+BBDDCliente);
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	/**
	 * Método que realiza la desconexión con la base de datos
	 * @param Connection con: recibimos la conexion con la base de datos
	 * @return No devuelve nada
	 */
	public static void closeBD(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Método para crear las tablas en la BBDD 
	 * @param Connection con: recibimos la conexion con la base de datos
	 * @return Devuelve un boolean dependiendo si se ha realizado correctamente(true) o incorrectamente(false)
	 */
	public static boolean crearTablas(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Usuario (nombre String, dni String, email String, domicilio String, contrasenia String, permisos int)";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			sql = "CREATE TABLE IF NOT EXISTS Producto (cod int, nombre String, tipo String, marca String, tamanyo String, precio double, stock int)";
			st.executeUpdate(sql);
			sql = "CREATE TABLE IF NOT EXISTS Carrito (dniUsu String, codProd int, nomProd String, tipoProd String, marcaProd String, tamanyoProd String, precioProd double)";
			st.executeUpdate(sql);
			st.close();
			return true;
		} catch (SQLException e) {
			System.err.println(String.format("ERROR AL CREAR LAS TABLAS: Usuario, Producto y Carrito", e.getMessage()));
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Método para insertar los datos del usuario en la tabla usuario de la BBDD
	 * @param Connection con, datos del usuario: recibimos la conexion con la base de datos y los datos del usuario
	 * @return No devuelve nada
	 */
	public static void insertarUsuario(Connection con,  String nombre,  String dni,  String email,  String domicilio,  String contrasenia,  int permisos) {
		String sql = "INSERT INTO Usuario VALUES('"+nombre+"','"+dni+"','"+email+"','"+domicilio+"','"+contrasenia+"','"+permisos+"')";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println(String.format("ERROR AL INSERTAR LOS DATOS EN LA TABLA: Usuario", e.getMessage()));
			e.printStackTrace();
		}
	}
	
	/**
	 * Método para insertar los datos del producto en la tabla producto de la BBDD
	 * @param Connection con, datos del producto: recibimos la conexion con la base de datos y los datos del producto
	 * @return No devuelve nada
	 */
	public static void insertarProducto(Connection con,   int cod,  String nombre,  String tipo,  String marca,  String tamanyo,  double precio,  int stock) {
		String sql = "INSERT INTO Producto VALUES('"+cod+"','"+nombre+"','"+tipo+"','"+marca+"','"+tamanyo+"',"+precio+",'"+stock+"')";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println(String.format("ERROR AL INSERTAR LOS DATOS EN LA TABLA: Producto", e.getMessage()));
			e.printStackTrace();
		}
	}
	
	/**
	 * Método para insertar los datos de la compra en la tabla carrito de la BBDD
	 * @param Connection con, datos del producto: recibimos la conexion con la base de datos y los datos del producto
	 * @return No devuelve nada
	 */
	public static void insertarCarrito(Connection con,   String dniUsu , int codProd, String nomProd, String tipoProd, String marcaProd, String tamanyoProd,double precioProd) {
		String sql = "INSERT INTO Carrito VALUES('"+dniUsu+"','"+codProd+"','"+nomProd+"','"+tipoProd+"','"+marcaProd+"','"+tamanyoProd+"',"+precioProd+")";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println(String.format("ERROR AL INSERTAR LOS DATOS EN LA TABLA: Carrito", e.getMessage()));
			e.printStackTrace();
		}
	}
	
	/**
	 * Método para borrar los datos del Usuario si el dni recibido es el mismo que buscamos en la BBDD
	 * @param Connection con, el dni del usuario: recibimos la conexion con la base de datos y el dni del usuario
	 * @return No devuelve nada
	 */
	public static void eleminarUsuario(Connection con, String dni) {
		String sent = "DELETE FROM Usuario WHERE dni ='"+dni+"'";
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sent);

		} catch (SQLException e) {
			System.err.println(String.format("ERROR AL BORRAR LOS DATOS DEL USUARIO", e.getMessage()));
			e.printStackTrace();
		}finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Método para borrar los datos del producto si el codigo recibido es el mismo que buscamos en la BBDD
	 * @param Connection con, el cod del producto: recibimos la conexion con la base de datos y el cod del producto
	 * @return No devuelve nada
	 */
	public static void eleminarProducto(Connection con, int cod) {
		String sent = "DELETE FROM Producto WHERE cod ='"+cod+"'";
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sent);

		} catch (SQLException e) {
			System.err.println(String.format("ERROR AL BORRAR LOS DATOS DEL PRODUCTO", e.getMessage()));
			e.printStackTrace();
		}finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Método para borrar los datos del carrito de un usuario si el dni recibido es el mismo que buscamos en la BBDD
	 * @param Connection con, el dni del usuario : recibimos la conexion con la base de datos y el dni del usuario
	 * @return No devuelve nada
	 */
	public static void eleminarCarrito(Connection con, String dni) {
		String sent = "DELETE FROM Carrito WHERE dni ='"+dni+"'";
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sent);

		} catch (SQLException e) {
			System.err.println(String.format("ERROR AL BORRAR LOS DATOS DEL CARRITO", e.getMessage()));
			e.printStackTrace();
		}finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Método para buscar los datos de un usuario si el dni recibido es el mismo que buscamos en la BBDD
	 * @param Connection con, el dni de un usuario : recibimos la conexion con la base de datos y el dni del usuario
	 * @return Devuelve el usuario buscado
	 */
	public static boolean obtenerUsuario(Connection con, String DNI) {
		boolean encontrada = false;
		String sent = "SELECT nombre FROM Usuario WHERE dni = '"+DNI+"'";
		try (Statement st = con.createStatement();){
			ResultSet rs = st.executeQuery(sent);
			if(rs.next()) {
				encontrada = true;
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println(String.format("ERROR AL ENCONTRAR LOS DATOS DEL USUARIO", e.getMessage()));
			e.printStackTrace();
		}
		return encontrada;
	}
	
	/**
	 * Método para buscar los datos de un usuario si el dni recibido es el mismo que buscamos en la BBDD
	 * @param Connection con, el dni de un usuario : recibimos la conexion con la base de datos y el dni del usuario
	 * @return Devuelve el usuario buscado
	 */
	
	
	
	//recibe le dni de un usuario y devuelve la contraseña que esta almacenada en la bd junto ese dni
	public static String obtenerContrasena(Connection con, String DNI) {
		String ret = "";
		String sent = "SELECT contrasenia FROM Usuario WHERE dni = '"+DNI+"'";
		try (Statement st = con.createStatement();){
			ResultSet rs = st.executeQuery(sent);
			ret = rs.getString("contrasenia");
			rs.close();
		} catch (SQLException e) {
			System.err.println(String.format("ERROR AL ENCONTRAR LOS DATOS DEL USUARIO", e.getMessage()));
			e.printStackTrace();
		}
		return ret;
	}
	
//	public static Usuario obtenerUsuario(Connection con, String DNI) {
//		String sent = "SELECT * FROM Usuario WHERE dni = '"+DNI+"'";
//		Statement stmt = null;
//		Usuario u = null;
//		try {
//			stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(sent);
//			if (rs.next()) {
//				String nombre = rs.getString("nombre");
//				String dni = rs.getString("dni");
//				String email = rs.getString("email");
//				String domicilio = rs.getString("domicilio");
//				String contrasenia = rs.getString("contrasenia");
//				int permisos = rs.getInt("permisos");
//				u = new Usuario(nombre, dni, email, domicilio, contrasenia, permisos);
//			}
//			rs.close();
//			
//			
//			
//		} catch (SQLException e) {
//			System.err.println(String.format("ERROR AL ENCONTRAR LOS DATOS DEL USUARIO", e.getMessage()));
//			e.printStackTrace();
//		}finally {
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}return u;	
//	}
	
	/**
	 * Método para modificar los datos de un usuario si el dni recibido y la contrasenia son los mismos que buscamos en la BBDD
	 * @param Connection con, el dni de un usuario y su contrasenia : recibimos la conexion con la base de datos, el dni del usuario y su contrasenia
	 * @return No devuelve nada
	 */
	public static void modificarConUsuario(Connection con, String DNI, String contr){
		String sent = "UPDATE Usuario SET contrasenia='"+contr+"' where dni = '"+DNI+"'";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.err.println(String.format("ERROR AL MODIFICAR LOS DATOS DEL USUARIO", e.getMessage()));
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate(sent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}

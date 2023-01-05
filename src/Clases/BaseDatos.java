package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	 * Método para crear la tabla Usuario en la BBDD 
	 * @param Connection con: recibimos la conexion con la base de datos
	 * @return Devuelve un boolean dependiendo si se ha realizado correctamente(true) o incorrectamente(false)
	 */
	public static boolean crearTablasUsuario(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Usuario (nombre String, dni String, email String, domicilio String, contrasenia String, permisos int)";
		try {
			Statement st = con.createStatement();
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
	 * Método para crear la tbala Producto en la BBDD 
	 * @param Connection con: recibimos la conexion con la base de datos
	 * @return Devuelve un boolean dependiendo si se ha realizado correctamente(true) o incorrectamente(false)
	 */
	public static boolean crearTablasProducto(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Producto (cod int, nombre String, tipo String, marca String, tamanyo String, precio double, stock int, ruta String)";
		try {
			Statement st = con.createStatement();
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
	 * Método para crear la tabla Carrito en la BBDD 
	 * @param Connection con: recibimos la conexion con la base de datos
	 * @return Devuelve un boolean dependiendo si se ha realizado correctamente(true) o incorrectamente(false)
	 */
	public static boolean crearTablasCarrito(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Carrito (dniUsu String, codProd int, nomProd String, tipoProd String, marcaProd String, tamanyoProd String, cantidad int, precioProd double)";
		try {
			Statement st = con.createStatement();
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
	public static void insertarProducto(Connection con,   int cod,  String nombre,  String tipo,  String marca,  String tamanyo,  double precio,  int stock, String ruta) {
		String sql = "INSERT INTO Producto VALUES('"+cod+"','"+nombre+"','"+tipo+"','"+marca+"','"+tamanyo+"',"+precio+",'"+stock+"','"+ruta+"')";
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
	public static void insertarCarrito(Connection con,   String dniUsu , int codProd, String nomProd, String tipoProd, String marcaProd, String tamanyoProd,int cantidad,double precioProd) {
		String sql = "INSERT INTO Carrito VALUES('"+dniUsu+"','"+codProd+"','"+nomProd+"','"+tipoProd+"','"+marcaProd+"','"+tamanyoProd+"','"+cantidad+"',"+precioProd+")";
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
	public static void eleminarCarrito(Connection con) {
		String sent = "DELETE FROM Carrito ";
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sent);

		} catch (SQLException e) {
			
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
	 * BUSCAR
	 * Método para buscar los datos de un usuario si el dni recibido es el mismo que buscamos en la BBDD
	 * @param Connection con, el dni de un usuario : recibimos la conexion con la base de datos y el dni del usuario
	 * @return Devuelve el usuario buscado
	 */
	public static boolean buscarUsuario(Connection con, String dni) {
		boolean encontrada = false;
		String sent = "SELECT nombre FROM Usuario WHERE dni = '"+dni+"'";
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
	
	/**
	 * Método para buscar los datos de un usuario si el dni recibido es el mismo que buscamos en la BBDD
	 * @param Connection con, el dni de un usuario : recibimos la conexion con la base de datos y el dni del usuario
	 * @return Devuelve el usuario buscado
	 */
	/*
	 *Obtener el usuario que estamos introduciendo los datos en la ventana 
	 */
	public static Usuario obtenerUsuario(Connection con, String dni) {
		String sent = "SELECT * FROM Usuario WHERE dni = '"+dni+"'";
		Statement stmt = null;
		Usuario u = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sent);
			if (rs.next()) {
				String nombre = rs.getString("nombre");
				String dnI = rs.getString("dni");
				String email = rs.getString("email");
				String domicilio = rs.getString("domicilio");
				String contrasenia = rs.getString("contrasenia");
				int permisos = rs.getInt("permisos");
				u = new Usuario(nombre, dnI, email, domicilio, contrasenia, permisos);
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println(String.format("ERROR AL ENCONTRAR LOS DATOS DEL USUARIO", e.getMessage()));
			e.printStackTrace();
		}return u;	
	}
	
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
	
	/**
	 * Método para buscar los datos de un tipo de Producto si el tipo recibido es el mismo que buscamos en la BBDD
	 * @param Connection con, el tipo de tipo String : recibimos la conexion con la base de datos y el tipo de tipo String
	 * @return Devuelve la lista de productos
	 */
	public static ArrayList<Producto> obtenerProductoTipo(Connection con, String ti){
		ArrayList<Producto> a = new ArrayList<>();
		String sent = "SELECT * FROM Producto WHERE tipo = '" + ti + "'";
		System.out.println(sent);
		Statement stmt = null;
		Producto p = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sent);
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String marca = rs.getString("marca");
				String tipo = rs.getString("tipo");
				double precio = rs.getDouble("precio");
				String tam = rs.getString("tamanyo");
				int stock = rs.getInt("stock");
				int cod = rs.getInt("cod");
				String ruta = rs.getString("ruta");
				p = new Producto(cod, nombre, tipo, marca, tam, precio, stock, ruta);
				a.add(p);
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println(String.format("ERROR AL ENCONTRAR LOS DATOS DEL USUARIO", e.getMessage()));
			e.printStackTrace();
		}
		return a;	
	}
	
	
	/**
	 * Método para buscar los datos de un  Producto si el nombre recibido es el mismo que buscamos en la BBDD
	 * @param Connection con, el nombre de tipo String : recibimos la conexion con la base de datos y el nombre de tipo String
	 * @return Devuelve la lista de productos
	 */
	public static ArrayList<Producto> obtenerProducto(Connection con, String nombre){
		ArrayList<Producto> a = new ArrayList<>();
		String sent = "SELECT * FROM Producto WHERE nombre = '" + nombre + "'";
		System.out.println(sent);
		Statement stmt = null;
		Producto p = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sent);
			while (rs.next()) {
				String nombres = rs.getString("nombre");
				String marca = rs.getString("marca");
				String tipo = rs.getString("tipo");
				double precio = rs.getDouble("precio");
				String tam = rs.getString("tamanyo");
				int stock = rs.getInt("stock");
				int cod = rs.getInt("cod");
				String ruta = rs.getString("ruta");
				p = new Producto(cod, nombres, tipo, marca, tam, precio, stock, ruta);
				a.add(p);
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println(String.format("ERROR AL ENCONTRAR LOS DATOS DEL PRODUCTO", e.getMessage()));
			e.printStackTrace();
		}
		return a;	
	}
	
	/**
	 * Método para restar el stock dadas por parametro al producto de productocuto cuyo nombre es el dado por parametro
	 * @param con, nom, unidades: coneixion con la BaseDatos, el nombre del producto y el unidades a restar
	 * @throws SQLException, Propaga la excepción
	 */
	public static void restarUnidadesAProducto(Connection con, String nom, int unidades)  {
		String sent = "UPDATE Producto SET stock = stock - "+unidades+ " where nombre = '"+nom+"'";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * METODO PARA OBTENER EL STOCK RESTANTE DE UN PRODUCTO DE LA tienda CUYO NOMBRE ES EL DADO POR P�RAMETRO
	 * @param con --> Conexi�n con la BD
	 * @param nom --> Nombre del producto
	 * @return --> El stock restante (Unidades restantes)
	 */
	public static int obtenerStockProducto(Connection con, String nom) {
		
		String sent = "SELECT * FROM Producto WHERE nombre = '"+nom+"'";
		Statement stmt = null;
		int stock = 0;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sent);
			if (rs.next()) {
				stock = rs.getInt("stock");
			}
			rs.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		}return stock;	
	}
	
	/**
	 * Método para buscar el precio de un producto cuyo nombre es el dado por parametro
	 * @param con, nom: Conexión con la BD y el nombre del producto
	 * @return double, el precio del producto
	 */
	public static double obtenerPrecioProducto(Connection con, String nom) {
		String sent = "SELECT * FROM Producto WHERE nombre = '"+nom+"'";
		Statement stmt = null;
		double precio = 0;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sent);
			if (rs.next()) {
				precio = rs.getDouble("precio");
			}
			rs.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		}return precio;	
	}
	
	
	public static ArrayList<Carrito> obtenerListaCarrito(Connection con, String Udni){
		ArrayList<Carrito> carrito = new ArrayList<>();
		
		try {
			Statement stm = con.createStatement();
			String sql = "SELECT * FROM Carrito WHERE dniUsu='"+Udni+"'";
			ResultSet rst = stm.executeQuery(sql);
			while (rst.next()) {
				String dni = rst.getString("dniUsu");
				int cod = Integer.parseInt(rst.getString("codProd"));
				String nom = rst.getString("nomProd");
				String tipo = rst.getString("tipoProd");
				String marca = rst.getString("marcaProd");
				String tam = rst.getString("tamanyoProd");
				int cant = Integer.parseInt(rst.getString("cantidad"));
				double prec = Double.parseDouble(rst.getString("precioProd"));
				Carrito c = new Carrito(dni, cod, nom, tipo, marca,tam, cant,prec);
				carrito.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carrito;
	}
	

	
	public static void eliminarFila(Connection con, String dni) {
		try {
			Statement stm = con.createStatement();
			String sent = "DELETE * FROM Carrito WHERE dniUsu = '"+ dni +"'";
			stm.executeUpdate(sent);
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * METODO PARA ELIMINAR DE LA TABLA pedido EL PRODUCTO EL CUAL TIENE EL CODIGO DADO POR PARAMETRO
	 * @param con --> Conexi�n con la BD
	 * @param codigo --> Codigo del producto a eliminar
	 */
	public static void eliminarFilaPorCodigoProd(Connection con, String tipo) {
		String sent = "DELETE FROM Carrito WHERE tipoProd ='"+tipo+"'";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate(sent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void obtenerAdmin(Connection con, String dniA) {
		String sent = "SELECT * FROM Usuario WHERE dni = '"+dniA+"'";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getRuta(Connection con, String tipo) {
		String sent = "SELECT ruta FROM Producto WHERE tipo = '"+tipo+"'";
		Statement stmt = null;
		String ruta="";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sent);
			if(rs.next()) {
				ruta = rs.getString("ruta");	
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ruta;
	}
	
	public static void modificarDato(Connection con, Producto p) {
		String sql = "UPDATE Dato SET cod='"+p.getCod()+"',nombre='"+p.getNombre()+"',tipo='"+p.getTipo()+"',marca='"+p.getMarca()+"',tamanyo='"+p.getTamanyo()+"',precio='"+p.getPrecio()+"',strock='"+p.getStock()+"'";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

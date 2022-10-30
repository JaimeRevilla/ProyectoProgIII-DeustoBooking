package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {



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
	
	
	public static void crearTablas(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Usuario (nombre String, dni String, email String, domicilio String, contrasenia String, permisos int)";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			sql = "CREATE TABLE IF NOT EXISTS Producto (cod int, nombre String, tipo String, marca String, tamanyo String, precio double, stock int)";
			st.executeUpdate(sql);
			sql = "CREATE TABLE IF NOT EXISTS Carrito (dniUsu String, codProd int, nomProd String, tipoProd String, marcaProd String, tamanyoProd String, precioProd double)";
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Metodo de insertar Usuario
	public static void insertarUsuario(Connection con,  String nombre,  String dni,  String email,  String domicilio,  String contrasenia,  int permisos) {
		String sql = "INSERT INTO Usuario VALUES('"+nombre+"','"+dni+"','"+email+"','"+domicilio+"','"+contrasenia+"','"+permisos+"')";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Metodo de insertar Producto
	public static void insertarProducto(Connection con,   int cod,  String nombre,  String tipo,  String marca,  String tamanyo,  double precio,  int stock) {
		String sql = "INSERT INTO Producto VALUES('"+cod+"','"+nombre+"','"+tipo+"','"+marca+"','"+tamanyo+"',"+precio+",'"+stock+"')";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Metodo de insertar Carrito
	public static void insertarCarrito(Connection con,   String dniUsu , int codProd, String nomProd, String tipoProd, String marcaProd, String tamanyoProd,double precioProd) {
		String sql = "INSERT INTO Carrito VALUES('"+dniUsu+"','"+codProd+"','"+nomProd+"','"+tipoProd+"','"+marcaProd+"','"+tamanyoProd+"',"+precioProd+")";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Metodo de borrar Usuario
	public static void eleminarUsuario(Connection con, String dni) {
		String sent = "DELETE FROM Usuario WHERE dni ='"+dni+"'";
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sent);

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
		}
	}
	
	//Metodo de borrar Producto
	public static void eleminarProducto(Connection con, int cod) {
		String sent = "DELETE FROM Producto WHERE cod ='"+cod+"'";
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sent);

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
		}
	}
	
	//Metodo de borrar Carrito
	public static void eleminarCarrito(Connection con, String dni) {
		String sent = "DELETE FROM Carrito WHERE dni ='"+dni+"'";
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sent);

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
		}
	}
	
	public static Usuario obtenerUsuario(Connection con, String DNI) {
		String sent = "SELECT * FROM Usuario WHERE dni = '"+DNI+"'";
		Statement stmt = null;
		Usuario u = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sent);
			if (rs.next()) {
				String nombre = rs.getString("nombre");
				String dni = rs.getString("dni");
				String email = rs.getString("email");
				String domicilio = rs.getString("domicilio");
				String contrasenia = rs.getString("contrasenia");
				int permisos = rs.getInt("permisos");
				u = new Usuario(nombre, dni, email, domicilio, contrasenia, permisos);
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
		}return u;	
	}
	
	public static void modificarConUsuario(Connection con, String DNI, String contr){
		String sent = "UPDATE Usuario SET contrasenia='"+contr+"' where dni = '"+DNI+"'";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
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
	}
	
	
	
	

}

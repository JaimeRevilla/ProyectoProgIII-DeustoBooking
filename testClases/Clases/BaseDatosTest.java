package Clases;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BaseDatosTest {
	private Connection con;

	@Before
	public void setUp() throws Exception {
		
		con = BaseDatos.initBD("DeustoIkea.db");
	}

	@After
	public void tearDown() throws Exception {
		con.close();
	}

	@Test
	public void testInitBD() {
		assertNotNull(con);
	}

	@Test
	public void testCrearTablasUsuario() {
		BaseDatos.crearTablasUsuario(con);
		assertNotNull(con);
	}

	@Test
	public void testCrearTablasProducto() {
		BaseDatos.crearTablasProducto(con);
		assertNotNull(con);
	}

	@Test
	public void testCrearTablasCarrito() {
		BaseDatos.crearTablasCarrito(con);
		assertNotNull(con);
	}

	@Test
	public void testInsertarUsuario() {
		assertThrows(AssertionError.class, ()->{assertThrows(SQLException.class, ()->{BaseDatos.insertarUsuario(con, "daniel","111A","dani@mail.com","caceres","111B",0);});});
	}

	@Test
	public void testInsertarProducto() {
		assertThrows(AssertionError.class, ()->{assertThrows(SQLException.class, ()->{BaseDatos.insertarProducto(con, 0, "dadsas", "asdsad", "adasd", "adsd", 3.3, 3, null);});});
	}

	@Test
	public void testInsertarCarrito() {
		assertThrows(AssertionError.class, ()->{assertThrows(SQLException.class, ()->{BaseDatos.insertarCarrito(con, "111A", 3, "asdsd", "asdasd", "asds", "adsasd", 3, 3.3);});});
	}



	@Test
	public void testBuscarUsuario() {
		boolean encontrada = BaseDatos.buscarUsuario(con, "111A");
		assertTrue(encontrada);	
	}

	@Test
	public void testObtenerContrasena() {
		String contr = BaseDatos.obtenerContrasena(con, "111A");
		assertEquals("111B", contr);
	}
	
	@Test
	public void testObtenerProductoTipo() {
		ArrayList<Producto> prod = BaseDatos.obtenerProductoTipo(con, "ELECTRICA");
		assertEquals(0, prod.size());
	}


//	@Test
//	public void testRestarUnidadesAProducto() {
//		Producto p = new Producto(0, "abcd", null, null, null, 0, 10, null);
//		BaseDatos.restarUnidadesAProducto(con, 2,"abcd");
//		assertEquals(8, p.getStock());
//	}
//
//	@Test
//	public void testObtenerStockProducto() {
//		int cant = BaseDatos.obtenerStockProducto(con, "Sofa");
//		assertEquals(200, cant);
//	}
//
//	@Test
//	public void testObtenerPrecioProducto() {
//		fail("Not yet implemented");
//	}


}

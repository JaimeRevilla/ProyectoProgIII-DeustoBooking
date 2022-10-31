package Clases;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BaseDatosTest {
	private Connection con;
	
	@Before
	public void setUp() throws Exception {
		con = BaseDatos.initBD("data/DeustoIkea.db");
	}

	@After
	public void tearDown() throws Exception {
		BaseDatos.closeBD(con);
	}

	@Test
	public void testInitBD() {
		assertNotNull(con);
	}
	
	@Test
	public void testCloseBD() {
	
	}
	
	@Test
	public void testCrearTablas() {
		boolean correcto = BaseDatos.crearTablas(con);
		assertTrue(correcto);
	}
	
	@Test
	public void testObtenerUsuario() {
		boolean encontrada = BaseDatos.obtenerUsuario(con, "111A");
		assertTrue(encontrada);
	}
	
	@Test
	public void testInsertarUsuario() {
		
		

	}
}

package Clases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	private Usuario usuario;
	private String nombre = "nombre";
	private String dni = "dni";
	private String email = "email";
	private String domicilio = "domicilio";
	private String contrasenia = "contrasenia";
	private boolean permisos = false;
	
	private String newNombre = "newNombre";
	private String newDni = "newDni";
	private String newEmail = "newEmail";
	private String newDomicilio = "newDomicilio";
	private String newContrasenia = "newContrasenia";
	private boolean newPermisos = true;
	
	@Before
	public void setUp() throws Exception {
		usuario = new Usuario(nombre, dni, email, domicilio, contrasenia, permisos);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUsuario() {
		
		assertNotNull(usuario);
		assertEquals(nombre, usuario.getNombre());
		assertEquals(dni, usuario.getDni());
		assertEquals(email, usuario.getEmail());
		assertEquals(domicilio, usuario.getDomicilio());
		assertEquals(contrasenia, usuario.getContrasenia());
		assertEquals(permisos, usuario.isPermisos());
	}
	
	/*TESTS DE GETS*/
	@Test
	public void testGetNombre() {
		
		assertEquals(nombre, usuario.getNombre());
	}
	
	@Test
	public void testGetDni() {
		
		assertEquals(dni, usuario.getDni());
	}
	
	@Test
	public void testGetEmail() {
		
		assertEquals(email, usuario.getEmail());
	}
	
	@Test
	public void testGetDomicilio() {
		
		assertEquals(domicilio, usuario.getDomicilio());
	}
	
	@Test
	public void testGetContrasenia() {
		
		assertEquals(contrasenia, usuario.getContrasenia());
	}
	
	@Test
	public void testGetPermisos() {
		
		assertEquals(permisos, usuario.isPermisos());
	}
	
	
	/*TESTS DE SETS*/
	@Test
	public void testSetNombre() {
		
		usuario.setNombre(newNombre);
		assertEquals(newNombre, usuario.getNombre());
	}
	
	@Test
	public void testSetDni() {
		
		usuario.setDni(newDni);
		assertEquals(newDni, usuario.getDni());
	}
	
	@Test
	public void testSetEmail() {
		
		usuario.setEmail(newEmail);
		assertEquals(newEmail, usuario.getEmail());
	}
	
	@Test
	public void testSetDomicilio() {
		
		usuario.setDomicilio(newDomicilio);
		assertEquals(newDomicilio, usuario.getDomicilio());
	}
	
	@Test
	public void testSetContrasenia() {
		
		usuario.setContrasenia(newContrasenia);
		assertEquals(newContrasenia, usuario.getContrasenia());
	}
	
	
	@Test
	public void testSetPermisos() {
		
		usuario.setPermisos(newPermisos);
		assertEquals(newPermisos, usuario.isPermisos());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

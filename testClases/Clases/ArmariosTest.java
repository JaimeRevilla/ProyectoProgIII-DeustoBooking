package Clases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArmariosTest {
	private Armarios armarios;
	private int numEstanterias = 0;
	
	private int nuevonumEstanterias = 1;
	
	@Before
	public void setUp() throws Exception {
		armarios = new Armarios(0, null, null, null, null, 0.0, 0, TipoArmario.ROBLE, numEstanterias);
	}

	@After
	public void tearDown() throws Exception {
	}
	


	@Test
	public void testArmario() {
		assertNotNull(armarios);
		assertEquals(numEstanterias, armarios.getNumEstanterias());
		
	}
	
	//get
	@Test
	public void getNumEstanterias() {
		assertEquals(numEstanterias, armarios.getNumEstanterias());
	}
	
	//set
	@Test
	public void setNumEstanterias() {
		armarios.setNumEstanterias(nuevonumEstanterias);
		assertEquals(nuevonumEstanterias, armarios.getNumEstanterias());
	}

}

package Clases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProductoTest {
	private Producto producto;
	private int codigo = 0;
	private String nombre = "nombre";
	private String tipo = "tipo";
	private String marca = "marca";
	private String tamanyo = "tamanyo";
	private double precio = 0;
	private int stock =0;

	
	private int nuevocodigo = 1;
	private String nuevonombre = "nuevonombre";
	private String nuevotipo = "nuevotipo";
	private String nuevomarca = "nuevomarca";
	private String nuevotamanyo = "nuevotamanyo";
	private double nuevoprecio = 1;
	private int nuevostock =1;

	@Before
	public void setUp() throws Exception {
		producto = new Producto(codigo, nombre, tipo, marca, tamanyo, precio, stock, null);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testProducto() {
		assertNotNull(producto);
		assertEquals(codigo, producto.getCod());
		assertEquals(nombre, producto.getNombre());
		assertEquals(tipo, producto.getTipo());
		assertEquals(marca, producto.getMarca());
		assertEquals(tamanyo, producto.getTamanyo());
		assertEquals(precio, producto.getPrecio(),0);
		assertEquals(stock, producto.getStock());
	}
	
	
	
	//gets
	@Test
	public void getCodigo() {
		assertEquals(codigo, producto.getCod());
	}
	
	@Test
	public void getNombre() {
		assertEquals(nombre, producto.getNombre());
	}
	
	
	@Test
	public void getTipo() {
		assertEquals(tipo, producto.getTipo());
	}
	
	@Test
	public void getMarca() {
		assertEquals(marca, producto.getMarca());
	}	
	
	@Test
	public void getTamanyo() {
		assertEquals(tamanyo, producto.getTamanyo());
	}
	
	@Test
	public void getPrecio() {
		assertEquals(precio, producto.getPrecio(), 0.0);
	}

	@Test
	public void getStock() {
		assertEquals(stock, producto.getStock());
	}

	
	
	
	//sets
	
	@Test
	public void setCodigo() {
		producto.setCod(nuevocodigo);
		assertEquals(nuevocodigo, producto.getCod());
	}
	
	@Test
	public void setNombre() {
		producto.setNombre(nuevonombre);
		assertEquals(nuevonombre, producto.getNombre());	
	}
	
	@Test
	public void setTipo() {
		producto.setTipo(nuevotipo);
		assertEquals(nuevotipo, producto.getTipo());
	}
	
	@Test
	public void setMarca() {
		producto.setMarca(nuevomarca);
		assertEquals(nuevomarca, producto.getMarca());	
	}
	
	@Test
	public void setTamanyo() {		
		producto.setTamanyo(nuevotamanyo);
		assertEquals(nuevotamanyo, producto.getTamanyo());	
	}	
	@Test
	public void setPrecio() {
		producto.setPrecio(nuevoprecio);
		assertEquals(nuevoprecio, producto.getPrecio(),0.0);	
	}
	
	@Test
	public void setStock() {
		producto.setStock(nuevostock);
		assertEquals(nuevostock, producto.getStock());	
	}
	

}

package Clases;

public class Producto {
	/**
	 * Atributos de la clase Producto
	 */
	private int cod;
	private String nombre;
	private String tipo;
	private String marca;
	private String tamanyo;
	private double precio;
	private int stock;
	private String ruta;
	
	/**
	 * Constructor con atributos de la clase Producto
	 * @param cod
	 * @param nombre
	 * @param tipo
	 * @param marca
	 * @param tamanyo
	 * @param precio
	 * @param stock
	 * @param ruta
	 */
	public Producto(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock, String ruta) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.tipo = tipo;
		this.marca = marca;
		this.tamanyo = tamanyo;
		this.precio = precio;
		this.stock = stock;
		this.ruta = ruta;
	}
	
	/**
	 * Método get del atributo ruta, el atributo ruta es un String
	 * @return devuelve la ruta del producto
	 */
	public String getRuta() {
		return ruta;
	}

	/**
	 * Método set del atributo ruta, el atributo ruta es un String
	 * @param ruta
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	/**
	 * Método get del atributo cod, el atributo cod es un int
	 * @return devuelve un codigo 
	 */
	public int getCod() {
		return cod;
	}
	
	/**
	 * Método set del atributo cod, el atributo cod es un int
	 * @param cod
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	/**
	 * Método get del atibuto nombre, el atributo nombre es un String
	 * @return devuelve un nombre 
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Método set del atributo nombre, el atributo nombre es un String
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Método get del atributo tipo, el atributi tipo es un String
	 * @return devuelve el tipo del producto
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Método set del atributo tipo, el atributo tipo es un String
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Método get del atributo marca, el atributo marca es un String
	 * @return devuele la marca de un producto
	 */
	public String getMarca() {
		return marca;
	}
	
	/**
	 * Método set del atributo marca, el atributo marca es un String 
	 * @param marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	/**
	 * Método get del atributo tamanyo, el atributo tamanyo es un String
	 * @return devuelve el tamanyo de un producto
	 */
	public String getTamanyo() {
		return tamanyo;
	}
	
	/**
	 * Método set del atributo tamanyo, el atributo tamanyo es un String
	 * @param tamanyo
	 */
	public void setTamanyo(String tamanyo) {
		this.tamanyo = tamanyo;
	}
	
	/**
	 * Método get del atributo precio, el atributo precio es un double
	 * @return devuelve un precio de un producto
	 */
	public double getPrecio() {
		return precio;
	}
	
	/**
	 * Método set del atrinbuto precio, el atributo precio es un double
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	/**
	 * Método get del atributi stock, el atributo stock es un int
	 * @return devuelve un stock de un producto
	 */
	public int getStock() {
		return stock;
	}
	
	/**
	 * Método set del atributo stock, el atributo stock es un int
	 * @param stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Método toString de como vamos a ver la informacion del producto
	 */
	@Override
	public String toString() {
		return "Producto: Codigo=" + cod +"\n, Nombre=" + nombre + ", Tipo=" + tipo + ", Marca=" + marca + ",Tamaño="
				+ tamanyo + ", precio=" + precio + ", stock=" + stock + "";
	}

	
	
	
	

}

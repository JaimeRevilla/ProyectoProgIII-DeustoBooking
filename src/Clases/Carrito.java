package Clases;

public class Carrito {
	/**
	 * Atributos de la clase Carrito
	 */
	private String dni; 
	private int cod;
	private String nom;
	private String tipo;
	private String marca;
	private String tamanyo;
	private int cantidad;
	private double precio;
	
	/**
	 * Constructor con atributos de la clase Carrito
	 * @param dni
	 * @param cod
	 * @param nom
	 * @param tipo
	 * @param marca
	 * @param tamanyo
	 * @param cantidad
	 * @param precio
	 */
	public Carrito(String dni, int cod, String nom, String tipo,String marca, String tamanyo, int cantidad,double precio) {
		super();
		this.dni = dni;
		this.cod = cod;
		this.nom = nom;
		this.tipo = tipo;
		this.marca = marca;
		this.tamanyo = tamanyo;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	/**
	 * Método get del atributo marca, el atributo marca es un String
	 * @return devuelve la marca
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
	 * Método get del atributo dni, el atributo dni es un String
	 * @return devuelve el dni
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * Método set del atributo dni, el atributo dni es un String
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * Método get del atributo cod, el atributo cod es un int
	 * @return devuelve el cod
	 */
	public int getCod() {
		return cod;
	}
	
	/**
	 *  Método set del atributo cod, el atributo cod es un int
	 * @param cod
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	/**
	 * Método get del atributo nom, el atributo nom es un String
	 * @return devuelve el nombre del producto
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Método set del atributo nom, el atributo nom es un String
	 * @param nom devuelve el nombre del producto
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 *  Método get del atributo tipo, el atributo tipo es un String
	 * @return devuelve el tipo de producto
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
	 * @return devuelve el precio del producto
	 */
	public double getPrecio() {
		return precio;
	}
	
	/**
	 * Método set del atributo precio, el atributo precio es un double
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	/**
	 * Método get del atributo cantidad, el atributo cantidad es un int
	 * @return cantidad devuelvo la cantidad de un producto
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Método set del atributo cantidad, el atributo cantidad es un String
	 * @param cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Metodo de toString, nos ayudara a saber como queremos devolvolver la informacion de la clase
	 */
	@Override
	public String toString() {
		return "Carrito [dni=" + dni + ", cod=" + cod + ", nom=" + nom + ", tipo=" + tipo + ", marca=" + marca
				+ ", tamanyo=" + tamanyo + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}

	
	
	
	
	
}

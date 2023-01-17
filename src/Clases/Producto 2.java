package Clases;

public class Producto {
	private int cod;
	private String nombre;
	private String tipo;
	private String marca;
	private String tamanyo;
	private double precio;
	private int stock;
	private String ruta;
	
		
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
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public int getCod() {
		return cod;
	}
	
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTamanyo() {
		return tamanyo;
	}
	public void setTamanyo(String tamanyo) {
		this.tamanyo = tamanyo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto: Codigo=" + cod +"\n, Nombre=" + nombre + "\n, Tipo=" + tipo + ",\n Marca=" + marca + ",Tamaño="
				+ tamanyo + ",\n precio=" + precio + ", stock=" + stock + "";
	}

	
	
	
	

}

package Clases;

public class Carrito {
	private String dni; 
	private int cod;
	private String nom;
	private String tipo;
	private String marca;
	private String tamanyo;
	private int cantidad;
	private double precio;
	
	
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Carrito [dni=" + dni + ", cod=" + cod + ", nom=" + nom + ", tipo=" + tipo + ", marca=" + marca
				+ ", tamanyo=" + tamanyo + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}

	
	
	
	
	
}

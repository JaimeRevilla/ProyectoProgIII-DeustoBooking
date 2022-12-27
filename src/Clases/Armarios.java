package Clases;

public class Armarios extends Producto {
	
	private TipoArmario tipoArmario;
	private int numEstanterias;
	
	public Armarios(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock, String ruta,
			TipoArmario tipoArmario, int numEstanterias) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock, ruta);
		this.numEstanterias = numEstanterias;
		this.tipoArmario = tipoArmario;
	}

	public TipoArmario getTipoArmario() {
		return tipoArmario;
	}

	public void setTipoArmario(TipoArmario tipoArmario) {
		this.tipoArmario = tipoArmario;
	}

	public int getNumEstanterias() {
		return numEstanterias;
	}

	public void setNumEstanterias(int numEstanterias) {
		this.numEstanterias = numEstanterias;
	}

	//Falta to String
	
	
	
	
	
	

}

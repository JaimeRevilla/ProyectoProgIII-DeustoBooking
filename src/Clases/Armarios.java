package Clases;

public class Armarios extends Producto {
	
	private TipoArmario tipoArmario;
	private int numEstanterias;
	
	public Armarios(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock,
			TipoArmario tipoArmario, int numEstanterias) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock);
		this.numEstanterias = numEstanterias;
		if (tipo.contains("ROBLE")) {
			this.tipoArmario = TipoArmario.ROBLE;
		} else if (tipo.contains("ABEDUL")) {
			this.tipoArmario = TipoArmario.ABEDUL;
		} else if (tipo.contains("PINO")) {
			this.tipoArmario = TipoArmario.PINO;
		} else if (tipo.contains("EUCALIPTO")) {
			this.tipoArmario = TipoArmario.EUCALIPTO;
		} else if (tipo.contains("HAYA")) {
			this.tipoArmario = TipoArmario.HAYA;
		}
			
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

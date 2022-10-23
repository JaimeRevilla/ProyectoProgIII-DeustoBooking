package Clases;

public class Sillas extends Producto{
	private TipoSillas tipoSillas;

	public Sillas(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock,
			TipoSillas tipoSillas) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock);
		if(tipo.contains("OFICINA")) {
			this.tipoSillas=TipoSillas.OFICINA;
		}
		else if(tipo.contains("REINA")) {
			this.tipoSillas=TipoSillas.REINA;
		}
		else if(tipo.contains("PLEGABLE")) {
			this.tipoSillas=TipoSillas.PLEGABLE;
		}
		else if(tipo.contains("GAMER")) {
			this.tipoSillas=TipoSillas.GAMER;
		}
		else if(tipo.contains("COCINA")) {
			this.tipoSillas=TipoSillas.COCINA;
		}
	}

	public TipoSillas getTipoSillas() {
		return tipoSillas;
	}

	public void setTipoSillas(TipoSillas tipoSillas) {
		this.tipoSillas = tipoSillas;
	}
	
	//Falta toString

}

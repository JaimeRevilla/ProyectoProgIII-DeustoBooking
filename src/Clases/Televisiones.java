package Clases;

public class Televisiones extends Producto{
	private TipoTV tipoTV;

	public Televisiones(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock,
			TipoTV tipoTV) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock);
		
		if(tipo.contains("CURVA")) {
			this.tipoTV=TipoTV.CURVA;
		}
		else if(tipo.contains("PLANA")) {
			this.tipoTV=TipoTV.PLANA;
		}
	}

	public TipoTV getTipoTV() {
		return tipoTV;
	}

	public void setTipoTV(TipoTV tipoTV) {
		this.tipoTV = tipoTV;
	}
	
	//Falta toString
	
}

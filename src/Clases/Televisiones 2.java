package Clases;

public class Televisiones extends Producto{
	private TipoTV tipoTV;

	public Televisiones(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock, String ruta,
			TipoTV tipoTV) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock ,ruta);
		this.tipoTV = tipoTV;
	}

	public TipoTV getTipoTV() {
		return tipoTV;
	}

	public void setTipoTV(TipoTV tipoTV) {
		this.tipoTV = tipoTV;
	}
	
	//Falta toString
	
}

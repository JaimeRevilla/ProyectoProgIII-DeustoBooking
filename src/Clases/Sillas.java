package Clases;

public class Sillas extends Producto{
	private TipoSillas tipoSillas;

	public Sillas(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock,
			TipoSillas tipoSillas) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock);
		this.tipoSillas = tipoSillas;
	}

	public TipoSillas getTipoSillas() {
		return tipoSillas;
	}

	public void setTipoSillas(TipoSillas tipoSillas) {
		this.tipoSillas = tipoSillas;
	}
	
	//Falta toString

}

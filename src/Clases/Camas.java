package Clases;

public class Camas extends Producto{
	private TipoCamas tipoCamas;

	public Camas(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock,
			TipoCamas tipoCamas) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock);
		this.tipoCamas = tipoCamas;
	}

	public TipoCamas getTipoCamas() {
		return tipoCamas;
	}

	public void setTipoCamas(TipoCamas tipoCamas) {
		this.tipoCamas = tipoCamas;
	}

	//Falta toString
}

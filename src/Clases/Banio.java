package Clases;

public class Banio extends Producto{
	private TipoBanio tipoBanio;

	public Banio(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock,
			TipoBanio tipoBanio) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock);
		this.tipoBanio = tipoBanio;
	}

	public TipoBanio getTipoBanio() {
		return tipoBanio;
	}

	public void setTipoBanio(TipoBanio tipoBanio) {
		this.tipoBanio = tipoBanio;
	}
	
	//Falta toString
	
}

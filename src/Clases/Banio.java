package Clases;

public class Banio extends Producto{
	private TipoBanio tipoBanio;

	public Banio(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock,
			TipoBanio tipoBanio) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock);
		if(tipo.contains("DUCHA")){
			this.tipoBanio=TipoBanio.DUCHA;
		}
		else if(tipo.contains("BANIERA")){
			this.tipoBanio=TipoBanio.BANIERA;
		}
		else if(tipo.contains("JACUZZI")){
			this.tipoBanio=TipoBanio.JACUZZI;
		}
	}

	public TipoBanio getTipoBanio() {
		return tipoBanio;
	}

	public void setTipoBanio(TipoBanio tipoBanio) {
		this.tipoBanio = tipoBanio;
	}
	
	//Falta toString
	
}

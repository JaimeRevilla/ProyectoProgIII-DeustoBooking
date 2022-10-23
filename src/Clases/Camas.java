package Clases;

public class Camas extends Producto{
	private TipoCamas tipoCamas;

	public Camas(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock,
			TipoCamas tipoCamas) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock);
		if(tipo.contains("LITERA")) {
			this.tipoCamas=TipoCamas.LITERA;
		}
		else if(tipo.contains("SOFACAMA")) {
			this.tipoCamas=TipoCamas.SOFACAMA;
		}
		else if(tipo.contains("ACUATICA")) {
			this.tipoCamas=TipoCamas.ACUATICA;
		}
		else if(tipo.contains("ELECTRICA")) {
			this.tipoCamas=TipoCamas.ELECTRICA;
		}
	}

	public TipoCamas getTipoCamas() {
		return tipoCamas;
	}

	public void setTipoCamas(TipoCamas tipoCamas) {
		this.tipoCamas = tipoCamas;
	}

	//Falta toString
}

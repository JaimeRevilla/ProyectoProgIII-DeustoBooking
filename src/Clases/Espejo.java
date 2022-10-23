package Clases;

public class Espejo extends Producto{
	private TipoEspejo tipoEspejo;
	private boolean marco;
	
	public Espejo(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock,
			TipoEspejo tipoEspejo, boolean marco) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock);
		this.marco = marco;
		if(tipo.contains("RECTANGULAR")) {
			this.tipoEspejo=TipoEspejo.RECTAGUNLAR;
		}
		else if(tipo.contains("CUADRADO")) {
			this.tipoEspejo=TipoEspejo.CUADRADO;
		}
		else if(tipo.contains("CIRCULAR")) {
			this.tipoEspejo=TipoEspejo.CIRCULAR;
		}
		else if(tipo.contains("OVALADO")) {
			this.tipoEspejo=TipoEspejo.OVALADO;
		}
	}

	public TipoEspejo getTipoEspejo() {
		return tipoEspejo;
	}

	public void setTipoEspejo(TipoEspejo tipoEspejo) {
		this.tipoEspejo = tipoEspejo;
	}

	public boolean isMarco() {
		return marco;
	}

	public void setMarco(boolean marco) {
		this.marco = marco;
	}
	
	//Falta toString
	

}

package Clases;

public class Espejo extends Producto{
	private TipoEspejo tipoEspejo;
	private boolean marco;
	
	public Espejo(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock, String ruta,
			TipoEspejo tipoEspejo, boolean marco) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock, ruta);
		this.marco = false;
		this.tipoEspejo = tipoEspejo;
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

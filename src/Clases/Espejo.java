package Clases;

public class Espejo extends Producto{
	/**
	 * Atributos de la clase Espejo
	 */
	private TipoEspejo tipoEspejo;
	private boolean marco;
	
	/**
	 * Constructor con parametros de la clase Espejo
	 * @param cod
	 * @param nombre
	 * @param tipo
	 * @param marca
	 * @param tamanyo
	 * @param precio
	 * @param stock
	 * @param ruta
	 * @param tipoEspejo
	 * @param marco
	 */
	public Espejo(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock, String ruta,
			TipoEspejo tipoEspejo, boolean marco) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock, ruta);
		this.marco = false;
		this.tipoEspejo = tipoEspejo;
	}

	/**
	 * Método get del atributo tipoEspejo, el atributo tipoEspejo es un enum
	 * @return devuelve el tipoEspejo  
	 */
	public TipoEspejo getTipoEspejo() {
		return tipoEspejo;
	}

	/**
	 * Método set del atributo tipoEspejo, el atributo tipoEspejo es un enum
	 * @param tipoEspejo
	 */
	public void setTipoEspejo(TipoEspejo tipoEspejo) {
		this.tipoEspejo = tipoEspejo;
	}

	/**
	 * Método is del atributo marco, el atributo marco es un boolean
	 * @return devuelve un marco de tipo boolean
	 */
	public boolean isMarco() {
		return marco;
	}

	/**
	 * Método set del atributo marco, el atributo marco es boolen
	 * @param marco
	 */
	public void setMarco(boolean marco) {
		this.marco = marco;
	}
	
}

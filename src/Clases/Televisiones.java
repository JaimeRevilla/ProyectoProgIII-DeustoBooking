package Clases;

public class Televisiones extends Producto{
	/**
	 * Atributos de la clase Televisiones
	 */
	private TipoTV tipoTV;

	/**
	 * Constructor con atributos de la clase televisiones
	 * @param cod
	 * @param nombre
	 * @param tipo
	 * @param marca
	 * @param tamanyo
	 * @param precio
	 * @param stock
	 * @param ruta
	 * @param tipoTV
	 */
	public Televisiones(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock, String ruta,
			TipoTV tipoTV) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock ,ruta);
		this.tipoTV = tipoTV;
	}

	/**
	 * Método get del atributo tipo, el atributo tipo es un enum
	 * @return
	 */
	public TipoTV getTipoTV() {
		return tipoTV;
	}
	
	/**
	 * Método set del atributo tipo, el atributo tipo es un enum
	 * @param tipoTV
	 */
	public void setTipoTV(TipoTV tipoTV) {
		this.tipoTV = tipoTV;
	}
	
}

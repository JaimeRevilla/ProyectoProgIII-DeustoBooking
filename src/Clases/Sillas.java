package Clases;

public class Sillas extends Producto{
	/**
	 * Atributos de la clase Sillas
	 */
	private TipoSillas tipoSillas;

	/**
	 * Constructor de parametros de la clase Sillas
	 * @param cod
	 * @param nombre
	 * @param tipo
	 * @param marca
	 * @param tamanyo
	 * @param precio
	 * @param stock
	 * @param ruta
	 * @param tipoSillas
	 */
	public Sillas(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock, String ruta,
			TipoSillas tipoSillas) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock, ruta);
		this.tipoSillas = tipoSillas;
	}

	/**
	 * Método get del atributo tipoSilla, el atributo tipoSilla es enum
	 * @return devuelve un tipoSillas
	 */
	public TipoSillas getTipoSillas() {
		return tipoSillas;
	}
	
	/**
	 * Método set del atributo tipoSilla, el atributo tipoSilla es enum
	 * @param tipoSillas
	 */
	public void setTipoSillas(TipoSillas tipoSillas) {
		this.tipoSillas = tipoSillas;
	}
	
}

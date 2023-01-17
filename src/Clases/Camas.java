package Clases;

public class Camas extends Producto{
	/**
	 * Atributos de la clase Camas
	 */
	private TipoCamas tipoCamas;

	/**
	 * Constructor con parametros de la clase camas
	 * @param cod
	 * @param nombre
	 * @param tipo
	 * @param marca
	 * @param tamanyo
	 * @param precio
	 * @param stock
	 * @param ruta
	 * @param tipoCamas
	 */
	public Camas(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock, String ruta,
			TipoCamas tipoCamas) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock, ruta);
		this.tipoCamas = tipoCamas;
	}

	/**
	 * Método get del atributo tipoCamas, el atributo tipoCamas es un Enum
	 * @return devuelve el tipo del producto
	 */
	public TipoCamas getTipoCamas() {
		return tipoCamas;
	}
	/**
	 * Método set del atributio tipoCamas, el atributo tipoCamas es un Enum
	 * @param tipoCamas
	 */
	public void setTipoCamas(TipoCamas tipoCamas) {
		this.tipoCamas = tipoCamas;
	}
}

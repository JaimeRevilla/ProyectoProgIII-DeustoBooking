package Clases;

import java.util.regex.Pattern;

public class Usuario {
	/**
	 * Atributos de la clase Usuario
	 */
	private String nombre;
	private String dni;
	private String email;
	private String domicilio;
	private String contrasenia;
	private int permisos;
	
	/**
	 * Constructor por defecto de la clase Usuario
	 */
	public Usuario() {
		
	}
	
	/**
	 * Constructor con parametros de la clase Usuario
	 * @param nombre
	 * @param dni
	 * @param email
	 * @param domicilio
	 * @param contrasenia
	 * @param permisos
	 */
	public Usuario(String nombre, String dni, String email, String domicilio, String contrasenia, int permisos) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.email = email; //FALTA :metodo para autorellenar el email 
		this.domicilio = domicilio;
		this.contrasenia = contrasenia;
		this.permisos = permisos;
	}
	
	
	/***
	 * Método get del atributo nombre, el atributo nombre es un String
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Método set del atributo nombre, el atributo nombre es un String
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Método get del atributo dni, el atributo dni es un String
	 * @return devuelve el dni
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * Método set del atributo dni, el atributo dni es un String
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * Método get del atributo email, el atributo email es un String
	 * @return devuelve el email del usuario
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Método set del atributo email, el atributo email es un String
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Método get del atributo domicilio, el atributo domicilio es un String
	 * @return devuelve el domicilio del usuario
	 */
	public String getDomicilio() {
		return domicilio;
	}
	
	/**
	 * Método set del atributo domicilio, el atributo domicilio es un String
	 * @param domicilio
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	/**
	 * Método get del atributo contrasenia, el atributo contrasenia es un String
	 * @return devuelve la contrasenia de un usuario
	 */
	public String getContrasenia() {
		return contrasenia;
	}
	
	/**
	 * Método set del atributo contrasenia, el atributo contrasenia es un String
	 * @param contrasenia
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	/**
	 * Método get del atributo permisos, el atributo permisos es un boolean
	 * @return devuelve los permisos que tiene un usuario
	 */
	public int isPermisos() {
		return permisos;
	}
	
	/**
	 * Método set del atributo permisos, el atributo permisos es un boolean
	 * @param permisos
	 */
	public void setPermisos(int permisos) {
		this.permisos = permisos;
	}
	
}

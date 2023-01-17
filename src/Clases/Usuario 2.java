package Clases;

import java.util.regex.Pattern;

public class Usuario {
	private String nombre;
	private String dni;
	private String email;
	private String domicilio;
	private String contrasenia;
	private int permisos;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String dni, String email, String domicilio, String contrasenia, int permisos) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.email = email; //FALTA :metodo para autorellenar el email 
		this.domicilio = domicilio;
		this.contrasenia = contrasenia;
		this.permisos = permisos;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public int isPermisos() {
		return permisos;
	}
	public void setPermisos(int permisos) {
		this.permisos = permisos;
	}
	
	
	//FALTA toString
	
}

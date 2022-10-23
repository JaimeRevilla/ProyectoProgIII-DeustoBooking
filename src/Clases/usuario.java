package Clases;

public class usuario {
	private String nombre;
	private String dni;
	private String email;
	private String domicilio;
	private String contrasenia;
	private boolean permisos;
	
	
	public usuario(String nombre, String dni, String email, String domicilio, String contrasenia, boolean permisos) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.email = email; //FALTA :metodo para autorellenar el email insertado
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
	public boolean isPermisos() {
		return permisos;
	}
	public void setPermisos(boolean permisos) {
		this.permisos = permisos;
	}
	
	
	//FALTA toString
	
}

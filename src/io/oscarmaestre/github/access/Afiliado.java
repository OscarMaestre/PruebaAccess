package io.oscarmaestre.github.access;

import java.sql.Date;

public class Afiliado {
	private final String 	nombre;
	private final String 	apellidos;
	private final Date		fechaNacimiento;
	private final String	email;
	public Afiliado(String nombre, String apellidos, Date fechaNacimiento, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public String getEmail() {
		return email;
	}
	
}

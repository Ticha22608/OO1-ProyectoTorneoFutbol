package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {
	private int idPersona;
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fechaNacimiento;

    public Persona(int idPersona, String nombre, String apellido, int dni, LocalDate fechaNacimiento) {
    	this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public int getIdPersona() {
		return idPersona;
	}

	private void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(fechaNacimiento, other.fechaNacimiento);
	}
    
    
}

package modelo;

import java.time.LocalDate;

public class Jugador extends Persona {
    private double estatura;
    private double peso;
    private String posicion;
    private int numCamiseta;

    public Jugador(int idPersona, String nombre, String apellido, int dni, LocalDate fechaNacimiento
    		, double estatura, double peso, String posicion, int numCamiseta) {
    	super(idPersona, nombre, apellido, dni, fechaNacimiento);
    	this.estatura = estatura;
        this.peso = peso;
        this.posicion = posicion;
        this.numCamiseta = numCamiseta;
    }
   
	public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getNumCamiseta() {
        return numCamiseta;
    }

    public void setNumCamiseta(int numCamiseta) {
        this.numCamiseta = numCamiseta;
    }
    
    
}

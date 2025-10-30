package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Jugador extends Persona {
    private double estatura;
    private double peso;
    private String posicion;
    private int numCamiseta;
    private boolean estado;

    public Jugador(int idPersona, String nombre, String apellido, long dni, LocalDate fechaNacimiento
    		, double estatura, double peso, String posicion, int numCamiseta) {
    	super(idPersona, nombre, apellido, dni, fechaNacimiento);
    	this.estatura = estatura;
        this.peso = peso;
        this.posicion = posicion;
        this.numCamiseta = numCamiseta;
        this.estado=true;
    }

    @Override
    public String toString() {
        String estadoJugador = this.estado ? "Activo" : "Inactivo";
         return "Jugador{" +
                "estatura=" + estatura +
                ", peso=" + peso +
                ", posicion='" + posicion + '\'' +
                ", numCamiseta=" + numCamiseta +
                 ", estado= " + estadoJugador + ", "
                 + super.toString() +
                "}\n";
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Jugador jugador = (Jugador) o;
        return Double.compare(estatura, jugador.estatura) == 0 && Double.compare(peso, jugador.peso) == 0 && numCamiseta == jugador.numCamiseta && estado == jugador.estado && Objects.equals(posicion, jugador.posicion);
    }

}

package modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private String idEquipo;
    private List<Jugador> jugadores;
    private Entrenador entrenador;

    public Equipo(String nombre, String idEquipo, List<Jugador> jugadores, Entrenador entrenador) {
        this.nombre = nombre;
        this.idEquipo = idEquipo;
        this.jugadores = new ArrayList<>();
        this.entrenador = entrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}

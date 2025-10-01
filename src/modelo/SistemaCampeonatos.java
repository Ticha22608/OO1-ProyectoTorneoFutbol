package modelo;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaCampeonatos {
    private List<Torneo> torneos;
    private List<Equipo> equipos;
    private List<Jugador> jugadores;
    private List<Entrenador> entrenadores;

    public SistemaCampeonatos() {
        this.torneos = new ArrayList<Torneo>();
        this.equipos = new ArrayList<Equipo>();
        this.jugadores = new ArrayList<Jugador>();
        this.entrenadores = new ArrayList<Entrenador>();
    }

    public List<Torneo> getTorneos() {
        return torneos;
    }

    public void setTorneos(List<Torneo> torneos) {
        this.torneos = torneos;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }
    
}

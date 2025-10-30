package modelo;

import java.util.Objects;

public class Goleador {
    private Jugador jugador;
    private int goles;

    public Goleador(Jugador jugador, int goles) {
        this.jugador = jugador;
        this.goles = goles;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    @Override
    public String toString() {
        return "Goleador{" +
                "jugador=" + jugador.getNombre() +
                ", goles=" + goles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Goleador goleador = (Goleador) o;
        return getGoles() == goleador.getGoles() && Objects.equals(getJugador(), goleador.getJugador());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJugador(), getGoles());
    }
}

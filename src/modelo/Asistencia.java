package modelo;

import java.util.Objects;

public class Asistencia {
    private Jugador jugador;
    private int asistencias;

    public Asistencia(Jugador jugador, int asistencias) {
        this.jugador = jugador;
        this.asistencias = asistencias;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "jugador=" + jugador.getNombre() + " " + jugador.getApellido() +
                ", asistencias=" + asistencias +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Asistencia that = (Asistencia) o;
        return getAsistencias() == that.getAsistencias() && Objects.equals(getJugador(), that.getJugador());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJugador(), getAsistencias());
    }
}

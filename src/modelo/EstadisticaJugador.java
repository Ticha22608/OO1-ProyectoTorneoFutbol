package modelo;

public class EstadisticaJugador {
    private int idEstadistica;
    private int goles;
    private int asistencias;
    private int minutosJugados;
    private Jugador jugador;

    public EstadisticaJugador(int idEstadistica, int goles, int asistencias, int minutosJugados, Jugador jugador) {
        this.idEstadistica = idEstadistica;
        this.goles = goles;
        this.asistencias = asistencias;
        this.minutosJugados = minutosJugados;
        this.jugador = jugador;
    }

    public int getIdEstadistica() {
        return idEstadistica;
    }

    private void setIdEstadistica(int idEstadistica) {
        this.idEstadistica = idEstadistica;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public String toString() {
        return "EstadisticaJugador{" +
                "idEstadistica=" + idEstadistica +
                ", goles=" + goles +
                ", asistencias=" + asistencias +
                ", minutosJugados=" + minutosJugados +
                ", jugador=" + jugador +
                "}\n";
    }
}

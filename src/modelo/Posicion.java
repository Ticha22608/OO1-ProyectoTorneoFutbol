package modelo;

public class Posicion {
    private int puesto;
    private Equipo equipo;
    private int puntos;

    public Posicion(Equipo equipo, int puntos) {
        this.equipo = equipo;
        this.puntos = puntos;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Posicion{" +
                "puesto=" + puesto +
                ", equipo=" + equipo +
                ", puntos=" + puntos +
                "}";
    }
}

package modelo;

public class Ganador {
    private Equipo equipo;
    private int cantidadGoles;
    private int numeroFecha;

    public Ganador(Equipo equipo, int cantidadGoles, int numeroFecha) {
        this.equipo = equipo;
        this.cantidadGoles = cantidadGoles;
        this.numeroFecha = numeroFecha;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getCantidadGoles() {
        return cantidadGoles;
    }

    public void setCantidadGoles(int cantidadGoles) {
        this.cantidadGoles = cantidadGoles;
    }

    public int getNumeroFecha() {
        return numeroFecha;
    }

    public void setNumeroFecha(int numeroFecha) {
        this.numeroFecha = numeroFecha;
    }

    @Override
    public String toString() {
        return "Ganador{" +
                "equipo=" + equipo.getNombre() +
                ", cantidadGoles=" + cantidadGoles +
                ", numeroFecha=" + numeroFecha +
                "}\n";
    }
}
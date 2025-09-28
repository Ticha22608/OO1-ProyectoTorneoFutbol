package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Partido {
    private Date fecha;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String estadio;
    private List<EstadisticaJugador> estadistica;

    public Partido(Date fecha, Equipo equipoLocal, Equipo equipoVisitante, String estadio, List<EstadisticaJugador> estadistica) {
        this.fecha = fecha;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.estadio = estadio;
        this.estadistica = new ArrayList<>();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public List<EstadisticaJugador> getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(List<EstadisticaJugador> estadistica) {
        this.estadistica = estadistica;
    }
}

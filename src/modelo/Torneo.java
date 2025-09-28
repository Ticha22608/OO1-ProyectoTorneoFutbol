package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Torneo {
    private String nombre;
    private String temporada;
    private List<Equipo> equipos;
    private Date fechaInicio;
    private Date fechaFin;

    public Torneo(String nombre, String temporada, List<Equipo> equipos, Date fechaInicio, Date fechaFin) {
        this.nombre = nombre;
        this.temporada = temporada;
        this.equipos = new ArrayList<>();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}

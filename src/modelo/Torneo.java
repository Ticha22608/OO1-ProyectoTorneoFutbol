package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Torneo {
	private int idTorneo;
    private String nombre;
    private String temporada;
    private List<Equipo> equipos;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<EstadisticaJugador> estadisticaTorneo;
    private List<Partido> partidos;

    public Torneo(int idTorneo, String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) {
    	this.idTorneo=idTorneo;
    	this.nombre = nombre;
        this.temporada = temporada;
        this.equipos = new ArrayList<Equipo>();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadisticaTorneo = new ArrayList<EstadisticaJugador>();
        this.partidos = new ArrayList<Partido>();
    }
    
    public int getIdTorneo() {
		return idTorneo;
	}

	private void setIdTorneo(int idTorneo) {
		this.idTorneo = idTorneo;
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

	public List<EstadisticaJugador> getEstadisticaTorneo() {
		return estadisticaTorneo;
	}

	public void setEstadisticaTorneo(List<EstadisticaJugador> estadisticaTorneo) {
		this.estadisticaTorneo = estadisticaTorneo;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}


}

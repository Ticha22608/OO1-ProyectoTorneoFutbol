package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Partido {
	private int idPartido;
    private LocalDate fecha;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String estadio;
    private List<EstadisticaJugador> estadistica;

    public Partido(int idPartido, LocalDate fecha, Equipo equipoLocal, Equipo equipoVisitante, String estadio) {
    	this.idPartido = idPartido;
        this.fecha = fecha;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.estadio = estadio;
        this.estadistica = new ArrayList<EstadisticaJugador>();
    }
    
    public int getIdPartido() {
		return idPartido;
	}

	private void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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

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

    @Override
    public String toString() {
        return "Partido{" +
                "idPartido=" + idPartido +
                ", fecha=" + fecha +
                ", equipoLocal=" + equipoLocal +
                ", equipoVisitante=" + equipoVisitante +
                ", estadio='" + estadio + '\'' +
                ", estadistica=" + estadistica +
                "}\n";
    }

    public boolean agregarEstadisticaPartido(int goles, int asistencias, int minutosJugados, Jugador jugador) {
        //if (traerJugador(idJugador) == null) return false; //implementar luego, pero quizás con excepciones
        int id = 0;
        if (estadistica.size() > 0) id = estadistica.getLast().getIdEstadistica() + 1;
        EstadisticaJugador aux = new EstadisticaJugador(id, goles, asistencias, minutosJugados, jugador);
        return estadistica.add(aux);
    }

    public EstadisticaJugador traerEstadisticaJugador(int idEstadistica) {
        EstadisticaJugador aux = null;
        boolean encontrado = false;
        int i = 0;
        while (!encontrado && i < estadistica.size()) {
            if (idEstadistica == estadistica.get(i).getIdEstadistica()) {
                encontrado = true;
                aux = estadistica.get(i);
            }
            i++;
        }
        return aux;
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

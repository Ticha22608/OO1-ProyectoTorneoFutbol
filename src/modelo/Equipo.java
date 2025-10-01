package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipo {
	private int numEquipo;
    private String nombre;
    private String idEquipo;
    private LocalDate fechaFundacion;
    private List<Jugador> jugadores;
    private Entrenador entrenador;
    private List<EstadisticaJugador> estadisticaEquipo;

    public Equipo(int numEquipo, String nombre, String idEquipo, LocalDate fechaFundacion, Entrenador entrenador) {
        this.nombre = nombre;
        this.idEquipo = idEquipo;
        this.fechaFundacion = fechaFundacion;
        this.jugadores = new ArrayList<Jugador>();
        this.entrenador = entrenador;
        this.estadisticaEquipo= new ArrayList<EstadisticaJugador>();
    }
    
    public int getNumEquipo() {
		return numEquipo;
	}

	public void setNumEquipo(int numEquipo) {
		this.numEquipo = numEquipo;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    private void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public LocalDate getFechaFundacion() {
		return fechaFundacion;
	}

	public void setFechaFundacion(LocalDate fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

	public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

	public List<EstadisticaJugador> getEstadisticaEquipo() {
		return estadisticaEquipo;
	}

	public void setEstadisticaEquipo(List<EstadisticaJugador> estadisticaEquipo) {
		this.estadisticaEquipo = estadisticaEquipo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(idEquipo, other.idEquipo);
	}
	
	
    
}

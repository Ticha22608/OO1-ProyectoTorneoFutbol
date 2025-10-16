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
    public double calcularAlturaPromedio() {
        // 1. Verifica si hay jugadores para evitar división por cero
        if (this.jugadores.isEmpty()) {
            return 0.0;
        }

        double sumaAlturas = 0.0;
        int i = 0;

        // 2. Suma las estaturas de todos los jugadores usando un ciclo while
        while (i < this.jugadores.size()) {
            sumaAlturas += this.jugadores.get(i).getEstatura();
            i++;
        }

        // 3. Calcula el promedio: suma total dividida por la cantidad de jugadores
        return sumaAlturas / this.jugadores.size();
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

    @Override
    public String toString() {
        return "Equipo{" +
                "numEquipo=" + numEquipo +
                ", nombre='" + nombre + '\'' +
                ", idEquipo='" + idEquipo + '\'' +
                ", fechaFundacion=" + fechaFundacion +
                ", jugadores=" + jugadores +
                ", entrenador=" + entrenador +
                ", estadisticaEquipo=" + estadisticaEquipo +
                "}\n";
    }

    public boolean agregarJugador(String nombre, String apellido, long dni, LocalDate fechaNacimiento, double estatura, double peso, String posicion, int numCamiseta, boolean estado) {
        int id = 0;
        if (jugadores.size() > 0) {
            int indiceJugador = jugadores.size() - 1;
            id = jugadores.get(indiceJugador).getIdPersona();
        }
        Jugador nuevoJugador = new Jugador(id + 1, nombre, apellido, dni, fechaNacimiento, estatura, peso, posicion, numCamiseta);
        return jugadores.add(nuevoJugador);
    }

    public Jugador traerJugador(int idPersona){
        int indice = 0;
        boolean encontrado = false;
        Jugador aux = null;

        while(indice < jugadores.size() && !encontrado){
            if(jugadores.get(indice).getIdPersona() == idPersona) {
                encontrado = true;
                aux = jugadores.get(indice);
            }
            indice++;
        }
        return aux;
    }

    public boolean agregarJugador (Jugador j){
        if (jugadores.contains(j)) {
            return false;
        }
        return jugadores.add(j);
    }

    public boolean eliminarJugador(int idPersona){
        Jugador aEliminar = traerJugador(idPersona);
        return jugadores.remove(aEliminar);
    }

    public boolean agregarEstadisticaEquipo (int goles, int asistencias, int minutosJugados, Jugador jugador) {
        int id = 0;
        if (estadisticaEquipo.size() > 0){
            int indiceEstadistica = estadisticaEquipo.size() - 1;
            id = estadisticaEquipo.get(indiceEstadistica).getIdEstadistica();
        }
        EstadisticaJugador nuevaEstadisticaJugador = new EstadisticaJugador(id+1, goles, asistencias, minutosJugados, jugador);
        return estadisticaEquipo.add(nuevaEstadisticaJugador);
    }

    public EstadisticaJugador traerEstadisticaEquipo(int idEstadistica){
        int indice = 0;
        boolean encontrado = false;
        EstadisticaJugador aux = null;

        while (indice < estadisticaEquipo.size() && !encontrado) {
            if(estadisticaEquipo.get(indice).getIdEstadistica() == idEstadistica) {
                encontrado = true;
                aux = estadisticaEquipo.get(indice);
            }
            indice++;
        }
        return aux;
    }

}

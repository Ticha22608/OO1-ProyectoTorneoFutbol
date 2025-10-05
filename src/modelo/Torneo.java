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

    public boolean agregarEquipo(Equipo equipo) {
        if (this.traerEquipoPorId(equipo.getIdEquipo()) == null) {
            return this.equipos.add(equipo);
        }
        return false;
    }
    public boolean agregarEstadistica(EstadisticaJugador estadistica) {
        return this.estadisticaTorneo.add(estadistica);
    }
    public boolean agregarPartido(Partido partido) {
        if (this.traerPartidoPorId(partido.getIdPartido()) == null) {
            return this.partidos.add(partido);
        }
        return false;
    }
    public boolean darBajaJugadorEnEquipo(String idEquipo, int idJugador) {
        Equipo equipo = this.traerEquipoPorId(idEquipo);
        if (equipo != null) {
            System.out.println("Se intenta dar de baja al jugador " + idJugador + " del equipo " + idEquipo);
            return true;
        }
        return false;
    }

    public boolean eliminarEquipo(String idEquipo) {
        Equipo equipo = this.traerEquipoPorId(idEquipo);
        if (equipo != null) {
            return this.equipos.remove(equipo);
        }
        return false;
    }



    public Equipo traerEquipoPorId(String idEquipo) {
        int i = 0;
        while (i < this.equipos.size()) {
            Equipo equipo = this.equipos.get(i);
            if (equipo.getIdEquipo().equals(idEquipo)) {
                return equipo;
            }
            i++;
        }
        return null;
    }

    public EstadisticaJugador traerEstadisticaPorId(int idEstadistica) {
        int i = 0;
        while (i < this.estadisticaTorneo.size()) {
            EstadisticaJugador estadistica = this.estadisticaTorneo.get(i);
            if (estadistica.getIdEstadistica() == idEstadistica) {
                return estadistica;
            }
            i++;
        }
        return null;
    }

    public Partido traerPartidoPorId(int idPartido) {
        int i = 0;
        while (i < this.partidos.size()) {
            Partido partido = this.partidos.get(i);
            if (partido.getIdPartido() == idPartido) {
                return partido;
            }
            i++;
        }
        return null;
    }
    public Equipo equipoMayorAlturaPromedio() {
        if (equipos.isEmpty()) {
            return null;
        }

        Equipo mejorEquipo = equipos.getFirst();
        double mayorPromedio = mejorEquipo.calcularAlturaPromedio();

        for (Equipo equipo : equipos) {
            double promedio = equipo.calcularAlturaPromedio();
            if (promedio > mayorPromedio) {
                mayorPromedio = promedio;
                mejorEquipo = equipo;
            }
        }
        return mejorEquipo;
    }

    // --- Getters y Setters ---

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

    @Override
    public String toString() {
        return "Torneo{" +
                "idTorneo=" + idTorneo +
                ", nombre='" + nombre + '\'' +
                ", temporada='" + temporada + '\'' +
                ", equipos=" + equipos +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", estadisticaTorneo=" + estadisticaTorneo +
                ", partidos=" + partidos +
                "}/n";
    }
}


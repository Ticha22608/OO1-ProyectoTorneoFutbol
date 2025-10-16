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


    public boolean agregarEquipo(Equipo equipo) throws Exception {
        if (this.traerEquipoPorId(equipo.getIdEquipo()) != null) {

            throw new Exception("ERROR: Ya existe un Equipo con ID: " + equipo.getIdEquipo());
        }
        return this.equipos.add(equipo);
    }

    public boolean eliminarEquipo(String idEquipo) throws Exception {
        Equipo equipo = this.traerEquipoPorId(idEquipo);
        if (equipo == null) {

            throw new Exception("ERROR: El Equipo con ID: " + idEquipo + " no existe.");
        }
        return this.equipos.remove(equipo);
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

    public Equipo traerEquipoPorId(String idEquipo) {
        int indice = 0;
        boolean encontrado = false;
        Equipo aux= null;

        while (indice < equipos.size() && !encontrado) {
            if (equipos.get(indice).getIdEquipo() == idEquipo) {
                encontrado = true;
                aux= equipos.get(indice);
            }
            indice++;
        }
        return aux;
    }

    public EstadisticaJugador traerEstadisticaPorId(int idEstadistica) {
        int indice = 0;
        boolean encontrado = false;
        EstadisticaJugador aux=null;

        while (indice < estadisticaTorneo.size() && !encontrado) {
            if (estadisticaTorneo.get(indice).getIdEstadistica() == idEstadistica) {
                encontrado = true;
                aux =  estadisticaTorneo.get(indice);
            }
            indice++;
        }
        return aux;
    }

    public Partido traerPartidoPorId(int idPartido) {
        int indice = 0;
        boolean encontrado = false;
        Partido aux = null;

        while (indice < this.partidos.size() && !encontrado) {
            if (partidos.get(indice).getIdPartido() == idPartido) {
                encontrado=true;
                aux=partidos.get(indice);
            }
            indice++;
        }
        return aux;
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

}
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;

public class Torneo {
    private int idTorneo;
    private String nombre;
    private int temporada;
    private List<Equipo> equipos;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<EstadisticaJugador> estadisticaTorneo;
    private List<Partido> partidos;

    public Torneo(int idTorneo, String nombre, int temporada, LocalDate fechaInicio, LocalDate fechaFin) {
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

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
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
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Torneo torneo = (Torneo) o;
        return Objects.equals(nombre, torneo.nombre) && Objects.equals(temporada, torneo.temporada);
    }


    public int calcularGolesJugador(Jugador jugador) {
        int totalGoles = 0;
        for (EstadisticaJugador estadistica : estadisticaTorneo) {
            if (estadistica.getJugador().equals(jugador)) {
                totalGoles += estadistica.getGoles();
            }
        }
        return totalGoles;
    }

    public int calcularAsistenciasJugador(Jugador jugador) {
        int totalAsistencias = 0;
        for (EstadisticaJugador estadistica : estadisticaTorneo) {
            if (estadistica.getJugador().equals(jugador)) {
                totalAsistencias += estadistica.getAsistencias();
            }
        }
        return totalAsistencias;
    }


    public boolean agregarEquipo(Equipo equipo) throws Exception {
        if (this.traerEquipoPorId(equipo.getIdEquipo()) != null) {

            throw new Exception("ERROR: Ya existe un Equipo con ID: " + equipo.getIdEquipo());
        }
        return this.equipos.add(equipo);
    }

    public int calcularGolesJugador(Jugador jugador) {
        int totalGoles = 0;

        for (EstadisticaJugador estadistica : estadisticaTorneo) {
            if (estadistica.getJugador().equals(jugador)) {
                totalGoles += estadistica.getGoles();
            }
        }

        return totalGoles;
    }

    public int calcularAsistenciasJugador(Jugador jugador) {
        int totalAsistencias = 0;

        for (EstadisticaJugador estadistica : estadisticaTorneo) {
            if (estadistica.getJugador().equals(jugador)) {
                totalAsistencias += estadistica.getAsistencias();
            }
        }

        return totalAsistencias;
    }

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

    public boolean agregarEstadistica(int goles, int asistencias, int minutosJugados, Jugador jugador) {
        int id = 0;
        if (estadisticaTorneo.size() > 0){
            int indiceEstadistica = estadisticaTorneo.size() - 1;
            id = estadisticaTorneo.get(indiceEstadistica).getIdEstadistica();
        }
        EstadisticaJugador nuevaEstadisticaJugador = new EstadisticaJugador(id+1, goles, asistencias, minutosJugados, jugador);
        return estadisticaTorneo.add(nuevaEstadisticaJugador);
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

        Equipo mejorEquipo = equipos.get(0);
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

    /*
     Genera la tabla de posiciones del torneo.
     Para cada partido suma los goles por equipo (sumando las estadisticas de jugadores)
     y asigna 3 puntos por victoria, 1 por empate.
     Retorna una lista de Posicion ordenada de mayor a menor puntaje.
     */
    public List<Posicion> generarTablaPosiciones() {
        Map<Equipo, Integer> puntosPorEquipo = new HashMap<>();


        for (Equipo equipo : this.equipos) {
            puntosPorEquipo.put(equipo, 0);
        }


        for (Partido partido : this.partidos) {
            int golesLocal = 0;
            int golesVisitante = 0;

            if (partido.getEstadistica() != null) {
                for (EstadisticaJugador est : partido.getEstadistica()) {
                    Jugador jugador = est.getJugador();
                    if (jugador == null) continue;

                    if (partido.getEquipoLocal() != null && partido.getEquipoLocal().getJugadores().contains(jugador)) {
                        golesLocal += est.getGoles();
                    } else if (partido.getEquipoVisitante() != null && partido.getEquipoVisitante().getJugadores().contains(jugador)) {
                        golesVisitante += est.getGoles();
                    }
                }
            }

            Equipo local = partido.getEquipoLocal();
            Equipo visitante = partido.getEquipoVisitante();

            if (local == null || visitante == null) continue; // ignorar partidos mal formados

            if (golesLocal > golesVisitante) {
                puntosPorEquipo.put(local, puntosPorEquipo.getOrDefault(local, 0) + 3);
            } else if (golesLocal < golesVisitante) {
                puntosPorEquipo.put(visitante, puntosPorEquipo.getOrDefault(visitante, 0) + 3);
            } else {
                puntosPorEquipo.put(local, puntosPorEquipo.getOrDefault(local, 0) + 1);
                puntosPorEquipo.put(visitante, puntosPorEquipo.getOrDefault(visitante, 0) + 1);
            }
        }

        List<Posicion> tabla = new ArrayList<>();
        for (Map.Entry<Equipo, Integer> entry : puntosPorEquipo.entrySet()) {
            tabla.add(new Posicion(entry.getKey(), entry.getValue()));
        }

        Collections.sort(tabla, new Comparator<Posicion>() {
            @Override
            public int compare(Posicion p1, Posicion p2) {
                return Integer.compare(p2.getPuntos(), p1.getPuntos());
            }
        });

        for (int i = 0; i < tabla.size(); i++) {
            tabla.get(i).setPuesto(i + 1);
        }

        return tabla;
    }

}
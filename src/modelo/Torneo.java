package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            if (Objects.equals(equipos.get(indice).getIdEquipo(), idEquipo)) {
                encontrado = true;
                aux = equipos.get(indice);
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
    public List<Ganador> traerGanadoresPorFecha(int numeroFecha) {
        List<Ganador> ganadores = new ArrayList<>();
        int indice = 0;

        while (indice < partidos.size()) {
            Partido partido = partidos.get(indice);
            int golesLocal = 0;
            int golesVisitante = 0;

            // Calcular goles de cada equipo
            if (partido.getEstadistica() != null) {
                int j = 0;
                while (j < partido.getEstadistica().size()) {
                    EstadisticaJugador est = partido.getEstadistica().get(j);
                    Jugador jugador = est.getJugador();
                    if (jugador != null) {
                        if (partido.getEquipoLocal() != null && partido.getEquipoLocal().getJugadores().contains(jugador)) {
                            golesLocal += est.getGoles();
                        } else if (partido.getEquipoVisitante() != null && partido.getEquipoVisitante().getJugadores().contains(jugador)) {
                            golesVisitante += est.getGoles();
                        }
                    }
                    j++;
                }
            }

            // Determinar ganador
            if (golesLocal > golesVisitante) {
                ganadores.add(new Ganador(partido.getEquipoLocal(), golesLocal, numeroFecha));
            } else if (golesVisitante > golesLocal) {
                ganadores.add(new Ganador(partido.getEquipoVisitante(), golesVisitante, numeroFecha));
            }
            indice++;
        }
        return ganadores;
    }

    public List<Posicion> generarTablaPosiciones() {
        List<Posicion> tabla = new ArrayList<>();

        // Inicializar la tabla con todos los equipos en 0 puntos
        int i = 0;
        while (i < equipos.size()) {
            tabla.add(new Posicion(equipos.get(i), 0));
            i++;
        }

        // Calcular puntos para cada partido
        i = 0;
        while (i < partidos.size()) {
            Partido partido = partidos.get(i);
            int golesLocal = 0;
            int golesVisitante = 0;

            // Si hay estadísticas, calcular goles
            if (partido.getEstadistica() != null) {
                List<EstadisticaJugador> estadisticas = partido.getEstadistica();
                int j = 0;
                while (j < estadisticas.size()) {
                    EstadisticaJugador est = estadisticas.get(j);
                    Jugador jugador = est.getJugador();
                    if (jugador != null) {
                        if (partido.getEquipoLocal() != null && partido.getEquipoLocal().getJugadores().contains(jugador)) {
                            golesLocal += est.getGoles();
                        } else if (partido.getEquipoVisitante() != null && partido.getEquipoVisitante().getJugadores().contains(jugador)) {
                            golesVisitante += est.getGoles();
                        }
                    }
                    j++;
                }
            }

            Equipo local = partido.getEquipoLocal();
            Equipo visitante = partido.getEquipoVisitante();

            if (local != null && visitante != null) {
                // Actualizar puntos en la tabla
                int j = 0;
                while (j < tabla.size()) {
                    Posicion pos = tabla.get(j);
                    if (pos.getEquipo().equals(local)) {
                        if (golesLocal > golesVisitante) {
                            pos.setPuntos(pos.getPuntos() + 3);
                        } else if (golesLocal == golesVisitante) {
                            pos.setPuntos(pos.getPuntos() + 1);
                        }
                    } else if (pos.getEquipo().equals(visitante)) {
                        if (golesVisitante > golesLocal) {
                            pos.setPuntos(pos.getPuntos() + 3);
                        } else if (golesLocal == golesVisitante) {
                            pos.setPuntos(pos.getPuntos() + 1);
                        }
                    }
                    j++;
                }
            }
            i++;
        }

        // Ordenar la tabla por puntos (ordenamiento burbuja)
        i = 0;
        while (i < tabla.size() - 1) {
            int j = 0;
            while (j < tabla.size() - i - 1) {
                if (tabla.get(j).getPuntos() < tabla.get(j + 1).getPuntos()) {
                    // Intercambiar posiciones
                    Posicion temp = tabla.get(j);
                    tabla.set(j, tabla.get(j + 1));
                    tabla.set(j + 1, temp);
                }
                j++;
            }
            i++;
        }

        // Asignar puestos según el orden final
        i = 0;
        while (i < tabla.size()) {
            tabla.get(i).setPuesto(i + 1);
            i++;
        }

        return tabla;
    }

}
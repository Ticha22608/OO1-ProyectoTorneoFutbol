package modelo;

import java.util.Comparator;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaCampeonatos {
    private List<Torneo> torneos;
    private List<Equipo> equipos;
    private List<Jugador> jugadores;
    private List<Entrenador> entrenadores;
    private List<EstadisticaJugador> estadisticas;

    public SistemaCampeonatos() {
        this.torneos = new ArrayList<Torneo>();
        this.equipos = new ArrayList<Equipo>();
        this.jugadores = new ArrayList<Jugador>();
        this.entrenadores = new ArrayList<Entrenador>();
        this.estadisticas = new ArrayList<EstadisticaJugador>();
    }

    public List<Torneo> getTorneos() {
        return torneos;
    }

    public void setTorneos(List<Torneo> torneos) {
        this.torneos = torneos;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }
    
    public boolean agregarTorneo(String nombre, int temporada, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
    	if(traerTorneo(nombre) != null) throw new Exception("ERROR: Ya existe un Torneo con nombre: "+ nombre + " en esa temporada.");
    	int id=0;
    	if(torneos.size() > 0) {
    		int ultimoIndice = torneos.size() - 1;
    		id = torneos.get(ultimoIndice).getIdTorneo();
    	}
    	Torneo agregar = new Torneo(id+1, nombre, temporada, fechaInicio, fechaFin);
    	return torneos.add(agregar);
    }
    
    
    public Torneo traerTorneo(int idTorneo) {
    	int indice = 0;
    	boolean encontrado = false;
    	Torneo aux = null;
    	
    	while(indice < torneos.size() && !encontrado) {
    		if(torneos.get(indice).getIdTorneo() == idTorneo) {
    			encontrado = true;
    			aux = torneos.get(indice);
    		}
    		indice++;
    	}
    	return aux;
    }

    public Torneo traerTorneo(String nombre){
        int indice = 0;
        boolean encontrado = false;
        Torneo aux = null;

        while(indice < torneos.size() && !encontrado) {
            if(torneos.get(indice).getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
                aux = torneos.get(indice);
            }
            indice++;
        }
        return aux;
    }
    
    public boolean eliminarTorneo(int idTorneo) throws Exception {
    	Torneo aEliminar = traerTorneo(idTorneo);
    	if(aEliminar == null) throw new Exception("ERROR: El Torneo con ID: " + idTorneo + " no existe.");
        return torneos.remove(aEliminar);

    }
    
    public boolean agregarEquipo(String nombre, String idEquipo, LocalDate fechaFundacion, Entrenador entrenador) throws Exception {
    	if(traerEquipo(idEquipo) != null ) throw new Exception("ERROR: Ya existe un Equipo con ID: " + idEquipo);
        int numEquipo = 0;
    	if(equipos.size() > 0) {
    		int ultimoIndice = equipos.size() - 1;
    		numEquipo = equipos.get(ultimoIndice).getNumEquipo();
    	}
    	Equipo agregar = new Equipo(numEquipo+1, nombre, idEquipo, fechaFundacion, entrenador);
    	return equipos.add(agregar);
    }
    
    public Equipo traerEquipo(int numEquipo) {
    	int indice = 0;
    	boolean encontrado = false;
    	Equipo aux = null;
    	
    	while(indice < equipos.size() && !encontrado) {
    		if(equipos.get(indice).getNumEquipo() == numEquipo) {
    			encontrado = true;
    			aux = equipos.get(indice);
    		}
    		indice++;
    	}
    	return aux;
    }
    
    public Equipo traerEquipo(String idEquipo) {
    	int indice = 0;
    	boolean encontrado = false;
    	Equipo aux = null;
    	
    	while(indice < equipos.size() && !encontrado) {
    		if(equipos.get(indice).getIdEquipo().equals(idEquipo)) {
    			encontrado = true;
    			aux = equipos.get(indice);
    		}
    		indice++;
    	}
    	return aux;
    }
    
    public boolean eliminarEquipo(String idEquipo) throws Exception {
    	Equipo aEliminar = traerEquipo(idEquipo);
    	if(aEliminar == null) throw new Exception("ERROR: El Equipo con ID: " + idEquipo + " no existe.");
        return equipos.remove(aEliminar);
    }
    
    public boolean agregarJugador(String nombre, String apellido, long dni, LocalDate fechaNacimiento, double estatura, double peso, String posicion, int numCamiseta, boolean estado) throws Exception {
    	if(traerJugador(dni) != null) throw new Exception("ERROR: Ya existe un Jugador con DNI: " + dni);
        int id = 0;
    	if(jugadores.size() > 0) {
    		int ultimoIndice = jugadores.size() - 1;
    		id = jugadores.get(ultimoIndice).getIdPersona();
    	}
    	Jugador agregar = new Jugador(id+1, nombre, apellido, dni, fechaNacimiento, estatura, peso, posicion, numCamiseta);
    	return jugadores.add(agregar);
    }
    
    public Jugador traerJugador(int idPersona) {
    	int indice = 0;
    	boolean encontrado = false;
    	Jugador aux = null;
    	
    	while(indice < jugadores.size() && !encontrado) {
    		if(jugadores.get(indice).getIdPersona() == idPersona) {
    			encontrado = true;
    			aux = jugadores.get(indice);
    		}
    		indice++;
    	}
    	return aux;
    }

    public Jugador traerJugador(long dni) {
        int indice = 0;
        boolean encontrado = false;
        Jugador aux = null;

        while(indice < jugadores.size() && !encontrado) {
            if(jugadores.get(indice).getDni() == dni) {
                encontrado = true;
                aux = jugadores.get(indice);
            }
            indice++;
        }
        return aux;
    }
    
    public void eliminarJugador(int idPersona) throws Exception{
    	Jugador aEliminar = traerJugador(idPersona);
        if(aEliminar == null) throw new Exception("ERROR: El Jugador con ID: " + idPersona + " no existe.");
        aEliminar.setEstado(false);
    }
    
    public boolean agregarEntrenador(String nombre, String apellido, long dni, LocalDate fechaNacimiento,String estrategiaFavorita) throws Exception{
    	if(traerEntrenador(dni) != null) throw new Exception("ERROR: Ya existe un Entrenador con dni: " + dni);
        int id = 0;
    	if(entrenadores.size() > 0) {
    		int ultimoIndice = entrenadores.size() - 1;
    		id = entrenadores.get(ultimoIndice).getIdPersona();
    	}
    	Entrenador agregar = new Entrenador(id+1, nombre, apellido, dni, fechaNacimiento, estrategiaFavorita);
    	return entrenadores.add(agregar);
    }
    
    
    public Entrenador traerEntrenador(int idPersona) {
    	int indice = 0;
    	boolean encontrado = false;
    	Entrenador aux = null;
    	
    	while(indice < entrenadores.size() && !encontrado) {
    		if(entrenadores.get(indice).getIdPersona() == idPersona) {
    			encontrado = true;
    			aux = entrenadores.get(indice);
    		}
    		indice++;
    	}
    	return aux;
    }

    public Entrenador traerEntrenador(long dni) {
        int indice = 0;
        boolean encontrado = false;
        Entrenador aux = null;

        while(indice < entrenadores.size() && !encontrado) {
            if(entrenadores.get(indice).getDni() == dni) {
                encontrado = true;
                aux = entrenadores.get(indice);
            }
            indice++;
        }
        return aux;
    }
    
    public List<Entrenador> traerEntrenadores(String estrategiaFavorita){
    	List<Entrenador> lstEntrenadores = new ArrayList<Entrenador>();
    	
    	for(int i = 0; i<entrenadores.size(); i++) {
    		if(entrenadores.get(i).getEstrategiaFavorita().equals(estrategiaFavorita)) {
    			lstEntrenadores.add(entrenadores.get(i));
    		}
    	}
    	return lstEntrenadores;
    }
    
   public List<Jugador> traerJugadores(LocalDate fecha1, LocalDate fecha2){
    	List<Jugador> jugadoresEntreFechas = new ArrayList<Jugador>();
    	
    	if(fecha1.isAfter(fecha2)) {
    		LocalDate aux= fecha1;
    		fecha1=fecha2;
    		fecha2=aux;
    	}
    	
    	for(Jugador j: jugadores) {
    		if((j.getFechaNacimiento().isAfter(fecha1) || j.getFechaNacimiento().isEqual(fecha1)) &&
    			 (j.getFechaNacimiento().isBefore(fecha2) || j.getFechaNacimiento().isEqual(fecha2))) {
    			jugadoresEntreFechas.add(j);
    		}
    	}
    	return jugadoresEntreFechas;
    }
    
    
    public List<Equipo> traerEquipos(LocalDate fecha){
    	List<Equipo> equiposFecha = new ArrayList<Equipo>();
    	
    	for(int i=0; i<equipos.size(); i++) {
    		if(equipos.get(i).getFechaFundacion().isBefore(fecha)) {
    			equiposFecha.add(equipos.get(i));
    		}
    	}
    	return equiposFecha;
    }



    public List<Goleador> listaGoleadores() {
        List<Goleador> aux = new ArrayList<Goleador>();
        for (Jugador j : jugadores) {
            int goles = 0;
            for (Torneo t : torneos) {
                goles += t.calcularGolesJugador(j);
            }
            aux.add(new Goleador(j, goles));
        }
        aux.sort(
            Comparator.comparingInt(Goleador::getGoles).reversed()
                      .thenComparing(g->g.getJugador().getNombre(),String.CASE_INSENSITIVE_ORDER)
                      .thenComparing(g->g.getJugador().getApellido(),String.CASE_INSENSITIVE_ORDER)
        );
        return aux;
    }

    public List<Asistencia> listaAsistidores() {
        List<Asistencia> aux = new ArrayList<Asistencia>();
        for (Jugador j : jugadores) {
            int asistencias = 0;
            for (Torneo t : torneos) {
                asistencias += t.calcularAsistenciasJugador(j);
            }
            aux.add(new Asistencia(j, asistencias));
        }
        aux.sort(
           Comparator.comparingInt(Asistencia::getAsistencias).reversed()
                     .thenComparing(a->a.getJugador().getNombre(),String.CASE_INSENSITIVE_ORDER)
                     .thenComparing(a->a.getJugador().getApellido(),String.CASE_INSENSITIVE_ORDER)
        );
        return aux;
    }

}

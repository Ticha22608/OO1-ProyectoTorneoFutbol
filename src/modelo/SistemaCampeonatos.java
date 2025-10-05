package modelo;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaCampeonatos {
    private List<Torneo> torneos;
    private List<Equipo> equipos;
    private List<Jugador> jugadores;
    private List<Entrenador> entrenadores;

    public SistemaCampeonatos() {
        this.torneos = new ArrayList<Torneo>();
        this.equipos = new ArrayList<Equipo>();
        this.jugadores = new ArrayList<Jugador>();
        this.entrenadores = new ArrayList<Entrenador>();
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
    
    public boolean agregarTorneo(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) {
    	
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
    
    public boolean eliminarTorneo(int idTorneo) {
    	Torneo aEliminar = traerTorneo(idTorneo);
    	if(aEliminar != null) {
    		return torneos.remove(aEliminar);
    	}else {
    		return false;
    	}
    }
    
    public boolean agregarEquipo(String nombre, String idEquipo, LocalDate fechaFundacion, Entrenador entrenador) {
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
    
    public boolean eliminarEquipo(String idEquipo) {
    	Equipo aEliminar = traerEquipo(idEquipo);
    	if(aEliminar != null) {
    		return equipos.remove(aEliminar);
    	}else {
    		return false;
    	}
    }
    
    public boolean agregarJugador(String nombre, String apellido, long dni, LocalDate fechaNacimiento, double estatura, double peso, String posicion, int numCamiseta) {
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
    
    public boolean eliminarJugador(int idPersona) {
    	Jugador aEliminar = traerJugador(idPersona);
    	if(aEliminar != null) {
    		return jugadores.remove(aEliminar);
    	}else {
    		return false;
    	}
    }
    
    public boolean agregarEntrenador(String nombre, String apellido, long dni, LocalDate fechaNacimiento,String estrategiaFavorita) {
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
}

package test;

import java.time.LocalDate;
import java.util.List;

import modelo.EstadisticaJugador;
import modelo.SistemaCampeonatos;

public class TestSistemaCampeonato {

	public static void main(String[] args) {
        // TODO Auto-generated method stub

        SistemaCampeonatos sistema = new SistemaCampeonatos();

        sistema.agregarTorneo("Apertura", "otoño", LocalDate.of(2025, 4, 12), LocalDate.of(2025, 6, 29));
        sistema.agregarTorneo("Clausura", "primavera", LocalDate.of(2025, 9, 9), LocalDate.of(2025, 11, 20));

        //System.out.println(sistema.getTorneos().toString());

        sistema.agregarEntrenador("Gustavo", "Quinteros", 33456789, LocalDate.of(1965, 2, 15), "Ofensiva");
        sistema.agregarEntrenador("Ruben", "Forestello", 44321987, LocalDate.of(1971, 2, 15), "4-3-3");
        sistema.agregarEntrenador("Jorge", "Vivaldo", 43678910, LocalDate.of(1967, 2, 16), "4-3-3");

        System.out.println(sistema.getEntrenadores().toString());

        sistema.agregarEquipo("Club Atlético Independiente", "CAI", LocalDate.of(1905, 1, 1), sistema.traerEntrenador(1));
        sistema.agregarEquipo("Club Atlético Temperley", "CAT", LocalDate.of(1912, 11, 1), sistema.traerEntrenador(2));
        sistema.agregarEquipo("Club Atlético Talleres", "TAL", LocalDate.of(1906, 6, 1), sistema.traerEntrenador(3));

        System.out.println(sistema.getEquipos().toString());

        sistema.agregarJugador("Santiago", "Montiel", 42123456, LocalDate.of(2000, 11, 22), 1.66, 60.0, "Extremo derecho", 7); //cai
        sistema.agregarJugador("Kevin", "Lomonaco", 43564876, LocalDate.of(2002, 1, 8), 1.92, 80.0, "Defensa", 26); //cai
        sistema.agregarJugador("Lorenzo", "Monti", 43523765, LocalDate.of(1998, 3, 2), 1.85, 77.0, "Centrocampista", 4); //cat
        sistema.agregarJugador("Franco", "Ayunta", 40546342, LocalDate.of(2002, 11, 29), 1.80, 70.0, "Delantero", 13); //cat
        sistema.agregarJugador("Damian", "Tello", 41234984, LocalDate.of(1995, 9, 23), 1.90, 80.0, "Arquero", 1); //tal
        sistema.agregarJugador("Camilo", "Viganoni", 44987533, LocalDate.of(2003, 12, 10), 1.81, 85.0, "Delantero", 7); //tal

        System.out.println(sistema.getJugadores().toString());

        System.out.println("\nEntrenadores por estrategia fav:\n");

        System.out.println(sistema.traerEntrenadores("4-3-3").toString());

        sistema.traerEquipo("CAI").agregarJugador(sistema.traerJugador(1));
        sistema.traerEquipo("CAI").agregarJugador(sistema.traerJugador(2));
        sistema.traerEquipo("CAT").agregarJugador(sistema.traerJugador(3));
        sistema.traerEquipo("CAT").agregarJugador(sistema.traerJugador(4));
        sistema.traerEquipo("TAL").agregarJugador(sistema.traerJugador(5));
        sistema.traerEquipo("TAL").agregarJugador(sistema.traerJugador(6));

        System.out.println("Jugadores CAI:");
        System.out.println(sistema.traerEquipo("CAI").getJugadores().toString());
        System.out.println("Jugadores CAT:");
        System.out.println(sistema.traerEquipo("CAT").getJugadores().toString());
        System.out.println("Jugadores TAL:");
        System.out.println(sistema.traerEquipo("TAL").getJugadores().toString());

        sistema.traerEquipo("CAI").agregarEstadisticaEquipo(9, 5, 1309, sistema.traerJugador(1));
        sistema.traerEquipo("CAI").agregarEstadisticaEquipo(2, 1, 3168, sistema.traerJugador(2));
        sistema.traerEquipo("CAT").agregarEstadisticaEquipo(1, 0, 2051, sistema.traerJugador(3));
        sistema.traerEquipo("CAT").agregarEstadisticaEquipo(2, 0, 910, sistema.traerJugador(4));
        sistema.traerEquipo("TAL").agregarEstadisticaEquipo(0, 0, 2790, sistema.traerJugador(5));
        sistema.traerEquipo("TAL").agregarEstadisticaEquipo(4, 1, 1352, sistema.traerJugador(6));

        System.out.println("Estadisticas Independiente: ");
        System.out.println(sistema.traerEquipo("CAI").traerEstadisticaEquipo(1).toString());
        System.out.println(sistema.traerEquipo("CAI").traerEstadisticaEquipo(2).toString());
        System.out.println("Estadisticas Temperley: ");
        System.out.println(sistema.traerEquipo("CAT").traerEstadisticaEquipo(1).toString());
        System.out.println(sistema.traerEquipo("CAT").traerEstadisticaEquipo(2).toString());
        System.out.println("Estadisticas Talleres: ");
        System.out.println(sistema.traerEquipo("TAL").traerEstadisticaEquipo(1).toString());
        System.out.println(sistema.traerEquipo("TAL").traerEstadisticaEquipo(2).toString());

    }

}

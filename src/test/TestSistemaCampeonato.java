package test;

import java.time.LocalDate;

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
		
		//System.out.println(sistema.getEquipos().toString());
		
		sistema.agregarJugador("Santiago", "Montiel", 42123456, LocalDate.of(2000, 11, 22), 60.0, 1.66, "Extremo derecho", 7); //cai
		sistema.agregarJugador("Kevin", "Lomonaco", 43564876, LocalDate.of(2002, 1, 8), 80.0, 1.92, "Defensa", 26); //cai
		sistema.agregarJugador("Lorenzo", "Monti", 43523765, LocalDate.of(1998, 3, 2), 77.0, 1.85, "Centrocampista", 4); //cat
		sistema.agregarJugador("Franco", "Ayunta", 40546342, LocalDate.of(2002, 11, 29), 70.0, 1.80, "Delantero", 13); //cat
		sistema.agregarJugador("Damian", "Tello", 41234984, LocalDate.of(1995, 9, 23), 80.0, 1.90, "Arquero", 1); //tal
		sistema.agregarJugador("Camilo", "Viganoni", 44987533, LocalDate.of(2003, 12, 10), 85.0, 1.81, "Delantero", 7); //tal
		
		//System.out.println(sistema.getJugadores().toString());
		
		System.out.println("\nEntrenadores por estrategia fav:\n");
		
		System.out.println(sistema.traerEntrenadores("4-3-3").toString());

	}

}

package test;

import java.time.LocalDate;
import java.util.List;

import modelo.*;

public class TestSistemaCampeonato {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        SistemaCampeonatos sistema = new SistemaCampeonatos();
        try {
            sistema.agregarTorneo("Apertura", 2023, LocalDate.of(2025, 4, 12), LocalDate.of(2025, 6, 29));
            sistema.agregarTorneo("Clausura", 2024, LocalDate.of(2025, 9, 9), LocalDate.of(2025, 11, 20));
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("TORNEOS DEL CAMPEONATO LA REDONDA: \n");
        System.out.println(sistema.getTorneos().toString());

        try {
            sistema.agregarEntrenador("Gustavo", "Quinteros", 33456789, LocalDate.of(1965, 2, 15), "Ofensiva");
            sistema.agregarEntrenador("Ruben", "Forestello", 44321987, LocalDate.of(1971, 2, 15), "4-3-3");
            sistema.agregarEntrenador("Jorge", "Vivaldo", 43678910, LocalDate.of(1967, 2, 16), "4-3-3");
        } catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("\nENTRENADORES: \n");
        System.out.println(sistema.getEntrenadores().toString());

        try {
            sistema.agregarEquipo("Club Atlético Independiente", "CAI", LocalDate.of(1905, 1, 1), sistema.traerEntrenador(1));
            sistema.agregarEquipo("Club Atlético Temperley", "CAT", LocalDate.of(1912, 11, 1), sistema.traerEntrenador(2));
            sistema.agregarEquipo("Club Atlético Talleres", "TAL", LocalDate.of(1906, 6, 1), sistema.traerEntrenador(3));
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("\nEQUIPOS: \n");
        System.out.println(sistema.getEquipos().toString());

        try{
            sistema.agregarJugador("Santiago", "Montiel", 42123456, LocalDate.of(2000, 11, 22), 1.66, 60.0, "Extremo derecho", 7, true); //cai
            sistema.agregarJugador("Kevin", "Lomonaco", 43564876, LocalDate.of(2002, 1, 8), 1.92, 80.0, "Defensa", 26, true); //cai
            sistema.agregarJugador("Lorenzo", "Monti", 43523765, LocalDate.of(1998, 3, 2), 1.85, 77.0, "Centrocampista", 4, true); //cat
            sistema.agregarJugador("Franco", "Ayunta", 40546342, LocalDate.of(2002, 11, 29), 1.80, 70.0, "Delantero", 13, true); //cat
            sistema.agregarJugador("Damian", "Tello", 41234984, LocalDate.of(1995, 9, 23), 1.90, 80.0, "Arquero", 1, true); //tal
            sistema.agregarJugador("Camilo", "Viganoni", 44987533, LocalDate.of(2003, 12, 10), 1.81, 85.0, "Delantero", 7, true); //tal
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("\nJUGADORES: \n");
        System.out.println(sistema.getJugadores().toString());

        System.out.println("\nENTRENADORES POR ESTRATEGIA FAV:\n");

        System.out.println(sistema.traerEntrenadores("4-3-3").toString());

        sistema.traerEquipo("CAI").agregarJugador(sistema.traerJugador(1));
        sistema.traerEquipo("CAI").agregarJugador(sistema.traerJugador(2));
        sistema.traerEquipo("CAT").agregarJugador(sistema.traerJugador(3));
        sistema.traerEquipo("CAT").agregarJugador(sistema.traerJugador(4));
        sistema.traerEquipo("TAL").agregarJugador(sistema.traerJugador(5));
        sistema.traerEquipo("TAL").agregarJugador(sistema.traerJugador(6));

        System.out.println("\nJUGADORES CAI:\n");
        System.out.println(sistema.traerEquipo("CAI").getJugadores().toString());
        System.out.println("\nJUGADORES CAT:\n");
        System.out.println(sistema.traerEquipo("CAT").getJugadores().toString());
        System.out.println("\nJUGADORES TAL:\n");
        System.out.println(sistema.traerEquipo("TAL").getJugadores().toString());

        sistema.traerEquipo("CAI").agregarEstadisticaEquipo(9, 5, 1309, sistema.traerJugador(1));
        sistema.traerEquipo("CAI").agregarEstadisticaEquipo(2, 1, 3168, sistema.traerJugador(2));
        sistema.traerEquipo("CAT").agregarEstadisticaEquipo(1, 0, 2051, sistema.traerJugador(3));
        sistema.traerEquipo("CAT").agregarEstadisticaEquipo(2, 0, 910, sistema.traerJugador(4));
        sistema.traerEquipo("TAL").agregarEstadisticaEquipo(0, 0, 2790, sistema.traerJugador(5));
        sistema.traerEquipo("TAL").agregarEstadisticaEquipo(4, 1, 1352, sistema.traerJugador(6));

        System.out.println("\nESTADISTICAS INDEPENDIENTE: \n");
        System.out.println(sistema.traerEquipo("CAI").traerEstadisticaEquipo(1).toString());
        System.out.println(sistema.traerEquipo("CAI").traerEstadisticaEquipo(2).toString());
        System.out.println("\nESTADISTICAS TEMPERLEY: \n");
        System.out.println(sistema.traerEquipo("CAT").traerEstadisticaEquipo(1).toString());
        System.out.println(sistema.traerEquipo("CAT").traerEstadisticaEquipo(2).toString());
        System.out.println("\nESTADISTICAS TALLERES: \n");
        System.out.println(sistema.traerEquipo("TAL").traerEstadisticaEquipo(1).toString());
        System.out.println(sistema.traerEquipo("TAL").traerEstadisticaEquipo(2).toString());


// Test restantes para verificar de Torneo

        System.out.println("Pruebas de Torneo restantes ");
        // Test de eliminación (Caso de uso 2)
        System.out.println("\nPRUEBA DE ELIMINACIÓN DE EQUIPO:\n");
        try {
            sistema.eliminarEquipo("CAT");
            System.out.println("Equipo eliminado exitosamente");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // Test de búsqueda por fecha de nacimiento (Caso de uso 6)
        System.out.println("\nJUGADORES ENTRE FECHAS DE NACIMIENTO:\n");
        List<Jugador> jugadoresEntreFechas = sistema.traerJugadores(
                LocalDate.of(2000, 1, 1),
                LocalDate.of(2003, 12, 31)
        );
        System.out.println(jugadoresEntreFechas.toString());

        // Test de búsqueda de equipos por fecha fundación (Caso de uso 7)
        System.out.println("\nEQUIPOS ANTERIORES A FECHA:\n");
        List<Equipo> equiposAntiguos = sistema.traerEquipos(LocalDate.of(1910, 1, 1));
        System.out.println(equiposAntiguos.toString());

        // Test de cálculo de altura promedio (Caso de uso 8)
        System.out.println("\nALTURA PROMEDIO DE EQUIPOS:\n");
        System.out.println("Altura promedio CAI: " + sistema.traerEquipo("CAI").calcularAlturaPromedio());
        System.out.println("Altura promedio TAL: " + sistema.traerEquipo("TAL").calcularAlturaPromedio());

        // Test de equipo con mayor altura promedio (Caso de uso 9)
        Torneo torneoApertura = sistema.traerTorneo("Apertura");
        try {
            // Agregamos los equipos al torneo
            torneoApertura.agregarEquipo(sistema.traerEquipo("CAI"));
            torneoApertura.agregarEquipo(sistema.traerEquipo("CAT"));
            torneoApertura.agregarEquipo(sistema.traerEquipo("TAL"));

            System.out.println("\nEQUIPO CON MAYOR ALTURA PROMEDIO:\n");
            Equipo equipoMasAlto = torneoApertura.equipoMayorAlturaPromedio();
            if (equipoMasAlto != null) {
                System.out.println(equipoMasAlto.toString());
            } else {
                System.out.println("No hay equipos en el torneo o no tienen jugadores");
            }
        } catch(Exception e) {
            System.out.println("Error al agregar equipos al torneo: " + e.getMessage());
        }

        // Agregar partidos para probar casos de uso 4 y 11
        System.out.println("\nAGREGANDO PARTIDOS DE PRUEBA:\n");
        try {
            // Crear partido CAI vs TAL
            Partido partido1 = new Partido(1, LocalDate.of(2025, 4, 15),
                    sistema.traerEquipo("CAI"), sistema.traerEquipo("TAL"), "Libertadores de América");
            partido1.agregarEstadisticaPartido(2, 0, 90, sistema.traerJugador(1)); // 2 goles Montiel
            partido1.agregarEstadisticaPartido(0, 1, 90, sistema.traerJugador(2)); // 1 asistencia Lomonaco
            torneoApertura.agregarPartido(partido1);
            System.out.println("Partido 1 agregado: " + partido1.toString());

            // Agregar las estadísticas del partido también al torneo para que
            // los cálculos globales de goles/asistencias las tomen en cuenta
            torneoApertura.agregarEstadistica(new EstadisticaJugador(1, 2, 1, 90, sistema.traerJugador(1))); // Montiel: 2 goles, 1 asistencia
            torneoApertura.agregarEstadistica(new EstadisticaJugador(2, 1, 1, 90, sistema.traerJugador(2))); // Lomonaco: 1 gol, 1 asistencia
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // Test de tabla de posiciones (Caso de uso 11)
        System.out.println("\nTABLA DE POSICIONES:\n");
        List<Posicion> tablaPosiciones = torneoApertura.generarTablaPosiciones();
        System.out.println(tablaPosiciones.toString());

        // Test de ganadores por fecha (Caso de uso 4)
        System.out.println("\nGANADORES POR FECHA:\n");
        List<Ganador> ganadoresFecha1 = torneoApertura.traerGanadoresPorFecha(1);
        System.out.println(ganadoresFecha1.toString());

        // Test de goles por jugador (Caso de uso 12)
        System.out.println("\nGOLES POR JUGADOR:\n");
        System.out.println("Goles Montiel: " + torneoApertura.calcularGolesJugador(sistema.traerJugador(1)));
        System.out.println("Goles Lomonaco: " + torneoApertura.calcularGolesJugador(sistema.traerJugador(2)));

        // Test de asistencias por jugador (Caso de uso 13)
        System.out.println("\nASISTENCIAS POR JUGADOR:\n");
        System.out.println("Asistencias Montiel: " + torneoApertura.calcularAsistenciasJugador(sistema.traerJugador(1)));
        System.out.println("Asistencias Lomonaco: " + torneoApertura.calcularAsistenciasJugador(sistema.traerJugador(2)));

        System.out.println("\n---Métodos 14 y 15---\n");
        sistema.traerTorneo(1).agregarEstadistica(5, 2, 655, sistema.traerJugador(1));
        sistema.traerTorneo(2).agregarEstadistica(4, 3, 654, sistema.traerJugador(1));
        sistema.traerTorneo(1).agregarEstadistica(1, 1, 1582, sistema.traerJugador(2));
        sistema.traerTorneo(2).agregarEstadistica(1, 0, 1582, sistema.traerJugador(2));
        sistema.traerTorneo(1).agregarEstadistica(1, 0, 1024, sistema.traerJugador(3));
        sistema.traerTorneo(2).agregarEstadistica(0, 0, 1026, sistema.traerJugador(3));
        sistema.traerTorneo(1).agregarEstadistica(1, 0, 455, sistema.traerJugador(4));
        sistema.traerTorneo(2).agregarEstadistica(1, 0, 455, sistema.traerJugador(4));
        sistema.traerTorneo(1).agregarEstadistica(0, 0, 1395, sistema.traerJugador(5));
        sistema.traerTorneo(2).agregarEstadistica(0, 0, 1395, sistema.traerJugador(5));
        sistema.traerTorneo(1).agregarEstadistica(2, 1, 676, sistema.traerJugador(6));
        sistema.traerTorneo(2).agregarEstadistica(2, 0, 676, sistema.traerJugador(6));
        System.out.println(sistema.listaGoleadores());
        System.out.println(sistema.listaAsistidores());

    }

}

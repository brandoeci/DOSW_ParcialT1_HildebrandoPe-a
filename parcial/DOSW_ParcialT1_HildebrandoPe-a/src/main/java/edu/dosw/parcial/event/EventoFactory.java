package edu.dosw.parcial.event;

import edu.dosw.parcial.actividad.Conferencia;
import edu.dosw.parcial.actividad.Hackathon;
import edu.dosw.parcial.actividad.Taller;

public class EventoFactory {

    public static Evento crearEvento(String tipo, String titulo,
                                     String fechaHoraInicio,
                                     int duracion,
                                     int cupoMaximo) {

        switch (tipo.toLowerCase()) {
            case "conferencia":
                return new Conferencia(titulo, fechaHoraInicio,
                        duracion, cupoMaximo, "Invitado Especial");
            case "taller":
                return new Taller(titulo, fechaHoraInicio,
                        duracion, cupoMaximo, false);
            case "hackathon":
                return new Hackathon(titulo, fechaHoraInicio,
                        duracion, cupoMaximo, "2026-05-01");
            default:
                throw new IllegalArgumentException("Tipo de evento inválido");
        }
    }
}

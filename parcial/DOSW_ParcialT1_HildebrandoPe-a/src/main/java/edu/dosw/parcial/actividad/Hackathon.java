package edu.dosw.parcial.actividad;

import edu.dosw.parcial.event.Evento;

public class Hackathon extends Evento {

    private String fechaLimiteInscripcion;

    public Hackathon(String titulo, String fechaHoraInicio,
                     int duracion, int cupoMaximo,
                     String fechaLimiteInscripcion) {
        this.fechaLimiteInscripcion = fechaLimiteInscripcion;
        validarReglas();
    }

    @Override
    public void validarReglas() {
        if (duracion < 240) {
            throw new IllegalArgumentException("Duración mínima para hackathon es 240 minutos.");
        }
    }
}
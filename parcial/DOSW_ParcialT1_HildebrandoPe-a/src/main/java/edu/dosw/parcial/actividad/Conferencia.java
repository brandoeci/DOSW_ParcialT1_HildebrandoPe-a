package edu.dosw.parcial.actividad;

import edu.dosw.parcial.event.Evento;

public class Conferencia extends Evento {

    private String nombreConferencista;

    public Conferencia(String titulo, String fechaHoraInicio,
                       int duracion, int cupoMaximo,
                       String nombreConferencista) {
        this.nombreConferencista = nombreConferencista;
        validarReglas();
    }

    @Override
    public void validarReglas() {
        if (duracion > 180) {
            throw new IllegalArgumentException("Duración máxima para conferencia es 180 minutos.");
        }
    }
}

package edu.dosw.parcial.actividad;

import edu.dosw.parcial.event.Evento;

public class Taller extends Evento {

    private boolean requiereMaterialPrevio;

    public Taller(String titulo, String fechaHoraInicio,
                  int duracion, int cupoMaximo,
                  boolean requiereMaterialPrevio) {
        this.requiereMaterialPrevio = requiereMaterialPrevio;
        validarReglas();
    }

    @Override
    public void validarReglas() {
        if (duracion > 240) {
            throw new IllegalArgumentException("Duración máxima para taller es 240 minutos.");
        }
    }

    @Override
    public void cambiarEstado(String nuevoEstado) {
        if (nuevoEstado.equals("CONFIRMADO") && inscritos.size() < 10) {
            System.out.println("No se puede confirmar min 10 inscritos.");
            return;
        }
        super.cambiarEstado(nuevoEstado);
    }
    public void setRequiereMaterialPrevio(boolean requiereMaterialPrevio) {
        this.requiereMaterialPrevio = requiereMaterialPrevio;
    }
}

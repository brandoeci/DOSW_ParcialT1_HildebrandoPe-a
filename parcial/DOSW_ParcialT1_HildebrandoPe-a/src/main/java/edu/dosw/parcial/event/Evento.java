package edu.dosw.parcial.event;

import edu.dosw.parcial.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Evento {

    protected String titulo;
    protected String fechaHoraInicio;
    protected int duracion;
    protected int cupoMaximo;
    protected String estado = "CREADO";
    protected List<Observer> inscritos = new ArrayList<>();

    public Evento(String titulo, String fechaHoraInicio, int duracion, int cupoMaximo) {
        this.titulo = titulo;
        this.fechaHoraInicio = fechaHoraInicio;
        this.duracion = duracion;
        this.cupoMaximo = cupoMaximo;
    }
    public void agregarInscrito(Observer observer) {
        if (inscritos.size() >= cupoMaximo) {
            System.out.println("Cupo máximo alcanzado.");
            notifyObservers("El evento alcanzó el cupo máximo.");
            return;
        }
        inscritos.add(observer);
    }
    protected void notifyObservers(String mensaje) {
        for (Observer o : inscritos) {
            o.update(mensaje);
        }
    }
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notifyObservers("El evento cambió a estado: " + nuevoEstado);
    }
    public void cambiarFecha(String nuevaFecha) {
        this.fechaHoraInicio = nuevaFecha;
        notifyObservers("La fecha del evento cambió a: " + nuevaFecha);
    }
    public abstract void validarReglas();
    public int getCantidadInscritos() {
        return inscritos.size();
    }
}

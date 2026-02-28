package edu.dosw.parcial.observer;

public class Inscrito implements Observer {

    private String nombre;
    private String correo;

    public Inscrito(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    @Override
    public void update(String mensaje) {
        System.out.println("Notificación para " + nombre + " (" + correo + "): " + mensaje);
    }
}

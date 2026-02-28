package edu.dosw.parcial;

import edu.dosw.parcial.actividad.Taller;
import edu.dosw.parcial.event.Evento;
import edu.dosw.parcial.event.EventoFactory;
import edu.dosw.parcial.observer.Inscrito;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Tipo de evento (conferencia/taller/hackathon): ");
        System.out.print("Usuario creador (codigo,nombre,correo): ");
        String saltos = sc.nextLine();
        String[] datosCreador = saltos.split(",");
        if (datosCreador.length != 3) {
            System.out.println("Formato inválido.");
            return;
        }
        String correoCreador = datosCreador[2];
        if (!correoCreador.endsWith("@escuelaing.edu.co")) {
            System.out.println("Correo del profesor inválido.");
            return;
        }
        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Duración (minutos): ");
        int duracion = Integer.parseInt(sc.nextLine());

        System.out.print("Fecha (YYYY-MM-DD): ");
        String fecha = sc.nextLine();

        System.out.print("Hora inicio (HH:MM): ");
        String hora = sc.nextLine();

        System.out.print("Cupo máximo: ");
        int cupo = Integer.parseInt(sc.nextLine());

        Evento evento = EventoFactory.crearEvento(
                tipo,
                titulo,
                fecha + " " + hora,
                duracion,
                cupo
        );
        System.out.println("\nEvento creado correctamente.");
        if (evento instanceof Taller) {
            System.out.print("Requiere material previo? (true/false): ");
            boolean material = Boolean.parseBoolean(sc.nextLine());
            ((Taller) evento).setRequiereMaterialPrevio(material);
        }
        System.out.println("\n INSCRIPCIÓN DE ESTUDIANTES ");
        System.out.println("Ingrese estudiantes en formato:");
        System.out.println("id_nombre_correo_programa");
        System.out.println("Escribe 'fin' para terminar.");
        while (true) {
            String entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }
            String[] datos = entrada.split("_");
            if (datos.length != 4) {
                System.out.println("Formato inválido.");
                continue;
            }
            String nombre = datos[1];
            String correo = datos[2];
            if (!correo.endsWith("@mail.escuelaing.edu.co")) {
                System.out.println("Correo estudiante inválido.");
                continue;
            }
            Inscrito estudiante = new Inscrito(nombre, correo);
            evento.agregarInscrito(estudiante);

            System.out.println("Estudiante inscrito correctamente.");

            if (evento instanceof Taller && evento.getCantidadInscritos() >= 10) {
                evento.cambiarEstado("CONFIRMADO");
            }
        }
        System.out.println("\nProceso finalizado.");
        sc.close();
    }
}
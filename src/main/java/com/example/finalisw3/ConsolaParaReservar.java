package com.example.finalisw3;

import java.util.List;
import java.util.Scanner;

public class ConsolaParaReservar {
    private static final Scanner scanner = new Scanner(System.in);
    /*
    * Esta clase solamente sirve para hacer funcionar por la consola de comandos la aplicacion de reservas
    *
    * */

    public static void main(String args []) {
        RepositorioReservas repositorio = new RepositorioReservas();
        GestorReservas gestorReservas = new GestorReservas(repositorio);
        while (true){
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Hacer reserva");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Modificar reservas");
            System.out.println("4. Listar reservas");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    hacerReserva(gestorReservas);
                    break;
                case 2:
                    cancelarReserva(gestorReservas);
                    break;
                case 3:
                    modificarReservas(gestorReservas);
                    break;
                case 4:
                    listarReservas(gestorReservas);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        }
    }
    private static void hacerReserva(GestorReservas gestorReservas){
        System.out.println("Ingrese la fecha de la reserva: (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();

        System.out.println("Ingrese la hora de la reserva: (HH:mm): ");
        String hora = scanner.nextLine();

        System.out.println("Ingrese la cantidad de comensales: ");
        int comensales = scanner.nextInt();
        scanner.nextLine(); // limpiar el buffer porque suceden pedillos

        System.out.println("Ingrese el nombre del titular de la reserva: ");
        String nombre = scanner.nextLine();

        gestorReservas.hacerReserva(fecha, hora, comensales, nombre);
        System.out.println("Reserva realizada con exito");
    }
    private static void cancelarReserva(GestorReservas gestorReservas){
        System.out.println("Ingrese el indice de la reserva a cancelar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();// el fixer de pedillos

        List<Reserva> reservas = gestorReservas.listarReserva();
        if (indice >= 0 && indice < reservas.size()){
            gestorReservas.cancelarReserva(reservas.get(indice));
            System.out.println("Reserva cancelada con exito");
        }else {
            System.out.println("indice no valido ");
        }
    }
    private static void listarReservas(GestorReservas gestorReservas){
        List<Reserva> reservas = gestorReservas.listarReserva();
        for (int i = 0; i < reservas.size(); i++) {
            Reserva reserva = reservas.get(i);
            System.out.println(i+1 + ". Fecha: " + reserva.getFecha() + ", Hora: " + reserva.getHora() +
                    ", Comensales: " + reserva.getComensales() + ", Titular: " + reserva.getNombreTitular());
        }
    }
    private static void modificarReservas(GestorReservas gestorReservas){
        System.out.print("Ingrese el índice de la reserva a modificar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer después de leer el número

        indice = indice - 1;
        List<Reserva> reservas = gestorReservas.listarReserva();
        if (indice >= 0 && indice < reservas.size()) {
            Reserva reservaSeleccionada = reservas.get(indice);

            System.out.println("Reserva actual seleccionada:");
            mostrarDetallesReserva(reservaSeleccionada);

            System.out.print("Ingrese la nueva fecha (o Enter para mantener la actual): ");
            String nuevaFecha = scanner.nextLine();
            if (!nuevaFecha.isEmpty()) {
                reservaSeleccionada.setFecha(nuevaFecha);
            }

            System.out.print("Ingrese la nueva hora (o Enter para mantener la actual): ");
            String nuevaHora = scanner.nextLine();
            if (!nuevaHora.isEmpty()) {
                reservaSeleccionada.setHora(nuevaHora);
            }

            System.out.print("Ingrese la nueva cantidad de comensales (o Enter para mantener la actual): ");
            String nuevaCantidad = scanner.nextLine();
            if (!nuevaCantidad.isEmpty()) {
                reservaSeleccionada.setComensales(Integer.parseInt(nuevaCantidad));
            }

            System.out.println("Reserva modificada con éxito.");
            mostrarDetallesReserva(reservaSeleccionada);
        } else {
            System.out.println("Índice no válido.");
        }
    }
    private static void mostrarDetallesReserva(Reserva reserva) {
        System.out.println("Fecha: " + reserva.getFecha() +
                ", Hora: " + reserva.getHora() +
                ", Comensales: " + reserva.getComensales() +
                ", Titular: " + reserva.getNombreTitular());
    }
}
package com.example.finalisw3;

import java.util.List;

public class GestorReservas {
    private RepositorioReservas repositorio;
    public GestorReservas(RepositorioReservas repositorio){
        this.repositorio = repositorio;
    }
    public void hacerReserva(String fecha, String hora, int comensales, String nombre){
        Reserva reserva = new Reserva(fecha, hora, comensales, nombre);
        repositorio.agregarReserva(reserva);
    }
    public void cancelarReserva(Reserva reserva){
        repositorio.eliminarReserva(reserva);
    }
    public List<Reserva> listarReserva(){
        return repositorio.listarReservas();
    }

    public void modificarReserva(Reserva reserva, String nuevaFecha, String nuevaHora, int nuevaCantidad) {
        if (nuevaFecha != null && !nuevaFecha.isEmpty()) {
            reserva.setFecha(nuevaFecha);
        }

        if (nuevaHora != null && !nuevaHora.isEmpty()) {
            reserva.setHora(nuevaHora);
        }

        if (nuevaCantidad > 0) {
            reserva.setComensales(nuevaCantidad);
        }
    }

}

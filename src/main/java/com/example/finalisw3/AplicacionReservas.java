package com.example.finalisw3;

import java.util.List;

public class AplicacionReservas {
    private RepositorioReservas repositorio;

    public AplicacionReservas() {
        this.repositorio = new RepositorioReservas();
    }

    public void hacerReserva(String fecha, String hora, int comensales, String nombre) {
        Reserva reserva = new Reserva(fecha, hora, comensales, nombre);
        repositorio.agregarReserva(reserva);
    }

    public void cancelarReserva(Reserva reserva) {
        repositorio.eliminarReserva(reserva);
    }

    public List<Reserva> listarReservas() {
        return repositorio.listarReservas();
    }

    public void modificarReserva(Reserva reservaAntigua, String nuevaFecha, String nuevaHora, int nuevosComensales, String nuevoTitular) {
        Reserva reservaNueva = new Reserva(nuevaFecha,nuevaHora,nuevosComensales, nuevoTitular);
        repositorio.modificarReserva(reservaAntigua, reservaNueva);

    }
}

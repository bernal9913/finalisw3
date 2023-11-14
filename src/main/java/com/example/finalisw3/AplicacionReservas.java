package com.example.finalisw3;

import java.util.List;

public class AplicacionReservas {
    private RepositorioReservas repositorio;

    public AplicacionReservas() {
        this.repositorio = new RepositorioReservas();
    }

    public void hacerReserva(String fecha, String hora, int comensales) {
        Reserva reserva = new Reserva(fecha, hora, comensales);
        repositorio.agregarReserva(reserva);
    }

    public void cancelarReserva(Reserva reserva) {
        repositorio.eliminarReserva(reserva);
    }

    public List<Reserva> listarReservas() {
        return repositorio.listarReservas();
    }

    public void modificarReserva(Reserva reservaAntigua, String nuevaFecha, String nuevaHora, int nuevosComensales) {
        Reserva reservaNueva = new Reserva(nuevaFecha,nuevaHora,nuevosComensales);
        repositorio.modificarReserva(reservaAntigua, reservaNueva);

    }
}

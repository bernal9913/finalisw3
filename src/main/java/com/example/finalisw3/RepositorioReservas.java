package com.example.finalisw3;

import java.util.ArrayList;
import java.util.List;

public class RepositorioReservas {
    private List<Reserva> reservas;

    public RepositorioReservas() {
        this.reservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservas;
    }
}

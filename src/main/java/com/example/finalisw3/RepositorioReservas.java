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

    public void modificarReserva(Reserva reservaAntigua, Reserva reservaNueva) {
        if (reservas.contains(reservaAntigua)){
            System.out.println("Reserva anterior: " + reservaAntigua.getFecha()
                    + reservaAntigua.getHora()
                    + reservaAntigua.getComensales());
            reservas.remove(reservaAntigua);
            reservas.add(reservaNueva);
            System.out.println("Reserva nueva agregada con exito");
        }else {
            System.out.println("Ha ocurrido un error agregando la reserva");
        }
    }
}

package com.example.finalisw3;

public class Reserva {
    private String fecha;
    private String hora;
    private int comensales;

    public Reserva(String fecha, String hora, int comensales) {
        this.fecha = fecha;
        this.hora = hora;
        this.comensales = comensales;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getComensales() {
        return comensales;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Hora: " + hora + ", Comensales: " + comensales;
    }
}

package com.example.finalisw3;

public class Reserva {
    private String fecha;
    private String hora;
    private int comensales;
    private String nombreTitular;

    public Reserva(String fecha, String hora, int comensales, String nombreTitular) {
        this.fecha = fecha;
        this.hora = hora;
        this.comensales = comensales;
        this.nombreTitular = nombreTitular;
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
    public String getNombreTitular(){
        return nombreTitular;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Hora: " + hora + ", Comensales: " + comensales;
    }
}

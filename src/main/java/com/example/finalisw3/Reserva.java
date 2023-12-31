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

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setComensales(int comensales) {
        this.comensales = comensales;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    @Override
    public String toString() {
        return "Titular: "+ nombreTitular+ ", Fecha: " + fecha + ", Hora: " + hora + ", Comensales: " + comensales;
    }

    
}

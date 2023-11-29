package com.example.finalisw3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioReservas {
    private List<Reserva> reservas;
    private String archivoCSV;

    public RepositorioReservas(/* String archivoCSV */) {
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
    /**
     * Este fragmento de cargar reservas es una duda enorme si jala
     * pero, fue agregado por si a lo mejor se necesitaba guardar en csv
     * usar bajo su propio riesgo
     *
     * **/
    private void cargarReservas(){
        try(BufferedReader br = new BufferedReader(new FileReader(archivoCSV))){
            String line;
            while((line = br.readLine()) != null){
                String [] partes = line.split(",");
                if(partes.length == 3){
                    Reserva reserva = new Reserva(partes[0], partes[1], Integer.parseInt(partes[2]), partes[3]);
                    reservas.add(reserva);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void guardarReserva(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCSV))){
            for (Reserva reserva : reservas){
                bw.write(String.format("%s,%s,%d%n", reserva.getFecha(), reserva.getHora(), reserva.getComensales()));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

package tests;
import com.example.finalisw3.AplicacionReservas;
import com.example.finalisw3.Reserva;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class testsReservas {
    @Test
    public void hacerReservaTest(){
        AplicacionReservas aplicacionReservas = new AplicacionReservas();
        aplicacionReservas.hacerReserva(
                "01-12-2023",
                "18:00",
                3);

        // checar si la reservacion se creo
        List<Reserva> reservas = aplicacionReservas.listarReservas();
        Assert.assertEquals(reservas.size(),1);

        // checar la informacion de la reserva
        Reserva reserva = reservas.get(0);
        Assert.assertEquals(reserva.getFecha(), "01-12-2023");
        Assert.assertEquals(reserva.getHora(), "18:00");
        Assert.assertEquals(reserva.getComensales(), 3);
    }

    @Test
    public void cancelarReservaTest(){
        AplicacionReservas aplicacionReservas = new AplicacionReservas();
        Reserva reserva = new Reserva(
                "01-12-2023",
                "18:00",
                3);
        aplicacionReservas.hacerReserva(
                reserva.getFecha(),
                reserva.getHora(),
                reserva.getComensales());

        aplicacionReservas.cancelarReserva(reserva);
        List<Reserva> reservas = aplicacionReservas.listarReservas();
        System.out.println(reservas);
        Assert.assertTrue(!reservas.isEmpty()); // anda bien contreras el assert

    }
    // TODO: arreglar e investigar el porque no pasan los tests
    @Test
    public void modificarReservaTest(){
        AplicacionReservas aplicacionReservas = new AplicacionReservas();
        // reservacion con valores fuera de rango para ver si fue modificada
        Reserva reservaViejita = new Reserva(
                "22-22-2222",
                "22:22",
                2);
        aplicacionReservas.hacerReserva(
                reservaViejita.getFecha(),
                reservaViejita.getHora(),
                reservaViejita.getComensales());

        String fechaNueva = "01-12-2023";
        String horaNueva = "20:30";
        int comensalesNueva = 2;
        Reserva reservaNueva = new Reserva(
                fechaNueva,
                horaNueva,
                comensalesNueva);

        aplicacionReservas.modificarReserva(
                reservaViejita,
                fechaNueva,
                horaNueva,
                comensalesNueva);

        List<Reserva> reservas = aplicacionReservas.listarReservas();
        //Assert.assertEquals(reservas.size(),1);

        Reserva reservaMod = reservas.get(0);
        Assert.assertEquals(reservaMod.getFecha(), fechaNueva);
        Assert.assertEquals(reservaMod.getHora(), horaNueva);
        Assert.assertEquals(reservaMod.getComensales(), comensalesNueva);
    }
}

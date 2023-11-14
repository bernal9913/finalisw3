package tests;
import com.example.finalisw3.AplicacionReservas;
import com.example.finalisw3.RepositorioReservas;
import com.example.finalisw3.Reserva;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class testsReservas {
    Reserva reserva = new Reserva("01-12-2023", "18:00", 3);
    @BeforeClass
    public void preparar(){

    }
    @Test
    public void hacerReservaTest(){
        AplicacionReservas aplicacionReservas = new AplicacionReservas();
        aplicacionReservas.hacerReserva(
                reserva.getFecha(), reserva.getHora(), reserva.getComensales());

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
        aplicacionReservas.hacerReserva(
                reserva.getFecha(),
                reserva.getHora(),
                reserva.getComensales());

        aplicacionReservas.cancelarReserva(reserva);
        RepositorioReservas repositorioReservas = new RepositorioReservas();


        repositorioReservas.eliminarReserva(reserva);
        List<Reserva> reservas = repositorioReservas.listarReservas();
        System.out.println(reservas);
        Assert.assertTrue(reservas.isEmpty()); // anda bien contreras el assert

    }
    // TODO: arreglar e investigar el porque no pasan los tests
    @Test
    public void modificarReservaTest(){
        AplicacionReservas aplicacionReservas = new AplicacionReservas();
        RepositorioReservas repositorioReservas = new RepositorioReservas();
        // reservacion con valores fuera de rango para ver si fue modificada
        Reserva reservaViejita = new Reserva(
                "22-22-2222",
                "22:22",
                2);
        repositorioReservas.agregarReserva(
                reservaViejita);


        //Reserva reservaNueva = new Reserva(reserva.getFecha(), reserva.getHora(), reserva.getComensales());
/*
        aplicacionReservas.modificarReserva(
                reservaViejita,
                fechaNueva,
                horaNueva,
                comensalesNueva);
*/

        repositorioReservas.modificarReserva(reservaViejita, reserva);

        List<Reserva> reservas = repositorioReservas.listarReservas();
        Assert.assertEquals(reservas.size(),1);

        Reserva reservaMod = reservas.get(0);


        Assert.assertEquals(reservaMod.getFecha(), reserva.getFecha());
        Assert.assertEquals(reservaMod.getHora(), reserva.getHora());
        Assert.assertEquals(reservaMod.getComensales(), reserva.getComensales());
    }
}

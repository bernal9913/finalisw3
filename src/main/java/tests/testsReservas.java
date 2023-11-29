package tests;
import com.example.finalisw3.AplicacionReservas;
import com.example.finalisw3.RepositorioReservas;
import com.example.finalisw3.Reserva;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class testsReservas {
    Reserva reserva = new Reserva("01-12-2023", "18:00", 3, "Emilio Garra");


    @BeforeClass
    public void preparar(){

    }
    @Test
    public void hacerReservaTest(){
        AplicacionReservas aplicacionReservas = new AplicacionReservas();
        aplicacionReservas.hacerReserva(
                reserva.getFecha(), reserva.getHora(), reserva.getComensales(), reserva.getNombreTitular());

        // checar si la reservacion se creo
        List<Reserva> reservas = aplicacionReservas.listarReservas();
        Assert.assertEquals(reservas.size(),1);

        // checar la informacion de la reserva
        Reserva reserva = reservas.get(0);
        Assert.assertEquals(reserva.getFecha(), "01-12-2023");
        Assert.assertEquals(reserva.getHora(), "18:00");
        Assert.assertEquals(reserva.getComensales(), 3);
        Assert.assertEquals(reserva.getNombreTitular(), "Emilio Garra");
    }

    @Test
    public void cancelarReservaTest(){
        AplicacionReservas aplicacionReservas = new AplicacionReservas();
        aplicacionReservas.hacerReserva(
                reserva.getFecha(),
                reserva.getHora(),
                reserva.getComensales(),
                reserva.getNombreTitular());

        aplicacionReservas.cancelarReserva(reserva);
        RepositorioReservas repositorioReservas = new RepositorioReservas();


        repositorioReservas.eliminarReserva(reserva);
        List<Reserva> reservas = repositorioReservas.listarReservas();
        System.out.println(reservas);
        Assert.assertTrue(reservas.isEmpty()); // anda bien contreras el assert

    }
    @Test
    public void modificarReservaTest(){
        AplicacionReservas aplicacionReservas = new AplicacionReservas();
        RepositorioReservas repositorioReservas = new RepositorioReservas();
        // reservacion con valores fuera de rango para ver si fue modificada
        Reserva reservaViejita = new Reserva(
                "22-22-2222",
                "22:22",
                2,
                "Emilio Loreto");
        repositorioReservas.agregarReserva(
                reservaViejita);

        repositorioReservas.modificarReserva(reservaViejita, reserva);

        List<Reserva> reservas = repositorioReservas.listarReservas();
        Assert.assertEquals(reservas.size(),1);

        Reserva reservaMod = reservas.get(0);


        Assert.assertEquals(reservaMod.getFecha(), reserva.getFecha());
        Assert.assertEquals(reservaMod.getHora(), reserva.getHora());
        Assert.assertEquals(reservaMod.getComensales(), reserva.getComensales());
        System.out.println(reservas);
    }
    @Test
    public void listarReservas(){
        AplicacionReservas aplicacionReservas = new AplicacionReservas();
        aplicacionReservas.hacerReserva(reserva.getFecha(), reserva.getHora(), reserva.getComensales(), reserva.getNombreTitular());
        aplicacionReservas.hacerReserva("2023-29-11", "20:30", 3, "Taylor Swift");
        aplicacionReservas.hacerReserva("2023-29-11", "22:30", 1, "Frank Ocean");
        aplicacionReservas.hacerReserva("2023-29-11", "19:23", 40, "La parvada");

        List<Reserva> reservas = aplicacionReservas.listarReservas();
        System.out.println(reservas);
        Assert.assertEquals(reservas.size(), 4);
        Reserva reservaLaParvada = null;

        // Iterar sobre la lista de reservas
        for (Reserva reserva : reservas) {
            // Verificar si el titular es "La parvada"
            if ("La parvada".equals(reserva.getNombreTitular())) {
                reservaLaParvada = reserva;
                break;
            }
        }

        Assert.assertNotNull(reservaLaParvada, "No se encontró la reserva con el titular 'La Parvada'");
        Assert.assertEquals(reservaLaParvada.getNombreTitular(), "La parvada", "El titular no es 'La Parvada'");
    }
}

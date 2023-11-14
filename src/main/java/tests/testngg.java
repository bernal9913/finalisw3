package tests;

import com.example.finalisw3.AplicacionReservas;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class testngg {
    private AplicacionReservas aplicacionReservas;

    @BeforeClass
    public void setUp() {
        aplicacionReservas = new AplicacionReservas();
    }

    @Test
    public void hacerReservaAgregaReserva() {
        aplicacionReservas.hacerReserva("2023-12-01", "18:00", 4);
        assertEquals(aplicacionReservas.listarReservas().size(), 1);
    }


}
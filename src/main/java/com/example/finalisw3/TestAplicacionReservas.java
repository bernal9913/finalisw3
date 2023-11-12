package com.example.finalisw3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestAplicacionReservas {
    private AplicacionReservas aplicacionReservas;

    @BeforeEach
    public void setUp() {
        aplicacionReservas = new AplicacionReservas();
    }

    @Test
    public void hacerReservaAgregaReserva() {
        aplicacionReservas.hacerReserva("2023-12-01", "18:00", 4);
        assertEquals(1, aplicacionReservas.listarReservas().size());
    }
    // TODO: arreglar el environment de junit
}

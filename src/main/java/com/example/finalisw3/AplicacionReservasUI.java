package com.example.finalisw3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AplicacionReservasUI extends Application {
    private AplicacionReservas aplicacionReservas;
    private ListView<Reserva> reservasListView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        aplicacionReservas = new AplicacionReservas();

        primaryStage.setTitle("Aplicación de Reservas");

        Label fechaLabel = new Label("Fecha:");
        TextField fechaField = new TextField();
        Label horaLabel = new Label("Hora:");
        TextField horaField = new TextField();
        Label comensalesLabel = new Label("Comensales:");
        TextField comensalesField = new TextField();

        Button hacerReservaButton = new Button("Hacer Reserva");
        Button cancelarReservaButton = new Button("Cancelar Reserva");
        TextArea reservasTextArea = new TextArea();

        reservasListView = new ListView<>();

        hacerReservaButton.setOnAction(e -> {
            String fecha = fechaField.getText();
            String hora = horaField.getText();
            int comensales = Integer.parseInt(comensalesField.getText());
            aplicacionReservas.hacerReserva(fecha, hora, comensales);
            actualizarReservasListView(reservasListView);
        });

        cancelarReservaButton.setOnAction(e -> {
            Reserva reservaSeleccionada = reservasListView.getSelectionModel().getSelectedItem();
            if (reservaSeleccionada != null) {
                aplicacionReservas.cancelarReserva(reservaSeleccionada);
                actualizarReservasListView(reservasListView);
            }
        });

        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(fechaLabel, fechaField, horaLabel,
                horaField, comensalesLabel, comensalesField,
                hacerReservaButton, cancelarReservaButton, reservasListView);


        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void actualizarReservasListView(ListView<Reserva> reservasListView) {
        reservasListView.getItems().clear();
        reservasListView.getItems().addAll(aplicacionReservas.listarReservas());
    }
}

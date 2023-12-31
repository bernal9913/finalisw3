package com.example.finalisw3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AplicacionReservasUI extends Application {
    private AplicacionReservas aplicacionReservas;
    private ListView<Reserva> reservasListView;
    private TextField nuevaFechaField;
    private TextField nuevaHoraField;
    private TextField nuevosComensalesField;


    public static void main(String[] args) {
        launch(args);
        RepositorioReservas repositorio = new RepositorioReservas();
        //ConsolaParaReservar.ejecutar(repositorio);
    }

    @Override
    public void start(Stage primaryStage) {
        aplicacionReservas = new AplicacionReservas();

        primaryStage.setTitle("Aplicación de Reservas");
        /*
        * Elementos generales de interfaz
        * */
        Label fechaLabel = new Label("Fecha: (YYYY-MM-DD)");
        TextField fechaField = new TextField();
        Label horaLabel = new Label("Hora: (HH:mm)");
        TextField horaField = new TextField();
        Label comensalesLabel = new Label("Comensales:");
        TextField comensalesField = new TextField();
        Label nombreLabel = new Label("Nombre del titular:");
        TextField nombreField = new TextField();

        Button hacerReservaButton = new Button("Hacer Reserva");
        Button cancelarReservaButton = new Button("Cancelar Reserva");
        Button modificarReservaButton = new Button("Modificar reserva");
        TextArea reservasTextArea = new TextArea();

        // regex chatgepetiadas porque no nos salen
        String fechaRegex = "\\d{4}-\\d{2}-\\d{2}";
        String horaRegex = "\\d{2}:\\d{2}";
        String comensalesRegex= "\\d+";
        // patrones para las regex
        Pattern fechaPattern = Pattern.compile(fechaRegex);
        Pattern horaPattern = Pattern.compile(horaRegex);
        Pattern comensalesPattern = Pattern.compile(comensalesRegex);

        // Eventos de cambio para los campos de fecha y hora
        fechaField.textProperty().addListener((observable, oldValue, newValue) -> {
            Matcher matcher = fechaPattern.matcher(newValue);
            if (!matcher.matches()) {
                fechaField.setStyle("-fx-border-color: red;");
            } else {
                fechaField.setStyle(""); // Restaurar el estilo por defecto
            }
        });

        horaField.textProperty().addListener((observable, oldValue, newValue) -> {
            Matcher matcher = horaPattern.matcher(newValue);
            if (!matcher.matches()) {
                horaField.setStyle("-fx-border-color: red;");
            } else {
                horaField.setStyle(""); // Restaurar el estilo por defecto
            }
        });
        comensalesField.textProperty().addListener((observable, oldValue, newValue) -> {
            Matcher matcher = comensalesPattern.matcher(newValue);
            if (!matcher.matches()) {
                comensalesField.setStyle("-fx-border-color: red;");
            } else {
                comensalesField.setStyle(""); // Restaurar el estilo por defecto
            }
        });
        /*
        * Parte de codigo para modificar la reservación
        * */
        nuevaFechaField = new TextField();
        nuevaHoraField = new TextField();
        nuevosComensalesField = new TextField();

        reservasListView = new ListView<>();
        reservasListView.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) { // Doble clic
                mostrarVentanaModificarReserva(reservasListView.getSelectionModel().getSelectedItem());
            }
        });

        hacerReservaButton.setOnAction(e -> {
            String fecha = fechaField.getText();
            String hora = horaField.getText();
            String comensalesStr = comensalesField.getText();
            String nombre = nombreField.getText();

            Matcher matcherFecha = fechaPattern.matcher(fecha);
            Matcher matcherHora = horaPattern.matcher(hora);
            Matcher matcherComensales = comensalesPattern.matcher(comensalesStr);

            if (matcherFecha.matches() && matcherHora.matches() && matcherComensales.matches()) {
                int comensales = Integer.parseInt(comensalesStr);
                aplicacionReservas.hacerReserva(fecha, hora, comensales, nombre);
                actualizarReservasListView(reservasListView);
            } else {
                // Aquí puedes mostrar un mensaje de error o actualizar la UI para reflejar que la entrada es inválida.
                showAlert("Error", "Por favor, ingresa la información en el formato correcto.");
            }
        });

        cancelarReservaButton.setOnAction(e -> {
            Reserva reservaSeleccionada = reservasListView.getSelectionModel().getSelectedItem();
            if (reservaSeleccionada != null) {
                aplicacionReservas.cancelarReserva(reservaSeleccionada);
                actualizarReservasListView(reservasListView);
            }
        });
        modificarReservaButton.setOnAction(event -> {
            Reserva reservaSeleccionada = reservasListView.getSelectionModel().getSelectedItem();
            if (reservaSeleccionada != null) {
                mostrarVentanaModificarReserva(reservaSeleccionada);
            }
        });
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(
                fechaLabel, fechaField,
                horaLabel, horaField,
                comensalesLabel, comensalesField,
                nombreLabel, nombreField,
                hacerReservaButton, cancelarReservaButton, reservasListView);


        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void actualizarReservasListView(ListView<Reserva> reservasListView) {
        reservasListView.getItems().clear();
        reservasListView.getItems().addAll(aplicacionReservas.listarReservas());
    }

    private void mostrarVentanaModificarReserva(Reserva reserva) {
        Stage ventanaModificarReserva = new Stage();
        ventanaModificarReserva.initModality(Modality.APPLICATION_MODAL);
        ventanaModificarReserva.setTitle("Modificar Reserva");

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(new Label("Nueva Fecha:"), new TextField(reserva.getFecha()),
                new Label("Nueva Hora:"), new TextField(reserva.getHora()),
                new Label("Nuevos Comensales:"), new TextField(String.valueOf(reserva.getComensales())),
                new Label("Nuevo titular:"), new TextField(reserva.getNombreTitular()));

        /*
        * new Button("Guardar Cambios", new EventHandler<ActionEvent>() {
        *   @Override
        *   public void handle(ActionEvent event) {
        *       modificarReserva(reserva, ((TextField) vbox.getChildren().get(1)).getText(),
        *           ((TextField) vbox.getChildren().get(3)).getText(),
        *           Integer.parseInt(((TextField) vbox.getChildren().get(5)).getText()));
        *       ventanaModificarReserva.close();
                }
            });
        * */
        Button guardarCambiosButton = new Button("Guardar Cambios");
        guardarCambiosButton.setOnAction(event -> {
            modificarReserva(reserva, ((TextField) vbox.getChildren().get(1)).getText(),
                    ((TextField) vbox.getChildren().get(3)).getText(),
                    Integer.parseInt(((TextField) vbox.getChildren().get(5)).getText()),
                    ((TextField) vbox.getChildren().get(7)).getText());
            ventanaModificarReserva.close();
        });

        vbox.getChildren().add(guardarCambiosButton);

        Scene scene = new Scene(vbox, 500, 500);
        ventanaModificarReserva.setScene(scene);
        ventanaModificarReserva.showAndWait();
    }
    private void modificarReserva(Reserva reservaAntigua,
                                  String nuevaFecha,
                                  String nuevaHora,
                                  int nuevosComensales,
                                  String nuevoTitular) {

        aplicacionReservas.modificarReserva(reservaAntigua, nuevaFecha, nuevaHora, nuevosComensales, nuevoTitular);
        actualizarReservasListView(reservasListView);
    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}

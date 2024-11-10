package com.dpm.juegofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author danielpm.dev
 */
public class InicioControlador {
    public Button btIniciar;
    public TextField tfJugador1;
    public TextField tfJugador2;

    private String nombreJugador1;
    private String nombreJugador2;

    // Función para manejar el inicio del juego
    public void accionIniciar(ActionEvent actionEvent) {
        // Establecer los nombres de los jugadores
        setNombreJugador1(tfJugador1.getText());
        setNombreJugador2(tfJugador2.getText());

        // Lanzar ventana del juego
        try {
            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("juego.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la nueva ventana
            JuegoControlador juegoControlador = loader.getController();

            // Pasar los nombres de los jugadores al controlador del juego
            juegoControlador.setNombresJugadores(nombreJugador1, nombreJugador2);

            // Crear el nuevo escenario (ventana)
            Stage stage = new Stage();
            Scene scene = new Scene(root, 750, 450);
            stage.setScene(scene);
            stage.setTitle("Juego de Tres en Raya");
            scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());

            // Hacer que la ventana sea modal (bloquea la ventana principal)
            stage.initModality(Modality.APPLICATION_MODAL);

            // Mostrar la ventana
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setNombreJugador1(String nombreJugador1) {
        this.nombreJugador1 = (nombreJugador1.isEmpty()) ? "Jugador 1" : nombreJugador1;
    }

    public void setNombreJugador2(String nombreJugador2) {
        this.nombreJugador2 = (nombreJugador2.isEmpty()) ? "Jugador 2" : nombreJugador2;
    }

    public String getNombreJugador1() {
        return nombreJugador1;
    }

    public String getNombreJugador2() {
        return nombreJugador2;
    }
}


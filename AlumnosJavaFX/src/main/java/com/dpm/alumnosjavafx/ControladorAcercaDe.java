package com.dpm.alumnosjavafx;

import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author danielpm.dev
 */
public class ControladorAcercaDe {

    public Button btSalir;
    public ImageView imgLinkedin;
    public ImageView imgGithub;
    public Button btCopy;
    public Label lCorreo;

    @FXML
    private void initialize() {
        addHoverEffect(imgGithub);
        addHoverEffect(imgLinkedin);
    }

    private void addHoverEffect(ImageView imageView) {
        imageView.setOnMouseEntered(e -> {
            imageView.setScaleX(1.2);
            imageView.setScaleY(1.2);
        });

        imageView.setOnMouseExited(e -> {
            imageView.setScaleX(1.0);
            imageView.setScaleY(1.0);
            imageView.setEffect(null);
        });
    }

    public void accionSalir(ActionEvent actionEvent) {
        // Lógica para cerrar la ventana modal o salir
        Stage stage = (Stage) btSalir.getScene().getWindow();
        stage.close();
    }

    public void accionAbrir(MouseEvent mouseEvent) {
        // Determinar qué imagen fue clickeada
        Object source = mouseEvent.getSource();

        String url = null;

        if (source == imgGithub) {
            url = "https://github.com/DanielPMdev"; // Cambia por tu URL de GitHub
        } else if (source == imgLinkedin) {
            url = "https://www.linkedin.com/in/danielpmdev/"; // Cambia por tu URL de LinkedIn
        }

        if (url != null) {
            animarClick((ImageView) source, url);
        }
    }

    private void animarClick(ImageView imageView, String url) {
        // Crear la animación de escala para el clic
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(150), imageView);
        scaleTransition.setFromX(1.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(1.2); // Aumentar el tamaño un poco
        scaleTransition.setToY(1.2);
        scaleTransition.setAutoReverse(true); // Volver a tamaño original
        scaleTransition.setCycleCount(2); // Escalar y volver

        // Al finalizar la animación, abrir el navegador
        scaleTransition.setOnFinished(event -> abrirEnNavegador(url));
        scaleTransition.play();
    }

    private void abrirEnNavegador(String url) {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("win")) {
                // Para Windows, intenta abrir la URL con Desktop
                Desktop.getDesktop().browse(new URI(url));
            } else if (os.contains("mac")) {
                // Para macOS
                Runtime.getRuntime().exec(new String[]{"open", url});
            } else if (os.contains("nix") || os.contains("nux")) {
                // Para Linux
                Runtime.getRuntime().exec(new String[]{"xdg-open", url});
            } else {
                System.err.println("Sistema operativo no soportado para esta operación.");
            }
        } catch (IOException | URISyntaxException e) {
            System.err.println("Error al intentar abrir el navegador: " + e.getMessage());
        }
    }

    public void accionCopy(ActionEvent actionEvent) {
        // Crear un objeto Clipboard para acceder al portapapeles del sistema
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent contenido = new ClipboardContent();

        // Establecer el texto que deseas copiar
        contenido.putString(lCorreo.getText());

        // Poner el contenido en el portapapeles
        clipboard.setContent(contenido);

        JOptionPane.showMessageDialog(null, "Texto copiado correctamente al Portapapeles");
    }

//    private void abrirEnNavegador(String url) {
//        String navegador = "firefox"; // Cambia "firefox" si prefieres otro navegador
//        try {
//            // Ejecuta el comando para abrir la URL con el navegador especificado
//            Runtime.getRuntime().exec(new String[]{navegador, url});
//        } catch (IOException e) {
//            System.err.println("Error al intentar abrir el navegador: " + e.getMessage());
//        }
//    }

//    private void abrirEnNavegador(String url) {
//        if (Desktop.isDesktopSupported()) {
//            Platform.runLater(() -> {
//                try {
//                    Desktop.getDesktop().browse(new URI(url));
//                } catch (IOException e) {
//                    System.err.println("Error al intentar abrir el navegador: " + e.getMessage());
//                } catch (URISyntaxException e) {
//                    System.err.println("URL no válida: " + e.getMessage());
//                }
//            });
//        } else {
//            System.err.println("Desktop no soportado en este sistema.");
//        }
//    }
}

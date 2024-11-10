package com.dpm.juegofx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JuegoControlador {
    public GridPane gridpanel;
    public Label txInfo;
    public Label lbTiempo;
    public Button btReload;
    public Button btUndo;
    public Button btEnd;

    //FILA 0
    public Button bt00;
    public Button bt01;
    public Button bt02;

    //FILA 1
    public Button bt10;
    public Button bt11;
    public Button bt12;

    //FILA 2
    public Button bt20;
    public Button bt21;
    public Button bt22;

    //TABLERO
    public Button[][] casillas = {
            {bt00, bt01, bt02},
            {bt10, bt11, bt12},
            {bt20, bt21, bt22}
    };

    private String nombreJugador1;
    private String nombreJugador2;
    private int turno = 1; // 1 para Jugador 1 (X), 2 para Jugador 2 (O)

    //TEMPORIZADOR
    private int tiempoRestante;
    private int tiempoGuardado;
    private Timeline timeline;

    private int ultimoFila = -1;
    private int ultimoColumna = -1;
    private boolean juegoAcabado = false;

    // Función para establecer los nombres de los jugadores
    public void setNombresJugadores(String nombreJugador1, String nombreJugador2) {
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;

        // Verifica que los nombres no sean null y muestra el nombre del jugador actual
        if (nombreJugador1 != null) {
            txInfo.setText("Turno de " + nombreJugador1 + " (X)");
        } else {
            txInfo.setText("Turno de Jugador 1 (X)"); // Valor predeterminado si no se pasaron los nombres
        }
    }

    public void initialize() {
        // Inicializa el tablero de botones
        casillas = new Button[][]{
                {bt00, bt01, bt02},
                {bt10, bt11, bt12},
                {bt20, bt21, bt22}
        };

        tiempoRestante = 30;
        lbTiempo.setText("Tiempo: " + tiempoRestante + "s"); // Inicializa el Label
        iniciarJuego();
    }

    public void accionMovimiento(ActionEvent actionEvent) {
        Button botonPresionado = (Button) actionEvent.getSource();

        if (!juegoAcabado) {
            // Encuentra la posición del botón en el tablero
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (casillas[i][j] == botonPresionado) {
                        hacerMovimiento(i, j);
                        return;
                    }
                }
            }
        }
    }

    private void hacerMovimiento(int fila, int columna) {
        if (casillas[fila][columna].getText().isEmpty()) {
            casillas[fila][columna].setText(turno == 1 ? "X" : "O");

            // Guarda la posición del último movimiento
            ultimoFila = fila;
            ultimoColumna = columna;

            // Cambia el turno y actualiza la información
            turno = turno == 1 ? 2 : 1;
            tiempoRestante = 30;

            if (turno == 1) {
                txInfo.setText("Turno de " + nombreJugador1 + " (X)");
            } else {
                txInfo.setText("Turno de " + nombreJugador2 + " (O)");
            }

            int ganador = comprobarGanador();
            if (ganador != 0) {
                mostrarGanador(ganador);
            }
        }
    }

    private int comprobarGanador() {
        // Comprobar filas
        for (int i = 0; i < 3; i++) {
            if (!casillas[i][0].getText().isEmpty() &&
                    casillas[i][0].getText().equals(casillas[i][1].getText()) &&
                    casillas[i][0].getText().equals(casillas[i][2].getText())) {
                return casillas[i][0].getText().equals("X") ? 1 : 2;
            }
        }

        // Comprobar columnas
        for (int j = 0; j < 3; j++) {
            if (!casillas[0][j].getText().isEmpty() &&
                    casillas[0][j].getText().equals(casillas[1][j].getText()) &&
                    casillas[0][j].getText().equals(casillas[2][j].getText())) {
                return casillas[0][j].getText().equals("X") ? 1 : 2;
            }
        }

        // Comprobar diagonales
        if (!casillas[0][0].getText().isEmpty() &&
                casillas[0][0].getText().equals(casillas[1][1].getText()) &&
                casillas[0][0].getText().equals(casillas[2][2].getText())) {
            return casillas[0][0].getText().equals("X") ? 1 : 2;
        }
        if (!casillas[0][2].getText().isEmpty() &&
                casillas[0][2].getText().equals(casillas[1][1].getText()) &&
                casillas[0][2].getText().equals(casillas[2][0].getText())) {
            return casillas[0][2].getText().equals("X") ? 1 : 2;
        }

        // Comprueba si hay un empate
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (casillas[i][j].getText().isEmpty()) {
                    return 0; // El juego continúa
                }
            }
        }
        return -1; // Empate
    }

    private void mostrarGanador(int ganador) {
        juegoAcabado = true;
        pausarTemporizador();

        // Determina la línea ganadora y agrega la clase CSS a los botones ganadores
        if (ganador == 1 || ganador == 2) {
            if (casillas[0][0].getText().equals(casillas[0][1].getText()) && casillas[0][0].getText().equals(casillas[0][2].getText())) {
                marcarLineaGanadora(casillas[0][0], casillas[0][1], casillas[0][2]);
            } else if (casillas[1][0].getText().equals(casillas[1][1].getText()) && casillas[1][0].getText().equals(casillas[1][2].getText())) {
                marcarLineaGanadora(casillas[1][0], casillas[1][1], casillas[1][2]);
            } else if (casillas[2][0].getText().equals(casillas[2][1].getText()) && casillas[2][0].getText().equals(casillas[2][2].getText())) {
                marcarLineaGanadora(casillas[2][0], casillas[2][1], casillas[2][2]);
            } else if (casillas[0][0].getText().equals(casillas[1][0].getText()) && casillas[0][0].getText().equals(casillas[2][0].getText())) {
                marcarLineaGanadora(casillas[0][0], casillas[1][0], casillas[2][0]);
            } else if (casillas[0][1].getText().equals(casillas[1][1].getText()) && casillas[0][1].getText().equals(casillas[2][1].getText())) {
                marcarLineaGanadora(casillas[0][1], casillas[1][1], casillas[2][1]);
            } else if (casillas[0][2].getText().equals(casillas[1][2].getText()) && casillas[0][2].getText().equals(casillas[2][2].getText())) {
                marcarLineaGanadora(casillas[0][2], casillas[1][2], casillas[2][2]);
            } else if (casillas[0][0].getText().equals(casillas[1][1].getText()) && casillas[0][0].getText().equals(casillas[2][2].getText())) {
                marcarLineaGanadora(casillas[0][0], casillas[1][1], casillas[2][2]);
            } else if (casillas[0][2].getText().equals(casillas[1][1].getText()) && casillas[0][2].getText().equals(casillas[2][0].getText())) {
                marcarLineaGanadora(casillas[0][2], casillas[1][1], casillas[2][0]);
            }

            if (ganador == 1){
                txInfo.setText("¡" + nombreJugador1 + " gana!");
            }else {
                txInfo.setText("¡" + nombreJugador2 + " gana!");
            }

        } else {
            txInfo.setText("¡Los jugadores han EMPATADO!");
        }
    }

    private void marcarLineaGanadora(Button... botones) {
        // Marcar los botones ganadores con un estilo específico
        for (Button boton : botones) {
            boton.getStyleClass().add("boton-ganador");
        }
    }

    public void accionUndo(ActionEvent actionEvent) {
        juegoAcabado = false;
        reanudarTemporizador();

        if (ultimoFila != -1 && ultimoColumna != -1) {

            // Eliminar el estilo CSS de los botones ganadores
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    casillas[i][j].getStyleClass().remove("boton-ganador");
                }
            }

            casillas[ultimoFila][ultimoColumna].setText(""); // Borra el último movimiento
            turno = turno == 1 ? 2 : 1; // Cambia el turno de nuevo

            if (turno == 1) {
                txInfo.setText("Turno de " + nombreJugador1 + " (X)");
            } else {
                txInfo.setText("Turno de " + nombreJugador2 + " (O)");
            }

            // Reinicia el último movimiento
            ultimoFila = -1;
            ultimoColumna = -1;
        }
    }

    public void accionReload(ActionEvent actionEvent) {
        juegoAcabado = false;
        tiempoRestante = 30;  // Reinicia el tiempo
        lbTiempo.setText("Tiempo: " + tiempoRestante + "s");  // Actualiza el Label de tiempo

        // Detener el temporizador actual si está en marcha
        if (timeline != null) {
            timeline.stop();
        }

        // Reinicia el temporizador
        iniciarTemporizador();  // Vuelve a iniciar el temporizador con el tiempo restante

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casillas[i][j].getStyleClass().remove("boton-ganador");
                casillas[i][j].setText(""); // Limpia cada botón
            }
        }
        turno = 1; // Reinicia el turno al jugador 1
        txInfo.setText("Turno de " + nombreJugador1 + " (X)");
        ultimoFila = -1;
        ultimoColumna = -1;
    }

    public void accionEnd(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close(); // Cierra la ventana del juego
    }

    public void iniciarTemporizador() {
        // Crear un Timeline para contar los segundos
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
                    // Reducir el tiempo restante
                    tiempoRestante--;
                    lbTiempo.setText("Tiempo: " + tiempoRestante + "s");

                    // Verificar si se acabó el tiempo
                    if (tiempoRestante <= 0) {
                        // Detener el temporizador
                        timeline.stop();
                        // Aquí puedes colocar el código para finalizar el juego o hacer algo más
                        lbTiempo.setText("¡Tiempo agotado!");

                        //Damos por acabado el juego
                        juegoAcabado = true;
                    }
                })
        );

        timeline.setCycleCount(Timeline.INDEFINITE); // El temporizador se repetirá indefinidamente cada segundo
        timeline.play();  // Iniciar el temporizador
    }

    // Función para pausar el temporizador y guardar el tiempo restante
    public void pausarTemporizador() {
        tiempoGuardado = tiempoRestante;  // Guardar el tiempo restante
        timeline.pause();  // Pausar el temporizador
    }

    // Función para reanudar el temporizador desde el tiempo guardado
    public void reanudarTemporizador() {
        tiempoRestante = tiempoGuardado;  // Restaurar el tiempo guardado
        lbTiempo.setText("Tiempo: " + tiempoRestante + "s");
        timeline.play();  // Reanudar el temporizador
    }

    public void iniciarJuego() {
        tiempoRestante = 30;  // Reiniciar el tiempo
        lbTiempo.setText("Tiempo: " + tiempoRestante + "s");
        iniciarTemporizador();
    }
}

/*
private void mostrarGanador(int ganador) {
        juegoAcabado = true;
        if (ganador == 1) {
            txInfo.setText("¡Jugador 1 (X) gana!");
        } else if (ganador == 2) {
            txInfo.setText("¡Jugador 2 (O) gana!");
        } else {
            txInfo.setText("¡Los jugadores han EMPATADO!");
        }
    }
 */
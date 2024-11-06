package com.dpm.alumnosjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Gestor de Alumnos en JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
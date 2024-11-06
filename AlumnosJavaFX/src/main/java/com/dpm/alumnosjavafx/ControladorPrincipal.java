package com.dpm.alumnosjavafx;

import com.dpm.herramientas.SimpleCSVReader;
import com.dpm.herramientas.SimpleCSVWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author danielpm.dev
 */
public class ControladorPrincipal {

    public MenuItem miAcerca;
    public MenuItem miCargar;
    public MenuItem miGuardar;
    public MenuItem miSalir;
    public Button lanzarTabla;
    public Button lanzarLista;

    private List<Alumno> listaAlumnos = new ArrayList();
    SimpleCSVReader lector = new SimpleCSVReader();
    SimpleCSVWriter escritor = new SimpleCSVWriter();
    private final static String RUTA_IMPORTAR = "./src/archivos/importar.csv";
    private final static String RUTA_EXPORTAR = "./src/archivos/resultado.csv";

    public void accionCargar(ActionEvent actionEvent) {
        this.listaAlumnos = lector.cargarAlumnosDesdeCSV(RUTA_IMPORTAR);

        if (!listaAlumnos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se han cargado " + listaAlumnos.size() + " alumnos correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se han podido cargar los datos. La lista está vacía.");
        }
    }

    public void accionGuardar(ActionEvent actionEvent) {
        boolean exportacionExitosa = escritor.exportarAlumnosCSV(listaAlumnos, RUTA_EXPORTAR);

        // Mostrar mensaje según el resultado de la exportación
        if (exportacionExitosa) {
            JOptionPane.showMessageDialog(null, "Exportación a CSV completada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al exportar a CSV.");
        }
    }

    public void accionSalir(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void lanzarAcerca(ActionEvent actionEvent) {
        try {
            // Cargar el archivo FXML desde la ruta correcta
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dpm/alumnosjavafx/acercade.fxml"));
            Parent root = loader.load();

            // Crear una nueva ventana (Stage)
            Stage modalStage = new Stage();
            modalStage.initModality(Modality.APPLICATION_MODAL); // Establecer la modalidad como modal
            modalStage.setTitle("Acerca de");
            modalStage.setScene(new Scene(root)); // Establecer la escena con el contenido cargado

            // Mostrar la ventana modal
            modalStage.showAndWait(); // Esperar a que se cierre la ventana
        } catch (IOException e) {
            e.printStackTrace(); // Manejar la excepción de carga del FXML
        }
    }

    public void accionTabla(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dpm/alumnosjavafx/tabla.fxml"));
            Parent root = loader.load();

            // Obtener el controlador del archivo FXML
            ControladorTabla controladorTabla = loader.getController();

            // Pasar la lista de alumnos al ControladorTabla
            controladorTabla.setListaAlumnos(this.listaAlumnos);

            // Configurar y mostrar la ventana de la tabla
            Stage modalStage = new Stage();
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.setTitle("Vista tabla de Gestión Alumnos");
            modalStage.setScene(new Scene(root));

            // Esperar a que la ventana se cierre
            modalStage.showAndWait();

            // Recuperar la lista de alumnos actualizada
            this.listaAlumnos = controladorTabla.getListaAlumnos();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void accionLista(ActionEvent actionEvent) {
        try {
            // Cargar el archivo FXML desde la ruta correcta
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dpm/alumnosjavafx/lista.fxml"));
            Parent root = loader.load();

            // Obtener el controlador del archivo FXML
            ControladorLista controladorLista = loader.getController();

            // Pasar la lista de alumnos al ControladorLista
            controladorLista.setListaAlumnos(this.listaAlumnos);

            // Crear una nueva ventana (Stage)
            Stage modalStage = new Stage();
            modalStage.initModality(Modality.APPLICATION_MODAL); // Establecer la modalidad como modal
            modalStage.setTitle("Vista tabla de Gestión Alumnos");
            modalStage.setScene(new Scene(root)); // Establecer la escena con el contenido cargado

            // Mostrar la ventana modal
            modalStage.showAndWait(); // Esperar a que se cierre la ventana

            // Recuperar la lista de alumnos actualizada
            this.listaAlumnos = controladorLista.getListaAlumnos();

        } catch (IOException e) {
            e.printStackTrace(); // Manejar la excepción de carga del FXML
        }
    }

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
}

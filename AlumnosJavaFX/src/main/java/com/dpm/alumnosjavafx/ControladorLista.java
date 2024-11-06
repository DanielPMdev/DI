package com.dpm.alumnosjavafx;

import com.dpm.herramientas.SimpleCSVReader;
import com.dpm.herramientas.SimpleCSVWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
public class ControladorLista {

    public MenuItem miCargar;
    public MenuItem miGuardar;
    public MenuItem miSalir;
    public MenuItem miAcerca;
    public Button btImportar;
    public Button btExportar;
    public ListView listaContenido;

    //Variables fuera de la Ventana
    private List<Alumno> listaAlumnos = new ArrayList();
    private ObservableList<Alumno> tListaAlumnos = FXCollections.observableArrayList();
    //private ObservableList<Alumno> tListaAlumnos = FXCollections.observableArrayList(listaAlumnos); // ObservableList para el TableView
    SimpleCSVReader lector = new SimpleCSVReader();
    SimpleCSVWriter escritor = new SimpleCSVWriter();
    private final static String RUTA_IMPORTAR = "./src/archivos/importar.csv";
    private final static String RUTA_EXPORTAR = "./src/archivos/resultado.csv";

    @FXML
    private void initialize() {
        // Vincula el ObservableList al ListView
        listaContenido.setItems(tListaAlumnos);
    }

    public void accionCargar(ActionEvent actionEvent) {
        this.listaAlumnos = lector.cargarAlumnosDesdeCSV(RUTA_IMPORTAR);

        if (!listaAlumnos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se han cargado " + listaAlumnos.size() + " alumnos correctamente.");
            tListaAlumnos.setAll(listaAlumnos); // Actualizar el ObservableList
            this.listaContenido.setItems(tListaAlumnos);
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

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
        this.tListaAlumnos.setAll(listaAlumnos); // Cargar los datos en el ObservableList
    }
}

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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorTabla {

    public TableView tablaContenido;

    @FXML
    private TableColumn<Alumno, String> columnaNombre;
    @FXML
    private TableColumn<Alumno, String> columnaApellidos;
    @FXML
    private TableColumn<Alumno, String> columnaPoblacion;
    @FXML
    private TableColumn<Alumno, String> columnaCurso;
    @FXML
    private TableColumn<Alumno, String> columnaEmail;
    @FXML
    private TableColumn<Alumno, LocalDate> columnaMatricula;
    @FXML
    private TableColumn<Alumno, Boolean> columnaCarnet;

    public TextField txfNombre;
    public TextField txfApellidos;
    public TextField txfPoblacion;
    public ComboBox<String> cbCurso; // Especifica que es un ComboBox de String
    public TextField txfEmail;
    public DatePicker dpMatricula;
    public RadioButton rbSi;
    public RadioButton rbNo;

    public Button btNuevo;
    public Button btEdit;
    public Button btDelete;
    public Button btLimpiar;

    public MenuItem miCargar;
    public MenuItem miGuardar;
    public MenuItem miSalir;

    //Variables fuera de la Ventana
    private List<Alumno> listaAlumnos = new ArrayList();
    private ObservableList<Alumno> tListaAlumnos = FXCollections.observableArrayList(listaAlumnos); // ObservableList para el TableView
    SimpleCSVReader lector = new SimpleCSVReader();
    SimpleCSVWriter escritor = new SimpleCSVWriter();
    private final static String RUTA_IMPORTAR = "./src/archivos/importar.csv";
    private final static String RUTA_EXPORTAR = "./src/archivos/resultado.csv";

    @FXML
    private void initialize() {
        // Configura las columnas para mostrar los datos correctos
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        columnaPoblacion.setCellValueFactory(new PropertyValueFactory<>("poblacion"));
        columnaCurso.setCellValueFactory(new PropertyValueFactory<>("curso"));
        columnaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnaMatricula.setCellValueFactory(new PropertyValueFactory<>("fechaMatricula"));
        columnaCarnet.setCellValueFactory(new PropertyValueFactory<>("carnet"));

        // Establecer la lista de alumnos en la tabla
        tablaContenido.setItems(tListaAlumnos);

        // Agregar el listener para la selección de filas
        tablaContenido.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                cargarDatosEnInputs((Alumno) newValue);
            }
        });
    }

    public ControladorTabla() {
    }

    public void accionCargar(ActionEvent actionEvent) {
        this.listaAlumnos = lector.cargarAlumnosDesdeCSV(RUTA_IMPORTAR);

        if (!listaAlumnos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se han cargado " + listaAlumnos.size() + " alumnos correctamente.");
            tListaAlumnos.setAll(listaAlumnos); // Actualizar el ObservableList
            this.tablaContenido.setItems(tListaAlumnos);
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

    public void accionNuevo(ActionEvent actionEvent) {
        // Capturar datos del formulario
        String nombre = txfNombre.getText().trim();
        String apellidos = txfApellidos.getText().trim();
        String poblacion = txfPoblacion.getText().trim();
        String curso = cbCurso.getValue();
        String email = txfEmail.getText().trim();
        LocalDate matricula = dpMatricula.getValue();
        boolean carnet = rbSi.isSelected();

        // Validaciones
        if (nombre.isEmpty() || apellidos.isEmpty() || poblacion.isEmpty() || curso == null || email.isEmpty() || matricula == null) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return; // Salir del método si hay campos vacíos
        }

        int posicion = this.posicionContacto(nombre);
        if (posicion == -1) { // Si NO lo encuentra lo añade
            // Crear un nuevo alumno y agregarlo a la lista
            Alumno nuevoAlumno = new Alumno(nombre, apellidos, poblacion, curso, email, matricula, carnet);
            listaAlumnos.add(nuevoAlumno);
            tListaAlumnos.setAll(listaAlumnos); // Actualizar el ObservableList
            this.tablaContenido.setItems(tListaAlumnos);
            JOptionPane.showMessageDialog(null, "Alumno añadido correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El alumno ya existe.");
        }

        limpiarCampos();
    }

    public void accionEdit(ActionEvent actionEvent) {
        // Capturar datos del formulario
        String nombre = txfNombre.getText().trim();
        String apellidos = txfApellidos.getText().trim();
        String poblacion = txfPoblacion.getText().trim();
        String curso = cbCurso.getValue();
        String email = txfEmail.getText().trim();
        LocalDate matricula = dpMatricula.getValue();
        boolean carnet = rbSi.isSelected();

        // Validaciones
        if (nombre.isEmpty() || apellidos.isEmpty() || poblacion.isEmpty() || curso == null || email.isEmpty() || matricula == null) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return; // Salir del método si hay campos vacíos
        }

        int posicion = this.posicionContacto(nombre);
        if (posicion != -1) { // Si encuentra el alumno, lo edita
            Alumno alumno = listaAlumnos.get(posicion);
            alumno.setNombre(nombre);
            alumno.setApellidos(apellidos);
            alumno.setPoblacion(poblacion);
            alumno.setCurso(curso);
            alumno.setEmail(email);
            alumno.setFechaMatricula(matricula);
            alumno.setCarnet(carnet);

            // Actualizar el ObservableList
            tListaAlumnos.setAll(listaAlumnos);
            this.tablaContenido.setItems(tListaAlumnos);
            JOptionPane.showMessageDialog(null, "Alumno editado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El alumno no existe.");
        }

        limpiarCampos();
    }

    public void accionDelete(ActionEvent actionEvent) {
        String nombre = txfNombre.getText().trim();
        int posicion = this.posicionContacto(nombre);

        if (posicion != -1) { // Si lo encuentra, lo borra
            listaAlumnos.remove(posicion);
            tListaAlumnos.setAll(listaAlumnos); // Actualizar el ObservableList
            this.tablaContenido.setItems(tListaAlumnos);
            JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El alumno no existe.");
        }

        limpiarCampos();
    }

    public void accionLimpiar(ActionEvent actionEvent) {
        limpiarCampos();
    }

    private void limpiarCampos() {
        // Limpiar campos después de agregar
        txfNombre.clear();
        txfApellidos.clear();
        txfPoblacion.clear();
        cbCurso.setValue("1º DAM");
        txfEmail.clear();
        dpMatricula.setValue(null);
        rbSi.setSelected(false);
        rbNo.setSelected(true);
    }

    private void cargarDatosEnInputs(Alumno alumno) {
        txfNombre.setText(alumno.getNombre());
        txfApellidos.setText(alumno.getApellidos());
        txfPoblacion.setText(alumno.getPoblacion());
        cbCurso.setValue(alumno.getCurso());
        txfEmail.setText(alumno.getEmail());
        dpMatricula.setValue(alumno.getFechaMatricula()); // Asegúrate de que sea un LocalDate
        if (alumno.isCarnet()) {
            rbSi.setSelected(true);
            rbNo.setSelected(false);
        } else {
            rbSi.setSelected(false);
            rbNo.setSelected(true);
        }
    }

    private int posicionContacto(String n) {
        if (listaAlumnos == null || listaAlumnos.isEmpty()) {
            return -1; // La lista está vacía o no inicializada
        }

        // Recorremos la lista buscando el alumno por su nombre
        for (int i = 0; i < listaAlumnos.size(); i++) {
            Alumno alumno = listaAlumnos.get(i);
            if (alumno.getNombre().equals(n)) {
                return i; // Devuelve el índice si el nombre coincide
            }
        }

        return -1; // No se encontró el alumno
    }

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
        this.tListaAlumnos.setAll(listaAlumnos); // Actualizar el ObservableList para el TableView
        this.tablaContenido.setItems(tListaAlumnos); // Establecer los datos en la tabla
    }
}
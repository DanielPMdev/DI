package com.dpm.herramientas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.dpm.alumnosjavafx.Alumno;

/**
 * @author danielpm.dev
 */
public class SimpleCSVWriter {
    public boolean exportarAlumnosCSV(List<Alumno> listaAlumnos, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // Escribir la cabecera del CSV
            writer.write("Nombre;Apellidos;Poblacion;Curso;Email;FechaMatricula;Carnet");
            writer.newLine();

            // Recorrer la lista de alumnos y escribir cada uno en el archivo
            for (Alumno alumno : listaAlumnos) {
                String linea = String.join(";",
                        alumno.getNombre(),
                        alumno.getApellidos(),
                        alumno.getPoblacion(),
                        alumno.getCurso(),
                        alumno.getEmail(),
                        alumno.getFechaMatricula().toString(),
                        Boolean.toString(alumno.isCarnet())
                );
                writer.write(linea);
                writer.newLine();
            }

            //System.out.println("Exportación a CSV completada con éxito.");
            return true;

        } catch (IOException e) {
            System.err.println("Error al exportar a CSV: " + e.getMessage());
            return false; // Exportación fallida
        }
    }
}

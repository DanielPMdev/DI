package com.dpm.herramientas;

import com.dpm.alumnosjavafx.Alumno;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author danielpm.dev
 */
public class SimpleCSVReader {

    public List<Alumno> cargarAlumnosDesdeCSV(String rutaArchivo) {
        List<Alumno> listaAlumnos = new ArrayList<>();

        String linea;
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // Leer la primera línea (cabecera) y descartarla
            br.readLine();

            // Leer las siguientes líneas con los datos
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                String nombre = datos[0];
                String apellidos = datos[1];
                String poblacion = datos[2];
                String curso = datos[3];
                String email = datos[4];
                String fechaMatricula = datos[5]; // Fecha como String
                boolean carnet = Boolean.parseBoolean(datos[6]);

                Alumno alumno = new Alumno(nombre, apellidos, poblacion, curso, email, fechaMatricula, carnet);
                listaAlumnos.add(alumno);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaAlumnos;
    }
}
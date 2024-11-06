/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dmp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import Modelo.Alumno;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author DanielPM.dev
 */
public class SimpleCSVWriter {
    public boolean exportarAlumnosACSV(List<Alumno> listaAlumnos, String rutaArchivo) {
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
                        alumno.getFechaMatricula(),
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

    private List<Alumno> generaListaAlumnos() {
        List<Alumno> listaAlumnos = new ArrayList();
        Alumno alum1 = new Alumno();
        alum1.setNombre("Ana");
        alum1.setApellidos("Alvarez");
        alum1.setPoblacion("Alcázar");
        alum1.setCurso("1");
        listaAlumnos.add(alum1);

//        Alumno alum2 = new Alumno();
//        alum2.setNombre("Berto");
//        alum2.setApellidos("Benito");
//        alum2.setPoblacion("Badajoz");
//        alum2.setCurso("1");
//        listaAlumnos.add(alum2);
//        
//        Alumno alum3 = new Alumno();
//        alum3.setNombre("Eduardo");
//        alum3.setApellidos("Estevez");
//        alum3.setPoblacion("Ecija");
//        alum3.setCurso("2");
//        listaAlumnos.add(alum3);
//        
//        Alumno alum4 = new Alumno();
//        alum4.setNombre("Pedro");
//        alum4.setApellidos("Perez");
//        alum4.setPoblacion("Palencia");
//        alum4.setCurso("1");
//        listaAlumnos.add(alum4);
//        
//        Alumno alum5 = new Alumno();
//        alum5.setNombre("Rosa");
//        alum5.setApellidos("Rivas");
//        alum5.setPoblacion("Roma");
//        alum5.setCurso("2");
//        listaAlumnos.add(alum5);
        return listaAlumnos;
    }

    /*
    public static void main(String[] args) {
        SimpleCSVWriter simpleCsvWriter = new SimpleCSVWriter();
        try {
            simpleCsvWriter.writeToFile("./src/elemento/DATA2.CSV");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
     */
}

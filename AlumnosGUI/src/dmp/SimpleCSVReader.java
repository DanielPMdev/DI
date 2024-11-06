/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dmp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import Modelo.Alumno;
import java.io.IOException;
// el package elemento contiene el "ESQUEMA" del objeto Alumno

 
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
    
    /*
    public static void main(String[] args) {
        SimpleCSVReader simpleCsvReader = new SimpleCSVReader();
        try {
            List<AlumnoDetalle> listaAlumnos = simpleCsvReader.readCsvFile("./src/elemento/DATA.CSV");
            System.out.println("=========================== Detalle Alumnos ====================");
            listaAlumnos.stream().forEach((alum) -> {
                System.out.println("Nombre    = " + alum.getNombre());
                System.out.println("Apellidos = " + alum.getApellidos());
                System.out.println("Poblacion = " + alum.getPoblacion());
                System.out.println("Curso     = " + alum.getCurso());
                System.out.println("--------------------------------------------------------------");
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    */

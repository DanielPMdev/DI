/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author DanielPM.dev
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Alumno {

    private String nombre;
    private String apellidos;
    private String poblacion;
    private String curso;
    private String email;
    private LocalDate fechaMatricula;
    private boolean carnet;

    // Expresión regular para validar el email
    private static final String EMAIL_PATTERN
            = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@"
            + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Constructor vacío
    public Alumno() {
    }

    // Constructor con parámetros
    public Alumno(String nombre, String apellidos, String poblacion, String curso, String email, String fechaMatricula, boolean carnet) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.poblacion = poblacion;
        this.curso = curso;
        setEmail(email);  // Validación del email en el setter
        setFechaMatricula(fechaMatricula); //Validación de la matricula en el setter
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String ape) {
        this.apellidos = ape;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String pob) {
        this.poblacion = pob;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String cur) {
        this.curso = cur;
    }    

    public boolean isCarnet() {
        return carnet;
    }

    public void setCarnet(boolean carnet) {
        this.carnet = carnet;
    }        
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email no válido");
        }
    }
    
    public String getFechaMatricula() {
        return fechaMatricula.format(DATE_FORMATTER);  // Formatear a String
    }

    public void setFechaMatricula(String fechaDeMatricula) {
        try {
            this.fechaMatricula = LocalDate.parse(fechaDeMatricula, DATE_FORMATTER);  // Parseo de String a LocalDate
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Debe ser dd/MM/yyyy.");
        }
    }
    
    // Método para validar el email
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }    
    
    // Sobreescribir el método toString()
    @Override
    public String toString() {
        return "AlumnoDetalle {"
                + "nombre='" + nombre + '\''
                + ", apellidos='" + apellidos + '\''
                + ", poblacion='" + poblacion + '\''
                + ", curso='" + curso + '\''
                + ", email='" + email + '\''
                + ", fecha de la matricula='" + fechaMatricula + '\''
                + ", carnet='" + carnet + '\''
                + '}';
    }
}

package models;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String codigo;
    private String nombre;
    private int maxAlumnos;
    private int horasSemana;
    private int creditos;
    private Ciclo ciclo;
    private List<Seccion> secciones; // Lista de secciones

    public Curso(String codigo, String nombre, int maxAlumnos, int horasSemana, int creditos, Ciclo ciclo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.maxAlumnos = maxAlumnos;
        this.horasSemana = horasSemana;
        this.creditos = creditos;
        this.ciclo = ciclo;
        this.secciones = new ArrayList<>(); // Inicializamos la lista de secciones
    }

    // Métodos para añadir secciones
    public void agregarSeccion(Seccion seccion) {
        this.secciones.add(seccion);
    }

    // Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMaxAlumnos() {
        return maxAlumnos;
    }

    public void setMaxAlumnos(int maxAlumnos) {
        this.maxAlumnos = maxAlumnos;
    }

    public int getHorasSemana() {
        return horasSemana;
    }

    public void setHorasSemana(int horasSemana) {
        this.horasSemana = horasSemana;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }
}
package models;

import java.util.List;


public class Docente extends Persona{
    private List<Curso> cursosAsignados;

    public Docente(String codigo, String nombre, String correo, String contraseña) {
        super(codigo, nombre, correo, contraseña);
    }

}
